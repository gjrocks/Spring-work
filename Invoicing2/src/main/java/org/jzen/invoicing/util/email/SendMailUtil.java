package org.jzen.invoicing.util.email;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Component
public class SendMailUtil {

	private static final Logger logger = LoggerFactory.getLogger(SendMailUtil.class);
	@Autowired
	Configuration freemarkerConfig;
	 @Autowired
	 IProxyMailSender proxyMailSender;
	public static int noOfQuickServiceThreads = 20;
	
	/**
	 * this statement create a thread pool of twenty threads
	 * here we are assigning send mail task using ScheduledExecutorService.submit();
	 */
	private ScheduledExecutorService quickService = Executors.newScheduledThreadPool(noOfQuickServiceThreads); // Creates a thread pool that reuses fixed number of threads(as specified by noOfThreads in this case).
	
	public boolean sendMailSynchronously(IMimeMessageWrapper mimeMessageWrapper, Map attributes, String templatePath
			) throws Exception {

		boolean mailSent=true;
		logger.debug("Entering sendMail()...");
		final String htmlText = getFreeMarkerTemplateContent(templatePath, attributes);
		mimeMessageWrapper.setText(htmlText);
		mimeMessageWrapper.setHtml(true);
		try {
		proxyMailSender.send(mimeMessageWrapper);
		}
		catch(Exception e) {
			return false;
		}
		logger.debug("Exiting sendMail()...");
		return true;
	}

	

	public void sendMailAsynchrounsly(IMimeMessageWrapper mimeMessageWrapper, Map attributes, String templatePath
			) throws Exception {

		logger.debug("Entering sendMail()...");
		final String htmlText = getFreeMarkerTemplateContent(templatePath, attributes);
		mimeMessageWrapper.setText(htmlText);
		quickService.submit(new Runnable() {
			@Override
			public void run() {
				try{
					proxyMailSender.send(mimeMessageWrapper);
				}catch(Exception e){
					logger.error("Exception occur while send a mail : ",e);
				}
			}
		});

		logger.debug("Exiting sendMail()...");
	}

	public String getFreeMarkerTemplateContent(String templatePath, Map<String, Object> model)
			throws TemplateException {

		try {
			Template t = freemarkerConfig.getTemplate(templatePath);
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			return html;
		} catch (Exception e) {
			logger.debug("Exception occured while processing fmtemplate:" + e.getMessage());
		}
		return "";
	}

}
