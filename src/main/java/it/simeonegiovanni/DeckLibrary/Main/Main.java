package it.simeonegiovanni.DeckLibrary.Main;

import it.simeonegiovanni.DeckLibrary.Game.Game;
import it.simeonegiovanni.DeckLibrary.players.Player;
import it.simeonegiovanni.DeckLibrary.players.RandomPlayer;
import it.simeonegiovanni.DeckLibrary.players.RealPlayer;

public class Main {

    public static void main(String[] args) {
        Player p1 = new RandomPlayer();
        Player p2 = new RealPlayer();

        Game game = new Game(p1, p2);

        game.run();
    }
}
