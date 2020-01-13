package org.jzen.invoicing.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jzen.invoicing.bean.EntityAddressBean;
import org.jzen.invoicing.bean.InvoiceLineItemsBean;
import org.jzen.invoicing.bean.InvoiceSummaryBean;
import org.jzen.invoicing.controller.CurrentInvociesController;
import org.jzen.invoicing.entity.Contract;
import org.jzen.invoicing.entity.EbulkImport;
import org.jzen.invoicing.entity.Invoice;
import org.jzen.invoicing.service.CurrentInvoicesService;
import org.jzen.invoicing.service.EbulkImportService;
import org.jzen.invoicing.service.InvoiceSummaryService;
import org.jzen.invoicing.util.csv.CsvWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.zefer.pd4ml.PD4ML;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Component
public class ProposalDownloadHelper {
	private static final Logger logger = LoggerFactory.getLogger(ProposalDownloadHelper.class);
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	@Autowired
	Configuration freemarkerConfig;
	@Autowired
	private CurrentInvoicesService currentInvociesService;
	@Autowired
	InvoiceSummaryService invoiceSummaryService;
	@Autowired
	EbulkImportService ebulkImportService;
	public ZipOutputStream addFileToZip(PD4ML pd4ml, String fileName , StringReader srt,ZipOutputStream zos){
		
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		try {
			pd4ml.render(srt, bos);
		
		byte[] input = bos.toByteArray();
		
		ZipEntry entry = new ZipEntry(fileName);
		zos.putNextEntry(entry);
		zos.write(input);
		zos.closeEntry();
		bos.close();
		} catch (InvalidParameterException e) {
			
		} catch (IOException e) {
			
		}
		return zos;


}

	
	public void downloadInvoices(List<Invoice> invoiceList,String zipFileName,String imagePath,HttpServletResponse response,Integer fileType)
			throws IOException {
		
	
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ZipOutputStream zos = new ZipOutputStream(baos);		
		PD4ML pd4ml = new PD4ML();
		String fileName="";
		
		
		//case for backing pdf
		if(fileType==0) {
			Map<String,StringReader> invoiceTemplateMap=generateFileContentBacking(invoiceList);
			
			 Iterator it = invoiceTemplateMap.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pair = (Map.Entry)it.next();
			        String invoiceNum=(String) pair.getKey();
			        StringReader template=(StringReader) pair.getValue();
			       
			        it.remove(); // avoids a ConcurrentModificationException
			        fileName = "Backing_"+invoiceNum + ".pdf";
					zos=addFileToZip(pd4ml,fileName,template,zos);
			    }
			
		}
		else if(fileType==1) {
				
				Map<String,StringReader> invoiceTemplateMap=generateFileContentInvoice(imagePath,invoiceList);
				 Iterator it = invoiceTemplateMap.entrySet().iterator();
				    while (it.hasNext()) {
				        Map.Entry pair = (Map.Entry)it.next();
				        String invoiceNum=(String) pair.getKey();
				        StringReader template=(StringReader) pair.getValue();
				       
				        it.remove(); // avoids a ConcurrentModificationException
				        fileName = invoiceNum + "_invociePdf.pdf";	
						zos=addFileToZip(pd4ml,fileName,template,zos);
				    }
				
			
		 }  			
			
			
			//case for download all
			else if(fileType==2) {
				
				
				Map<String,StringReader> invoiceTemplateMap=generateFileContentInvoice(imagePath,invoiceList);
				 Iterator it = invoiceTemplateMap.entrySet().iterator();
				    while (it.hasNext()) {
				        Map.Entry pair = (Map.Entry)it.next();
				        String invoiceNum=(String) pair.getKey();
				        StringReader template=(StringReader) pair.getValue();
				       
				        it.remove(); // avoids a ConcurrentModificationException
				        fileName =invoiceNum+ "\\"+invoiceNum + "_invociePdf.pdf";
						zos=addFileToZip(pd4ml,fileName,template,zos);
				    }
				
				   
					invoiceTemplateMap=generateFileContentBacking(invoiceList);
					
					  it = invoiceTemplateMap.entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pair = (Map.Entry)it.next();
					        String invoiceNum=(String) pair.getKey();
					        StringReader template=(StringReader) pair.getValue();
					       
					        it.remove(); // avoids a ConcurrentModificationException
					        fileName = invoiceNum+ "\\Backing_"+invoiceNum + ".pdf";
							zos=addFileToZip(pd4ml,fileName,template,zos);
							
							
							
					    }
					    
