
package com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
