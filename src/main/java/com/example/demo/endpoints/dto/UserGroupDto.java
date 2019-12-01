package com.example.demo.endpoints.dto;

import lombok.Data;

@Data
public class UserGroupDto {

    private String groupName;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
