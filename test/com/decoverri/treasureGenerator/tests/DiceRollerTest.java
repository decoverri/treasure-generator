package com.decoverri.treasureGenerator.tests;

import static org.junit.Assert.*;


import org.junit.Test;

import com.decoverri.treasureGenerator.logic.DiceRoller;
import com.decoverri.treasureGenerator.model.Dice;



public class DiceRollerTest {

	@Test
	public void testIfGeneratesNumberInTheRightIntervalWhenRollingASingleDie() {
		DiceRoller diceRoller = new DiceRoller();
		int result;

		for (int i = 4; i <= 12; i += 2) {
			Dice dice = new Dice(i);
			result = diceRoller.roll(1, dice);
			assertTrue(result >= 1 && result <= i);
		}
		Dice dice = new Dice(20);
		result = diceRoller.roll(1, dice);
		assertTrue(result >= 1 && result <= 20);

		dice = new Dice(100);
		result = diceRoller.roll(1, dice);
		assertTrue(result >= 1 && result <= 100);
	}

}
