package com.samples.modelling.chess.board;

import java.util.List;

import com.samples.modelling.chess.PathStyle;

public class Position {

	private final int xIndex;
	private final int yIndex;

	public Position(String aPos) {
		// TODO Auto-generated constructor stub
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

	public static PathStyle getPathStyle(Position aStart, Position aEnd) {
		if (isStraightPath(aStart, aEnd))
			return PathStyle.STRAIGHT;
	
		/*Not yet implemented.
		 * if (isSlantingPath(aStart, aEnd))
			return PathStyle.SLANTING;
		if (isHorseJump(aStart, aEnd))
			return PathStyle.HORSEJUMP;
			*/
		throw new InvalidPathStyleException(
				"The path from source " + aStart + " to destination " + aEnd + " is not a valid path style.");
	}

	private static boolean isHorseJump(Position aStart, Position aEnd) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isSlantingPath(Position aStart, Position aEnd) {
		// TODO Auto-generated method stub
		return false;
	}

	private static boolean isStraightPath(Position aStart, Position aEnd) {
		if (aStart.getxIndex() == aEnd.getxIndex() || aStart.getyIndex() == aEnd.getyIndex())
			return true;
		else
			return false;
	}

	public static int getDisplacement(Position aStart, Position aEnd) {
		return 0;
	}

	public static List<Position> getPathTraversed(Position aStart, Position aEnd) {
		// TODO Auto-generated method stub
		return null;
	}
}
