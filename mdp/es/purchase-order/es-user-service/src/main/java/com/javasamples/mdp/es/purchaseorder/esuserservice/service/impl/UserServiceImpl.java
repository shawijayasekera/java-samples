package com.javasamples.mdp.es.purchaseorder.esuserservice.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasamples.mdp.es.purchaseorder.esuserservice.dao.UsersRepository;
import com.javasamples.mdp.es.purchaseorder.esuserservice.dto.UserDTO;
import com.javasamples.mdp.es.purchaseorder.esuserservice.dto.domain.Users;
import com.javasamples.mdp.es.purchaseorder.esuserservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private KafkaTemplate<Long, String> kafkaTemplate;

	@Override
	public Long createUser(UserDTO userDTO) {

		Users user = new Users();
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		return this.usersRepository.save(user).getId();
	}

	@Override
	@Transactional
	public void updateUser(UserDTO userDTO) {
		this.usersRepository.findById(userDTO.getId()).ifPresent(user -> {
			user.setFirstname(userDTO.getFirstname());
			user.setLastname(userDTO.getLastname());
			user.setEmail(userDTO.getEmail());
			this.raiseEvent(userDTO);
		});
	}

	private void raiseEvent(UserDTO userDTO) {

		try {

			String value = OBJECT_MAPPER.writeValueAsString(userDTO);
			this.kafkaTemplate.sendDefault(userDTO.getId(), value);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
