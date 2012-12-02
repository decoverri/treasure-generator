package com.decoverri.treasureGenerator.model;

import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.enums.SpecialMaterial;

public class Shield {

	private String nome;
	private boolean masterwork;
	private Size size;
	private SpecialMaterial specialMaterial;

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

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public SpecialMaterial getSpecialMaterial() {
		return specialMaterial;
	}

	public void setSpecialMaterial(SpecialMaterial specialmaterial) {
		this.specialMaterial = specialmaterial;
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
		return string.toUpperCase().substring(0, 1) + string.toLowerCase().substring(1);
	}
}
