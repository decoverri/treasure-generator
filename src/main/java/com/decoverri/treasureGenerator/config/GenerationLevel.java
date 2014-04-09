package com.decoverri.treasureGenerator.config;

import org.apache.log4j.Level;

public class GenerationLevel extends Level {

	public static final int GENERATION_INT = DEBUG_INT - 10;

	public static final Level GENERATION = new GenerationLevel(GENERATION_INT, "GENERATION", 10);

	protected GenerationLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
	}

	public static Level toLevel(String logArgument) {
		if (logArgument != null && logArgument.toUpperCase().equals("GENERATION")) {
			return GENERATION;
		}
		return (Level) toLevel(logArgument);
	}

	public static Level toLevel(int val) {
		if (val == GENERATION_INT) {
			return GENERATION;
		}
		return (Level) toLevel(val, Level.DEBUG);
	}

	public static Level toLevel(int val, Level defaultLevel) {
		if (val == GENERATION_INT) {
			return GENERATION;
		}
		return Level.toLevel(val, defaultLevel);
	}

	public static Level toLevel(String logArgument, Level defaultLevel) {
		if (logArgument != null && logArgument.toUpperCase().equals("GENERATION")) {
			return GENERATION;
		}
		return Level.toLevel(logArgument, defaultLevel);
	}
}
