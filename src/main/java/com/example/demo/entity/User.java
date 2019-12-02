package com.example.demo.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column
	private String userName;

	@Column
	private String password;
	
	@OneToMany(mappedBy="user")
	private List<ToDoListItem> toDoLists;

	@ManyToMany
	private Set<UserGroupEntity> userGroupEntitySet;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
