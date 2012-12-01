package br.com.metalgames.treasureGenerator.model;

import br.com.metalgames.treasureGenerator.enums.Size;
import br.com.metalgames.treasureGenerator.enums.SpecialMaterial;
import br.com.metalgames.treasureGenerator.interfaces.Treasure;

public class Armor implements Treasure {

	private long id;

	private String nome;

	private boolean masterwork;

//	@Enumerated(EnumType.STRING)
	private Size size;

	private SpecialMaterial specialMaterial;

	private int intervalMin;

	private int intervalMax;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public int getIntervalMin() {
		return intervalMin;
	}

	public void setIntervalMin(int intervalMin) {
		this.intervalMin = intervalMin;
	}

	public int getIntervalMax() {
		return intervalMax;
	}

	public void setIntervalMax(int intervalMax) {
		this.intervalMax = intervalMax;
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