					    for(Invoice inv:invoiceList) {
							
							Set<EbulkImport> backingDataList=inv.getEbulkImportItems();
							String invocieNum=inv.getInvoiceNum();
							fileName=invocieNum+"\\Backing_"+invocieNum+".csv";		
							try {				
								OutputStreamWriter writer=new OutputStreamWriter(zos);
								ZipEntry entry = new ZipEntry(fileName);
								zos.putNextEntry(entry);
								CsvWriter csvWriter = new CsvWriter(writer);
								csvWriter=getCsvContents(csvWriter,backingDataList)	;		       				
								csvWriter.flush();
								zos.closeEntry();
								

							} catch (Exception e) {
								logger.debug("Exception occured while processing fmtemplate:" + e.getMessage());
							}

					    }
						
								
			}
			else if(fileType==3) {
				for(Invoice inv:invoiceList) {
					
				Set<EbulkImport> backingDataList=inv.getEbulkImportItems();
				String invocieNum=inv.getInvoiceNum();
				fileName="Backing_"+invocieNum+".csv";		
				try {				
					OutputStreamWriter writer=new OutputStreamWriter(zos);
					ZipEntry entry = new ZipEntry(fileName);
					zos.putNextEntry(entry);
					CsvWriter csvWriter = new CsvWriter(writer);
					csvWriter=getCsvContents(csvWriter,backingDataList)	;		       				
					csvWriter.flush();
					zos.closeEntry();
					

				} catch (Exception e) {
					logger.debug("Exception occured while processing fmtemplate:" + e.getMessage());
				}
			}
			}
				    
		zos.close();
        
		response.setContentType("application/zip");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + zipFileName + "\"");
		response.setStatus(HttpServletResponse.SC_OK);
		
		try {
			response.getOutputStream().write(baos.toByteArray());
			response.flushBuffer();
		} catch (IOException e) {
			logger.debug("error in downloading pdf");
		} finally {
			baos.close();
		}

	}
	
private Map generateFileContentBacking(List<Invoice> invoiceList) {
		
		
		Map backingInvoiceTemplateMap=new HashMap<String,StringReader>();
		for(Invoice invoice:invoiceList) {
		StringReader srt = new StringReader("");
		Map<String,Object> map = new HashMap<String,Object>();
		
		map.put("invoiceNumber", invoice.getInvoiceNum());
		map.put("invoiceTotal", invoice.getGross());
		map.put("ebulkImportList", invoice.getEbulkImportItems());
		Template t;
		try {
			t = freemarkerConfig.getTemplate("InvoiceBackingPdfTemplate.ftl");
			String htm = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
			srt = new StringReader(htm);
		} 	 catch (Exception e) {
			logger.debug("Exception occured while processing fmtemplate:" + e.getMessage());
		}
		
		backingInvoiceTemplateMap.put(invoice.getInvoiceNum(), srt);
		}
		return backingInvoiceTemplateMap;
	}

