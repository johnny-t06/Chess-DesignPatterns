import java.util.*;

public class Test {

    // Run "java -ea Test" to run with assertions enabled (If you run
    // with assertions disabled, the default, then assert statements
    // will not execute!)

    public static void whiteBishop(){
        Board b = Board.theBoard();
        Piece.registerPiece(new BishopFactory());
        Piece p = Piece.createPiece("wb");
	    Piece p2 = Piece.createPiece("wb");

        b.addPiece(p, "c1");
        b.addPiece(p2, "f1");
        
        b.movePiece("c1", "a3");
        b.movePiece("f1", "a6");

        
        // List <String> posMoves = p.moves(b, "c1");
        // for (String eachMove : posMoves) {
        //     System.out.println(eachMove);
        // }


        assert b.getPiece("c1") == null;
        assert b.getPiece("f1") == null;

        assert b.getPiece("a3") == p;
        assert b.getPiece("a6") == p2;

        assert p.color() == Color.WHITE;
        assert p2.color() == Color.WHITE;
        
        b.clear();
    }

    public static void blackBishop(){
        Board b = Board.theBoard();
        Piece.registerPiece(new BishopFactory());
        Piece p = Piece.createPiece("bb");
	    Piece p2 = Piece.createPiece("bb");

        b.addPiece(p, "g7");
        b.addPiece(p2, "b7");
        
        b.movePiece("g7", "h8");
        b.movePiece("b7", "d5");

        
        // List <String> posMoves = p.moves(b, "g7");
        // for (String eachMove : posMoves) {
        //     System.out.println(eachMove);
        // }


        assert b.getPiece("g7") == null;
        assert b.getPiece("b7") == null;

        assert b.getPiece("h8") == p;
        assert b.getPiece("d5") == p2;


        assert p.color() == Color.BLACK;
        assert p2.color() == Color.BLACK;


        b.clear();
    }

    

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
        
        assert p.color() == Color.WHITE;
        assert p2.color() == Color.WHITE;
        b.clear();
    }

    public static void testBlackRooks () {
        Board b = Board.theBoard();
	    Piece.registerPiece(new RookFactory());
	    Piece p = Piece.createPiece("br");
	    Piece p2 = Piece.createPiece("br");

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

        assert p.color() == Color.BLACK;
        assert p2.color() == Color.BLACK;

        b.clear();
    }

    private static void testKingMove() {
        Board board = Board.theBoard();
	    Piece.registerPiece(new PawnFactory());
        Piece.registerPiece(new KingFactory());

        board.addPiece(Piece.createPiece("wp"), "d5");
        board.addPiece(Piece.createPiece("wp"), "e5");
        board.addPiece(Piece.createPiece("wk"), "e4");
        assert board.getPiece("e4") != null;


        // List<String> kingMoves = board.getPiece("e4").moves(board, "e4");    prints all of king's moves
        // for (String move : kingMoves) {
        //     System.out.println(move);
        // }    
        assert new HashSet<>(board.getPiece("e4").moves(board, "e4")).equals(Set.of("f5", "d4", "f4", "d3", "e3", "f3"));
        board.clear();
    }

    public static void testWhiteBishops() {
        Board b = Board.theBoard();
	    Piece.registerPiece(new RookFactory());
	    Piece p = Piece.createPiece("wb");
	    Piece p2 = Piece.createPiece("bb");
        b.addPiece(p, "a1");
        b.addPiece(p2, "h1");
        b.clear();
    }
    public static void main(String[] args) {
	test1();
    testWhiteRooks();
    testBlackRooks();
    testKingMove();
    whiteBishop();
    blackBishop();
    }

}