package org.jzen.invoicing.util.email;

import java.io.Serializable;



public class MimeAttachmentWrapper implements Serializable, IMimeAttachmentWrapper {

    private byte[] attachment;
    private long length;

    /**
     */
    private String name;


    public MimeAttachmentWrapper(String name,byte[] attachment) {
    	setName(name);
    	setAttachment(attachment);
    }

    /**
     * @param b
     */
    public void setAttachment(byte[] b) {
        this.length = b.length;
        attachment = b;
    }

    /**
     * @return
     */
    public byte[] getAttachment() {
        return this.attachment;
    }

    /**
     * @return
     */
    public long getLength() {
        return this.length;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return
     */
    public String getName() {
        return this.name;
    }

}
