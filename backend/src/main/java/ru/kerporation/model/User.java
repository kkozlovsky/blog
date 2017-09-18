package ru.kerporation.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email", name = "unique_email")})
public class User {

	@Id
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Integer id;

	@NotNull
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	protected String password;
	
	@NotNull
	@Column(name = "enabled", nullable = false)
	private boolean enabled = true;

	@Column(name = "registered", columnDefinition = "timestamp default now()")
	@NotNull
	protected Date registered = new Date();

	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles;


	public User() {
	}

	public User(User u) {
		this(u.getUserId(), u.getEmail(), u.getPassword(), u.isEnabled(), u.getRoles());
	}

	public User(Integer id, String email, String password, boolean enabled, Role role, Role... roles) {
		this(id, email, password, enabled, EnumSet.of(role, roles));
	}

	public User(Integer id, String email, String password, boolean enabled, Set<Role> roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}


	public Integer getUserId() {
		return id;
	}

	public void setUserId(Integer userId) {
		this.id = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
}
