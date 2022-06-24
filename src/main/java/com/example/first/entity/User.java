package com.example.first.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User implements Serializable {
	@Id
	@NotBlank(message = "ログインIDの入力は必須です")
	@Email(message = "ログインIDはメールアドレスで入力してください")
	@Column(name = "id")
	private String id;
	@NotBlank(message = "ユーザー名の入力は必須です")
	@Column(name = "name")
	private String name;
	@NotBlank(message = "パスワードの入力は必須です")
	@Column(name = "password")
	private String password;

	public User() {
	}

	public User(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}