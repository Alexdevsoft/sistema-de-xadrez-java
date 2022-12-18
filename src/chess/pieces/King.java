package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMath chessMatch;

	public King(Board board, Color color, ChessMath chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;
		
	}
	
	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		ChessPiece pos = (ChessPiece)getBoard().piece(position);
		return pos == null || pos.getColor() != getColor();
	}
	
	private boolean testRookCastling(Position position) {
		ChessPiece pos = (ChessPiece)getBoard().piece(position);
		return pos != null && pos instanceof Rook && pos.getColor() == getColor() && pos.getMoveCount() == 0;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position pos = new Position(0, 0);
		
		pos.setValues(position.getRow() - 1, position.getColumn());
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() + 1, position.getColumn());
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow(), position.getColumn() - 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow(), position.getColumn() + 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() - 1, position.getColumn() - 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() - 1, position.getColumn() + 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() + 1, position.getColumn() - 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() + 1, position.getColumn() + 1);
		if(getBoard().positionExists(pos) && canMove(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		if(getMoveCount() == 0 && !chessMatch.getCheck()) {
			Position posT1 = new Position(position.getRow(), position.getColumn() + 3);
			if(testRookCastling(posT1)) {
				Position pos1 = new Position(position.getRow(), position.getColumn() + 1);
				Position pos2 = new Position(position.getRow(), position.getColumn() + 2);
				if(getBoard().piece(pos1) == null && getBoard().piece(pos2) == null) {
					mat[position.getRow()][position.getColumn() + 2] = true;
				}
			}
		}
		Position posT2 = new Position(position.getRow(), position.getColumn() - 4);
		if(testRookCastling(posT2)) {
			Position pos1 = new Position(position.getRow(), position.getColumn() - 1);
			Position pos2 = new Position(position.getRow(), position.getColumn() - 2);
			Position pos3 = new Position(position.getRow(), position.getColumn() - 3);
			if(getBoard().piece(pos1) == null && getBoard().piece(pos2) == null && getBoard().piece(pos3) == null) {
				mat[position.getRow()][position.getColumn() - 2] = true;
			}
		}
		
		return mat;
	}

}
