package com.decoverri.treasureGenerator.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.decoverri.treasureGenerator.enums.ArmorType;
import com.decoverri.treasureGenerator.enums.Size;
import com.decoverri.treasureGenerator.interfaces.Treasure;

@Entity
public class Armor implements Treasure {

	@Id
	@GeneratedValue
	private long id;
	
	private String name;
	private double price;
	
	@Enumerated(EnumType.STRING)
	private ArmorType type;
	
	@Transient
	private Size size;
	
	@Embedded
	private Interval interval;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public ArmorType getType() {
		return type;
	}

	public void setType(ArmorType type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if (this.size != null && this.size != Size.MEDIUM) {
			builder.append(this.size + " ");
		}
		double totalPrice = this.price + 150.0;
		builder.append("masterwork " + this.name + " (price " + totalPrice + "gp)");

		String string = builder.toString();
		return string.toUpperCase().substring(0, 1) + string.toLowerCase().substring(1);
	}

}
