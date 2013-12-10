package com.decoverri.treasureGenerator.dao;

import static ch.lambdaj.Lambda.convert;

import java.util.List;

import org.hibernate.Session;

import ch.lambdaj.function.convert.Converter;

import com.decoverri.treasureGenerator.model.TreasureTypeValue;


public class TreasureTypeValueDao {

	private Session session;
	
	public TreasureTypeValueDao(Session session) {
		this.session = session;
	}

	public void saveOrUpdate(List<TreasureTypeValue> values) {

		List<Integer> ints = convert(values, new Converter<TreasureTypeValue, Integer>() {

			@Override
			public Integer convert(TreasureTypeValue value) {
				return value.getValue();
			}
		});

		@SuppressWarnings("unchecked")
		List<TreasureTypeValue> treasureTypeValues = session.createQuery("select v from TreasureTypeValue v where value in (:values)").setParameterList("values", ints).list();
		
		for (TreasureTypeValue value : values) {
			if(!treasureTypeValues.contains(value)){
				session.save(value);
			}else{
				values.remove(value);
			}
		}
		values.addAll(treasureTypeValues);
		
	}

}
