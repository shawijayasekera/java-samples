package com.javasamples.mdp.es.purchaseorder.esorderservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasamples.mdp.es.purchaseorder.esorderservice.dao.PurchaseOrderRepository;
import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.PurchaseOrder;
import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.User;
import com.javasamples.mdp.es.purchaseorder.esorderservice.service.UserServiceEventHandler;

@Service
public class UserServiceEventHandlerImpl implements UserServiceEventHandler {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;

	@Override
	@Transactional
	public void updateUser(User user) {

		List<PurchaseOrder> userOrders = this.purchaseOrderRepository.findByUserId(user.getId());
		userOrders.forEach(p -> p.setUser(user));
		this.purchaseOrderRepository.saveAll(userOrders);

	}

	@KafkaListener(topics = "es-user-service-event")
	public void consume(String userStr) {
		
		try {
			
			User user = OBJECT_MAPPER.readValue(userStr, User.class);
			this.updateUser(user);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
