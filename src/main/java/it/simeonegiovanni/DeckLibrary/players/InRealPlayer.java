package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Library.Card;
import it.simeonegiovanni.DeckLibrary.Game.ImplDeck;
import it.simeonegiovanni.DeckLibrary.Library.InPlayer;

public interface InRealPlayer extends InPlayer {
    @Override
    int chooseCard(ImplDeck opponentPoints, Card opponentCard, Card tableCard);
}
