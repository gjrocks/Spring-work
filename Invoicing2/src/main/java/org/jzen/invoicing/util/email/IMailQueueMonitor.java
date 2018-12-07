package org.jzen.invoicing.util.email;


public interface IMailQueueMonitor {
	  void run();
	    void serializeMail(IMimeMessageWrapper msg) throws Exception;
	    void setDirectory(String directory) throws Exception;
	    String getDirectory();
	    void setProxyMailSender(IProxyMailSender proxyMailSender);
	    IProxyMailSender getProxyMailSender();
}
