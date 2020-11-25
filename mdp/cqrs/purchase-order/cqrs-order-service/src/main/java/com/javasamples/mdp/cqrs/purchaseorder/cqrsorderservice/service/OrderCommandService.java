package com.javasamples.mdp.cqrs.purchaseorder.cqrsorderservice.service;

public interface OrderCommandService {

	void createOrder(int userIndex, int productIndex);
    void cancelOrder(long orderId);
}
