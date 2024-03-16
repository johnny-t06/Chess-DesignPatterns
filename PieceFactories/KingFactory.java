package PieceFactories;
/*
 * File: KingFactory.java
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Singleton extension for king piece creation
 */

import Color;
import Pieces.King;
import Pieces.Piece;

public class KingFactory implements PieceFactory {
    public char symbol() { return 'k'; }
    public Piece create(Color c) { return new King(c); }
}