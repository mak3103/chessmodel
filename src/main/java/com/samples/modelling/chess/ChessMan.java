package com.samples.modelling.chess;

import java.util.List;

public interface ChessMan {

	public Color getColor();

	public String getCurrentLocation();

	public boolean isLegalMove(String aEndLoc);

	public void move(String aStartLoc, String aEnd);

	public List<String> getPathTraversed(String aStartLoc, String aEnd);
}
