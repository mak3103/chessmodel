package com.samples.modelling.chess.exceptions;

public class PostionNotVacantException extends RuntimeException {



	/**
	 * 
	 */
	private static final long serialVersionUID = -1763519212393328422L;

	public PostionNotVacantException() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	public PostionNotVacantException(String aMsg)
	{
		super(aMsg);
	}
}
