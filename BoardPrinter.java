/*
 * File: BoardPrinter.java
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Prints the board with iterator 
 */
public class BoardPrinter implements BoardInternalIterator {
    public void visit(String loc, Piece p) {
	if (p != null) {
	    System.out.println(loc + "=" + p.toString());
	}
    }
}