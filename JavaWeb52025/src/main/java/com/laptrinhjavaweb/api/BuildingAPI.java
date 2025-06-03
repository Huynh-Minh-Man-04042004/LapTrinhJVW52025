package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.bean.BuildingBean;

@RestController
public class BuildingAPI {

	@GetMapping("/api/building")
	public List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "street", required = false) String street,
			@RequestParam(value = "numberofbasement", required = false) Integer numberOfBasement,
			@RequestParam(value = "types", required = false) List<String> types) {
		List<BuildingBean> results = new ArrayList<BuildingBean>();
		return results;
	}

	@GetMapping("/api/building/{buildingid}")
	public List<BuildingBean> getBuildingDetail(@PathVariable("buildingid") Integer buildingid) {
		System.out.println("Hello");

		return null;
	}

	@PostMapping("/api/building")
	public BuildingBean createBuilding(@RequestBody BuildingBean newBuilding) {

		return null;
	}

	/*
	 * Xử lý xóa một hoặc nhiều building bằng cách truyền qua request 1 mảng id
	 * buildingIds, sau đó api hứng bằng cách dùng BuildingBean
	 */
	@DeleteMapping("/api/building")
	// public void deleteBuilding(@RequestBody Long[] ids) {
	public void deleteBuilding(@RequestBody BuildingBean deleteBuilding) {

		System.out.println("Hello delete");
	}

	@PutMapping("/api/building")
	public List<BuildingBean> updateBuilding(@RequestBody BuildingBean updateBuilding) {
		System.out.println("Hello");

		return null;
	}
}
