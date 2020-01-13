package org.jzen.jdf.lux.tracking.repository;

import java.util.List;
import java.util.Optional;

import org.jzen.jdf.lux.tracking.dto.ProposalThirdPartyDTO;
import org.jzen.jdf.lux.tracking.entity.ThirdPartyTrack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlfaThirdPartyRepository extends JpaRepository<ThirdPartyTrack, Integer> {
	
	ThirdPartyTrack findByAlfaTpNumber(String alfaTpNumber);
	
	@Query("SELECT t FROM ThirdPartyTrack t where t.alfaTpNumber = :alfaTpNumber AND t.countryCode = :countryCode")
    public Optional<ThirdPartyTrack> findByAlfaTpNumberAndCountry(@Param("alfaTpNumber") String alfaTpNumber,
                                                                  @Param("countryCode") String countryCode);

	@Query(value = "SELECT TT.ICS_TP_ID from JDF_ALFA_TP_TRACKING TT " +
			" JOIN JDF_ALFA_PROP_TP PT ON TT.JDF_ALFA_TP_TRACKING_ID = PT.JDF_ALFA_TP_TRACKING_ID " +
			" JOIN JDF_ALFA_PROP_TRACKING APT ON APT.JDF_ALFA_PROP_TRACKING_ID = PT.JDF_ALFA_PROP_TRACKING_ID " +
			" WHERE APT.ALFA_QUOTE_NUM = :agreementNumber AND TT.CTRY_CD= :countryCode", nativeQuery = true)
	public List<String> findByAlfaAgreementNumberAndCountry(@Param("agreementNumber") String agreementNumber,
																			  @Param("countryCode") String countryCode);

	@Query(value = "SELECT new org.jzen.jdf.lux.tracking.dto.ProposalThirdPartyDTO(ttr.alfaTpNumber, ptp.thirdPartyRole) " +
			" FROM ThirdPartyTrack ttr " +
			" JOIN ProposalThirdParty ptp ON ttr.id = ptp.thirdPartyTrackingId " +
			" JOIN ProposalTrack ptr ON ptr.id = ptp.proposalTrackingId " +
			" WHERE ptr.quoteNumber = :agreementNumber AND ttr.countryCode = :countryCode")
	public List<ProposalThirdPartyDTO> getAllProposalThirdParties(@Param("agreementNumber") String agreementNumber,
																  @Param("countryCode") String countryCode);
}