package com.javasamples.mdp.es.purchaseorder.esorderservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasamples.mdp.es.purchaseorder.esorderservice.dao.PurchaseOrderRepository;
import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.PurchaseOrder;
import com.javasamples.mdp.es.purchaseorder.esorderservice.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
	
	@Override
	public List<PurchaseOrder> getPurchaseOrders() {
		
		return this.purchaseOrderRepository.findAll();
	}

	@Override
	public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
		
		this.purchaseOrderRepository.save(purchaseOrder);
	}
}
