package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao.ProductRepository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao.PurchaseOrderRepository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao.PurchaseOrderSummaryRepository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao.UserRepository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.PurchaseOrderSummaryDTO;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.Product;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.PurchaseOrder;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.User;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	private PurchaseOrderSummaryRepository purchaseOrderSummaryRepository;

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
	public void placeOrder(int userIndex, int productIndex) {

		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setProductId(this.products.get(productIndex - 1).getId());
		purchaseOrder.setUserId(this.users.get(userIndex - 1).getId());
		this.purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	public List<PurchaseOrderSummaryDTO> getSaleSummary() {

		return this.purchaseOrderSummaryRepository.findAll().stream().map(pos -> {

			PurchaseOrderSummaryDTO dto = new PurchaseOrderSummaryDTO();
			dto.setState(pos.getState());
			dto.setTotalSale(pos.getTotalSale());
			return dto;
		}).collect(Collectors.toList());
	}
}
