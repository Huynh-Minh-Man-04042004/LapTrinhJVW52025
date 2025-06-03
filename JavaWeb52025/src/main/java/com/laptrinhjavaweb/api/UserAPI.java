package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.bean.UserBean;

@Controller
public class UserAPI {

	/*
	 * @GetMapping("/api/staffs") public List<UserBean> getStaff(@RequestParam(value
	 * = "buildingid", required = false) Long buildingid) { List<UserBean> results =
	 * new ArrayList<UserBean>(); return results; }
	 */

	@GetMapping("/api/user")
	@ResponseBody
	public List<UserBean> getStaff(@RequestParam(value = "buildingid", required = false) Long buildingid,
									@RequestParam(value = "role", required = false) String roleCode) {
		List<UserBean> results = new ArrayList<UserBean>();
		return results;
	}
}
