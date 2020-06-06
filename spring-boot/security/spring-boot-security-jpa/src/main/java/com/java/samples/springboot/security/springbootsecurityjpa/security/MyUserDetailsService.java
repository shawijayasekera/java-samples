package com.java.samples.springboot.security.springbootsecurityjpa.security;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.java.samples.springboot.security.springbootsecurityjpa.models.MyUserDetails;
import com.java.samples.springboot.security.springbootsecurityjpa.models.User;
import com.java.samples.springboot.security.springbootsecurityjpa.models.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException ("Not found : " + userName)); // if the optional type doesn't contain any record for the given user name it will throw the UsernameNotFoundException 

		return user.map(MyUserDetails::new).get();
	}
}
