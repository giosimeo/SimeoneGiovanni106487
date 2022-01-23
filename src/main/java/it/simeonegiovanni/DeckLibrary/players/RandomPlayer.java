package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Deck;
import it.simeonegiovanni.DeckLibrary.Game.Card;

import java.util.Random;

public class RandomPlayer extends Player implements InPlayer {
    @Override
    public int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard) {
        return new Random().nextInt(getHand().size());
    }
}
