package com.kbit.eem.DBModel;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kbit.eem.DBModel.util.BaseAuditEntity;
import com.kbit.eem.DBModel.util.DBConstants;

@Entity
@Table(name = "USERS", schema = DBConstants.SCHEMA_EEM)
@SequenceGenerator(name = "SEQ", sequenceName = "USERS_SEQ")
public class User extends BaseAuditEntity implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME", length = 20, unique = true)
	@NotNull
	private String username;

	@Column(name = "EMAIL", length = 50, unique = true, nullable = true)
	private String email;

	@Column(name = "FNAME", length = 20)
	@NotNull
	private String firstName;

	@Column(name = "LNAME", length = 20)
	@NotNull
	private String lastName;

	@Column(name = "PASSWORD", length = 50)
	@NotNull
	private String password;

	@Column(name = "ENCRYPTED")
	@NotNull
	private boolean encrypted;

	@Column(name = "ENABLED")
	@NotNull
	private boolean enabled;

	@Column(name = "CREATED_ON")
	@NotNull
	private Date createdDate;

	@Column(name = "LAST_LOGIN_ON")
	private Date lastLoginDate;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "AUTHORITIES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID") })
	private List<Role> roles;

	public User() {
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEncrypted() {
		return encrypted;
	}

	public void setEncrypted(boolean encrypted) {
		this.encrypted = encrypted;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.enabled;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.enabled;
	}
}