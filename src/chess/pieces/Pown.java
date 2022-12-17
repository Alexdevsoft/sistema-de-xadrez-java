package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pown extends ChessPiece {

	public Pown(Board board, Color color) {
		super(board, color);

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
		}
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
