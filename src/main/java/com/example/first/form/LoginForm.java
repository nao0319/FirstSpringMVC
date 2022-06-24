package com.example.first.form;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class LoginForm implements Serializable {
	@NotBlank(message = "ログインIDの入力は必須です")
	private String id;
	@NotBlank(message = "パスワードの入力は必須です")
	private String password;

	public LoginForm() {
	}

	public LoginForm(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
