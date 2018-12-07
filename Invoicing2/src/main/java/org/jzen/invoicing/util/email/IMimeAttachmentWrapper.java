package org.jzen.invoicing.util.email;

public interface IMimeAttachmentWrapper {
	 void setAttachment(byte[] b);
	    byte[] getAttachment();
	    long getLength() ;
	    void setName(String name);
	    String getName();
}
