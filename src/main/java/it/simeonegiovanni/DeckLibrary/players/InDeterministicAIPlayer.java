package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Card;
import it.simeonegiovanni.DeckLibrary.Game.Deck;

public interface InDeterministicAIPlayer {
    int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard);
}
