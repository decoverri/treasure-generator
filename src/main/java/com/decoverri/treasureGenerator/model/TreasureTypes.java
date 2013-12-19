package com.decoverri.treasureGenerator.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TreasureTypes {

	private List<TreasureType> treasureTypes = new ArrayList<TreasureType>();

	public List<TreasureType> getTreasureTypes() {
		return treasureTypes;
	}

	public void setTreasureTypes(List<TreasureType> treasureTypes) {
		this.treasureTypes = treasureTypes;
	}

	public String getFomattedSumOfValues() {
		return NumberFormat.getInstance(Locale.ENGLISH).format(sumAllValues());
	}
	
	private int sumAllValues() {
		int sum = 0;
		for (TreasureType type : treasureTypes) {
			if (type != null) {
				sum += sumValuesOfType(type);
			}
		}
		return sum;
	}

	private int sumValuesOfType(TreasureType type) {
		int sum = 0;
		for (TreasureTypeValue typeValues : type.getValues()) {
			sum += typeValues.getValue();
		}
		return sum;
	}
}
