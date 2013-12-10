package com.decoverri.treasureGenerator.model.treasure.data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.interfaces.GeneratorData;

@Entity
public class ArmorGeneratorData implements GeneratorData {

	@Id
	@GeneratedValue
	private long id;

	@Enumerated(EnumType.STRING)
	private ArmorType type;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArmorType getType() {
		return type;
	}

	public void setType(ArmorType type) {
		this.type = type;
	}

}
