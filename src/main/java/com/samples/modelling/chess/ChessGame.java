package com.samples.modelling.chess;

import java.util.ArrayList;
import java.util.List;

import com.samples.modelling.chess.board.Board;
import com.samples.modelling.chess.board.Position;
import com.samples.modelling.chess.chessmen.ChessMan;
import com.samples.modelling.chess.chessmen.Rook;


/**
 * @author Mayank The class representing a chess game where we have a board and
 *         chessmen. The class is responsible for initializing a {@link Board}
 *         with {@link ChessMan}. It checks for the legality of a given move by
 *         delegating to respective {@link ChessMan}. This also is  a place
 *         to implement game level rules like max no. of rooks, total pieces allowed etc.
 *
 */
public class ChessGame {

	/**
	 * The {@link Board} object.
	 */
	private final Board board;
	
	/**
	 * The list of white chessmen held by the player playing with white. 
	 */
	private final List<ChessMan> whiteChessmen = new ArrayList<ChessMan>();

	/**
	 * The list of black chessmen held by the player playing with black. 
	 */
	private final List<ChessMan> blackChessmen = new ArrayList<ChessMan>();

	/**
	 * initialize the game of chess.
	 * @param n - the size of the board to play with.
	 */
	public ChessGame(int n) {
		// TODO Auto-generated constructor stub
		board = new Board(n);
	}

	/**
	 * Initializes the board and places the chessmen on the board at their positions.
	 */
	public void initilizeGame() {
		// Initializing Rook.
		board.putChessMan(new Rook("WR1", Color.WHITE), new Position("0-0"));
		board.putChessMan(new Rook("WR2", Color.WHITE), new Position("0-" + (board.getSize() - 1)));
		board.putChessMan(new Rook("BR1", Color.BLACK), new Position((board.getSize() - 1) + "-0"));
		board.putChessMan(new Rook("BR2", Color.BLACK),
				new Position((board.getSize() - 1) + "-" + (board.getSize() - 1)));

		// TODO Add the respective chessmen in lists too.
		// The rest of the pieces can be initiated when they are available.
	}

	/**
	 * The method determines if a given move is valid or not based on the game's
	 * rules. It fetches the displacement and path style for the given move and
	 * then delegates it to the respective {@link ChessMan} to confirm if that
	 * is a valid behavior. PLease note the board level validation is not done
	 * here but is done as part of the actual move.
	 * 
	 * @param aPiece
	 *            - The {@link ChessMan} which is to be moved.
	 * @param aStart
	 *            - The starting position of the move.
	 * @param aEnd
	 *            - The end position of the move.
	 * @return - True if it is a legal move, false otherwise.
	 */
	private boolean isLegalMove(ChessMan aPiece, Position aStart, Position aEnd) {
		// TODO Implement the validation logic for a rook's movement.
		int size = board.getSize();

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

	/**
	 * The method moves a {@link ChessMan} from the start position to the
	 * destination position if that is valid move for the piece placed at start
	 * position. In case its not a legal move for the {@link ChessMan} or it is
	 * not valid based on the current {@link Board} position, a suitable runtime
	 * exception is thrown.
	 * 
	 * @param aStart
	 *            - the starting position.
	 * @param aEnd
	 *            - The end position.
	 */
	public void move(Position aStart, Position aEnd) {
		ChessMan piece = board.getChessMan(aStart);
		if (isLegalMove(piece, aStart, aEnd))
			board.move(aStart, aEnd);
	}

	/**
	 * The method to put a given {@link ChessMan} piece at the specified
	 * location if that is a valid put based on the rules of the game.
	 * 
	 * @param aPiece
	 *            - The piece to be put.
	 * @param aPos
	 *            - The position at which the piece needs to be put.
	 */
	public void put(ChessMan aPiece, Position aPos) {
		validatePut();
		board.putChessMan(aPiece, aPos);
	}

	/**
	 * This method will perform certain validations for the requested put move
	 * such as the no of chessman shouldnt exceed the max no. It will also check
	 * if all instances of a particular chessman(eg Rook, etc) are already
	 * there. This will throw runtime exception based on the type of validation
	 * failed.
	 */
	private void validatePut() {
		// TODO Auto-generated method stub
		// Not implemented yet.

	}

	/**
	 * Prints the current game with the board and chessmen placed at it.
	 */
	public void displayGameStatus()
	{
		board.print();
	}
	

}
