package com.samples.modelling.chess;

import com.samples.modelling.chess.board.Board;
import com.samples.modelling.chess.board.Position;
import com.samples.modelling.chess.chessmen.Rook;

public class ChessGame {

	
	public static void main(String[] args) {
		Board board = new Board(8);
		board.putChessMan(new Rook(Color.BLACK), new Position("1-3"));
		board.putChessMan(new Rook(Color.BLACK), new Position("1-4"));

	}
}
