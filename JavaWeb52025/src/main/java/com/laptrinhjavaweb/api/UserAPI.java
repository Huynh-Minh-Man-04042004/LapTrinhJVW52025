package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.model.UserDTO;

@RestController
public class UserAPI {

	/*
	 * @GetMapping("/api/staffs") public List<UserBean> getStaff(@RequestParam(value
	 * = "buildingid", required = false) Long buildingid) { List<UserBean> results =
	 * new ArrayList<UserBean>(); return results; }
	 */

	@GetMapping("/api/users")
	public List<UserDTO> getStaff(@RequestParam(value = "buildingid", required = false) Long buildingid,
									@RequestParam(value = "role", required = false) String roleCode) {
		List<UserDTO> results = new ArrayList<UserDTO>();
		return results;
	}
}
