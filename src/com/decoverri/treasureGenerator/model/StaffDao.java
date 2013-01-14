package com.decoverri.treasureGenerator.model;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.MagicItemStrength;

public class StaffDao {

	private final Session session;

	public StaffDao(Session session) {
		this.session = session;
	}

	public void save(Staff staff) {
		session.save(staff);
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
