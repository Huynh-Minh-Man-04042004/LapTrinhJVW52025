package com.laptrinhjavaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.entity.BuildingEntity;
import com.laptrinhjavaweb.utils.StringUtils;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER = "root";
	private static final String PASS = "Dcmkok123";

	@Override
	public List<BuildingEntity> findAll(Map<String, Object> request) {
		List<BuildingEntity> results = new ArrayList<BuildingEntity>();
		
		StringBuilder joins = new StringBuilder("");
		StringBuilder conditions = new StringBuilder("");
		StringBuilder havings = new StringBuilder("");
		StringBuilder sql = new StringBuilder("SELECT building.id,building.name,street,ward,districtid,floorarea,rentprice,servicefee,brokeragefee,managername,managerphone FROM building ");
		buildQueryJoin(joins,conditions,havings,request);
		buildQueryNotJoin(conditions,request);
		sql.append(joins + SystemConstant.ONE_EQUAL_ONE + conditions + " GROUP BY building.id " + havings);
		String sqlDebug = sql.toString();
		
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sqlDebug);) {
			while (rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setId(rs.getLong("id"));
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrictId(rs.getLong("districtid"));
				results.add(buildingEntity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public void buildQueryJoin(StringBuilder joins, StringBuilder conditions, StringBuilder havings, Map<String, Object> request) {
		if (!StringUtils.isNullOrEmpty((String) request.get("district"))) {
			joins.append(" JOIN district ON building.districtid = district.id ");
			conditions.append(" and district.code like '%" + request.get("district") + "%'");
		}
		if (request.get("rentAreaFrom") != null || request.get("rentAreaTo") != null) {
			joins.append(" JOIN rentarea ON rentarea.buildingid = building.id ");
			if (request.get("rentAreaFrom") != null) {
				conditions.append(" and rentarea.value >= " + request.get("rentAreaFrom"));
			}
			if (request.get("rentAreaTo") != null) {
				conditions.append(" and rentarea.value <= " + request.get("rentAreaTo"));
			}
		}
		if (request.get("staffId") != null) {
			joins.append(" JOIN assignmentbuilding ON assignmentbuilding.buildingid = building.id ");
			conditions.append(" and assignmentbuilding.staffid like '%" + request.get("staffId") + "%'");
		}
		List<String> types = (List<String>) request.get("type");
		if (types != null && !types.isEmpty()) {
			joins.append(" JOIN buildingrenttype ON building.id = buildingrenttype.buildingid JOIN renttype ON buildingrenttype.renttypeid = renttype.id ");
            String typeConditions = String.join("','", types);
            conditions.append(" AND renttype.code IN ('").append(typeConditions).append("')");
            //havings.append(" HAVING COUNT(DISTINCT renttype.code) = ").append(((List<String>) request.get("type")).size());
		}
	}

	public void buildQueryNotJoin(StringBuilder conditions, Map<String, Object> request) {
		if (!StringUtils.isNullOrEmpty((String) request.get("name"))) {
			conditions.append(" and building.name like '%" + request.get("name") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("street"))) {
			conditions.append(" and street like '%" + request.get("street") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("ward"))) {
			conditions.append(" and ward like '%" + request.get("ward") + "%'");
		}
		if (request.get("numberOfBasement") != null) {
			conditions.append(" and numberofbasement = " + request.get("numberOfBasement"));
		}
		if (request.get("floorArea") != null) {
			conditions.append(" and floorarea = " + request.get("floorArea"));
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("direction"))) {
			conditions.append(" and direction like '%" + request.get("direction") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("level"))) {
			conditions.append(" and level like '%" + request.get("level") + "%'");
		}
		if (request.get("rentPriceFrom") != null) {
			conditions.append(" and rentprice >= " + request.get("rentPriceFrom"));
		}
		if (request.get("rentPriceTo") != null) {
			conditions.append(" and rentprice <= " + request.get("rentPriceTo"));
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("managerName"))) {
			conditions.append(" and managername like '%" + request.get("managerName") + "%'");
		}
		if (!StringUtils.isNullOrEmpty((String) request.get("managerPhone"))) {
			conditions.append(" and managerphone like '%" + request.get("managerPhone") + "%'");
		}
	}
	
}
