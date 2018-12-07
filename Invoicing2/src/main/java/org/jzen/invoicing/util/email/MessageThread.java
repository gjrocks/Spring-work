package org.jzen.invoicing.util.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;



final class MessageThread extends Thread {

	private static final Logger logger = LoggerFactory.getLogger(MessageThread.class);
    private IMimeMessageWrapper msg;

    @Autowired
    IProxyMailSender proxyMailSender;
    
    public MessageThread(IMimeMessageWrapper msg) {
      this.msg = msg;
    }

    @Override
    public void run() {
      try {
    	  proxyMailSender.send(msg);
      } catch (Exception e) {
        logger.warn("MessageThread.Failed to send email "+e.getMessage());
      }
    }

}