package org.jzen.invoicing.controller;

import org.jzen.invoicing.service.CurrentProposalsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProposalController {

	private static final Logger logger = LoggerFactory.getLogger(ProposalController.class);
	
	@Autowired
	private CurrentProposalsService currentInvociesService;
	
	@PostMapping(value="/api/assign",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> assignAjax(
             @RequestBody AssignRequest assignRequest) {

        AjaxResponse result = new AjaxResponse();

        //If error, just return a 400 bad request, along with the error message
       
        logger.debug("Request :" + assignRequest!=null?assignRequest.toString():"");
       
        try {
        currentInvociesService.assignProposal(assignRequest);
        result.setResponseText("Success");
        result.setCode(200);
        }catch(Exception e) {
        	 result.setResponseText("Failure :" + e.getMessage());
             result.setCode(500);
             return ResponseEntity.status(500).body(result);
        }
        
         return ResponseEntity.ok(result);

    }
}
