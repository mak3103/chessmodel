package com.samples.modelling.chess.board;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.chessmen.ChessMan;


/**
 * @author Mayank.
 * This class represents one square block in the chess board.
 *
 */
public class Block {
	/**
	 * 
	 * The color of the square. 
	 */
	private final Color color;
	
	/**
	 * 
	 *The piece that is placed in the square. A null value means the square block is vacant. 
	 */
	private ChessMan chessman;

	/**
	 * 
	 * Contructor to create the Block.
	 */
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

	/**
	 * The method tells if the current block is occupied or not. 
	 * @return
	 */
	public boolean isVacant()
	{
		if(chessman==null)
			return true;
		else return false;
	}
	
	/**
	 * The contructor for creating a vacant block. 
	 * @param aColor
	 */
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
