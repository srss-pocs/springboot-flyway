package com.example.flyway.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Long id;

	String title;

	@Column(columnDefinition = "TEXT")
	String body;

	LocalDateTime createdAt;

	LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
	private Account account;
}
