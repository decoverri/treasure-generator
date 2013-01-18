package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.WondrousItemGeneratorData;

public class WondrousItemGeneratorDataDao {

	private final Session session;

	public WondrousItemGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WondrousItemGeneratorData wondrousGen) {
		session.save(wondrousGen);
	}

}
