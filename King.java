import java.util.*;

public class King extends Piece {
    public King(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wk";
        }
        return "bk";
    }

    private static HashMap <Character, Integer> chartoIntAdapter = new HashMap<>(){{
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

    private static HashMap <Integer, String> colgetStringfromIntMap= new HashMap<>(){{
        
        put(0 , "a");
        put(1 , "b");
        put(2 , "c");
        put(3 , "d");
        put(4 , "e");
        put(5 , "f");
        put(6 , "g");
        put(7 , "h");
    
    }};

    private static HashMap <Integer, String> rowgetStringFromIntMap = new HashMap<>(){{
        
        put(0 , "8");
        put(1 , "7");
        put(2 , "6");
        put(3 , "5");
        put(4 , "4");
        put(5 , "3");
        put(6 , "2");
        put(7 , "1");
    
    }};



    public List<String> moves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();

        int [] directions = {
            -1, 0, 1
        };
        
        int row = getIntfromChar(loc.charAt(0));
        int col = getIntfromChar(loc.charAt(1));
        String checkMoves;
        for (int eachDirection : directions) {
            int newRow = row + eachDirection; 
            int newCol = col + eachDirection; 
            if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
                checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
                Piece temp = b.getPiece(checkMoves);
                if (temp == null && temp.color() != this.color()) {
                    posMoves.add(checkMoves);
                }
            }

        }
        return posMoves;
        
    }

}