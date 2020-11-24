
package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
