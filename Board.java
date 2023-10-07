import java.util.*;
import java.lang.RuntimeException;


public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private static Board b;

    private Board() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
     }
    
    public static Board theBoard() {
	    if (b == null) {
            b = new Board();
        }
        return b;
    }
    
    private static HashMap <Character, Integer> locAdapter = new HashMap<>(){{
        put('a', 0);
        put('b', 1);
        put('c', 2);
        put('d', 3);
        put('e', 4);
        put('f', 5);
        put('g', 6);
        put('h', 7);
        
        put('1', 7);
        put('2', 6);
        put('3', 5);
        put('4', 4);
        put('5', 3);
        put('6', 2);
        put('7', 1);
        put('8', 0);

        
    }};

    private Integer getRow (Character c) {
        if (locAdapter.containsKey(c)) {
            return locAdapter.get(c);
        }
        throw new RuntimeException();
    }

    private Integer getCol (Character c) {
        if (locAdapter.containsKey(c)) {
            return locAdapter.get(c);
        }
        throw new RuntimeException();
    }
    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        Piece temp = null;
        int row = getRow(loc.charAt(0));
        int col = getCol(loc.charAt(1));
        temp = pieces[row][col];
        return temp;
    }

    public void addPiece(Piece p, String loc) {
        
        int row = getRow(loc.charAt(0));
        int col = getCol(loc.charAt(1));
        if (pieces[row][col] == null) {
            pieces[row][col] = p;
        }
        throw new RuntimeException();
    }

    public void movePiece(String from, String to) {
        Piece temp = getPiece(from);    //handles exceptions throwing if from doesn't exist
        if (temp != null) {
            int rowFrom = getRow(from.charAt(0)); 
            int colFrom = getCol(from.charAt(1)); 

            int rowTo = getRow(from.charAt(0)); //Handles exception throwing if to doesn't exist
            int colTo = getCol(from.charAt(1));
            List <String> moves = temp.moves(this, from);
            if (moves.contains(to)) {
                pieces[rowTo][colTo] = temp;
                pieces[rowFrom][colFrom] = null;
            }
        }
        
        
    }

    public void clear() {
	throw new UnsupportedOperationException();
    }

    public void registerListener(BoardListener bl) {
	throw new UnsupportedOperationException();
    }

    public void removeListener(BoardListener bl) {
	throw new UnsupportedOperationException();
    }

    public void removeAllListeners() {
	throw new UnsupportedOperationException();
    }

    public void iterate(BoardInternalIterator bi) {
	throw new UnsupportedOperationException();
    }
}