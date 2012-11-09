package br.com.generator.model;

import java.util.List;

import br.com.generator.enums.ProficiencyType;
import br.com.generator.enums.Size;
import br.com.generator.enums.SpecialMaterial;
import br.com.generator.enums.SpecialWeaponFeatures;
import br.com.generator.enums.WeaponType;

public class Weapon {

	private String nome;
	private boolean masterwork;
	private Money price;
	private ProficiencyType proficiency;
	private WeaponType weaponType;
	private Distance rangeIncrement;
	private Size size;
	private WeaponDamage damage;
	private Critical critical;
	private SpecialMaterial specialMaterial;
	private List<SpecialWeaponFeatures> specialFeatures;
	private Weight weight;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isMasterwork() {
		return masterwork;
	}

	public void setMasterwork(boolean masterwork) {
		this.masterwork = masterwork;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

	public ProficiencyType getProficiency() {
		return proficiency;
	}

	public void setProficiency(ProficiencyType proficiency) {
		this.proficiency = proficiency;
	}

	public WeaponType getWeaponType() {
		return weaponType;
	}

	public void setWeaponType(WeaponType weaponType) {
		this.weaponType = weaponType;
	}

	public Distance getRangeIncrement() {
		return rangeIncrement;
	}

	public void setRangeIncrement(Distance rangeIncrement) {
		this.rangeIncrement = rangeIncrement;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public WeaponDamage getDamage() {
		return damage;
	}

	public void setDamage(WeaponDamage damage) {
		this.damage = damage;
	}

	public Critical getCritical() {
		return critical;
	}

	public void setCritical(Critical critical) {
		this.critical = critical;
	}

	public SpecialMaterial getSpecialMaterial() {
		return specialMaterial;
	}

	public void setSpecialMaterial(SpecialMaterial specialmaterial) {
		this.specialMaterial = specialmaterial;
	}

	public List<SpecialWeaponFeatures> getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(List<SpecialWeaponFeatures> specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.size != null && this.size != Size.MEDIUM) {
			builder.append(this.size + " ");
		}
		if (isMasterwork()) {
			builder.append("masterwork ");
		}
		if (this.specialMaterial != null) {
			builder.append(this.specialMaterial + " ");
		}
		builder.append(this.nome);

		String string = builder.toString();
		return string.toUpperCase().substring(0, 1)
				+ string.toLowerCase().substring(1);
	}
}
