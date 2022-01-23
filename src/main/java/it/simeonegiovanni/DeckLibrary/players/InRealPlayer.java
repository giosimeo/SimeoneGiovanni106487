package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Card;
import it.simeonegiovanni.DeckLibrary.Game.Deck;

public interface InRealPlayer extends InPlayer {
    @Override
    int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard);
}
