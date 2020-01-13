package org.jzen.invoicing.service;

import java.util.List;

import org.jzen.invoicing.bean.CurrentProposalsBean;
import org.jzen.invoicing.controller.AssignRequest;
import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.entity.Proposal;
import org.jzen.jdf.lux.tracking.entity.ProposalTrack;
//import org.jzen.invoicing.entity.ProposalRunDates;
import org.springframework.data.domain.Page;


public interface CurrentProposalsService {
	
	public Page<ProposalTrack>  searchProposals(CurrentProposalsBean currentProposalsSearchBean);

	//ProposalRunDates getCurrentPeriod();
		
	public PagingData    getPagedProposals(CurrentProposalsBean currentProposalsSearchBean);
	
	//public List<Proposal> getProposalsByProposalNumList(List<String> invocieNumList);

	public void assignProposal(AssignRequest req);
	

}
