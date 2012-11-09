package br.com.generator.model;

public class Gemstone {

	private String name;
	private GemGrade grade;
	private Interval chanceInterval;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GemGrade getGrade() {
		return grade;
	}

	public void setGrade(GemGrade grade) {
		this.grade = grade;
	}

	public Interval getChanceInterval() {
		return chanceInterval;
	}

	public void setChanceInterval(Interval chanceInterval) {
		this.chanceInterval = chanceInterval;
	}

}
