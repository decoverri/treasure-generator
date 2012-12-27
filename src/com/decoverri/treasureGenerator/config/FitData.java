package com.decoverri.treasureGenerator.config;

import java.io.IOException;

public class FitData {

	public static void main(String[] args) throws IOException {

		new FitGems().fit();
		new FitArtObjects().fit();
		new FitPotions().fit();
		
		new FitTreasureA().fit();
		new FitTreasureB().fit();
		new FitTreasureC().fit();
	}
}