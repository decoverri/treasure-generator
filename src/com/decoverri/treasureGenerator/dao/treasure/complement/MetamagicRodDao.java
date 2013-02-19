package com.decoverri.treasureGenerator.dao.treasure.complement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.model.treasure.complement.MetamagicRod;

@Component
public class MetamagicRodDao {

	@Autowired
	private Session session;

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
