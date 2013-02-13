package com.decoverri.treasureGenerator.model.view;

import java.util.List;

public class TreasureTypeInfo {

	private String name;
	private String description;
	private List<Integer> values;

	public TreasureTypeInfo(String name, String description, List<Integer> values) {
		this.name = name;
		this.setDescription(description);
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Integer> getValues() {
		return values;
	}

	public void setValues(List<Integer> values) {
		this.values = values;
	}
}
