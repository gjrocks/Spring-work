package org.jzen.jdf.lux.tracking.dao;


import org.json.JSONObject;
import org.jzen.jdf.lux.domain.TrackingStatusMessage;
import org.jzen.jdf.lux.tracking.entity.ProposalTrack;
import org.jzen.jdf.lux.tracking.entity.ProposalTrackHistory;
import org.jzen.jdf.lux.tracking.repository.ProposalTrackHistoryRepository;
import org.jzen.jdf.lux.tracking.repository.ProposalTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.jzen.jdf.lux.application.utility.ConstantIdentifiers.APP_ID;

import java.util.List;

@Service
public class ProposalTrackingDaoService {

    

    @Autowired
    private ProposalTrackRepository proposalTrackerRepository;

    @Autowired
    private ProposalTrackHistoryRepository proposalTrackHistoryRepository;
    
  


    public List<ProposalTrack> getAllProposalTrackingInfo(){
        /*proposalTrackerRepository.findAll().stream().filter(p -> p.getCountryCode().equalsIgnoreCase("ES")).collect(Collectors.toList())
                .stream().filter((p) -> p.getStatusId() == INIT || p.getStatusId() == RESUBMIT).collect(Collectors.toList())
                .forEach(p -> {
                    if(p.getProposalTPIds().stream().allMatch(pt -> (pt.getThirdPartyTrack().getIcsId()) != null))
                        proposalExecutorList.add(p);
                });*/

        return proposalTrackerRepository.findAll();
    }

    @SuppressWarnings("unchecked")
	@Transactional
    public void updateProposalStatus(String agreementNumber, TrackingStatus trackingStatus){

        ProposalTrack proposalTrack = proposalTrackerRepository.findByAgreementNumber(agreementNumber);
        ProposalTrackHistory proposalTrackHistory = new ProposalTrackHistory(proposalTrack, trackingStatus.status, null);

        proposalTrack.setStatusId(trackingStatus.status);
        proposalTrack.setUpdatedBy(APP_ID);

        try {
            proposalTrackerRepository.save(proposalTrack);
        } catch(DataAccessException daex) {
            TrackingStatusMessage statusMessage = new TrackingStatusMessage();
            statusMessage.setAgreementNumber(proposalTrack.getAgreementNumber());
            statusMessage.setStatusCode(proposalTrack.getStatusId());
            statusMessage.setThirdParties(proposalTrack.getProposalTPIds());
            JSONObject trackingMessageJson = new JSONObject();
            trackingMessageJson.put("trackingMessage", statusMessage);

          
        }
        proposalTrackHistoryRepository.save(proposalTrackHistory);
    }

    public void setProposalTrackerRepository(ProposalTrackRepository proposalTrackerRepository) {
        this.proposalTrackerRepository = proposalTrackerRepository;
    }
}
