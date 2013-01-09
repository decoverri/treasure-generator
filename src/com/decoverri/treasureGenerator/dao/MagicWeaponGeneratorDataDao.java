package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.MagicWeaponGeneratorData;

public class MagicWeaponGeneratorDataDao {

	private final Session session;

	public MagicWeaponGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(MagicWeaponGeneratorData magicWeaponGen) {
		session.save(magicWeaponGen);
	}

}
