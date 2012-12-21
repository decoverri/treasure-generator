package com.decoverri.treasureGenerator.config;

import java.io.IOException;

public class FitData {

	public static void main(String[] args) throws IOException {
		new FitGems().fit();
		
		new FitTreasureA().fit();
		new FitTreasureB().fit();
	}
}
