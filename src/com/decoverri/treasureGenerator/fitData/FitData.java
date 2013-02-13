package com.decoverri.treasureGenerator.fitData;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.decoverri.treasureGenerator.config.HibernateUtil;

public class FitData {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	public static void main(String[] args) throws IOException {
		long inicio = System.currentTimeMillis();

		Transaction transaction = session.beginTransaction();

		new FitGems(session).fit();
		new FitArtObjects(session).fit();

		new FitPotions(session).fit();
		new FitPotionLevel(session).fit();

		new FitScrolls(session).fit();
		new FitScrollLevel(session).fit();

		new FitWand(session).fit();
		new FitWandLevel(session).fit();

		new FitArmor(session).fit();
		new FitSpecificArmor(session).fit();
		new FitMagicArmorAbility(session).fit();
		new FitMagicArmorStats(session).fit();

		new FitWeapon(session).fit();
		new FitSpecificWeapon(session).fit();
		new FitMagicWeaponAbility(session).fit();
		new FitFoe(session).fit();
		new FitMagicWeaponStats(session).fit();

		new FitWondrousItem(session).fit();
		new FitWondrousItemBodySlot(session).fit();

		new FitRing(session).fit();

		new FitRod(session).fit();
		new FitMetamagicRod(session).fit();

		new FitStaff(session).fit();
		
		new FitTreasureA(session).fit();
		new FitTreasureB(session).fit();
		new FitTreasureC(session).fit();
		new FitTreasureD(session).fit();
		new FitTreasureE(session).fit();
		new FitTreasureF(session).fit();
		new FitTreasureG(session).fit();
		new FitTreasureH(session).fit();
		new FitTreasureI(session).fit();

		new FitTreasure(session).fit();

		transaction.commit();

		long fim = System.currentTimeMillis();
		System.out.println("Total time: " + (fim - inicio)/1000.0 + "s");
	}
}
