package com.javasamples.mdp.es.purchaseorder.esuserservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasamples.mdp.es.purchaseorder.esuserservice.dto.UserDTO;
import com.javasamples.mdp.es.purchaseorder.esuserservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    private UserService userService;
	
	@PostMapping
    public Long createUser(@RequestBody UserDTO userDTO){
		
        return this.userService.createUser(userDTO);
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO userDTO){
    	
        this.userService.updateUser(userDTO);
    }
}
