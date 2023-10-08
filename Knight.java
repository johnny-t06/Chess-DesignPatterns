import java.util.*;

public class Knight extends Piece {
    public Knight(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wn";
        }
        return "bn";
    }

    public List<String> moves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();

        int [][] directions = { 
            {2, -1},
            {2, 1},
            {1, -2},
            {1, 2},
            {-2, -1},
            {-2, 1},
            {-1, -2},
            {-1, 2}
        };
        String checkMoves;
        int row = getIntfromChar(loc.charAt(1));
        int col = getIntfromChar(loc.charAt(0));
        for (int[] eachDirection : directions) {
            int newRow = row + eachDirection[0];
            int newCol = col + eachDirection[1];
            if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
                checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
                Piece temp = b.getPiece(checkMoves);
                if (temp == null) {
                    posMoves.add(checkMoves);
                }else if(temp.color() != this.color()){
                    posMoves.add(checkMoves);
                }
            }
        }   
        return posMoves;
    }
}