package org.jzen.invoicing.util.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class MimeMessageWrapper  implements Serializable, IMimeMessageWrapper {
	private static final long serialVersionUID = 1L;

    private static final String EMPTY = "";

    private final Logger logger = LoggerFactory.getLogger(MimeMessageWrapper.class);

    private boolean html;
    private String mailTo;
    private String[] mailCC;
    private String mailFrom;
    private String replyTo;
    private String subject = EMPTY;
    private String text = EMPTY;
    private String htmlText = EMPTY;
    private List attachments;
    private Map inlineElements;

    
    
    private String[] mailBCC;
    
    public String[] getMailBCC() {
        return mailBCC;
    }

    public void setMailBCC(String[] mailBCC) {
        this.mailBCC = mailBCC;
    }

 

    /**
     *
     * @param mailTo
     */
    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    /**
     *
     * @return
     */
    public String getMailTo() {
        return mailTo;
    }

    /**
     *
     * @param a
     */
    public void addAttachment(IMimeAttachmentWrapper a) {
        if (attachments == null)
            attachments = new ArrayList();

        attachments.add(a);
    }

    /**
     *
     * @return
     */
    public List getAttachments() {
        return attachments;
    }

    /**
     *
     * @param ref
     * @param file
     */
    public void addInLine(String ref, File file) {

        if (inlineElements == null)
            inlineElements = new HashMap();

        inlineElements.put(ref, file);
    }

    /**
     *
     * @return
     */
    public Map getInLineElements() {
        return this.inlineElements;
    }

    /**
     *
     * @param mailFrom
     */
    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    /**
     *
     * @return
     */
    public String getMailFrom() {
        return mailFrom;
    }

    /**
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @return
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        if (logger.isDebugEnabled()) {
            logger.debug("text: " + text);
        }

        this.text = text;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param replyTo
     */
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }

    /**
     *
     * @return
     */
    public String getReplyTo() {
        return replyTo;
    }

    /**
     *
     * @param html
     */
    public void setHtml(boolean html) {
        this.html = html;
    }

    /**
     *
     * @return
     */
    public boolean isHtml() {
        return html;
    }

    /**
     *
     * @param mailCC
     */
    public void setMailCC(String[] mailCC) {
        this.mailCC = mailCC;
    }

    /**
     *
     * @return
     */
    public String[] getMailCC() {
        return mailCC;
    }

    /**
     *
     * @param htmlText
     */
    public void setHtmlText(String htmlText) {
        if (logger.isDebugEnabled()) {
            logger.debug("htmlText: " + htmlText);
        }

        this.htmlText = htmlText;
    }

    /**
     *
     * @return
     */
    public String getHtmlText() {
        return htmlText;
    }

	

}
