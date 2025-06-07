package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.repository.DistrictRepository;
import com.laptrinhjavaweb.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER = "root";
	private static final String PASS = "Dcmkok123";

	@Override
	public DistrictEntity findById(Long districtId) {
		DistrictEntity result = new DistrictEntity();
		String query = "SELECT * FROM district WHERE id = ?";

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				PreparedStatement pstmt = conn.prepareStatement(query)) {

			pstmt.setLong(1, districtId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new DistrictEntity();
				result.setCode(rs.getString("code"));
				result.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
