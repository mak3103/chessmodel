package com.samples.modelling.chess;

public enum Color {

	WHITE, BLACK;

	public String toString() {
		if (this == WHITE)
			return "W";
		else
			return "B";
	}
}
