package com.decoverri.treasureGenerator.dao.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.WondrousItemGeneratorData;

public class WondrousItemGeneratorDataDao {

	private final Session session;

	public WondrousItemGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WondrousItemGeneratorData wondrousGen) {
		session.save(wondrousGen);
	}

}
