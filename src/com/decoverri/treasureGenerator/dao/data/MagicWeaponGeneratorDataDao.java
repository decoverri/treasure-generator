package com.decoverri.treasureGenerator.dao.data;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.data.MagicWeaponGeneratorData;

public class MagicWeaponGeneratorDataDao {

	private final Session session;

	public MagicWeaponGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(MagicWeaponGeneratorData magicWeaponGen) {
		session.save(magicWeaponGen);
	}

}
