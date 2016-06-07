package com.samples.modelling.chess.chessmen;

import java.util.List;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.PathStyle;

/**
 * @author Mayank The interface represents a chessman or chess piece. All the
 *         chessman must implement this interface.
 *
 */
public interface ChessMan {

	/**
	 * 
	 * @return - the color of the chessman.
	 */
	public Color getColor();

	/**
	 * 
	 * @return The list of supported path styles like straight, slanting and
	 *         horsejump.
	 */
	public List<PathStyle> getSupportedPathStyles();

	/**
	 * 
	 * @param aDisplacement
	 *            Accepts an int parameter and checks if it is a valid
	 *            displacement.
	 * @return - true if valid displacement for the current piece else false.
	 */
	public boolean isValidDisplacement(int aDisplacement);

}
