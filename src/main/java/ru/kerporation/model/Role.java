package ru.kerporation.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_roles")
public class Role implements GrantedAuthority {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "user_role_seq", sequenceName = "user_role_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_seq")
	private Integer Id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@NotEmpty
	@Column(name = "role")
	private String role;

	@Override
	public String getAuthority() {
		return role;
	}

	public Role() {
	}

	public Role(User user, String role) {
		this.user = user;
		this.role = role;
	}

	public Integer getId() {
		return Id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
