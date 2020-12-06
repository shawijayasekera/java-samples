package com.javasamples.mdp.es.purchaseorder.esorderservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.PurchaseOrder;
import com.javasamples.mdp.es.purchaseorder.esorderservice.service.PurchaseOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
    private PurchaseOrderService purchaseOrderService;
	
	@GetMapping
    public List<PurchaseOrder> getAllOrders(){
		
        return this.purchaseOrderService.getPurchaseOrders();
    }

    @PostMapping
    public void createOrder(@RequestBody PurchaseOrder purchaseOrder){
    	
        this.purchaseOrderService.createPurchaseOrder(purchaseOrder);
    }
}
