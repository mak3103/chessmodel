package com.samples.modelling.chess.exceptions;

public class InvalidPositionException extends RuntimeException {


	private static final long serialVersionUID = 5645612827066462327L;

	public InvalidPositionException() {
	super();
	}
	
	public InvalidPositionException(String aMsg) {
		super(aMsg);
		}
}
