package com.javasamples.mdp.cqrs.purchaseorder.orderservice.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao.ProductRepository;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao.PurchaseOrderRepository;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao.UserRepository;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.Product;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.PurchaseOrder;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.User;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.service.OrderCommandService;

@Service
public class OrderCommandServiceImpl implements OrderCommandService {

	private static final long ORDER_CANCELLATION_WINDOW = 30;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	private List<User> users;
	private List<Product> products;

	/*
	 * because this is the contract that guarantees that this method will be invoked
	 * only once in the bean lifecycle. It may happen (though unlikely) that a bean
	 * is instantiated multiple times by the container in its internal working, but
	 * it guarantees that @PostConstruct will be invoked only once.
	 */
	@PostConstruct
	private void init() {

		this.users = this.userRepository.findAll();
		this.products = this.productRepository.findAll();
	}

	@Override
	public void createOrder(int userIndex, int productIndex) {

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setProductId(this.products.get(productIndex - 1).getId());
		purchaseOrder.setUserId(this.users.get(userIndex - 1).getId());
		Date orderDate = new Date();  
		purchaseOrder.setOrderDate(orderDate);
		this.purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	public void cancelOrder(long orderId) {

		this.purchaseOrderRepository.findById(orderId).ifPresent(purchaseOrder -> {

			LocalDateTime orderDate = LocalDateTime.ofInstant(purchaseOrder.getOrderDate().toInstant(),
					ZoneId.systemDefault());
			if (Duration.between(orderDate, LocalDate.now()).toDays() <= ORDER_CANCELLATION_WINDOW) {
				this.purchaseOrderRepository.deleteById(orderId);
				// additional logic to issue refund
			}
		});
	}
}
