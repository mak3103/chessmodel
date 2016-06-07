package com.samples.modelling.chess.chessmen;

import java.util.ArrayList;
import java.util.List;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.PathStyle;

public class Rook implements ChessMan {

	private final Color color;
	private final List<PathStyle> pathStyles;

	public Rook(Color aColor) {

		color = aColor;
		pathStyles = new ArrayList<PathStyle>();
		pathStyles.add(PathStyle.STRAIGHT);
	}

	public Color getColor() {

		return color;
	}

	public String getCurrentLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PathStyle> getSupportedPathStyles() {
		// TODO Auto-generated method stub
		return new ArrayList<PathStyle>(pathStyles);
	}

	public boolean isValidDisplacement(int aDisplacement) {
		// TODO Auto-generated method stub
		return true;
	}





}
