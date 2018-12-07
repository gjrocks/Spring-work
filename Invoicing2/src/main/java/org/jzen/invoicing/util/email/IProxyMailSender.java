package org.jzen.invoicing.util.email;



public interface IProxyMailSender {
	
	 /**
     * 
     * @param msg
     * @throws Exception
     */
   public void send(IMimeMessageWrapper msg) throws Exception;

}
