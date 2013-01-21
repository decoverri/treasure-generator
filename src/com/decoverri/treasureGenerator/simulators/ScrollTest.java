package com.decoverri.treasureGenerator.simulators;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.COMMON;
import static com.decoverri.treasureGenerator.enums.MagicType.ARCANE;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;
import com.decoverri.treasureGenerator.dao.treasure.ScrollDao;
import com.decoverri.treasureGenerator.model.treasure.Scroll;

public class ScrollTest {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) {
		Transaction transaction = session.beginTransaction();
		ScrollDao dao = new ScrollDao(session);
		Scroll scroll = dao.getScroll(0, COMMON, ARCANE, 2);
		transaction.commit();
		System.out.println(scroll);
	}
}
