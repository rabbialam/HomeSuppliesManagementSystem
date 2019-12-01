package com.example.demo.controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.example.demo.endpoints.dto.ToDoListItemDTO;
import com.example.demo.endpoints.dto.UpdateToDoListItemDTO;
import com.example.demo.entity.ToDoListItem;
import com.example.demo.entity.User;
import com.example.demo.repository.ToDoListRepository;
import com.example.demo.repository.UserRepository;

@Configuration
public class ToDoListService implements IToDoListService {

	@Autowired
	ToDoListRepository toDoListRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Override
	public List<String> getUserToDoList(String userName) {
		List<String> items = new ArrayList<>();
		User user = new User();
		if (userName != null) {
			user = userRepository.findByUserName(userName);
			if (user != null) {
				items = toDoListRepository.findByUserId(user.getUserId());
			} else {
				items = null;
			}
		} else {
			items = null;
		}
		return items;
	}

	@Override
	public Map<HttpStatus, String> setUserItem(ToDoListItemDTO toDoListItemDto) {
		Map<HttpStatus, String> statusMap = new HashMap<>();

		if (toDoListItemDto != null) {
			User user = userRepository.findByUserName(toDoListItemDto.getUserName());

			if (user != null
					&& (toDoListItemDto.getItemDescription() != null && !toDoListItemDto.getItemDescription().isEmpty())
					&& (toDoListRepository.findByUserIdAndItemDescription(user.getUserId(),
							toDoListItemDto.getItemDescription()) == null)) {
				ToDoListItem toDoListItem = new ToDoListItem();
				toDoListItem.setUser(user);
				toDoListItem.setItemDescription(toDoListItemDto.getItemDescription());
				toDoListRepository.save(toDoListItem);
				statusMap.put(HttpStatus.OK, "Saved Item Successfully");
			} else {
				statusMap.put(HttpStatus.BAD_REQUEST, "Errors in Item fields. Item not saved");
			}
		} else {
			statusMap.put(HttpStatus.BAD_REQUEST, "No DTO present. Item not saved");
		}

		return statusMap;

	}

	@Override
	public Map<HttpStatus, String> updateUserItem(UpdateToDoListItemDTO updateToDoListItemDTO) {
		Map<HttpStatus, String> statusMap = new HashMap<>();

		if (updateToDoListItemDTO != null) {
			User user = userRepository.findByUserName(updateToDoListItemDTO.getUserName());

			if (user != null
					&& (updateToDoListItemDTO.getOldItemDescription() != null
							&& !updateToDoListItemDTO.getOldItemDescription().isEmpty())
					&& (updateToDoListItemDTO.getNewItemDescription() != null
							&& !updateToDoListItemDTO.getNewItemDescription().isEmpty())
					&& (toDoListRepository.findByUserIdAndItemDescription(user.getUserId(),
							updateToDoListItemDTO.getOldItemDescription()) != null)
					&& (toDoListRepository.findByUserIdAndItemDescription(user.getUserId(),
							updateToDoListItemDTO.getNewItemDescription()) == null)) {

				ToDoListItem oldToDoListItem = toDoListRepository.findByUserIdAndItemDescription(user.getUserId(),
						updateToDoListItemDTO.getOldItemDescription());

				ToDoListItem newToDoListItem = new ToDoListItem();
				newToDoListItem.setItemId(oldToDoListItem.getItemId());
				newToDoListItem.setUser(user);
				newToDoListItem.setItemDescription(updateToDoListItemDTO.getNewItemDescription());
				toDoListRepository.save(newToDoListItem);
				statusMap.put(HttpStatus.OK, "Updated Item Successfully");
			} else {
				statusMap.put(HttpStatus.BAD_REQUEST, "Errors in Item fields. Item not updated");
			}
		} else {
			statusMap.put(HttpStatus.BAD_REQUEST, "No DTO present. Item not updated");
		}
		return statusMap;

	}

	@Override
	public Map<HttpStatus, String> deleteUserItem(ToDoListItemDTO toDoListItemDto) {
		Map<HttpStatus, String> statusMap = new HashMap<>();

		if (toDoListItemDto != null) {
			User user = userRepository.findByUserName(toDoListItemDto.getUserName());

			if (user != null && (toDoListItemDto.getItemDescription() != null
					&& !toDoListItemDto.getItemDescription().isEmpty())) {
				ToDoListItem toDoListItem = toDoListRepository.findByUserIdAndItemDescription(user.getUserId(),
						toDoListItemDto.getItemDescription());

				if (toDoListItem != null) {
					toDoListRepository.delete(toDoListItem);
					statusMap.put(HttpStatus.OK, "Deleted Item Successfully");
				} else {
					statusMap.put(HttpStatus.BAD_REQUEST, "No such item exists. Item delete failed.");
				}
			} else {
				statusMap.put(HttpStatus.BAD_REQUEST, "Errors in Item fields. Item delete failed.");
			}
		} else {
			statusMap.put(HttpStatus.BAD_REQUEST, "No DTO present. Item delete failed.");
		}
		return statusMap;
	}

}
