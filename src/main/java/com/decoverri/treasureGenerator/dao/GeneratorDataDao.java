package com.decoverri.treasureGenerator.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.interfaces.GeneratorData;

@Component
public class GeneratorDataDao {

	@Autowired
	private Session session;

	public void save(GeneratorData genData) {
		session.save(genData);
	}

}
