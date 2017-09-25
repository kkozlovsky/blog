package ru.kerporation.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "post_seq", sequenceName = "post_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
	private Integer id;

	@NotNull
	@Column(name = "title", nullable = false) 
	private String title;

	@NotEmpty
	@Column(name = "preview", columnDefinition = "text")
	private String preview;
	
	@NotEmpty
	@Column(name = "content", columnDefinition = "text")
	private String content;

	@NotNull
	@Column(name = "date_сreated", columnDefinition = "timestamp default now()")
	private LocalDate dateCreated = LocalDate.now();

		
	public Post() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	
}

