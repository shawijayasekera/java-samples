package com.javasamples.mdp.es.purchaseorder.esuserservice.service;

import com.javasamples.mdp.es.purchaseorder.esuserservice.dto.UserDTO;

public interface UserService {

	public Long createUser(UserDTO userDTO);
    public void updateUser(UserDTO userDTO);
}
