package com.samples.modelling.chess.chessmen;

import java.util.ArrayList;
import java.util.List;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.PathStyle;


/**
 * @author Mayank
 *The class represnets the Rook in the game of chess and behaves like it.
 */
public class Rook implements ChessMan {

	/**
	 * The color of the rook.
	 */
	private final Color color;
	
	/**
	 * The list of path stypes supported by rook. It only spoorts straight run.
	 */
	private final List<PathStyle> pathStyles;

	/**
	 * 
	 * @param aColor - The color of the rook to be created.
	 */
	public Rook(Color aColor) {

		color = aColor;
		pathStyles = new ArrayList<PathStyle>();
		pathStyles.add(PathStyle.STRAIGHT);
	}


	public Color getColor() {

		return color;
	}

	public List<PathStyle> getSupportedPathStyles() {
		return new ArrayList<PathStyle>(pathStyles);
	}

	public boolean isValidDisplacement(int aDisplacement) {
		// The rook has no limit for displacement. It is only restricted by the board length. 
		return true;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return color.toString()+"R";
	}
}
