import java.util.*;

public class Pawn extends Piece {
    public Pawn(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wp";
        }
        return "bp";
    }

    public List<String> moves(Board b, String loc) {
        List<String> posMoves = new LinkedList<>();
        int moveAmount = (this.color() == Color.WHITE) ? -1 : 1;
        int row = getIntfromChar(loc.charAt(0));
        int col = getIntfromChar(loc.charAt(1));
        int newRow = row + moveAmount;
        int [] captureCol = {1, -1};
        String checkMoves;

        if (newRow < 8 && newRow >= 0 && col >= 0 && col < 8) {
            
            checkMoves = colgetStringfromInt(col) + rowgetStringfromInt(newRow);
            Piece temp = b.getPiece(checkMoves);
            if (temp == null) {
                posMoves.add(checkMoves);
            }
            for (int cols : captureCol) {
                int newCol = cols + col;    /// CHECK ADDITION 
                checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
                Piece captureTemp = b.getPiece(checkMoves);
            if (captureTemp != null && this.color() != captureTemp.color()) {
                posMoves.add(checkMoves);
            }
            }
        }

        if ((this.color() == Color.WHITE && row == 6) || (this.color() == Color.BLACK && row == 1)) {
            newRow += moveAmount;
            checkMoves = colgetStringfromInt(col) + rowgetStringfromInt(newRow);
            Piece temp = b.getPiece(checkMoves);
            if (temp == null) {
                posMoves.add(checkMoves);
            }
        }

        // int [][] directions = { 
        //     {1, 1},
        //     {-1, 1},
        // };
        // int captureRow, captureCol;
        // for (int [] eachDirection : directions) {
        //     captureRow = row + eachDirection;
        //     captureCol = col + eachDirection;
        //     if (newRow < 8 && newRow >= 0 && newCol >= 0 && newCol < 8) {
        //         checkMoves = colgetStringfromInt(newCol) + rowgetStringfromInt(newRow);
        //         Piece temp = b.getPiece(checkMoves);
        //         if (temp == null && temp.color() != this.color()) {
        //             posMoves.add(checkMoves);
        //         }
        //     }
        // }
        
        
        return posMoves;

    }

}