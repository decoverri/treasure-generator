package model;

import interfaces.Table;

import java.util.HashMap;


public class TreasureTypeATable implements Table{

	@Override
	public HashMap<Integer, HashMap<String, Integer>> getMap() {

		HashMap<String, Integer> data = new HashMap<String, Integer>();
		data.put("CPNumberOfDice", 0);
		data.put("CPBaseDice", 0);
		data.put("CPMultiplier", 1);
		data.put("SPNumberOfDice", 0);
		data.put("SPBaseDice", 0);
		data.put("SPMultiplier", 1);
		data.put("GPNumberOfDice", 0);
		data.put("GPBaseDice", 0);
		data.put("GPMultiplier", 1);
		data.put("PPNumberOfDice", 0);
		data.put("PPBaseDice", 0);
		data.put("PPMultiplier", 1);

		HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();

		data.put("CPNumberOfDice", 5);
		data.put("CPBaseDice", 10);
		data.put("SPNumberOfDice", 3);
		data.put("SPBaseDice", 4);
		map.put(1, data);

		data.put("CPNumberOfDice", 2);
		data.put("CPBaseDice", 6);
		data.put("CPMultiplier", 10);
		data.put("SPNumberOfDice", 4);
		data.put("SPBaseDice", 8);
		data.put("GPNumberOfDice", 1);
		data.put("GPBaseDice", 4);
		map.put(5, data);

		data.put("CPNumberOfDice", 5);
		data.put("CPBaseDice", 10);
		data.put("CPMultiplier", 10);
		data.put("SPNumberOfDice", 5);
		data.put("SPBaseDice", 10);
		data.put("GPNumberOfDice", 1);
		data.put("GPBaseDice", 8);
		map.put(10, data);
		
		data.put("CPNumberOfDice", 2);
		data.put("CPBaseDice", 4);
		data.put("CPMultiplier", 100);
		data.put("SPNumberOfDice", 3);
		data.put("SPBaseDice", 6);
		data.put("SPMultiplier", 10);
		data.put("GPNumberOfDice", 4);
		data.put("GPBaseDice", 4);
		map.put(25, data);
		
		data.put("CPNumberOfDice", 4);
		data.put("CPBaseDice", 4);
		data.put("CPMultiplier", 100);
		data.put("SPNumberOfDice", 4);
		data.put("SPBaseDice", 6);
		data.put("SPMultiplier", 10);
		data.put("GPNumberOfDice", 8);
		data.put("GPBaseDice", 6);
		map.put(50, data);
		
		data.put("SPNumberOfDice", 6);
		data.put("SPBaseDice", 8);
		data.put("SPMultiplier", 10);
		data.put("GPNumberOfDice", 3);
		data.put("GPBaseDice", 4);
		data.put("GPMultiplier", 10);
		map.put(100, data);
		
		data.put("SPNumberOfDice", 2);
		data.put("SPBaseDice", 4);
		data.put("SPMultiplier", 100);
		data.put("GPNumberOfDice", 4);
		data.put("GPBaseDice", 4);
		data.put("GPMultiplier", 10);
		data.put("PPNumberOfDice", 2);
		data.put("PPBaseDice", 4);
		map.put(200, data);
		
		data.put("GPNumberOfDice", 6);
		data.put("GPBaseDice", 6);
		data.put("GPMultiplier", 10);
		data.put("PPNumberOfDice", 8);
		data.put("PPBaseDice", 6);
		map.put(500, data);
		
		data.put("GPNumberOfDice", 2);
		data.put("GPBaseDice", 4);
		data.put("GPMultiplier", 100);
		data.put("PPNumberOfDice", 10);
		data.put("PPBaseDice", 10);
		map.put(1000, data);
		
		data.put("GPNumberOfDice", 4);
		data.put("GPBaseDice", 8);
		data.put("GPMultiplier", 100);
		data.put("PPNumberOfDice", 6);
		data.put("PPBaseDice", 10);
		data.put("PPMultiplier", 10);
		map.put(5000, data);
		
		data.put("GPNumberOfDice", 2);
		data.put("GPBaseDice", 4);
		data.put("GPMultiplier", 1000);
		data.put("PPNumberOfDice", 12);
		data.put("PPBaseDice", 8);
		data.put("PPMultiplier", 10);
		map.put(10000, data);
		
		data.put("GPNumberOfDice", 2);
		data.put("GPBaseDice", 6);
		data.put("GPMultiplier", 1000);
		data.put("PPNumberOfDice", 8);
		data.put("PPBaseDice", 10);
		data.put("PPMultiplier", 100);
		map.put(50000, data);
		
		
		return map;
	}

}
