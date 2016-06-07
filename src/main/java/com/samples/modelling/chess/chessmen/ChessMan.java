package com.samples.modelling.chess.chessmen;

import java.util.List;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.PathStyle;

public interface ChessMan {

	public Color getColor();
	public String getCurrentLocation();
	public List<PathStyle> getSupportedPathStyles();
	public boolean isValidDisplacement(int aDisplacement);

}
