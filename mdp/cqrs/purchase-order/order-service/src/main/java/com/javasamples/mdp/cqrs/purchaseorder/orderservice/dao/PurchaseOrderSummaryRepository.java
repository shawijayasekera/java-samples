package com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.PurchaseOrderSummary;

@Repository
public interface PurchaseOrderSummaryRepository extends JpaRepository<PurchaseOrderSummary, String>{

	Optional<PurchaseOrderSummary> findByState(String state);
}
