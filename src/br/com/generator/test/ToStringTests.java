package br.com.generator.test;

import br.com.generator.enums.Size;
import br.com.generator.enums.SpecialMaterial;
import br.com.generator.model.Armor;

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
	}
}
