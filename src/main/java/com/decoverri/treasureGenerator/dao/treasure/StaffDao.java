package com.decoverri.treasureGenerator.dao.treasure;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;
import com.decoverri.treasureGenerator.model.treasure.Staff;

@Component
public class StaffDao {

	private Session session;

	@Autowired
	public StaffDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(Staff staff) {
		session.saveOrUpdate(staff);
	}

	public Staff getStaff(MagicItemStrength strength, int roll) {
		Query query = session.createQuery("select s from Staff s where strength = :strength and " +
										  ":roll >= bottomValue and :roll <= topValue")
										  .setParameter("strength", strength)
										  .setParameter("roll", roll);
		return (Staff) query.list().get(0);
	}

}
