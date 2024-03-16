/*
 * File: Bishop.java
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Extends Piece to account for Bishop moves
 */
import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color c) { 
        super(c);
    }

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