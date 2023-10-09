import java.util.*;
import java.lang.RuntimeException;


public class Board {

    private Piece[][] pieces = new Piece[8][8];
    private List<BoardListener> allListners = new LinkedList<>();
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
    
    protected static HashMap <Character, Integer> chartoIntAdapter = new HashMap<>(){{
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

    protected static HashMap <Integer, String> colgetStringfromIntMap= new HashMap<>(){{
        
        put(0 , "a");
        put(1 , "b");
        put(2 , "c");
        put(3 , "d");
        put(4 , "e");
        put(5 , "f");
        put(6 , "g");
        put(7 , "h");
    
    }};

    protected static HashMap <Integer, String> rowgetStringFromIntMap = new HashMap<>(){{
        
        put(0 , "8");
        put(1 , "7");
        put(2 , "6");
        put(3 , "5");
        put(4 , "4");
        put(5 , "3");
        put(6 , "2");
        put(7 , "1");
    
    }};

    protected Integer getIntfromChar (Character c) {
        if (chartoIntAdapter.containsKey(c)) {
            return chartoIntAdapter.get(c);
        }
        throw new RuntimeException();
    }

    protected String colgetStringfromInt (int i) {
        if (colgetStringfromIntMap.containsKey(i)) {
            return colgetStringfromIntMap.get(i);
        }
        throw new RuntimeException();
    }

    protected String rowgetStringfromInt (int i) {
        if (rowgetStringFromIntMap.containsKey(i)) {
            return rowgetStringFromIntMap.get(i);
        }
        throw new RuntimeException();
    }


    // Returns piece at given loc or null if no such piece
    // exists
    public Piece getPiece(String loc) {
        int row = getIntfromChar(loc.charAt(1));
        int col = getIntfromChar(loc.charAt(0));

        return pieces[row][col];

    }

    public void addPiece(Piece p, String loc) {
        
        int row = getIntfromChar(loc.charAt(1));    //handles exceptions if key does not exist
        int col = getIntfromChar(loc.charAt(0));
        if (pieces[row][col] == null) {
            pieces[row][col] = p;
            return;
        }
        throw new RuntimeException();
    }

    public void movePiece(String from, String to) {
        Piece fromPiece = getPiece(from);    //handles exceptions throwing if from is not within bounds

        if (fromPiece != null) {
            int rowFrom = getIntfromChar(from.charAt(1)); 
            int colFrom = getIntfromChar(from.charAt(0)); 

            int rowTo = getIntfromChar(to.charAt(1)); //Handles exception throwing if to doesn't exist
            int colTo = getIntfromChar(to.charAt(0));

            List <String> moves = fromPiece.moves(this, from);
            
            
            if (moves.contains(to) ) {
                Piece toPiece = getPiece(to);
                for (BoardListener eachListener : allListners) {
                    eachListener.onMove(from, to, fromPiece);
                }

                pieces[rowTo][colTo] = fromPiece;
                pieces[rowFrom][colFrom] = null;
                if (toPiece != null) {
                    for (BoardListener eachListener : allListners) {
                        eachListener.onCapture(fromPiece, toPiece);
                    }
                }
                
            }else {
                throw new RuntimeException();
            }
        }else {
            throw new RuntimeException();   //handles exeception when no piece at first location
        }
        
        
    }

    public void clear() {
	    for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                pieces[i][j] = null;
            }
        }
    }

    public void registerListener(BoardListener bl) {
        allListners.add(bl);
    }

    public void removeListener(BoardListener bl) {
        if(!allListners.contains(bl)) {
            throw new RuntimeException();
        }
        allListners.remove(bl);
    }

    public void removeAllListeners() {
        allListners.clear();
    }

    public void iterate(BoardInternalIterator bi) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String col = colgetStringfromInt(j);
                String row = rowgetStringfromInt(i);
                String loc = col + row;
                Piece atLoc = pieces[i][j];
                bi.visit(loc, atLoc);
            }
        }
    }
}