package br.com.generator.model;

public class ArtObject {

	private String name;
	private ArtGrade grade;
	private Money price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArtGrade getGrade() {
		return grade;
	}

	public void setGrade(ArtGrade grade) {
		this.grade = grade;
	}

	public Money getPrice() {
		return price;
	}

	public void setPrice(Money price) {
		this.price = price;
	}

}
