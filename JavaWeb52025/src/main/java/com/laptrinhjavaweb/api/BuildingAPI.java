package com.laptrinhjavaweb.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.customexception.FieldRequiredException;
import com.laptrinhjavaweb.model.AssignmentBuildingDTO;
import com.laptrinhjavaweb.model.BuildingDTO;
import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.service.BuildingService;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {

	@Autowired
	private BuildingService buildingService;

	@GetMapping
	public List<BuildingSearchResponse> getBuilding(@RequestParam(value = "name", required = false) String name,
													@RequestParam(value = "street", required = false) String street,
													@RequestParam(value = "ward", required = false) String ward,
													@RequestParam(value = "district", required = false) String district,
													@RequestParam(value = "numberOfBasement", required = false) Integer numberOfBasement,
													@RequestParam(value = "floorArea", required = false) Integer floorArea,
													@RequestParam(value = "rentPriceFrom", required = false) Integer rentPriceFrom,
													@RequestParam(value = "rentPriceTo", required = false) Integer rentPriceTo,
													@RequestParam(value = "direction", required = false) String direction,
													@RequestParam(value = "level", required = false) String level,
													@RequestParam(value = "rentAreaFrom", required = false) Integer rentAreaFrom,
													@RequestParam(value = "rentAreaTo", required = false) Integer rentAreaTo,
													@RequestParam(value = "managerName", required = false) String managerName,
													@RequestParam(value = "managerPhone", required = false) String managerPhone,
													@RequestParam(value = "staffId", required = false) Integer staffId,
													@RequestParam(value = "types", required = false) String types) {

		List<String> typeList = types != null ? Arrays.asList(types.split(",")) : Collections.emptyList();
		
		Map<String, Object> request = new HashMap<>();
		request.put("name", name);
		request.put("street", street);
		request.put("ward", ward);
		request.put("district", district);
		request.put("numberOfBasement", numberOfBasement);
		request.put("floorArea", floorArea);
		request.put("direction", direction);
		request.put("level", level);
		request.put("rentPriceFrom", rentPriceFrom);
		request.put("rentPriceTo", rentPriceTo);
		request.put("rentAreaFrom", rentAreaFrom);
		request.put("rentAreaTo",rentAreaTo);
		request.put("managerName", managerName);
	    request.put("managerPhone", managerPhone);
	    request.put("staffId", staffId);
	    request.put("type", typeList);

		List<BuildingSearchResponse> results = buildingService.findAll(request);
		return results;
	}

	@GetMapping("/{buildingid}")
	public BuildingDTO getBuildingDetail(@PathVariable("buildingid") Integer buildingid) {
		BuildingDTO result = new BuildingDTO();
		return result;
	}

	/*
	 * @PostMapping("/api/building") public BuildingBean createBuilding(@RequestBody
	 * BuildingBean newBuilding) { System.out.println(10/0);
	 * System.out.println("Hello"); return null; }
	 */

	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO newBuilding) {
		/*
		 * try { System.out.println(10 / 0); // success return newBuilding; } catch
		 * (Exception e) { ErrorResponseBean errorResponseBean = new
		 * ErrorResponseBean(); errorResponseBean.setError(e.getMessage()); List<String>
		 * details = new ArrayList<String>(); details.add("Lỗi rồi ní ơi!");
		 * details.add("Sửa lại lẹ đi"); errorResponseBean.setDetails(details); return
		 * errorResponseBean; }
		 */

		try {
			validateData(newBuilding);
			return newBuilding;
		} catch (FieldRequiredException e) {
			throw e;
		}
	}

	private void validateData(BuildingDTO newBuilding) {
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
	public void deleteBuilding(@RequestBody BuildingDTO deleteBuilding) {

		System.out.println("Hello delete");
	}

	@PutMapping
	public BuildingDTO updateBuilding(@RequestBody BuildingDTO updateBuilding) {
		BuildingDTO result = new BuildingDTO();
		return result;
	}

	@PostMapping("/assignment")
	public void assignmentBuilding(@RequestBody AssignmentBuildingDTO buildingId) {

	}
}
