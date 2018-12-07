package org.jzen.invoicing.util.email;

import java.io.File;
import java.util.List;
import java.util.Map;



public interface IMimeMessageWrapper {
	 void setMailCC(String[] mailCC);
	    String[] getMailCC();
	    void setMailTo(String mailTo);
	    String getMailTo();
	    void addAttachment(IMimeAttachmentWrapper a);
	    
	    public String[] getMailBCC();
	    public void setMailBCC(String[] mailBCC);
	    /**
	     * @return
	     */
	    public List getAttachments();

	    /**
	     * @param mailFrom
	     */
	    public void setMailFrom(String mailFrom);

	    /**
	     * @return
	     */
	    public String getMailFrom();

	    /**
	     * @param subject
	     */
	    public void setSubject(String subject);

	    /**
	     * @return
	     */
	    public String getSubject();

	    /**
	     * @param text
	     */
	    public void setText(String text);

	    /**
	     * @return
	     */
	    public String getText();

	    /**
	     * @param replyTo
	     */
	    public void setReplyTo(String replyTo);

	    /**
	     * @return
	     */
	    public String getReplyTo();

	    /**
	     * @param html
	     */
	    public void setHtml(boolean html);

	    /**
	     * @return
	     */
	    public boolean isHtml();

	    /**
	     * @param ref
	     * @param file
	     */
	    public void addInLine(String ref,File file);

	    /**
	     * @return
	     */
	    public Map getInLineElements();

	    /**
	     * @param htmlText
	     */
	    public void setHtmlText(String htmlText);

	    /**
	     * @return
	     */
	    public String getHtmlText();
}
