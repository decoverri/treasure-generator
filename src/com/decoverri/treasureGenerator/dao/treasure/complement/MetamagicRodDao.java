package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod;

public class MetamagicRodDao {

	private final Session session;

	public MetamagicRodDao(Session session) {
		this.session = session;
	}

	public void save(MetamagicRod metamagic) {
		session.save(metamagic);
	}

	public void saveOrUpdate(MetamagicRod metamagic) {
		session.saveOrUpdate(metamagic);
	}

	public MetamagicRod getMetamagicRod(int spellLevelIncrement, int roll) {
		Query query = session.createQuery("select m from MetamagicRod m where spellLevelIncrement = :increment and " +
										  ":roll >= bottomValue and :roll <= topValue")
										  .setParameter("increment", spellLevelIncrement)
										  .setParameter("roll", roll);
		return (MetamagicRod) query.list().get(0);
	}

}
