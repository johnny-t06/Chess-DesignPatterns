/*
 * File: BishopFactory.java
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Singleton extension of PieceFactory
 */
public class BishopFactory implements PieceFactory {
    public char symbol() { return 'b'; }
    public Piece create(Color c) { return new Bishop(c); }
}