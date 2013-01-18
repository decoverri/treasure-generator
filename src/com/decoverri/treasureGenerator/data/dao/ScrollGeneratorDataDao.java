package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.ScrollGeneratorData;

public class ScrollGeneratorDataDao {

	private final Session session;

	public ScrollGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(ScrollGeneratorData scrollGen) {
		session.save(scrollGen);
	}

}
