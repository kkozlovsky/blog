package ru.kerporation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.kerporation.model.Post;
import ru.kerporation.service.PostService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(PostEndpoint.REST_URL)
public class PostEndpoint {

	public static final String REST_URL = "/api/posts";

	private PostService postService;

	@Autowired
	public PostEndpoint(PostService postService) {
		this.postService = postService;
	}

	@GetMapping
	public List<Post> getAllPosts() {
		return postService.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
		Post post = postService.findOne(id);
		if (post != null)
			return ResponseEntity.ok(post);
		else
			return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<?> savePost(@RequestBody Post post) {
		if (post.getId() != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}

		Post PostToSave = postService.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(PostToSave.getId())
				.toUri();

		return ResponseEntity.created(location).body(post);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePostById(@PathVariable Integer id) {
		Post postToDelete = postService.findOne(id);
		if (postToDelete == null) {
			System.out.println("Post not found");
			return ResponseEntity.notFound().build();
		}

		postService.delete(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
		if (postService.findOne(id) == null) {
			System.out.println("Post with id " + id + " not found");
			return ResponseEntity.notFound().build();
		}

		postService.save(post);
		return ResponseEntity.ok().body(post);
	}
}
