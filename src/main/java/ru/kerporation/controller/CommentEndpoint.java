package ru.kerporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kerporation.model.Comment;
import ru.kerporation.model.User;
import ru.kerporation.service.CommentService;
import ru.kerporation.service.UserService;

import java.net.URI;
import java.util.List;

@RestController
public class CommentEndpoint {

	@Autowired
	private CommentService commentService;
	@Autowired
	private UserService userService;

	@GetMapping("/api/{postId}/comments")
	public List<Comment> getAllCommentsByPostId(@PathVariable Integer postId){
		return commentService.findAllByPostIdOrderByDateDesc(postId);
	}

	@GetMapping("/api/users/{username}/comments")
	public List<Comment> getAllCommentsByUserId(@PathVariable String username){
		return commentService.findAllByUserUsernameOrderByDateDesc(username);
	}

	@PostMapping("api/{username}/comments")
	public ResponseEntity<?> addComment(@PathVariable String username, @RequestBody Comment comment){
		User user = userService.findByUsername(username);

		if(user == null)
			return ResponseEntity.notFound().build();

		comment.setUser(user);

		Comment commentSaved = commentService.save(comment);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(commentSaved.getId()).toUri();

		return ResponseEntity.created(location).body(comment);
	}

	@PutMapping("api/comments/{id}")
	public ResponseEntity<Comment> editComment(@PathVariable Integer id, @RequestBody Comment comment){
		if(commentService.findOne(id) == null)
			return ResponseEntity.notFound().build();

		commentService.save(comment);
		return ResponseEntity.ok().body(comment);
	}

	@DeleteMapping("api/comments/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Integer id){
		Comment commentToDelete = commentService.findOne(id);

		if(commentToDelete == null)
			return ResponseEntity.notFound().build();

		commentService.delete(commentToDelete);
		return ResponseEntity.noContent().build();
	}
}