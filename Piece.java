import java.util.*;


abstract public class Piece {
    private static HashMap<Character, PieceFactory> pfmap = new HashMap<>();

    private Color pieceColor; //new field

    protected Piece(Color color) {
        this.pieceColor = color;
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

    public Color color() {
        // You should write code here and just inherit it in
        // subclasses. For this to work, you should know
        // that subclasses can access superclass fields.
        return pieceColor;
    }


    public static void registerPiece(PieceFactory pf) {
        Character symbol = pf.symbol();
        pfmap.put(symbol, pf);
    }

    public static Piece createPiece(String name) {
        Character colorChar = name.charAt(0);
        Character type = name.charAt(1);

        PieceFactory pf = pfmap.get(type);
        Piece newPiece;
        Color color;
        if (colorChar == 'w') {
            color = Color.WHITE;
        }else if (colorChar == 'b') {
            color = Color.BLACK;
        }else{
            throw new RuntimeException();
        }
        newPiece = pf.create(color);
        return newPiece;
    }

    
    protected List<String> diaMoves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();

        int [][] directions = { 
            {-1, -1},
            {-1, 1},
            {1, -1},
            {1, 1}
        };


        int row = getIntfromChar(loc.charAt(1));
        int col = getIntfromChar(loc.charAt(0));
        
        String checkMoves;
        for (int[] eachDirection : directions) {
            for (int i = 0; i < 8; i++) {

                int newRow = row + eachDirection[0] * i;
                int newCol = col + eachDirection[1] * i;
                if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
    
                    checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
                    Piece temp = b.getPiece(checkMoves);
                    if (temp == null) {
                        posMoves.add(checkMoves);
                    }else {
                        if (temp.color() != this.color()) {
                            posMoves.add(checkMoves);
                            break;  //Can't jump over pieces
                        }
                    }
                }else {
                    break;  //out of bounds loop 
                }
                
            }
        }

        return posMoves;
    }
    public List<String> rookMoves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();
        int [][] directions = { 
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
        };
        int row = getIntfromChar(loc.charAt(1));
        int col = getIntfromChar(loc.charAt(0));
        String checkMoves; 
        for (int [] eachDirection: directions) {
            for (int i = 0; i < 8; i++) {
                int newRow = row + eachDirection[0] * i;
                int newCol = col + eachDirection[1] * i;
                if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
                    checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
                    Piece temp = b.getPiece(checkMoves);
                    if (temp == null) {
                        posMoves.add(checkMoves);
                    }else {
                        if (temp.color() != this.color()) {
                            posMoves.add(checkMoves);
                            break;  //Can't jump over pieces
                        }
                    }
                }else {
                    break;  //out of loop 
                }

            }
        }
        return posMoves;

        }
    abstract public String toString();
    abstract public List<String> moves(Board b, String loc);
}