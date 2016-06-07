package com.samples.modelling.chess;

import java.util.List;

public enum PathStyle {

	STRAIGHT, SLANTING, HORSEJUMP;

	public List<String> getPathTraversed(String aStart, String aEnd) {
		switch (this) {
		case STRAIGHT:
			// TODO - implement logic;
			return null;
		case SLANTING:
			// TODO - implement logic;
			return null;
		default:
			// TODO - implement logic;
			return null;
		}
	}
}
