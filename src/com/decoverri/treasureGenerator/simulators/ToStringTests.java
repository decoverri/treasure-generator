package com.decoverri.treasureGenerator.simulators;

import static com.decoverri.treasureGenerator.enums.Currency.PP;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.enums.SpecialMaterial;
import com.decoverri.treasureGenerator.model.Armor;
import com.decoverri.treasureGenerator.model.Coins;


public class ToStringTests {

	public static void main(String[] args) {
		Armor armor = new Armor();

		armor.setNome("fullplate");
		System.out.println(armor);

		armor.setMasterwork(true);
		System.out.println(armor);

		armor.setSize(Size.SMALL);
		System.out.println(armor);

		armor.setSpecialMaterial(SpecialMaterial.ADAMANTINE);
		System.out.println(armor);
		
		System.out.println(new Coins());
		System.out.println(new Coins(42));
		System.out.println(new Coins(3, PP));
	}
}
