package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.StaffGeneratorData;

public class StaffGeneratorDataDao {

	private final Session session;

	public StaffGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(StaffGeneratorData staffGen) {
		session.save(staffGen);
	}

}
