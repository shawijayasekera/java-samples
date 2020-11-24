package com.javasamples.mdp.cqrs.purchaseorder.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javasamples.mdp.cqrs.purchaseorder.orderservice.dto.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
