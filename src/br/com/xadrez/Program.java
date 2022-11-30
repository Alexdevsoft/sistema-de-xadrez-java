package br.com.xadrez;

import br.com.chess.ChessMath;

/**
 * 
 * @author ALEX
 *
 */

public class Program {

	public static void main(String[] args) {
		
		ChessMath chessMath = new ChessMath();
		UI.printBoard(chessMath.getPieces());

	}

}
