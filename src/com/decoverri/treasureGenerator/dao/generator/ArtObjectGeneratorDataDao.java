package com.decoverri.treasureGenerator.dao.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.ArtObjectGeneratorData;

public class ArtObjectGeneratorDataDao {

	private final Session session;

	public ArtObjectGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ArtObjectGeneratorData artGen) {
		session.save(artGen);
	}

}
