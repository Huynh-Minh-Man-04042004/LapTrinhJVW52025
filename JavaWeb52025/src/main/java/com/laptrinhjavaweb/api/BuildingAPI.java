package com.laptrinhjavaweb.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.bean.AssignmentBuildingBean;
import com.laptrinhjavaweb.bean.BuildingBean;
import com.laptrinhjavaweb.customexception.FieldRequiredException;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@GetMapping
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

	/*
	 * @PostMapping("/api/building") public BuildingBean createBuilding(@RequestBody
	 * BuildingBean newBuilding) { System.out.println(10/0);
	 * System.out.println("Hello"); return null; }
	 */

	@PostMapping
	public BuildingBean createBuilding(@RequestBody BuildingBean newBuilding) {
		/*
		 * try { System.out.println(10 / 0); // success return newBuilding; } catch
		 * (Exception e) { ErrorResponseBean errorResponseBean = new
		 * ErrorResponseBean(); errorResponseBean.setError(e.getMessage()); List<String>
		 * details = new ArrayList<String>(); details.add("Lỗi rồi ní ơi!");
		 * details.add("Sửa lại lẹ đi"); errorResponseBean.setDetails(details); return
		 * errorResponseBean; }
		 */

		validateData(newBuilding);
		return newBuilding;
	}

	private void validateData(BuildingBean newBuilding){
		if (newBuilding.getName() == null || newBuilding.getName() == "" || newBuilding.getNumberOfBasement() == null) {
			throw new FieldRequiredException("Name or NumberOfBasement is required");
		}
	}

	/*
	 * Xử lý xóa một hoặc nhiều building bằng cách truyền qua request 1 mảng id
	 * buildingIds, sau đó api hứng bằng cách dùng BuildingBean
	 */
	@DeleteMapping
	// public void deleteBuilding(@RequestBody Long[] ids) {
	public void deleteBuilding(@RequestBody BuildingBean deleteBuilding) {

		System.out.println("Hello delete");
	}

	@PutMapping
	public BuildingBean updateBuilding(@RequestBody BuildingBean updateBuilding) {

		return updateBuilding;
	}

	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody AssignmentBuildingBean buildingId) {

	}
}
