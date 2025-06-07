package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.repository.entity.RentAreaEntity;

public interface RentAreaRepository {

	List<RentAreaEntity> getRentArea(Long id);
}
