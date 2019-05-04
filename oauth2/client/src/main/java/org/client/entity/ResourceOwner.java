package org.client.entity;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.client.constrant.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "CLIENT_USER")
public class ResourceOwner implements UserDetails{
	
	private static final long serialVersionUID = 2127198281192056516L;
	
	@Id
	@Getter@Setter
	private Long id;
	@Getter@Setter
	private String username;
	@Getter@Setter
	private String password;
	@Getter
	@Enumerated(EnumType.STRING)
	private UserRole role;
	@Column(length=2000)
	@Getter@Setter
	private String access_token;
	@Getter@Setter
	private LocalDateTime access_token_validity;
	@Column(length=2000)
	@Getter@Setter
	private String refresh_token;
	
	@Transient
	@Getter@Setter
	private Collection<? extends GrantedAuthority> authorities;
	@Transient
	@Getter@Setter
	private boolean accountNonExpired = true;
	@Transient
	@Getter@Setter
	private boolean accountNonLocked = true;
	@Transient
	@Getter@Setter
	private boolean credentialsNonExpired = true;
	@Transient
	@Getter@Setter
	private boolean enabled = true;
	
	public void setRole(UserRole role) {
		this.role = role;
		this.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(role.name())));
	}
	
	
}
