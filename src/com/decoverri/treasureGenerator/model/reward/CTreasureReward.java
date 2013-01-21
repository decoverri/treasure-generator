package com.decoverri.treasureGenerator.model.reward;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.decoverri.treasureGenerator.model.data.ArtObjectGeneratorData;

@Entity
public class CTreasureReward {

	@Id
	@GeneratedValue
	private long id;

	private int value;

	@OneToMany
	private List<ArtObjectGeneratorData> arts;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<ArtObjectGeneratorData> getArts() {
		return arts;
	}

	public void setArts(List<ArtObjectGeneratorData> arts) {
		this.arts = arts;
	}

}
