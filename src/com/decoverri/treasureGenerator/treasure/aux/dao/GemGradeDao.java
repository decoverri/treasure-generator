package com.decoverri.treasureGenerator.treasure.aux.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.decoverri.treasureGenerator.treasure.aux.model.GemGrade;

public class GemGradeDao {

	private final Session session;

	public GemGradeDao(Session session) {
		this.session = session;
	}

	public void save(GemGrade grade) {
		session.save(grade);
	}

	public void saveOrUpdate(GemGrade grade) {
		session.saveOrUpdate(grade);
	}

	@SuppressWarnings("unchecked")
	public GemGrade searchByGradeNumber(GemGrade grade) {
		Criteria criteria = session.createCriteria(GemGrade.class);
		criteria.add(Restrictions.eq("grade", grade.getGrade()));
		List<GemGrade> list = criteria.list();
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}
