import java.util.*;

public class Rook extends Piece {
    public Rook(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wr";
        }
        return "br";
    }

    public List<String> moves(Board b, String loc) {
        return rookMoves(b, loc);
    }

}