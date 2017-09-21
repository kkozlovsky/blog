package ru.kerporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kerporation.model.User;
import ru.kerporation.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(UserEndpoint.REST_URL)
public class UserEndpoint {
	
	@Autowired
	UserService userService;
	
	public static final String REST_URL = "/api/users";

	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}

	@GetMapping("/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable String username){
		User user = userService.findByUsername(username);

		if(user == null)
			return ResponseEntity.notFound().build();

		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody User user){
		if(user.getId() != null)
			return ResponseEntity.status(HttpStatus.CONFLICT).build();

		User userSaved = userService.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{username}")
				.buildAndExpand(userSaved.getUsername())
				.toUri();

		return ResponseEntity.created(location).body(user);
	}

	@PutMapping("/{username}")
	public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user){
		if(userService.findByUsername(username) == null)
			ResponseEntity.notFound().build();

		userService.save(user);
		return ResponseEntity.ok(user);
	}

	@DeleteMapping("/{username}")
	public ResponseEntity<?> deleteUser(@PathVariable String username){
		User userToDelete = userService.findByUsername(username);

		if(userToDelete == null)
			return ResponseEntity.notFound().build();

		userService.delete(userToDelete);
		return ResponseEntity.noContent().build();
	}
	
}
