package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.PurchaseOrderSummary;

@Repository
public interface PurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummary, String>{

	Optional<PurchaseOrderSummary> findByState(String state);
}
