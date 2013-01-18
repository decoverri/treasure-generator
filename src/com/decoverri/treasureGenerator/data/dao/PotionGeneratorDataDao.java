package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.PotionGeneratorData;

public class PotionGeneratorDataDao {

	private final Session session;

	public PotionGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(PotionGeneratorData potionGen) {
		session.save(potionGen);
	}

}
