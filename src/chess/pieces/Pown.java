package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMath;
import chess.ChessPiece;
import chess.Color;

public class Pown extends ChessPiece {
	
	private ChessMath chessMatch;

	public Pown(Board board, Color color, ChessMath chessMatch) {
		super(board, color);
		this.chessMatch = chessMatch;

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position piece = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			piece.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsApiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() - 2, position.getColumn());
			Position piece2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsApiece(piece)
					&& getBoard().positionExists(piece2) && !getBoard().thereIsApiece(piece2) && getMoveCount() == 0) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(piece) && isThereOppenentPiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(piece) && isThereOppenentPiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOppenentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() - 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOppenentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() - 1][right.getColumn()] = true;
				}
			}
		}
		else {
			piece.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsApiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() + 2, position.getColumn());
			Position piece2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(piece) && !getBoard().thereIsApiece(piece)
					&& getBoard().positionExists(piece2) && !getBoard().thereIsApiece(piece2) && getMoveCount() == 0) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(piece) && isThereOppenentPiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			piece.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(piece) && isThereOppenentPiece(piece)) {
				mat[piece.getRow()][piece.getColumn()] = true;
			}
			
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() - 1);
				if(getBoard().positionExists(left) && isThereOppenentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() + 1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() + 1);
				if(getBoard().positionExists(right) && isThereOppenentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() + 1][right.getColumn()] = true;
				}
			}
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
