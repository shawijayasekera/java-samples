package com.javasamples.mdp.cqrs.purchaseorder.orderservice.service;

public interface OrderCommandService {

	void createOrder(int userIndex, int productIndex);
    void cancelOrder(long orderId);
}
