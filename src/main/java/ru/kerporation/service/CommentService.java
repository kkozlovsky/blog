package ru.kerporation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kerporation.model.Comment;
import ru.kerporation.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<Comment> findAllByPostIdOrderByDateDesc(Integer postId) {
		List<Comment> commentList = commentRepository.findAllByPostIdOrderByDateCreatedDesc(postId);
		return commentList;
	}
	
	public List<Comment> findAllByUserUsernameOrderByDateDesc(String username) {
		List<Comment> commentList = commentRepository.findAllByUserUsernameOrderByDateCreatedDesc(username);
		return commentList;
	}
	
	public Comment save(Comment comment) {
		Comment savedComment = commentRepository.save(comment);
		return savedComment;
	}


	public Comment findOne(Integer id) {
		Comment comment = commentRepository.findOne(id);
		return comment;
	}

	public void delete(Comment commentToDelete) {
		commentRepository.delete(commentToDelete);
	}
}
