package com.example.flyway.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;

	String email;

	String password;

	String firstName;

	String lastName;

	LocalDateTime createdAt;

	LocalDateTime updatedAt;

	@OneToMany(mappedBy = "account")
	private List<Post> posts;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "account_authority", joinColumns = {
			@JoinColumn(name = "account_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "authority_name", referencedColumnName = "name") })
	private Set<Authority> authorities = new HashSet<>();
}
