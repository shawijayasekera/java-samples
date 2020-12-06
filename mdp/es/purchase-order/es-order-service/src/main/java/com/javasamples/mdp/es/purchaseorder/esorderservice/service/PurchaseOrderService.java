package com.javasamples.mdp.es.purchaseorder.esorderservice.service;

import java.util.List;

import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.PurchaseOrder;

public interface PurchaseOrderService {

	public List<PurchaseOrder> getPurchaseOrders();
    public void createPurchaseOrder(PurchaseOrder purchaseOrder);
}
