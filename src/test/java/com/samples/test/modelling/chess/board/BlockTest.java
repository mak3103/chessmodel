package com.samples.test.modelling.chess.board;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.board.Block;
import com.samples.modelling.chess.chessmen.Rook;

/**
 * @author Mayank
 *
 */
public class BlockTest {

	private  Block emptyWBlock;
	private  Block rookBBlock;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		emptyWBlock= new Block(Color.WHITE);
		rookBBlock = new Block(Color.BLACK, new Rook("BR1",Color.WHITE));
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.samples.modelling.chess.board.Block#isVacant()}.
	 */
	@Test
	public void testIsVacant() {
		assertTrue(emptyWBlock.isVacant());
		assertFalse(rookBBlock.isVacant());
	}

}
