package org.jzen.invoicing.util.email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.jzen.invoicing.controller.UserController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MailQueueMonitor  extends Thread implements IMailQueueMonitor {

	 private String directory;
	    private IProxyMailSender proxyMailSender;

	    private final Logger logger = LoggerFactory.getLogger(MailQueueMonitor.class);

	    /**
	     * Creates a new mailq directory with the given path
	     * @param directory
	     * @return
	     */
	    private boolean createDirectory(String directory){
	        logger.debug("Creating new mailq directory: " + directory);
	        
	        boolean result = (new File(directory)).mkdirs();
	        
	        if(!result){
	            logger.error("Failed to create mailq directory: " + directory);
	        }
	        else{
	            logger.debug("Created directory: " + directory);
	        }
	            
	        return result;
	    }


	    private boolean checkDirectory() {
	        File t = new File(directory);

	        if (!t.exists()) {
	            return createDirectory(directory);
	        }

	        if (!t.isDirectory()) {
	            logger.error("Specified directory " + directory +
	                        " is NOT a directory");
	            return false;
	        }
	        if (!t.canWrite()) {
	            logger.error("Specified directory " + directory +
	                        " is NOT writable");
	            return false;
	        }

	        return true;
	    }

	    private File[] getFileList() {
	        File t = new File(directory);
	        return t.listFiles();
	    }

	    /**
	     */
	    public synchronized void run() {

	        try {

	            if (logger.isDebugEnabled())
	                logger.debug("Checking for unsent mails...");

	            File[] files = getFileList();

	            if (logger.isDebugEnabled())
	                logger.debug(files.length + " files found");

	            for (int u = 0; u < files.length; u++) {

	                if (files[u].getName().endsWith(".email")) {

	                    if (logger.isDebugEnabled())
	                        logger.debug("Found unsent mail: " + files[u].getName());

	                    FileInputStream fis = new FileInputStream(files[u]);

	                    ObjectInputStream in = new ObjectInputStream(fis);
	                    MimeMessageWrapper w = (MimeMessageWrapper)in.readObject();

	                    in.close();
	                    fis.close();
	                    
	                    boolean deleted = files[u].delete();
	                    
	                    if (logger.isDebugEnabled())
	                        logger.debug(files[u].getName()+":deleted="+deleted);
	                        
	                        
	                    try {
	                        proxyMailSender.send(w);
	                    } catch (Exception ex) {
	                        //Do nothing                        
	                    }
	                    
	                } else {
	                    if (logger.isDebugEnabled())
	                        logger.debug("Non email file detected");
	                }
	            }


	        } catch (Exception ex) {
	            logger.error("Error in run() ;msg=" + ex.getMessage(), ex);
	        }

	    }

	    /**
	     * @param msg
	     * @throws Exception
	     */
	    public void serializeMail(IMimeMessageWrapper msg) throws Exception {

	        if (logger.isDebugEnabled())
	            logger.debug("Serialising email");

	        Date f = new Date();

	        ObjectOutputStream os =
	            new ObjectOutputStream(new FileOutputStream(new File(directory, String.valueOf(f.getTime()) + msg +".email")));
	        os.writeObject(msg);
	        os.flush();
	        os.close();
	    }

	    /**
	     * @param directory
	     * @throws Exception
	     */
	    public void setDirectory(String directory) throws Exception {
	        this.directory = directory;
	        if (!checkDirectory()) {
	            throw new Exception("Invalid Directory for mailq");
	        }

	    }

	    /**
	     * @return
	     */
	    public String getDirectory() {
	        return directory;
	    }

	    /**
	     * @param proxyMailSender
	     */
	    public void setProxyMailSender(IProxyMailSender proxyMailSender) {
	        this.proxyMailSender = proxyMailSender;
	    }

	    /**
	     * @return
	     */
	    public IProxyMailSender getProxyMailSender() {
	        return proxyMailSender;
	    }

}
