package br.com.generator.model;

import static br.com.generator.enums.Currency.GP;
import br.com.generator.enums.Currency;

public class Money {

	private double value;
	private Currency currency;

	public Money(double value, Currency currency) {
		this.value = value;
		this.currency = currency;
	}

	public Money(double value) {
		this.value = value;
		this.currency = GP;
	}

	public Money() {
		this.value = 0;
		this.currency = GP;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return (value + " " + currency).toLowerCase();
	}
}
