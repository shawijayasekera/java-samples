package com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.javasamples.mdp.mvp.purchaseorder.mvporderservice.dto.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
