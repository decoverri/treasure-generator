package br.com.generator.test;

import static br.com.generator.enums.Currency.PP;
import br.com.generator.enums.Size;
import br.com.generator.enums.SpecialMaterial;
import br.com.generator.model.Armor;
import br.com.generator.model.Money;

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
		
		System.out.println(new Money());
		System.out.println(new Money(42));
		System.out.println(new Money(3, PP));
	}
}
