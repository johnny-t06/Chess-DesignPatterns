import java.util.*;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)


    public static void test1() {
	Board b = Board.theBoard();
	Piece.registerPiece(new PawnFactory());
	Piece p = Piece.createPiece("bp");
	b.addPiece(p, "a3");
	assert b.getPiece("a3") == p;
    b.clear();
    }
    
    public static void testWhiteRooks () {
        Board b = Board.theBoard();
	    Piece.registerPiece(new RookFactory());
	    Piece p = Piece.createPiece("wr");
	    Piece p2 = Piece.createPiece("wr");

        b.addPiece(p, "a1");
        b.addPiece(p2, "h1");
        
        assert b.getPiece("a1") == p;
        assert b.getPiece("h1") == p2;

        b.movePiece("a1", "a5");
        b.movePiece("h1", "h7");
        
        assert b.getPiece("a1") == null;
        assert b.getPiece("h1") == null;

        
        assert b.getPiece("a5") == p;
        assert b.getPiece("h7") == p2;

        b.clear();
    }

    public static void testBlackRooks () {
        Board b = Board.theBoard();
	    Piece.registerPiece(new RookFactory());
	    Piece p = Piece.createPiece("wr");
	    Piece p2 = Piece.createPiece("wr");

        b.addPiece(p, "a1");
        b.addPiece(p2, "h1");
        
        assert b.getPiece("a1") == p;
        assert b.getPiece("h1") == p2;

        b.movePiece("a1", "a5");
        b.movePiece("h1", "h7");

        assert b.getPiece("a1") == null;
        assert b.getPiece("h1") == null;
        
        assert b.getPiece("a5") == p;
        assert b.getPiece("h7") == p2;

        b.clear();
    }

    private static void testKingMove() {
        Board board = Board.theBoard();
	    Piece.registerPiece(new PawnFactory());
        Piece.registerPiece(new KingFactory());

        board.addPiece(Piece.createPiece("wp"), "d5");
        board.addPiece(Piece.createPiece("wp"), "e5");
        board.addPiece(Piece.createPiece("wk"), "e4");

        assert new HashSet<>(board.getPiece("e4").moves(board, "e4")).equals(Set.of("f5", "d4", "f4", "d3", "e3", "f3"));
    }

    public static void testWhiteBishops() {
        Board b = Board.theBoard();
	    Piece.registerPiece(new RookFactory());
	    Piece p = Piece.createPiece("wb");
	    Piece p2 = Piece.createPiece("bb");
        b.addPiece(p, "a1");
        b.addPiece(p2, "h1");

    }
    public static void main(String[] args) {
	// test1();
    // testWhiteRooks();
    // testBlackRooks();
    testKingMove();

    }

}