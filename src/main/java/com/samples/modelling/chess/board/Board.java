package com.samples.modelling.chess.board;

import java.util.List;

import com.samples.modelling.chess.Color;
import com.samples.modelling.chess.PathStyle;
import com.samples.modelling.chess.chessmen.ChessMan;
import com.samples.modelling.chess.exceptions.InvalidMoveException;
import com.samples.modelling.chess.exceptions.InvalidPositionException;
import com.samples.modelling.chess.exceptions.PostionNotVacantException;

public class Board {

	private final Block[][] boardStructure;

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

	public void arrangeChessmen() {
		// TODO for future
	}

	public void putChessMan(ChessMan aPiece, Position aPos) {
		Block block = getBlock(aPos);
		if (!block.isVacant()) {
			throw new PostionNotVacantException("The Position " + aPos + " is not vacant to be occupied.");
		}

		block.setChessman(aPiece);
	}

	public void move(Position aStart, Position aEnd) {

		Block srcblock = getBlock(aStart);
		Block destblock = getBlock(aEnd);

		if (srcblock.isVacant()) {
			throw new InvalidMoveException("No Chessman is sound at the source position - " + aStart);
		}
		if (!destblock.isVacant()) {
			throw new InvalidMoveException("The Position " + aEnd + " is not vacant to be occupied.");
		}
		ChessMan piece = srcblock.getChessman();
		boolean isLegalMove = this.isLegalMove(piece, aStart, aEnd);
		if (!isLegalMove) {
			throw new InvalidMoveException(
					"The movement from position " + aStart + " to position " + aEnd + " is not valid.");
		}
		List<Position> path = Position.getPathTraversed(aStart, aEnd);

		if (!checkPathVacant(path)) {
			throw new InvalidMoveException("The path from source position " + aStart + " to destination position" + aEnd
					+ " is not vacant for move.");
		}

		srcblock.setChessman(null);
		destblock.setChessman(piece);

	}

	public boolean isLegalMove(ChessMan aPiece, Position aStart, Position aEnd) {
		// TODO Implement the validation logic for a rook's movement.
		int size = boardStructure.length;
		PathStyle proposedPathStyle = Position.getPathStyle(aStart, aEnd);
		int proposedDisplacement = Position.getDisplacement(aStart, aEnd);
		List<PathStyle> supportedPathStyles = aPiece.getSupportedPathStyles();

		if (!supportedPathStyles.contains(proposedPathStyle)) {
			return false;
		}
		if (!aPiece.isValidDisplacement(proposedDisplacement)) {
			return false;
		}
		if (proposedDisplacement > size) {
			return false;
		}

		return true;
	}

	private boolean checkPathVacant(List<Position> path) {
		// TODO Auto-generated method stub
		for (int i = 1; i < path.size(); i++) {
			if (!getBlock(path.get(i)).isVacant()) {
				return false;
			}
		}
		return true;
	}

	private Block getBlock(Position aPos) {
		if(aPos.getxIndex()<0||aPos.getxIndex()>boardStructure.length||aPos.getyIndex()<0||aPos.getyIndex()>boardStructure.length)
		{
			throw new InvalidPositionException("The provided position "+aPos+" is not a valid position in board. ");
		}
		return boardStructure[aPos.getxIndex()][aPos.getyIndex()];
	}

	public void print() {
		// TODO Auto-generated method stub
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
}
