package com.decoverri.treasureGenerator.data.dao;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.data.model.MagicArmorGeneratorData;

public class MagicArmorGeneratorDataDao {

	private final Session session;

	public MagicArmorGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(MagicArmorGeneratorData magicArmorGen) {
		session.save(magicArmorGen);
	}

}
