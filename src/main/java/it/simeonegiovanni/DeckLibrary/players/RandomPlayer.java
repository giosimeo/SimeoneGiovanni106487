package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.ImplDeck;
import it.simeonegiovanni.DeckLibrary.Library.Card;
import it.simeonegiovanni.DeckLibrary.Game.PlayerImpl;
import it.simeonegiovanni.DeckLibrary.Library.InPlayer;

import java.util.Random;

public class RandomPlayer extends PlayerImpl implements InPlayer {

    @Override
    public int chooseCard(ImplDeck opponentPoints, Card opponentCard, Card tableCard) {
        return new Random().nextInt(getHand().size());
    }
}
