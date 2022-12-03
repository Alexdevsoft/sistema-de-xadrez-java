package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece{
	
	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOppenentPiece(Position position) {
		ChessPiece pos = (ChessPiece)getBoard().piece(position);
		return pos != null && pos.getColor() != color;
	}

}
