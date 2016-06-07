package com.samples.modelling.chess.exceptions;

public class InvalidMoveException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1947096922544741861L;

	public InvalidMoveException() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	public InvalidMoveException(String aMsg)
	{
		super(aMsg);
	}
}
