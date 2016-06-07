package com.samples.modelling.chess.board;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.chessmen.ChessMan;

public class Block {
	private final Color color;
	private ChessMan chessman;

	public Block(Color aColor, ChessMan aPiece) {
		color = aColor;
		chessman = aPiece;
	}

	/**
	 * @return the chessman
	 */
	public ChessMan getChessman() {
		return chessman;
	}

	/**
	 * @param chessman the chessman to set
	 */
	public void setChessman(ChessMan chessman) {
		this.chessman = chessman;
	}

	public boolean isVacant()
	{
		if(chessman==null)
			return true;
		else return false;
	}
	public Block(Color aColor) {
		color = aColor;
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

}
