package com.samples.modelling.chess;

public class Block {
	private final Color color;
	private final ChessMan chessman;
	private final String location;

	public Block(Color aColor, ChessMan aPiece, String aLoc) {
		color = aColor;
		chessman = aPiece;
		location = aLoc;

	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @return the piece
	 */
	public ChessMan getChessMan() {
		return chessman;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

}
