package ru.kerporation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kerporation.model.User;
import ru.kerporation.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getOne(Integer id) {
		User user = userRepository.getOne(id);
//		checkNotNull(user, "User with id: " + id + " not found");
		return user;
	}
	
	public User findByUsername(String username) {
		User user = userRepository.findByUsername(username);
//		checkNotNull(user, "User with email: " + email + " not found");
		return user;
	}

	public User save(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
}
