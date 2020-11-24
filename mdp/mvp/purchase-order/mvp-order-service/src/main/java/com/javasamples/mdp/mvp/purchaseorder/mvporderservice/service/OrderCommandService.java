package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service;

public interface OrderCommandService {

	void createOrder(int userIndex, int productIndex);
    void cancelOrder(long orderId);
}
