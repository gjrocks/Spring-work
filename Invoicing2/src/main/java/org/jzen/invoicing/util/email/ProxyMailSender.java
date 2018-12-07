package org.jzen.invoicing.util.email;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;


@Component
public class ProxyMailSender implements IProxyMailSender {

	
	 private final org.slf4j.Logger logger = LoggerFactory.getLogger(ProxyMailSender.class);

		  
		    private boolean             alwaysSerialise     = false;
		    private boolean             available           = true;
		    private String              mailFrom            = "noreply@unknown.com";
		    private String				pgpKeyAlias			= null;

		
		    private IMailQueueMonitor   mailQueueMonitor;
		    
		    @Autowired
			private JavaMailSender mailSender;
		    /**
		     *
		     * @param msg
		     * @throws Exception
		     */
		  
		    public void send(IMimeMessageWrapper msg) throws Exception {
		        if (logger.isDebugEnabled()) {
		            logger.debug("Entering send(IMimeMessageWrapper)...");
		            logger.debug("msgTo: " + msg.getMailTo());
		            logger.debug("available=" + available);
		        }

		        // if the mail system is turned off don;t do anything
		        if (!available) return;

		        MimeMessage message = mailSender.createMimeMessage();
		        MimeMessageHelper helper =
		            new MimeMessageHelper(message,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
		                    StandardCharsets.UTF_8.name());

		        try {

		            // Do we need to check for nulls?
		            helper.setTo(msg.getMailTo());
		            // following check needed to avoid java.lang.IllegalArgumentException: Bcc address array must not be null
		            
		            if(msg.getMailBCC()!=null && msg.getMailBCC().length>0)
		           {
		            helper.setBcc(msg.getMailBCC());
		           }
		            
		            if (msg.getMailCC() != null) {
		                helper.setCc(msg.getMailCC());
		            }

		            helper.setSubject(msg.getSubject());

		            if (msg.getMailFrom() == null) {
		                helper.setFrom(mailFrom);
		                if (logger.isDebugEnabled())  logger.debug("1.from: " + mailFrom);
		            } else {
		                helper.setFrom(msg.getMailFrom());
		                if (logger.isDebugEnabled())  logger.debug("2.from: " + msg.getMailFrom());
		            }
		            helper.setText(msg.getText(), true);

		            if (msg.getReplyTo() != null) {
		                helper.setReplyTo(msg.getReplyTo());
		            }

		            // adds inline elements to the email
		            final Map elem = msg.getInLineElements();
		            if (elem != null && !elem.isEmpty()) {
		                final Iterator eit = elem.keySet().iterator();
		                while (eit.hasNext()) {
		                    final String key = (String)eit.next();
		                    final File file = (File)elem.get(key);
		                    if (file != null && file.exists()) {
		                        final FileSystemResource res =
		                            new FileSystemResource(file);
		                        helper.addInline(key, res);
		                    }
		                }
		            }


		            final List at = msg.getAttachments();
		            if (at != null && !at.isEmpty()) {
		                for (int i = 0; i < at.size(); i++) {
		                    final IMimeAttachmentWrapper a =
		                        (IMimeAttachmentWrapper)at.get(i);
		                    helper.addAttachment(a.getName(),
		                                         new ByteArrayResource(a.getAttachment()));
		                }
		            }


		        } catch (Exception exBuild) {

		            logger.warn("Error occured constructing email: " +
		                        exBuild.getMessage(), exBuild);
		            throw exBuild;
		        }

		        // now send email
		        try {

		            if (alwaysSerialise) {
		                logger.info("Serialise mode on. Serialising mail instead of sending.");
		                mailQueueMonitor.serializeMail(msg);
		            } else {
		                if (logger.isDebugEnabled()) {
		                    logger.debug("Sending Mail to " + message.getReplyTo());
		                }
		               
		                mailSender.send(message);
		            }

		        } catch (MailException ex) {
		            logger.warn("Mail Send Failed: " + ex.getMessage());
		            mailQueueMonitor.serializeMail(msg);
		            throw ex;
		        }

		        logger.debug("Exiting send(IMimeMessageWrapper)...");
		    }
	

}
