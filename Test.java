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
        assert p.toString() == "wb";
        assert p2.color() == Color.WHITE;
        assert p.toString() == "wb";
        
        
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
        assert p.toString() == "bb";
        assert p2.toString() == "bb";



        b.clear();
    }

    public static void BishopBlockedMulti() {
        Board b = Board.theBoard();
        Piece.registerPiece(new BishopFactory());
        Piece.registerPiece(new PawnFactory());

        Piece p = Piece.createPiece("wb");
        Piece pawn1 = Piece.createPiece("wp");
        Piece pawn2 = Piece.createPiece("bp");
        Piece pawn3 = Piece.createPiece("wp");
        Piece pawn4 = Piece.createPiece("bp");



        b.addPiece(p, "c3");
        b.addPiece(pawn1, "f6");
        b.addPiece(pawn2, "d2");
        b.addPiece(pawn3, "a5");
        b.addPiece(pawn4, "e5");


        // List<String> bishopMoves = b.getPiece("c3").moves(b, "c3");    //prints all of king's moves
        // for (String eachMove : bishopMoves) {
        //     System.out.println(eachMove);
        // }    
        assert p.toString() == "wb";
        assert pawn1.toString() == "wp";
        assert pawn2.toString() == "bp";

        assert new HashSet<>(b.getPiece("c3").moves(b, "c3")).equals(Set.of("a1", "b2", "b4", "d4", "d2", "e5"));
        b.clear();

    }


    public static void whiteKing(){
        Board b = Board.theBoard();
        Piece.registerPiece(new KingFactory());
        Piece p = Piece.createPiece("wk");

        b.addPiece(p, "e1");

        b.movePiece("e1", "e2");

        assert b.getPiece("e1") == null;
        assert b.getPiece("e2") == p;

        b.movePiece("e2", "e3");

        assert b.getPiece("e2") == null;
        assert b.getPiece("e3") == p;

        try {       //tries to move a piece with invalid piece
            b.movePiece("e3", "e8");
        }
        catch (RuntimeException e) {
            // System.out.println("Error Caught");
            assert true;
        }

        try{
            b.movePiece("h2", "e8");
        }
        catch (RuntimeException e) {
            // System.out.println("Error Caught, No piece at first location");
            assert true;
        }
        assert p.toString() == "wk";
        assert p.color() == Color.WHITE;
        b.clear();
    }
    

    public static void whiteQueenMulti() {
        Board b = Board.theBoard();
	    Piece.registerPiece(new QueenFactory());
        Piece.registerPiece(new PawnFactory());

        Piece pawn1 = Piece.createPiece("wp");
        Piece pawn2 = Piece.createPiece("wp");
        Piece pawn3 = Piece.createPiece("wp");
        Piece pawn4 = Piece.createPiece("bp");
        Piece pawn5 = Piece.createPiece("bp");


	    Piece p = Piece.createPiece("wq");

        b.addPiece(p, "d2");
        b.addPiece(pawn1, "d6");
        b.addPiece(pawn2, "a2");
        b.addPiece(pawn3, "g5");
        b.addPiece(pawn4, "f4");
        b.addPiece(pawn5, "d1");

        // List<String> Moves = b.getPiece("d2").moves(b, "d2");    //prints all of king's moves
        // for (String eachMove : Moves) {
        //     System.out.println(eachMove);
        // }    
        
        assert p.toString() == "wq";

        assert new HashSet<>(b.getPiece("d2").moves(b, "d2")).equals(Set.of("c2", "b2", "e2", "f2", "g2", "h2", "c1", "d1", "e1", "e3", "f4", "c3", "b4", "a5", "d3", "d4", "d5"));
        b.clear();
        
    }
    public static void test1() {
        Board b = Board.theBoard();
        Piece.registerPiece(new PawnFactory());
        Piece p = Piece.createPiece("bp");

        b.addPiece(p, "a3");
        assert p.toString() == "bp";
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
        assert p.toString() == "wr";
        assert p2.toString() == "wr";
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
        assert p.toString() == "br";
        assert p2.toString() == "br";

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
        assert p.toString() == "wb";
        assert p2.toString() == "bb";
        b.addPiece(p, "a1");
        b.addPiece(p2, "h1");
        b.clear();
    }

    public static void PawnMulti() {    //single move and double move 
        Board b = Board.theBoard();
	    Piece.registerPiece(new PawnFactory());
	    Piece p = Piece.createPiece("wp");
	    Piece p2 = Piece.createPiece("wp");
	    Piece p3 = Piece.createPiece("bp");
	    Piece p4 = Piece.createPiece("bp");

        b.addPiece(p, "a2");
        b.addPiece(p2, "b2");

        b.addPiece(p3, "a7");
        b.addPiece(p4, "b7");

        // List<String> allMoves = b.getPiece("a2").moves(b, "a2");    //prints all of moves
        // for (String eachMove : allMoves) {
        //     System.out.println(eachMove);
        // }    
        b.movePiece("a2", "a3");
        b.movePiece("a7", "a6");

        assert new HashSet<>(b.getPiece("a3").moves(b, "a3")).equals(Set.of("a4"));
        assert new HashSet<>(b.getPiece("a6").moves(b, "a6")).equals(Set.of("a5"));
        assert new HashSet<>(b.getPiece("b2").moves(b, "b2")).equals(Set.of("b3", "b4"));
        assert new HashSet<>(b.getPiece("b7").moves(b, "b7")).equals(Set.of("b6", "b5"));

        b.clear();
        
    }
    public static void PawnCapture() {
        Board b = Board.theBoard();
	    Piece.registerPiece(new PawnFactory());
	    Piece p1 = Piece.createPiece("wp");
	    Piece p2 = Piece.createPiece("bp");
	    Piece p3 = Piece.createPiece("bp");
	    Piece p4 = Piece.createPiece("bp");


        b.addPiece(p1, "a2");
        b.addPiece(p2, "b3");
        b.addPiece(p3, "c3");
        b.addPiece(p4, "c4");
        
        assert new HashSet<>(b.getPiece("a2").moves(b, "a2")).equals(Set.of("a3", "a4", "b3"));
        b.movePiece("a2", "b3");
        assert new HashSet<>(b.getPiece("b3").moves(b, "b3")).equals(Set.of("b4", "c4"));
        assert p1.color() == Color.WHITE;
        assert p2.color() == Color.BLACK;

       
        b.clear();
        
    }

    public static void knightMoves() {
        Board b = Board.theBoard();
	    Piece.registerPiece(new KnightFactory());
	    Piece.registerPiece(new PawnFactory());

	    Piece p = Piece.createPiece("wn");
	    Piece p2 = Piece.createPiece("wp");
	    Piece p3 = Piece.createPiece("wp");
	    Piece p4 = Piece.createPiece("bp");

        b.addPiece(p, "d4");
        b.addPiece(p2, "b3");

        b.addPiece(p3, "e6");
        b.addPiece(p4, "c2");

        assert new HashSet<>(b.getPiece("d4").moves(b, "d4")).equals(Set.of("b5", "c2", "e2", "f3", "f5", "c6"));
        
        b.movePiece("d4", "e2");

        assert new HashSet<>(b.getPiece("e2").moves(b, "e2")).equals(Set.of("d4", "c3", "c1", "g1", "g3", "f4"));
        

    }
    public static void main(String[] args) {
        test1();
        testWhiteRooks();
        testBlackRooks();
        testKingMove();
        whiteBishop();
        blackBishop();
        whiteKing();
        BishopBlockedMulti();
        whiteQueenMulti();
        PawnMulti();
        PawnCapture();
        knightMoves();
    }

}