/*
 * File: BoardListener.java
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Interface for a BoardListener, declares actions of move and capture
 */
public interface BoardListener {
    void onMove(String from, String to, Piece p);
    void onCapture(Piece attacker, Piece captured);
}