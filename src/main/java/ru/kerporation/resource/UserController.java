package ru.kerporation.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kerporation.model.User;
import ru.kerporation.service.UserService;

import java.util.List;

@RestController
@RequestMapping(UserController.REST_URL)
public class UserController {
	
	@Autowired
	UserService userService;
	
	public static final String REST_URL = "/api/users";

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAll() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User get(@PathVariable("id") int id) {
		return userService.getOne(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		userService.deleteUser(id);
	}

	@RequestMapping(value = "/by", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getByMail(@RequestParam("email") String email) {
		return userService.findByEmail(email);
	}
}
