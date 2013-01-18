package com.decoverri.treasureGenerator.treasure.dao;

import static com.decoverri.treasureGenerator.enums.MagicItemRarity.UNCOMMON;
import static com.decoverri.treasureGenerator.enums.MagicType.DIVINE;

import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;

import com.decoverri.treasureGenerator.enums.HallowAdditionalSpell;
import com.decoverri.treasureGenerator.enums.MagicItemRarity;
import com.decoverri.treasureGenerator.enums.MagicType;
import com.decoverri.treasureGenerator.treasure.model.Scroll;

public class ScrollDao {

	private final Session session;

	public ScrollDao(Session session) {
		this.session = session;
	}

	public void save(Scroll scroll) {
		session.save(scroll);
	}

	public void saveOrUpdate(Scroll scroll) {
		session.saveOrUpdate(scroll);
	}

	public Scroll getScroll(int level, MagicItemRarity rarity, MagicType type, int roll) {
		Query query = session.createQuery("select s from Scroll s where s.spellLevel = :level and s.rarity = :rarity and " +
							"s.type = :type and :roll >= bottomValue and :roll <= topValue")
							.setParameter("level", level)
							.setParameter("rarity", rarity)
							.setParameter("type", type)
							.setParameter("roll", roll);
		Scroll scroll = (Scroll) query.list().get(0);
		if (level == 5 && rarity == UNCOMMON && type == DIVINE && roll > 98) {
			int i = new Random().nextInt(HallowAdditionalSpell.values().length);
			scroll.setSpell(scroll.getSpell() + " " + HallowAdditionalSpell.values()[i]);
		}
		return scroll;
	}

}
