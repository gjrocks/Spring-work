package org.jzen.invoicing.serviceImpl;

import java.util.HashMap;
import java.util.Map;


import org.jzen.invoicing.entity.UserDetail;
import org.jzen.invoicing.service.SendMailService;
import org.jzen.invoicing.util.FormatUtils;
import org.jzen.invoicing.util.email.IMimeMessageWrapper;
import org.jzen.invoicing.util.email.MimeMessageWrapper;
import org.jzen.invoicing.util.email.SendMailUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class SendMailServiceImpl implements SendMailService  {
	private static final Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);
	@Autowired
	private SendMailUtil sendMailUtil;
	
	@Autowired
	FormatUtils formatUtils;
	

	@Override
	public boolean sendPasswordInEmail(UserDetail user, String password) {
		boolean mailSent=false;
		 try {
	            Map map = new HashMap();
	            map.put("name",formatUtils.capitaliseFirstLetter(user.getUsername()));
	            map.put("password", password);
	          
	            map.put("fromName", "Ebulk Invoicing Team");

	            IMimeMessageWrapper mimeMessageWrapper = new MimeMessageWrapper();
	            mimeMessageWrapper.setMailTo(user.getEmail());
	            mimeMessageWrapper.setSubject("Notice");

	            mailSent= sendMailUtil.sendMailSynchronously(mimeMessageWrapper,map,"passwordEmailTemplate.ftl");

	        } catch (Exception e) {
	            logger.warn("sendPassword(): "+e.getMessage());
	        }
		 	
		 return mailSent;
	}
	
	
		
	}
	
	