private Map generateFileContentInvoice(String imagePath,List<Invoice> invoiceList) {
	
	Map invoiceTemplateMap=new HashMap<String,StringReader>();
	
	for(Invoice invoice:invoiceList) {
	StringReader srt = new StringReader("");
	Map<String,Object> map = new HashMap<String,Object>();
	
	map.put("imagePath", imagePath);
	map.put("invoiceNumber", invoice.getInvoiceNum());
	String invDate = dateFormat.format(invoice.getInvoiceDate());
	map.put("invoiceDate",invDate);
	map.put("accountNumber", "12345");
	map.put("poNumber","1234");
	
	
	
	map.put("invoice", invoice);
	map.put("productList", invoice.getInvoiceLineItems());
	map.put("totalNet", invoice.getNet());
	map.put("totalVat", invoice.getVat());
	map.put("grossTotal", invoice.getGross());
	Template t;
	try {
		t = freemarkerConfig.getTemplate("invoicePDFTemplate.ftl");
		String htm = FreeMarkerTemplateUtils.processTemplateIntoString(t, map);
		srt = new StringReader(htm);
	} 	 catch (Exception e) {
		logger.debug("Exception occured while processing fmtemplate:" + e.getMessage());
	}
		invoiceTemplateMap.put(invoice.getInvoiceNum(), srt);
	}
	return invoiceTemplateMap;
}

private CsvWriter getCsvContents(CsvWriter csvWriter,Set<EbulkImport> backingDataList) {
	List<String> fieldsNames=new ArrayList<String>();
	Map csvMap =new HashMap<String,CsvWriter>();
	fieldsNames.add("Forename");
	fieldsNames.add("Surname");
	fieldsNames.add("Sent Date");
	fieldsNames.add("Our Ref");
	
	fieldsNames.add("Organisation Name");
	fieldsNames.add("SITE");
	fieldsNames.add("Post code");
	fieldsNames.add("PO No");
	fieldsNames.add("General Ref");		
	fieldsNames.add("Volunteer?");
	fieldsNames.add("Disclosure type");		
	fieldsNames.add("Enhanced");
	fieldsNames.add("Standard");		
	fieldsNames.add("Basic");
	fieldsNames.add("PVG");
	fieldsNames.add("Admin Fee");		
	fieldsNames.add("DBS Adult First admin");
	fieldsNames.add("DBS Adult First fee");
	fieldsNames.add("VAT");
	fieldsNames.add("Total");

	final Collection fieldValues = fieldsNames;                
	try {
		csvWriter.writeln((String[])fieldValues.toArray(new String[fieldValues.size()]));
	
	
	
    if (backingDataList != null) {         
         for (EbulkImport ebulkImport:backingDataList) {
             
             final BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(ebulkImport);
             List<String> data = new ArrayList();
             data.add(ebulkImport.getApplicantForeName());
             data.add(ebulkImport.getApplicantSurname());
             data.add(ebulkImport.getApplicationSentDate());
             data.add(ebulkImport.getAppRef());
             data.add(ebulkImport.getOrganisationName());
             data.add(ebulkImport.getOrganisationReference());	             
             data.add(ebulkImport.getOrganisationPostcode());
           
             data.add(ebulkImport.getOrganisationPurchaseOrderNumber());
             
            
            
             data.add("test");
             data.add(ebulkImport.getApplicantIsVolunteer());
             data.add(ebulkImport.getApplicationDisclosureType());
             if(null!=ebulkImport.getApplicationEnhancedFee()) {
             data.add(String.valueOf(ebulkImport.getApplicationEnhancedFee()));
             }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationStandardFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationStandardFee()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationBasicFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationBasicFee()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationPaymentCharge()) {
	             data.add(String.valueOf(ebulkImport.getApplicationPaymentCharge()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationAdminFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationAdminFee()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationDBSAdultFirstAdminFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationDBSAdultFirstAdminFee()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationDBSAdultFirstFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationDBSAdultFirstAdminFee()));
	         }
             else {
            	 data.add("0"); 
             }
             if(null!=ebulkImport.getApplicationVatFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationVatFee()));
	         }
             else {
            	 data.add("0"); 
             }
             
             if(null!=ebulkImport.getApplicationTotalFee()) {
	             data.add(String.valueOf(ebulkImport.getApplicationTotalFee()));
	         }
             else {
            	 data.add("0"); 
             }
             
          	             
             csvWriter.writeln(data.toArray(new String[data.size()] ));
         }
     }
	}catch (IOException e) {
		logger.debug("error in writing csv");
	
	
}
    return csvWriter;

}

}
