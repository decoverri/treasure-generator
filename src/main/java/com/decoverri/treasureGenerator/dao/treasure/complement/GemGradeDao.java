package com.decoverri.treasureGenerator.dao.treasure.complement;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.complement.GemGrade;

@Component
public class GemGradeDao {

	private Session session;

	@Autowired
	public GemGradeDao(Session session) {
		this.session = session;
	}

	public void save(GemGrade grade) {
		session.save(grade);
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
