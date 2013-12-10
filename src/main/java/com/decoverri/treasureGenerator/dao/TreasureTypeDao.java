package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.TreasureType;

public class TreasureTypeDao {

	private Session session;
	
	public TreasureTypeDao(Session session) {
		this.session = session;
	}
	
	public void saveOrUpdate(TreasureType type) {
		session.saveOrUpdate(type);
	}

	@SuppressWarnings("unchecked")
	public List<TreasureType> getTreasureTypes() {
		return session.createQuery("select * from TreasureType").list();
	}

}
