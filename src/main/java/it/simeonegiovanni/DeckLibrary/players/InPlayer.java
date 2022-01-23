package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Card;
import it.simeonegiovanni.DeckLibrary.Game.Deck;

import java.util.List;

public interface InPlayer {
    Deck getHand();

    Deck getPointsDeck();

    int getPoints();

    void draw(Card card);

    void take(List<Card> cards);

    Card play(Deck opponentPoints, Card opponentCard, Card tableCard);

    int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard);

    boolean hasCardsInHand();

    String getType();
}
