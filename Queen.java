import java.util.*;

public class Queen extends Piece {
    public Queen(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wq";
        }
        return "bq";
    }

    public List<String> moves(Board b, String loc) {
        List<String> result = new LinkedList<>();
        List<String> posRook= rookMoves(b, loc);
        List<String> posDia = diaMoves(b, loc);
        result.addAll(posRook);
        result.addAll(posDia);
        return result;
    }

}