package com.decoverri.treasureGenerator.fitData;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.decoverri.treasureGenerator.config.HibernateUtil;

public class FitData {

	private static final Session session = HibernateUtil.getSessionFactory().getCurrentSession();

	@Test
	public void fitTreasureTypes() throws Exception {
		Transaction transaction = session.beginTransaction();
		new FitTreasureTypes(session).fit();
		transaction.commit();
	}
	
//	public static void main(String[] args) throws IOException {
//		long inicio = System.currentTimeMillis();
//
//		
//
//		new FitGems(session).fit();
//
//		new FitArtObjects(session).fit();
//
//		new FitPotions(session).fit();
//		new FitPotionLevel(session).fit();
//
//		new FitScrolls(session).fit();
//		new FitScrollLevel(session).fit();
//
//		new FitWand(session).fit();
//		new FitWandLevel(session).fit();
//
//		new FitArmor(session).fit();
//		new FitSpecificArmor(session).fit();
//		new FitMagicArmorAbility(session).fit();
//		new FitMagicArmorStats(session).fit();
//
//		new FitWeapon(session).fit();
//		new FitSpecificWeapon(session).fit();
//		new FitMagicWeaponAbility(session).fit();
//		new FitFoe(session).fit();
//		new FitMagicWeaponStats(session).fit();
//
//		new FitWondrousItem(session).fit();
//		new FitWondrousItemBodySlot(session).fit();
//
//		new FitRing(session).fit();
//
//		new FitRod(session).fit();
//		new FitMetamagicRod(session).fit();
//
//		new FitStaff(session).fit();
//		
//		new FitTreasure(session).fit();
//
//
//		long fim = System.currentTimeMillis();
//		System.out.println("Total time: " + (fim - inicio)/1000.0 + "s");
//	}
}
