import controllers.GameController;
import controllers.PlayerController;
import models.DifficultyLevel;
import models.Game;
import models.Player;
import strategies.winning.ColumnWinningStrategy;
import strategies.winning.RowWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to the Tic Tac Toe game!!");
        System.out.println("Let's start playing..");
        System.out.println("How many players would be playing?");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Enter the dimension for the board.");
        int dimension = sc.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Please enter details of Player " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Symbol: ");
            String symbol = sc.next();
            System.out.println("Is this player a BOT? (Y/N)");
            if (sc.next().equals("Y")) {
                System.out.println("What's the level of the bot? (E/M/H)");
                String level = sc.next();
                DifficultyLevel difficultyLevel;
                switch (level) {
                    case "E":
                        difficultyLevel = DifficultyLevel.EASY;
                        break;
                    case "M":
                        difficultyLevel = DifficultyLevel.MEDIUM;
                        break;
                    default:
                        difficultyLevel = DifficultyLevel.HARD;
                }
                players.add(PlayerController.createBot(name, symbol.charAt(0), difficultyLevel));
            } else {
                players.add(PlayerController.createHumanPlayer(name, symbol.charAt(0)));
            }
        }

//        System.out.println(players.stream().map(player -> player.getSymbol()).
//                collect(Collectors.toSet()).size());
//        System.out.println(players.size());
//        if(players.stream().map(player -> player.getSymbol()).
//                collect(Collectors.toSet()).size() != players.size()) {
//            throw new RuntimeException();
//        }


        assert players.stream().map(player -> player.getSymbol()).
                collect(Collectors.toSet()).size() == players.size();



        Game game = GameController.initiateGame(
                dimension,
                players,
                List.of(new ColumnWinningStrategy(), new RowWinningStrategy()));

        System.out.println("Are you ready to start the game?");

        if (sc.next().equals("Y")) {
            GameController gc = new GameController(game);
            gc.startGame();
        }

        System.out.println("Game ended.");

        // TODO: Ask if the player wants a replay of the game.
        // Using the list of moves that we have stored.




    }
}