package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.ArtObjectGeneratorData;

public class ArtObjectGeneratorDataDao {

	private final Session session;

	public ArtObjectGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ArtObjectGeneratorData artGen) {
		session.save(artGen);
	}


}
