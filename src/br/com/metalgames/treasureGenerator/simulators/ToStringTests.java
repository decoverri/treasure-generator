package br.com.metalgames.treasureGenerator.simulators;

import static br.com.metalgames.treasureGenerator.enums.Currency.PP;
import br.com.metalgames.treasureGenerator.enums.Size;
import br.com.metalgames.treasureGenerator.enums.SpecialMaterial;
import br.com.metalgames.treasureGenerator.model.Armor;
import br.com.metalgames.treasureGenerator.model.Coins;

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
