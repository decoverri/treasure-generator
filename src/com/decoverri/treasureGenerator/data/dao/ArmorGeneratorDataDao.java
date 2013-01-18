package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.ArmorGeneratorData;

public class ArmorGeneratorDataDao {

	private final Session session;

	public ArmorGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ArmorGeneratorData armorGen) {
		session.save(armorGen);
	}

}
