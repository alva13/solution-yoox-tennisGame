package com.example;

public class GameProcessor {

    public static Game process(Game game, int point) {

        Game gameOutput = new Game();

        if (point == 1) {
            gameOutput.p1Points = game.p1Points + 1;
            System.out.println("Player 1 scores one point.");
        } else {
            gameOutput.p2Points = game.p2Points + 1;
            System.out.println("Player 2 scores one point.");
        }

        if ( (gameOutput.p1Points <= 2 && gameOutput.p2Points <= 2) ||
                (gameOutput.p1Points <= 3 && gameOutput.p2Points <= 3 && gameOutput.p1Points != gameOutput.p2Points)) {
            System.out.println(pointName(game.p1Points) + " " + pointName(game.p2Points));
            return gameOutput;
        } else if (gameOutput.p1Points == gameOutput.p2Points){
            System.out.println("Deuce.");
        } else if ((gameOutput.p1Points >= gameOutput.p2Points + 2)) {
            System.out.println("P1 wins.");
            gameOutput.status = 1;
        } else if ((gameOutput.p2Points >= gameOutput.p1Points + 2)) {
            System.out.println("P2 wins.");
            gameOutput.status = 1;
        }else if (gameOutput.p1Points == gameOutput.p2Points + 1) {
            System.out.println("Advantage P1.");
        } else if (gameOutput.p1Points + 1 == gameOutput.p2Points) {
            System.out.println("Advantage P2.");
        }

        return gameOutput;

        }


    private static String pointName(int number) {
        switch (number) {
            case 0: return "love";
            case 1: return "fifteen";
            case 2: return "thirty";
            case 3: return "forty";
            default: return "boom";
        }
    }
}
