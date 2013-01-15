package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.PotionGeneratorData;

public class PotionGeneratorDataDao {

	private final Session session;

	public PotionGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(PotionGeneratorData potionGen) {
		session.save(potionGen);
	}

}
