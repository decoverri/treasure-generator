package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.MagicWeaponGeneratorData;

public class MagicWeaponGeneratorDataDao {

	private final Session session;

	public MagicWeaponGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(MagicWeaponGeneratorData magicWeaponGen) {
		session.save(magicWeaponGen);
	}

}
