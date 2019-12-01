package com.example.demo.endpoints.dto;

public class UpdateToDoListItemDTO {

	private Long itemId;
	private String userName;
	private String oldItemDescription;
	private String newItemDescription;

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldItemDescription() {
		return oldItemDescription;
	}

	public void setOldItemDescription(String oldItemDescription) {
		this.oldItemDescription = oldItemDescription;
	}

	public String getNewItemDescription() {
		return newItemDescription;
	}

	public void setNewItemDescription(String newItemDescription) {
		this.newItemDescription = newItemDescription;
	}

}
