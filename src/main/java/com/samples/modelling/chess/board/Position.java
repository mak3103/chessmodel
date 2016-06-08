package com.samples.modelling.chess.board;

import java.util.ArrayList;
import java.util.List;

import com.samples.modelling.chess.PathStyle;
import com.samples.modelling.chess.exceptions.InvalidPathStyleException;

/**
 * @author Mayank The class representing a position on the chess board.
 *
 */
public class Position {

	/**
	 * The x coordinate.
	 */
	private final int xIndex;

	/**
	 * The y coordinate.
	 */
	private final int yIndex;

	/**
	 * Accepts a string separating the x and y coordinates by a hyphen.
	 * 
	 * @param aPos
	 */
	public Position(String aPos) {
		String[] indices = aPos.split("-");
		xIndex = Integer.parseInt(indices[0]);
		yIndex = Integer.parseInt(indices[1]);
	}

	/**
	 * @return the xIndex
	 */
	public int getxIndex() {
		return xIndex;
	}

	/**
	 * @return the yIndex
	 */
	public int getyIndex() {
		return yIndex;
	}

	/**
	 * The method calculates the path style.
	 * 
	 * @param aStart
	 *            - the start position.
	 * @param aEnd
	 *            - the end position.
	 * @return - A path style that is applicable when a piece moves from aStart
	 *         to aEnd.
	 */
	public static PathStyle getPathStyle(Position aStart, Position aEnd) {
		if (isStraightPath(aStart, aEnd))
			return PathStyle.STRAIGHT;

		/*
		 * Not yet implemented. if (isSlantingPath(aStart, aEnd)) return
		 * PathStyle.SLANTING; if (isHorseJump(aStart, aEnd)) return
		 * PathStyle.HORSEJUMP;
		 */
		throw new InvalidPathStyleException(
				"The path from source " + aStart + " to destination " + aEnd + " is not a valid path style.");
	}

	// Not needded for the first iteration.
	// TODO - Implementation needs to be done.
	private static boolean isHorseJump(Position aStart, Position aEnd) {
		return false;
	}

	// Not needded for the first iteration.
	// TODO - Implementation needs to be done.
	private static boolean isSlantingPath(Position aStart, Position aEnd) {
		return false;
	}

	private static boolean isStraightPath(Position aStart, Position aEnd) {
		if (aStart.getxIndex() == aEnd.getxIndex() || aStart.getyIndex() == aEnd.getyIndex())
			return true;
		else
			return false;
	}

	/**
	 * Returns the no of blocks travelled by the piece if it goes from aStart to
	 * aEnd.
	 * 
	 * @param aStart
	 *            - the starting position
	 * @param aEnd
	 *            - the final position of the piece.
	 * @return - the no of blocks travelled by the piece in the move.
	 */
	public static int getDisplacement(Position aStart, Position aEnd) {

		PathStyle pathStyle = getPathStyle(aStart, aEnd);
		int displacement = 0;

		switch (pathStyle) {
		case STRAIGHT:
			if (aStart.getxIndex() == aEnd.getxIndex()) {
				displacement = Math.abs(aStart.getyIndex() - aEnd.getyIndex());
			} else {
				displacement = Math.abs(aStart.getxIndex() - aEnd.getxIndex());
			}
			break;
		case SLANTING:
			throw new UnsupportedOperationException("The slanting path style is not yet supported.");

		case HORSEJUMP:
			throw new UnsupportedOperationException("The horsejump path style is not yet supported.");

		}
		return displacement;
	}

	/**
	 * The method returns the list of positions covered by the piece in a move.
	 * 
	 * @param aStart
	 *            - the start position.
	 * @param aEnd
	 *            - the end position.
	 * @return - the list of positions travelled by the piece.
	 */
	public static List<Position> getPathTraversed(Position aStart, Position aEnd) {
		PathStyle pathStyle = getPathStyle(aStart, aEnd);
		List<Position> path = new ArrayList<Position>();
		switch (pathStyle) {
		case STRAIGHT:
			if (aStart.getxIndex() == aEnd.getxIndex()) {
				if (aStart.getyIndex() < aEnd.getyIndex()) {
					for (int i = aStart.getyIndex(); i < aEnd.getyIndex(); i++) {
						path.add(new Position(aStart.getxIndex() + "-" + i));
					}
				} else {
					for (int i = aStart.getyIndex(); i > aEnd.getyIndex(); i--) {
						path.add(new Position(aStart.getxIndex() + "-" + i));
					}
				}
			} else {
				if (aStart.getxIndex() < aEnd.getxIndex()) {
					for (int i = aStart.getxIndex(); i < aEnd.getxIndex(); i++) {
						path.add(new Position(i + "-" + aStart.getyIndex()));
					}
				} else {
					for (int i = aStart.getxIndex(); i > aEnd.getxIndex(); i--) {
						path.add(new Position(i + "-" + aStart.getyIndex()));
					}
				}
			}
			break;
		case SLANTING:
			throw new UnsupportedOperationException("The slanting path style is not yet supported.");

		case HORSEJUMP:
			throw new UnsupportedOperationException("The horsejump path style is not yet supported.");

		}
		return path;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return xIndex + "-" + yIndex;
	}
}
