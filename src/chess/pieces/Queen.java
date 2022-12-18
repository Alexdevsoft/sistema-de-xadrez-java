package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece{

	public Queen(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "Q";
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position pos = new Position(0, 0);
		pos.setValues(position.getRow() - 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsApiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOppenentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow(), position.getColumn() - 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsApiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() - 1);
		}
		if (getBoard().positionExists(pos) && isThereOppenentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos) && !getBoard().thereIsApiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
			pos.setColumn(pos.getColumn() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOppenentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		pos.setValues(position.getRow() + 1, position.getColumn());
		while (getBoard().positionExists(pos) && !getBoard().thereIsApiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
			pos.setRow(pos.getRow() + 1);
		}
		if (getBoard().positionExists(pos) && isThereOppenentPiece(pos)) {
			mat[pos.getRow()][pos.getColumn()] = true;
		}
		
		Position pos2 = new Position(0, 0);
		pos2.setValues(position.getRow() - 1, position.getColumn() -1);
		while (getBoard().positionExists(pos2) && !getBoard().thereIsApiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
			pos2.setValues(pos2.getRow() - 1, pos2.getColumn() -1);
		}
		if (getBoard().positionExists(pos2) && isThereOppenentPiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
		}
		
		pos2.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos2) && !getBoard().thereIsApiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
			pos2.setValues(pos2.getRow() -1, pos2.getColumn() + 1);
		}
		if (getBoard().positionExists(pos2) && isThereOppenentPiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
		}
		
		pos2.setValues(position.getRow(), position.getColumn() + 1);
		while (getBoard().positionExists(pos2) && !getBoard().thereIsApiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
			pos2.setValues(pos2.getRow(), pos2.getColumn() + 1);
		}
		if (getBoard().positionExists(pos2) && isThereOppenentPiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
		}
		
		pos2.setValues(position.getRow() + 1, position.getColumn() - 1);
		while (getBoard().positionExists(pos2) && !getBoard().thereIsApiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
			pos2.setValues(pos2.getRow() + 1, pos2.getColumn() - 1);
		}
		if (getBoard().positionExists(pos2) && isThereOppenentPiece(pos2)) {
			mat[pos2.getRow()][pos2.getColumn()] = true;
		}
		
		return mat;
	}

}
