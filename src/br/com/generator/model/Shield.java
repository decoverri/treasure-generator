package br.com.generator.model;

import java.util.List;

import br.com.generator.enums.Size;
import br.com.generator.enums.SpecialMaterial;
import br.com.generator.enums.SpecialWeaponFeatures;

public class Shield {

	private String nome;
	private boolean masterwork;
	private Money price;
	private Size size;
	private int CABonus;
	private int checkPenalty;
	private Percent spellFailureChance;
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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getCABonus() {
		return CABonus;
	}

	public void setCABonus(int cABonus) {
		CABonus = cABonus;
	}

	public int getCheckPenalty() {
		return checkPenalty;
	}

	public void setCheckPenalty(int checkPenalty) {
		this.checkPenalty = checkPenalty;
	}

	public Percent getSpellFailureChance() {
		return spellFailureChance;
	}

	public void setSpellFailureChance(Percent spellFailureChance) {
		this.spellFailureChance = spellFailureChance;
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
		return string.toUpperCase().substring(0,1) + string.toLowerCase().substring(1) ;
	}
}
