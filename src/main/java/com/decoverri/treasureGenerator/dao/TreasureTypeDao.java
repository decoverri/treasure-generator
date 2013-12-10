package com.decoverri.treasureGenerator.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.TreasureType;

@Component
public class TreasureTypeDao {

	private Session session;
	
	@Autowired
	public TreasureTypeDao(Session session) {
		this.session = session;
	}
	
	public void saveOrUpdate(TreasureType type) {
		session.saveOrUpdate(type);
	}

	@SuppressWarnings("unchecked")
	public List<TreasureType> getTreasureTypes() {
		return session.createQuery("select t from TreasureType t").list();
	}

}
