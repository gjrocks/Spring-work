package org.jzen.invoicing.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jzen.invoicing.entity.EbulkImport;
import org.jzen.invoicing.repository.EbulkImportRepository;
import org.jzen.invoicing.service.EbulkImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EbulkImportServiceImpl implements EbulkImportService{
	
	@Autowired
	private EbulkImportRepository ebulkImportRepository;
	
//	@Override
//	public List<EbulkImport> getBackingData(List<String> invoiceNum){
//		
//		List<EbulkImport> ebulkImportList=new ArrayList<EbulkImport>();
//		List<EbulkImport> ebulkImportList=ebulkImportRepository.getEbulkImportListByInvoiceNum(invoiceNum);
//		
//		return ebulkImportList;
//	}
}
