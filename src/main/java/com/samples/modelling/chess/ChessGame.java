package com.samples.modelling.chess;

import com.samples.modelling.chess.board.Board;
import com.samples.modelling.chess.board.Position;
import com.samples.modelling.chess.chessmen.Rook;

public class ChessGame {

	
	public static void main(String[] args) {
		Board board = new Board(8);
		board.putChessMan(new Rook(Color.BLACK), new Position("0-7"));
		board.putChessMan(new Rook(Color.WHITE), new Position("3-7"));
		board.print();
		board.move(new Position("0-7"), new Position("7-7"));
		board.print();
	}
}
