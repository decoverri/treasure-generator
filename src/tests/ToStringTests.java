package tests;

import static enums.Currency.PP;
import model.Armor;
import model.Coins;
import enums.Size;
import enums.SpecialMaterial;

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
