package org.jzen.jdf.lux.tracking.repository;

import org.jzen.jdf.lux.tracking.entity.ProposalTrackHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalTrackHistoryRepository extends JpaRepository<ProposalTrackHistory, Integer> {
}