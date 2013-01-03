package com.decoverri.treasureGenerator.config;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class FitData {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) throws IOException {

		Transaction transaction = session.beginTransaction();

		//TODO Find a way to not add repeated entries (in case of rerunning this class)
		new FitGems(session).fit();
		new FitArtObjects(session).fit();
		new FitPotionLevel(session).fit();
		new FitPotions(session).fit();
		new FitScrollLevel(session).fit();
		new FitScrolls(session).fit();
		new FitWandLevel(session).fit();
		new FitWand(session).fit();
		new FitArmor(session).fit();

		new FitTreasureA(session).fit();
		new FitTreasureB(session).fit();
		new FitTreasureC(session).fit();
		new FitTreasureD(session).fit();

		transaction.commit();
	}
}
