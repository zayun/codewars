package ru.smoldyrev.rps;

/**
 * Created by SBT-Smoldyrev-EI on 14.11.2018.
 */
class Player implements RockPaperScissorsPlayer {

    private String currOpponent;
    private int round;

    private static final String[] SVEN = {"R", "R", "S", "P", "P", "R"};
    private static final String[] BIN = {"R", "P", "R", "S", "P", "S"};
    private static final String[] HUGH = {"S", "R", "P"};

    public String getName() {
        return "Small Egor";
    }

    public void setNewMatch(String opponentName) {
        currOpponent = opponentName;
        round = 0;
    }

    public String getShape() {
        switch (currOpponent) {
            case "Max Janssen":
                return "P";
            case "Vitraj Bachchan":
                return "R";
            case "Sven Johanson": {
                round = round > SVEN.length - 1 ? 0 : round;
                return SVEN[round++];
            }
            case "Bin Jinhao": {
                round = round > BIN.length - 1 ? 0 : round;
                return BIN[round++];
            }
            case "Jonathan Hughes": {
                round = round > HUGH.length - 1 ? 0 : round;
                return HUGH[round++];
            }
            default:
                return "P";
        }
    }

    public void setOpponentShape(String shape) {
        System.out.println(String.format("%s: %s", currOpponent, shape));
    }
}
