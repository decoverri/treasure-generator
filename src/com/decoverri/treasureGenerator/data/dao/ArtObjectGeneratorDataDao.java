package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.ArtObjectGeneratorData;

public class ArtObjectGeneratorDataDao {

	private final Session session;

	public ArtObjectGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ArtObjectGeneratorData artGen) {
		session.save(artGen);
	}

}
