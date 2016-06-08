package com.samples.modelling.chess.board;

import java.util.List;

import com.samples.modelling.chess.ChessGame;
import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.chessmen.ChessMan;
import com.samples.modelling.chess.exceptions.InvalidMoveException;
import com.samples.modelling.chess.exceptions.InvalidPositionException;
import com.samples.modelling.chess.exceptions.PostionNotVacantException;

/**
 * @author Mayank - The class representing the board. It abstracts the
 *         implementation of the board logic with the help of {@link Position}
 *         and {@link Block} classes from the rest of the code.
 *
 */
public class Board {

	/**
	 * The array of {@link Block} representing a square board.
	 */
	private final Block[][] boardStructure;

	/**
	 * The simple contructor which takes an integer n as the size.
	 * 
	 * @param n
	 *            - the size of the board.
	 */
	public Board(int n) {
		// TODO Auto-generated constructor stub
		boardStructure = new Block[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ((i + j) % 2 == 0)
					boardStructure[i][j] = new Block(Color.WHITE);
				else
					boardStructure[i][j] = new Block(Color.BLACK);
			}

		}
	}

	/**
	 * The method puts a given {@link ChessMan} at the given {@link Position}.
	 * 
	 * @param aPiece
	 *            - the {@link ChessMan} object to be placed on board.
	 * @param aPos
	 *            - the {@link Position} object at which the {@link ChessMan}
	 *            whould be placed.
	 */
	public void putChessMan(ChessMan aPiece, Position aPos) {
		Block block = getBlock(aPos);
		if (!block.isVacant()) {
			throw new PostionNotVacantException("The Position " + aPos + " is not vacant to be occupied.");
		}

		block.setChessman(aPiece);
	}

	/**
	 * The method provides the {@link ChessMan} placed at the given position.
	 * 
	 * @param aPos-
	 *            The position from which {@link ChessMan} is needed.
	 * @return - The {@link ChessMan} object placed at the given position.
	 */
	public ChessMan getChessMan(Position aPos) {
		return getBlock(aPos).getChessMan();
	}

	/**
	 * The method to move the {@link ChessMan} present at the starting position
	 * to the end position. The method does check for the board level invariants
	 * but not the rules specific to individual {@link ChessMan}.
	 * 
	 * @param aStart
	 *            - The starting position.
	 * @param aEnd
	 *            - The end position.
	 */
	public void move(Position aStart, Position aEnd) {

		Block srcblock = getBlock(aStart);
		Block destblock = getBlock(aEnd);
		ChessMan piece = srcblock.getChessman();

		checkBoardInvariats(aStart, aEnd, srcblock, destblock);

		srcblock.setChessman(null);
		destblock.setChessman(piece);

	}

	/**
	 * Checks for various board invariants like the source position shouldnt be
	 * vacant and destination block should be vacant. Please note that this
	 * provides a validation for board only rules. The rules specific to
	 * {@link ChessMan} will be handled by the respective implementations and
	 * coordinated by the {@link ChessGame} class.
	 * 
	 * @param aStart
	 *            - the start position of the move.
	 * @param aEnd
	 *            - the end position of the move.
	 * @param srcblock
	 *            - the source block.
	 * @param destblock
	 *            - the destination block.
	 */
	private void checkBoardInvariats(Position aStart, Position aEnd, Block srcblock, Block destblock) {
		if (srcblock.isVacant()) {
			throw new InvalidMoveException("No Chessman is sound at the source position - " + aStart);
		}
		if (!destblock.isVacant()) {
			throw new InvalidMoveException("The Position " + aEnd + " is not vacant to be occupied.");
		}

		List<Position> path = Position.getPathTraversed(aStart, aEnd);

		if (!checkPathVacant(path)) {
			throw new InvalidMoveException("The path from source position " + aStart + " to destination position" + aEnd
					+ " is not vacant for move.");
		}
	}

	/**
	 * Checks if the path traversed in a move is vacant to be taken.
	 * 
	 * @param path
	 *            - the list of positions present on the path.
	 * @return - true if the path is vacant and is valid for move, else returns
	 *         false.
	 */
	private boolean checkPathVacant(List<Position> path) {
		// TODO Auto-generated method stub
		for (int i = 1; i < path.size(); i++) {
			if (!getBlock(path.get(i)).isVacant()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * The method for returning a block corresponding to a given position.
	 * 
	 * @param aPos
	 *            - the position for which block is needed.
	 * @return - the block at the given position.
	 */
	private Block getBlock(Position aPos) {
		if (aPos.getxIndex() < 0 || aPos.getxIndex() > boardStructure.length || aPos.getyIndex() < 0
				|| aPos.getyIndex() > boardStructure.length) {
			throw new InvalidPositionException("The provided position " + aPos + " is not a valid position in board. ");
		}
		return boardStructure[aPos.getxIndex()][aPos.getyIndex()];
	}

	/**
	 * The simple print method to print or display the board in a simple text
	 * format.
	 */
	public void print() {
		System.out.println(
				"****************************************************************************************************************************************************************************************************");
		for (int i = 0; i < boardStructure.length; i++) {
			for (int j = 0; j < boardStructure.length; j++) {
				System.out.print(boardStructure[i][j]);
				System.out.print("\t\t\t");
			}
			System.out.println();
		}
		System.out.println(
				"****************************************************************************************************************************************************************************************************");
		System.out.println();
	}

	/**
	 * The method provides the size of a board.
	 * 
	 * @return - the integer representing the size of the board.
	 */
	public int getSize() {
		return boardStructure.length;
	}
}
