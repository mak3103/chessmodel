package com.samples.modelling.chess;

import java.util.List;

public class Rook implements ChessMan {

	private final Color color;
	private String currentLocation;
	private final PathStyle pathStyle = PathStyle.STRAIGHT;

	public Rook(Color aColor, String aLoc) {

		color = aColor;
		currentLocation = aLoc;
	}

	public Color getColor() {

		return color;
	}

	public String getCurrentLocation() {
		// TODO Auto-generated method stub
		return currentLocation;
	}

	public boolean isLegalMove(String aEndLoc) {
		// TODO Implement the validation logic for a rook's movement.
		return false;
	}

	public void move(String aStartLoc, String aEnd) {
		// TODO check if isLegalMove() and set the currentpos=aEnd

	}

	public List<String> getPathTraversed(String aStartLoc, String aEndLoc) {
		// TODO find the list of blocks covered from aStrat to aEnd.
		// return new Path(pathStyle)
		return pathStyle.getPathTraversed(aStartLoc, aEndLoc);
	}

}
