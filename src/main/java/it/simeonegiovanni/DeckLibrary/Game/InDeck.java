package it.simeonegiovanni.DeckLibrary.Game;

import java.util.List;

public interface InDeck {
    void add(Card card);

    Card draw();

    int size();

    List<Card> getCards();

    Card getCard(int index);

    int getPoints();

    boolean hasIndex(int index);

    boolean isEmpty();
}
