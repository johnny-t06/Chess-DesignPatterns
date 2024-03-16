/*
 * File: BoardInternalIterator
 * Author: Johnny Tan
 * Date: 03/15/2024
 * Purpose: Visitor interface to iterate over
 */
interface BoardInternalIterator {
    void visit(String loc, Piece p);
}