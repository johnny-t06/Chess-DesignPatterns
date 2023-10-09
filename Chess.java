/*
 * CS121 Project 2: Design Patterns with Chess
 * Author: Johnny Tan
 * Date: 10/6/2023
 */



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Chess {
	private static List <Character> validColumn = new LinkedList<>(){{
		add('a');
		add('b');
		add('c');
		add('d');
		add('e');
		add('f');
		add('g');
		add('h');

	}}; 
	private static List <Character> validRow = new LinkedList<>() {{
		add('1');
		add('2');
		add('3');
		add('4');
		add('5');
		add('6');
		add('7');
		add('8');

	}};
	private static List <Character> validColor = new LinkedList<>() {{
		add('w');
		add('b');
	}};

	private static List <Character> validPiece = new LinkedList<> () {{
		add('k');
		add('q');
		add('n');
		add('b');
		add('r');
		add('p');

	}};

    public static void main(String[] args) {
	if (args.length != 2) {
	    System.out.println("Usage: java Chess layout moves");
	}
	
		Piece.registerPiece(new KingFactory());
		Piece.registerPiece(new QueenFactory());
		Piece.registerPiece(new KnightFactory());
		Piece.registerPiece(new BishopFactory());
		Piece.registerPiece(new RookFactory());
		Piece.registerPiece(new PawnFactory());
		Board.theBoard().registerListener(new Logger());
	// args[0] is the layout file name
	// args[1] is the moves file name
	// Put your code to read the layout file and moves files
	// here.

	try {
		BufferedReader layoutReader = new BufferedReader(new FileReader(args[0]));
		BufferedReader movesReader = new BufferedReader(new FileReader(args[1]));
		String lineHolder;		//change readline?
		char column, row, color, pieceType;
		while ((lineHolder = layoutReader.readLine()) != null) {
			if (lineHolder.charAt(0) != '#') {
				column = lineHolder.charAt(0);
				row = lineHolder.charAt(1);		//skip the = in At(2)
				color = lineHolder.charAt(3);
				pieceType = lineHolder.charAt(4);
				if (validColumn.contains(column) && validRow.contains(row) && validColor.contains(color) && validPiece.contains(pieceType)) {
					String location = lineHolder.substring(0, 2);
					String fullPiece = lineHolder.substring(3);

					Board.theBoard().addPiece(Piece.createPiece(fullPiece), location);
				}else {
					throw new RuntimeException();
				}
			}
		}

		while ((lineHolder = movesReader.readLine()) != null) {
			if (lineHolder.charAt(0) != '#') {
				char movesCol1 = lineHolder.charAt(0);
				char movesCol2 = lineHolder.charAt(3);

				char movesRow1 = lineHolder.charAt(1);		//skip the hypen in At(2)
				char movesRow2 = lineHolder.charAt(4);

				if (validColumn.contains(movesCol1) && validColumn.contains(movesCol2) && validRow.contains(movesRow1) && validRow.contains(movesRow2)) {
					String fromLoc = lineHolder.substring(0, 2);
					String toLoc = lineHolder.substring(3);
					Board.theBoard().movePiece(fromLoc, toLoc);
				}else {
					throw new RuntimeException();
				}
			}
		}
		layoutReader.close();
		movesReader.close();

		
	}catch (IOException e) {

	}
	



	

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}