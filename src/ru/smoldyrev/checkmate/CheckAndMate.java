package ru.smoldyrev.checkmate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by SBT-Smoldyrev-EI on 16.11.2018.
 */
public class CheckAndMate {

    public static Set<PieceConfig> isCheck(final PieceConfig[] arrPieces, int player) {
        PieceConfig king = Arrays.stream(arrPieces).filter(p -> p.getOwner() == player && p.getPiece().equals("king")).findFirst().orElse(null);

        return Arrays.stream(arrPieces)
                .filter(p -> getSteps(arrPieces, p)
                        .stream()
                        .anyMatch(piece -> piece.getX() == king.getX() && piece.getY() == king.getY())).collect(Collectors.toSet());
    }

    public static boolean isMate(final PieceConfig[] arrPieces, int player) {

        Arrays.stream(arrPieces).filter(p -> p.getOwner() == player).forEach(p -> {
            getSteps(arrPieces, p).stream().forEach(p);
        });


        throw new RuntimeException("Not implemented yet!");
    }

    private static Set<PieceConfig> getSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();
        switch (piece.getPiece()) {
            case "pawn": {
                steps.addAll(getPawnSteps(arrPieces, piece));
                break;
            }
            case "rook": {
                steps.addAll(getRookSteps(arrPieces, piece));
                break;
            }
            case "knight": {
                steps.addAll(getKnightSteps(arrPieces, piece));
                break;
            }
            case "bishop": {
                steps.addAll(getBishopSteps(arrPieces, piece));
                break;
            }
            case "queen": {
                steps.addAll(getQuuenSteps(arrPieces, piece));
                break;
            }
            case "king": {
                steps.addAll(getKingSteps(arrPieces, piece));
                break;
            }
        }
        return steps;
    }

    private static Set<PieceConfig> getPawnSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();
        switch (piece.getOwner()) {
            case 0: {
                if (piece.getY() == 6 &&
                        getPieceByCoord(arrPieces, piece.getX(), piece.getY() - 1) == null &&
                        getPieceByCoord(arrPieces, piece.getX(), piece.getY() - 2) == null) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() - 2, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX(), piece.getY() + 1) == null) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() - 1, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX() - 1, piece.getY() - 1) != null && getPieceByCoord(arrPieces, piece.getX() - 1, piece.getY() - 1).getOwner() != piece.getOwner()) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() - 1, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX() + 1, piece.getY() - 1) != null && getPieceByCoord(arrPieces, piece.getX() + 1, piece.getY() - 1).getOwner() != piece.getOwner()) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() - 1, piece.getX(), piece.getY()));
                }
                break;
            }
            case 1: {
                if (piece.getY() == 1 &&
                        getPieceByCoord(arrPieces, piece.getX(), piece.getY() + 1) == null &&
                        getPieceByCoord(arrPieces, piece.getX(), piece.getY() + 2) == null) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() + 2, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX(), piece.getY() + 1) == null) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() + 1, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX() - 1, piece.getY() + 1) != null && getPieceByCoord(arrPieces, piece.getX() - 1, piece.getY() + 1).getOwner() != piece.getOwner()) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() + 1, piece.getX(), piece.getY()));
                }
                if (getPieceByCoord(arrPieces, piece.getX() + 1, piece.getY() + 1) != null && getPieceByCoord(arrPieces, piece.getX() + 1, piece.getY() + 1).getOwner() != piece.getOwner()) {
                    steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() + 1, piece.getX(), piece.getY()));
                }
                break;
            }
        }
        return steps.stream().filter(p -> p.getY() >= 0 && p.getY() <= 7 && p.getX() >= 0 && p.getX() <= 7).collect(Collectors.toSet());
    }

    private static Set<PieceConfig> getKnightSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();

        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() - 2, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() - 2, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() + 2, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() + 2, piece.getX(), piece.getY()));

        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 2, piece.getY() + 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 2, piece.getY() - 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 2, piece.getY() + 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 2, piece.getY() - 1, piece.getX(), piece.getY()));

        return steps.stream()
                .filter(p -> p.getY() >= 0 &&
                        p.getY() <= 7 &&
                        p.getX() >= 0 &&
                        p.getX() <= 7 &&
                        (getPieceByCoord(arrPieces, p.getX(), p.getY()) == null ||
                                getPieceByCoord(arrPieces, p.getX(), p.getY()).getOwner() != p.getOwner()))
                .collect(Collectors.toSet());
    }

    private static Set<PieceConfig> getRookSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();

        //right
        for (int i = piece.getX(); i < 8; i++) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, piece.getY(), piece.getX(), piece.getY()));
            if (i != piece.getX() && getPieceByCoord(arrPieces, i, piece.getY()) != null) {
                break;
            }
        }
        //left
        for (int i = piece.getX(); i >= 0; i--) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, piece.getY(), piece.getX(), piece.getY()));
            if (i != piece.getX() && getPieceByCoord(arrPieces, i, piece.getY()) != null) {
                break;
            }
        }
        //up
        for (int i = piece.getY(); i < 8; i++) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), i, piece.getX(), piece.getY()));
            if (i != piece.getY() && getPieceByCoord(arrPieces, piece.getX(), i) != null) {
                break;
            }
        }
        //down
        for (int i = piece.getY(); i >= 0; i--) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), i, piece.getX(), piece.getY()));
            if (i != piece.getY() && getPieceByCoord(arrPieces, piece.getX(), i) != null) {
                break;
            }
        }

        return steps;
    }

    private static Set<PieceConfig> getBishopSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();

        for (int i = piece.getX(), j = piece.getY(); i < 8 && j < 8 && i >= 0 && j >= 0; i++, j++) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, j, piece.getX(), piece.getY()));
            if (i != piece.getX() && j != piece.getY() && getPieceByCoord(arrPieces, i, j) != null) {
                break;
            }
        }
        for (int i = piece.getX(), j = piece.getY(); i < 8 && j < 8 && i >= 0 && j >= 0; i--, j--) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, j, piece.getX(), piece.getY()));
            if (i != piece.getX() && j != piece.getY() && getPieceByCoord(arrPieces, i, j) != null) {
                break;
            }
        }
        for (int i = piece.getX(), j = piece.getY(); i < 8 && j < 8 && i >= 0 && j >= 0; i--, j++) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, j, piece.getX(), piece.getY()));
            if (i != piece.getX() && j != piece.getY() && getPieceByCoord(arrPieces, i, j) != null) {
                break;
            }
        }
        for (int i = piece.getX(), j = piece.getY(); i < 8 && j < 8 && i >= 0 && j >= 0; i++, j--) {
            steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), i, j, piece.getX(), piece.getY()));
            if (i != piece.getX() && j != piece.getY() && getPieceByCoord(arrPieces, i, j) != null) {
                break;
            }
        }


        return steps;
    }

    private static Set<PieceConfig> getQuuenSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();
        steps.addAll(getRookSteps(arrPieces, piece));
        steps.addAll(getBishopSteps(arrPieces, piece));
        return steps;
    }

    private static Set<PieceConfig> getKingSteps(final PieceConfig[] arrPieces, PieceConfig piece) {
        Set<PieceConfig> steps = new HashSet<>();
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY(), piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY(), piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() + 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX(), piece.getY() - 1, piece.getX(), piece.getY()));

        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() + 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() - 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() - 1, piece.getY() + 1, piece.getX(), piece.getY()));
        steps.add(new PieceConfig(piece.getPiece(), piece.getOwner(), piece.getX() + 1, piece.getY() - 1, piece.getX(), piece.getY()));
        return steps;
    }

    private static PieceConfig getPieceByCoord(final PieceConfig[] arrPieces, int x, int y) {
        return Arrays.stream(arrPieces).filter(p -> p.getX() == x && p.getY() == y).findFirst().orElse(null);
    }
}