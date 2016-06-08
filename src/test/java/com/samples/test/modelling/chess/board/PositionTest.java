package com.samples.test.modelling.chess.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.samples.modelling.chess.PathStyle;
import com.samples.modelling.chess.board.Position;
import com.samples.modelling.chess.exceptions.InvalidPathStyleException;

/**
 * @author Mayank
 *
 */
public class PositionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetPathStyle() {
		PathStyle pathStyle = Position.getPathStyle(new Position("2-0"), new Position("2-1"));
		assertEquals(pathStyle, PathStyle.STRAIGHT);

		pathStyle = Position.getPathStyle(new Position("2-6"), new Position("7-6"));
		assertEquals(pathStyle, PathStyle.STRAIGHT);

	}

	@Test(expected = InvalidPathStyleException.class)
	public void testinValidPathStyle() {
		PathStyle pathStyle = Position.getPathStyle(new Position("2-0"), new Position("4-1"));
	}

	@Test
	public void testStraightDisplacement() {
		int displacement = Position.getDisplacement(new Position("2-6"), new Position("7-6"));
		assertEquals(displacement, 5);

		displacement = Position.getDisplacement(new Position("2-6"), new Position("2-2"));
		assertEquals(displacement, 4);

	}

	@Test(expected = InvalidPathStyleException.class)
	public void testSlantingDisplacement() {
		int displacement = Position.getDisplacement(new Position("1-1"), new Position("3-3"));
		assertEquals(displacement, 2);

	}

	@Test(expected = InvalidPathStyleException.class)
	public void testHorseJumpDisplacement() {
		int displacement = Position.getDisplacement(new Position("2-2"), new Position("3-4"));
		assertEquals(displacement, 3);
	}

	@Test
	public void testGetPathTraversed() {

	}

}
