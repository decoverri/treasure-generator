package com.decoverri.treasureGenerator.dao.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.ArmorGeneratorData;

public class ArmorGeneratorDataDao {

	private final Session session;

	public ArmorGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ArmorGeneratorData armorGen) {
		session.save(armorGen);
	}

}
