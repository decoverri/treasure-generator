package br.com.generator.interfaces;

import br.com.generator.enums.DamageType;

public interface Damage extends DiceGenerated{

	public DamageType getType();

}
