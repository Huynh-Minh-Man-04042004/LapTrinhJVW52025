package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.bean.BuildingBean;

@Controller
public class BuildingAPI {

	@RequestMapping(value = "/api/building", method = RequestMethod.GET)
	@ResponseBody
	public List<BuildingBean> getBuilding(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "floorArea", required = false) Integer floorArea,
			@RequestParam(value = "types", required = false) List<String> types) {
		System.out.println("Hello");
		return null;
	}

	@RequestMapping(value = "/api/building/{buildingid}", method = RequestMethod.GET)
	@ResponseBody
	public List<BuildingBean> getBuildingDetail(@PathVariable("buildingid") Integer buildingid) {
		System.out.println("Hello");

		return null;
	}

	@RequestMapping(value = "/api/building", method = RequestMethod.POST)
	@ResponseBody
	public BuildingBean createBuilding(@RequestBody BuildingBean newBuilding) {

		return null;
	}

	/*
	 * Xử lý xóa một hoặc nhiều building bằng cách truyền qua request 1 mảng id
	 * buildingIds, sau đó api hứng bằng cách dùng BuildingBean
	 */
	@RequestMapping(value = "/api/building", method = RequestMethod.DELETE)
	// public void deleteBuilding(@RequestBody Long[] ids) {
	public void deleteBuilding(@RequestBody BuildingBean deleteBuilding) {

		System.out.println("Hello delete");
	}

	@RequestMapping(value = "/api/building", method = RequestMethod.PUT)
	@ResponseBody
	public List<BuildingBean> updateBuilding(@RequestBody BuildingBean updateBuilding) {
		System.out.println("Hello");

		return null;
	}
}
