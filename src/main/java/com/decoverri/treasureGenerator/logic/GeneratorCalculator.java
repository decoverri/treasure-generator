package com.decoverri.treasureGenerator.logic;

import java.util.List;

import org.springframework.stereotype.Component;

import com.decoverri.treasureGenerator.interfaces.Treasure;

@Component
public class GeneratorCalculator {

	public double calculateTotalValue(List<Treasure> treasures) {
		double totalPrice = 0;
		for (Treasure treasure : treasures) {
			totalPrice += treasure.getTreasureValue();
		}
		return totalPrice;
	}

}
