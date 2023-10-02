public class Chess {
	public static void test1() {
		Board b = Board.theBoard();
		Piece.registerPiece(new BishopFactory());
		Piece blackBishop = Piece.createPiece("bb");
		assert blackBishop.toString() = "bb";	//check if createPiece is correct
		
		b.addPiece(blackBishop, "c8");
		b.addPiece(blackBishop, "f8");

		Piece c8 = b.getPiece("c8");			//check if getPiece is correct
		assert c8.toString() = "bb";

		Piece f8 = b.getPiece("f8");			
		assert f8.toString() = "bb";

		b.movePiece("c8", "b7");				//check if movePiece is correct
		Piece b7 = b.getPiece("b7");			
		assert b7.toString() = "bb";		

		b.movePiece("f8", "g7");				
		Piece g7 = b.getPiece("g7");			
		assert g7.toString() = "bb";	

	}
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

	// Leave the following code at the end of the simulation:
	System.out.println("Final board:");
	Board.theBoard().iterate(new BoardPrinter());
    }
}