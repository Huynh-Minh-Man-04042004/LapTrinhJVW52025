package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.repository.entity.RentAreaEntity;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{

	private static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER = "root";
	private static final String PASS = "Dcmkok123";

	@Override
	public List<RentAreaEntity> getRentArea(Long id) {
		List<RentAreaEntity> rentAreas = new ArrayList<>();
		String query = "SELECT building.id,rentarea.value FROM rentarea" + 
				" JOIN building ON building.id = rentarea.buildingid" + 
				" WHERE buildingid = ?";
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				RentAreaEntity rentTypeEntity = new RentAreaEntity();
				rentTypeEntity.setValue(rs.getInt("value"));
				rentAreas.add(rentTypeEntity);
	        }
			return rentAreas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
