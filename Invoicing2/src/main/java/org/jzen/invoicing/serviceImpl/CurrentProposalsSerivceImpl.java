package org.jzen.invoicing.serviceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jzen.invoicing.bean.CurrentProposalsBean;
import org.jzen.invoicing.bean.CurrentProposalsResultsBean;
import org.jzen.invoicing.controller.AssignRequest;
import org.jzen.invoicing.datatable.PagingData;
import org.jzen.invoicing.datatable.PagingGenerator;
//import org.jzen.invoicing.repository.CurrentProposalsRepository;
//import org.jzen.invoicing.repository.ProposalRunRepository;
import org.jzen.invoicing.repository.specification.ProposalSearchSpecificaton;
import org.jzen.invoicing.service.CurrentProposalsService;
import org.jzen.jdf.lux.tracking.dao.TrackingStatus;
import org.jzen.jdf.lux.tracking.entity.ProposalTrack;
import org.jzen.jdf.lux.tracking.repository.ProposalTrackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CurrentProposalsSerivceImpl implements CurrentProposalsService {

	private static final Logger logger = LoggerFactory.getLogger(CurrentProposalsSerivceImpl.class);
	@Autowired
	ProposalTrackRepository currentProposalsRepository;
	
	private static List<TrackingStatus> statuses=Arrays.asList(TrackingStatus.values());

	/*
	 * @Autowired ProposalRunRepository ProposalRunRepository;
	 */
	@Autowired
	ProposalSearchSpecificaton proposalSearchSpecification;

	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	
	
	@Override
	public Page<ProposalTrack> searchProposals(CurrentProposalsBean filter) {

		Pageable limit = new PageRequest(filter.getPage() - 1, filter.getDisplaySize(), new Sort(filter.getSortBy()));

		Page<ProposalTrack> ProposalResults = currentProposalsRepository.findAll(proposalSearchSpecification.findByCriteria(filter), limit);
		logger.debug("*filter.getPage()" + ProposalResults.getNumberOfElements());
		logger.debug("*filter.getDisplaySize()" + filter.getDisplaySize());

		return ProposalResults;
	}

	
	 /* @Override public ProposalRunDates getCurrentPeriod() {
	  
	  Map currentPeriodMap = new HashMap<String, String>(); ProposalRunDates
	  currentRunDates = ProposalRunRepository.getCurrentRunDates(); return
	  currentRunDates;
	  
	  }*/
	 

	@Override
	public PagingData getPagedProposals(CurrentProposalsBean currentProposalsSearchBean) {

		Page<ProposalTrack> proposalResults = searchProposals(currentProposalsSearchBean);
		logger.debug("ProposalResults" + proposalResults.getSize());
		final PagingData data = new PagingData(currentProposalsSearchBean.getPage());

		data.setNumResultsPerPage(currentProposalsSearchBean.getDisplaySize());

		long count;
		count = proposalResults.getTotalElements();
		logger.debug("count" + count);
		data.setTotalNumResults((int) count);

		if (count > 0) {

			List<CurrentProposalsResultsBean> currProposalResultsBean = new ArrayList<CurrentProposalsResultsBean>();
			for (ProposalTrack proposal : proposalResults.getContent()) {

				CurrentProposalsResultsBean currProposalResult = new CurrentProposalsResultsBean();
				currProposalResult.setAgreementNumber(proposal.getAgreementNumber());
				currProposalResult.setQuoteNumber(proposal.getQuoteNumber());
				currProposalResult.setErrorText(proposal.getErrorText());
				currProposalResult.setCountryCode(proposal.getCountryCode());
				currProposalResult.setCreatedAt(proposal.getCreatedAt());
				currProposalResult.setStatusId(proposal.getStatusId());
				currProposalResult.setTrackingStatus(statuses.stream().filter(r->r.getStatus()==proposal.getStatusId()).findFirst().get().toString());
				currProposalResult.setAssignedTo(proposal.getAssignedTo());
				currProposalResultsBean.add(currProposalResult);
			}
			data.setResults(currProposalResultsBean);
			PagingGenerator.getInstance().generatePages(data);
		}
		return data;
	}


	@Override
	public void assignProposal(AssignRequest req) {
		
		currentProposalsRepository.setAgreementNumberAssignedTo(req.getName(), req.getBundleID());
	}

	/*
	 * @Override public List<Proposal> getProposalsByProposalNumList(List<String>
	 * ProposalNumList) {
	 * 
	 * List<Proposal>
	 * invNumList=currentProposalsRepository.getProposalsByProposalNumList(
	 * ProposalNumList); return invNumList;
	 * 
	 * }
	 */
}
