package com.javasamples.mdp.es.purchaseorder.esorderservice.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.javasamples.mdp.es.purchaseorder.esorderservice.dto.domain.PurchaseOrder;

public interface PurchaseOrderRepository extends MongoRepository<PurchaseOrder, String> {

	@Query("{ 'user.id': ?0 }")
    List<PurchaseOrder> findByUserId(long userId);
}
