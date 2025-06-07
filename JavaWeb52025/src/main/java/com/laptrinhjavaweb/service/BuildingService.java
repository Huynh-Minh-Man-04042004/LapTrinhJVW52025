package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.model.response.BuildingSearchResponse;

public interface BuildingService {
	List<BuildingSearchResponse> findAll(Map<String, Object> request);
}
