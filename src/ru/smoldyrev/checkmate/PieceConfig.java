package ru.smoldyrev.checkmate;

import java.util.Objects;

/**
 * Created by SBT-Smoldyrev-EI on 16.11.2018.
 */
public class PieceConfig {

    private final String piece;
    private final int owner;
    private final int x;
    private final int y;
    private final int prevX;
    private final int prevY;

    public PieceConfig(final String piece, final int owner, final int x, final int y, final int prevX, final int prevY) {
        this.piece = piece;
        this.owner = owner;
        this.x = x;
        this.y = y;
        this.prevX = prevX;
        this.prevY = prevY;
    }

    public PieceConfig(final String piece, final int owner, final int x, final int y) {
        this.piece = piece;
        this.owner = owner;
        this.x = x;
        this.y = y;
        this.prevX = -1;
        this.prevY = -1;
    }

    public String getPiece() {
        return piece;
    }

    public int getOwner() {
        return owner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean hasPrevious() {
        return prevX >=0 && prevY >=0;
    }

    //will throw a RuntimeException if invoked for an object that do not have informations about its previous move.
    public int getPrevX() {
        if (prevX <0) {
            throw new RuntimeException();
        }
        return prevX;
    }

    // will throw a RuntimeException if invoked for an object that do not have informations about its previous move.
    public int getPrevY() {
        if (prevY <0) {
            throw new RuntimeException();
        }
        return prevY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceConfig that = (PieceConfig) o;
        return owner == that.owner &&
                x == that.x &&
                y == that.y &&
                Objects.equals(piece, that.piece);
    }

    @Override
    public int hashCode() {

        return Objects.hash(piece, owner, x, y);
    }

    @Override
    public String toString() {
        //return string formated as :"piece: king, owner: 0, x: 0, y: 4" (plus prevX and prevY if needed)
        return String.format("piece: %s, owner: %d, x: %d, y: %d, prevX: %d, prevY: %d", piece, owner, x, y, prevX, prevY);
    }
}
