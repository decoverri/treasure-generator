package com.decoverri.treasureGenerator.dao.data;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.data.WondrousItemGeneratorData;

public class WondrousItemGeneratorDataDao {

	private final Session session;

	public WondrousItemGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(WondrousItemGeneratorData wondrousGen) {
		session.save(wondrousGen);
	}

}
