package ru.kerporation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kerporation.model.User;
import ru.kerporation.repository.UserRepository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUsers() {
		return repository.findAll();
	}
	
	public User getOne(Integer id) {
		User user = repository.getOne(id);
		checkNotNull(user, "User with id: " + id + " not found");
		return user;
	}
	
	public User findByEmail(String email) {
		User user = repository.findByEmail(email);
		checkNotNull(user, "User with email: " + email + " not found");
		return user;
	}

	public void deleteUser(Integer id) {
		repository.delete(id);
	}
}
