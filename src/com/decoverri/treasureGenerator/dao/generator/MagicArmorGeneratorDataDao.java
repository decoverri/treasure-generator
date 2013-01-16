package com.decoverri.treasureGenerator.dao.generator;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.generator.MagicArmorGeneratorData;

public class MagicArmorGeneratorDataDao {

	private final Session session;

	public MagicArmorGeneratorDataDao(Session session) {
		this.session = session;
	}

	public void save(MagicArmorGeneratorData magicArmorGen) {
		session.save(magicArmorGen);
	}

}
