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

    

    public List<String> moves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();

        int [] directions = {
            -1, 0, 1
        };
        
        int row = getIntfromChar(loc.charAt(1));
        int col = getIntfromChar(loc.charAt(0));
        String checkMoves;
        for (int eachDirection : directions) {
            int newRow = row + eachDirection; 
            int newCol = col + eachDirection; 
            if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
                checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);

                Piece temp = b.getPiece(checkMoves);
                if (temp == null) {
                    posMoves.add(checkMoves);
                }else if (temp.color() != this.color()) {
                    posMoves.add(checkMoves);
                }
            }
        }
        return posMoves;
        
    }

}