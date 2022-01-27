package it.simeonegiovanni.DeckLibrary.Library;

import it.simeonegiovanni.DeckLibrary.Game.ImplDeck;

import java.util.List;

public interface InPlayer {
    ImplDeck getHand();

    ImplDeck getPointsDeck();

    int getPoints();

    void draw(Card card);

    void take(List<Card> cards);

    Card play(ImplDeck opponentPoints, Card opponentCard, Card tableCard);

    int chooseCard(ImplDeck opponentPoints, Card opponentCard, Card tableCard);

    boolean hasCardsInHand();

    String getType();
}
