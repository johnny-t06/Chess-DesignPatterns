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
	throw new UnsupportedOperationException();
    }

}