package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service;

import java.util.List;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.PurchaseOrderSummaryDTO;

public interface OrderQueryService {

	List<PurchaseOrderSummaryDTO> getSaleSummaryGroupByState();

	PurchaseOrderSummaryDTO getSaleSummaryByState(String state);

	double getTotalSale();
}
