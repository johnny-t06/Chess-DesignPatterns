import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { 
        super(c);
    }
    // implement appropriate methods

    public String toString() {
        if (this.color() == Color.WHITE) {
            return "wb";
        }
        return "bb";
    }

    public List<String> moves(Board b, String loc) {
	    return diaMoves(b, loc);
    }

}