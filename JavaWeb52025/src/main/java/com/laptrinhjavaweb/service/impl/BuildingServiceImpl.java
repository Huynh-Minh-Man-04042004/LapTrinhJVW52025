package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;
import com.laptrinhjavaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private DistrictRepository districtRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;

	@Override
	public List<BuildingSearchResponse> findAll(Map<String, Object> request) {
		List<BuildingSearchResponse> result = new ArrayList<>();
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(request);
		for (BuildingEntity item : buildingEntities) {
			BuildingSearchResponse buildingFilter = new BuildingSearchResponse();
			buildingFilter.setName(item.getName());
			
			DistrictEntity districtEntity = districtRepository.findById(item.getDistrictId());		
			buildingFilter.setAddress(item.getStreet() + " - " + item.getWard() + " - " + districtEntity.getName());
			
			buildingFilter.setManagerName(item.getManagerName());
			buildingFilter.setManagerPhone(item.getManagerPhone());
			buildingFilter.setFloorArea(item.getFloorArea());
			
			List<RentAreaEntity> areaEntities = rentAreaRepository.getRentArea(item.getId());
			StringBuilder rentAreas = new StringBuilder();
			for(RentAreaEntity rentAreaEntity: areaEntities) {
				if(rentAreas.length()>1) {
					rentAreas.append(",");
				}
				rentAreas.append(rentAreaEntity.getValue());
			}
			buildingFilter.setRentArea(rentAreas.toString());
			
			buildingFilter.setRentPrice(item.getRentPrice());
			buildingFilter.setServiceFee(item.getServiceFee());
			buildingFilter.setBrokerageFee(item.getBrokerageFee());
			result.add(buildingFilter);
		}
		return result;
	}

}
