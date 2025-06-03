package com.laptrinhjavaweb.bean;

public class BuildingBean {

	private Long id;
	private String name;
	private String street;
	private Integer numberOfBasement;
	private String[] types;
	private Long[] buildingIds;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String[] getTypes() {
		return types;
	}

	public void setTypes(String[] types) {
		this.types = types;
	}

	public Long[] getBuildingIds() {
		return buildingIds;
	}

	public void setBuildingIds(Long[] buildingIds) {
		this.buildingIds = buildingIds;
	}

}
