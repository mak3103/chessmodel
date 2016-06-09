package com.samples.test.modelling.chess;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import com.samples.modelling.chess.ChessGame;
import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.board.Board;
import com.samples.modelling.chess.board.Position;
import com.samples.modelling.chess.chessmen.ChessMan;
import com.samples.modelling.chess.chessmen.Rook;


public class ChessGameTest {
	
	private ChessGame game;
	
	@Before
	public void setUp()
	{
		game = new ChessGame(8);
	}

	@Test
	public void testSize()
	{
		assertNotNull(game.getBoard().getSize());
		assertEquals(game.getBoard().getSize(), 8);
	}
	
	@Test
	public void testInitilizeGame() {
		game.initilizeGame();

		Board board = game.getBoard();
		ChessMan rook = board.getChessMan(new Position("0-0"));
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertThat(rook.getColor(), equalTo(Color.WHITE));

	}

	@Test
	public void testRookMove() {

		game.initilizeGame();
		//test move forward horizontally
		game.move(new Position("0-0"), new Position("0-3"));
		Board board = game.getBoard();
		
		assertNull(board.getChessMan(new Position("0-0")));
		ChessMan rook = board.getChessMan(new Position("0-3"));
		
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertThat(rook.getColor(), equalTo(Color.WHITE));

		//test move backward horizontally
		game.move(new Position("0-3"), new Position("0-1"));
		board = game.getBoard();
		
		assertNull(board.getChessMan(new Position("0-3")));
		
		rook = board.getChessMan(new Position("0-1"));
		
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertThat(rook.getColor(), equalTo(Color.WHITE));
		game.initilizeGame();

		//test move forward vertically
		game.move(new Position("0-0"), new Position("3-0"));
		board = game.getBoard();
		
		assertNull(board.getChessMan(new Position("0-0")));
		rook = board.getChessMan(new Position("3-0"));
		
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertThat(rook.getColor(), equalTo(Color.WHITE));

		//test move backward vertically
		game.move(new Position("3-0"), new Position("1-0"));
		board = game.getBoard();
		
		assertNull(board.getChessMan(new Position("3-0")));
		
		rook = board.getChessMan(new Position("1-0"));
		
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertThat(rook.getColor(), equalTo(Color.WHITE));

	}

	@Test
	public void testPut() {

		game.initilizeGame();
		game.put(new Rook("WR3", Color.WHITE), new Position("5-4"));
		
		ChessMan rook = game.getBoard().getChessMan(new Position("5-4"));
		
		assertNotNull(rook);
		assertThat(rook, instanceOf(Rook.class));
		assertEquals(rook.getId(), "WR3");
		assertEquals(rook.getColor(), Color.WHITE);
	}

}
