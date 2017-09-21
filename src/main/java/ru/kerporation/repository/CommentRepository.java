package ru.kerporation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kerporation.model.Comment;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	public List<Comment> findAllByUserUsernameOrderByDateDesc(String username);

	public List<Comment> findAllByPostIdOrderByDateDesc(Integer postId);
}