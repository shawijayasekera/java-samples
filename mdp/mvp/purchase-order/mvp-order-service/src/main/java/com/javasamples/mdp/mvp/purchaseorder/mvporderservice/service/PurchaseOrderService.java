package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service;

import java.util.List;

import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.PurchaseOrderSummaryDTO;

public interface PurchaseOrderService {

	public void placeOrder(int userIndex, int productIndex);
    List<PurchaseOrderSummaryDTO> getSaleSummary();
}
