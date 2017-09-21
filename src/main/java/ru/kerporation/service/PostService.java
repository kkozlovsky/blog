package ru.kerporation.service;

import org.springframework.stereotype.Service;
import ru.kerporation.model.Post;
import ru.kerporation.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
	
	private PostRepository postRepository;
	
	public List<Post> findAll() {
		List<Post> posts = postRepository.findAll();
		return posts;
	}

	public Post findOne(Integer id) {
		Post post = postRepository.findOne(id);
		return post;
	}

	public Post save(Post post) {
		Post savedPosed = postRepository.save(post);
		return savedPosed;
	}

	public void delete(Integer id) {
		postRepository.delete(id);
	}
}
