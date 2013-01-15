package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.StaffGeneratorData;

public class StaffGeneratorDataDao {

	private final Session session;

	public StaffGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(StaffGeneratorData staffGen) {
		session.save(staffGen);
	}

}
