package com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.service;

import java.util.List;
import com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.dto.PurchaseOrderSummaryDTO;

public interface OrderQueryService {

	List<PurchaseOrderSummaryDTO> getSaleSummaryGroupByState();

	PurchaseOrderSummaryDTO getSaleSummaryByState(String state);

	double getTotalSale();
}
