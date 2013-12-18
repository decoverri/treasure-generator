package com.decoverri.treasureGenerator.dao;

import static ch.lambdaj.Lambda.convert;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.lambdaj.function.convert.Converter;

import com.decoverri.treasureGenerator.model.TreasureTypeValue;

@Component
public class TreasureTypeValueDao {

	private Session session;
	
	@Autowired
	public TreasureTypeValueDao(Session session) {
		this.session = session;
	}

	public void saveOrLoad(List<TreasureTypeValue> values) {

		List<Integer> ints = convert(values, new Converter<TreasureTypeValue, Integer>() {

			@Override
			public Integer convert(TreasureTypeValue value) {
				return value.getValue();
			}
		});

		@SuppressWarnings("unchecked")
		List<TreasureTypeValue> treasureTypeValues = session.createQuery("select v from TreasureTypeValue v where value in (:values)").setParameterList("values", ints).list();
		
		for (TreasureTypeValue value : new ArrayList<TreasureTypeValue>(values)) {
			if(!treasureTypeValues.contains(value)){
				session.saveOrUpdate(value);
			}else{
				values.remove(value);
			}
		}
		values.addAll(treasureTypeValues);
		
	}

	@SuppressWarnings("unchecked")
	public List<Integer> getValuesForLetter(char letter) {
		return session.createQuery("select v.value from TreasureType t join t.values v where t.letter=:letter order by v.value").setParameter("letter", letter).list();
	}

	@SuppressWarnings("unchecked")
	public List<TreasureTypeValue> getTypeValuesForLetter(char letter) {
		return session.createQuery("select v from TreasureType t join t.values v where t.letter=:letter order by v.value").setParameter("letter", letter).list();
	}

}
