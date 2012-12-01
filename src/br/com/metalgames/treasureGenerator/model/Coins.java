package br.com.metalgames.treasureGenerator.model;

import static br.com.metalgames.treasureGenerator.enums.Currency.GP;
import br.com.metalgames.treasureGenerator.enums.Currency;
import br.com.metalgames.treasureGenerator.interfaces.Treasure;

public class Coins implements Treasure {

	private double amount;
	private Currency currency;

	public Coins(double value, Currency currency) {
		this.amount = value;
		this.currency = currency;
	}

	public Coins(double value) {
		this.amount = value;
		this.currency = GP;
	}

	public Coins(Currency currency) {
		this.amount = 0;
		this.currency = currency;
	}

	public Coins() {
		this.amount = 0;
		this.currency = GP;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double value) {
		this.amount = value;
	}

	public Currency getCurrency() {
		return currency;
	}

	@Override
	public String toString() {
		return (amount + " " + currency).toLowerCase();
	}
}
