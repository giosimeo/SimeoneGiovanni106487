package it.simeonegiovanni.DeckLibrary.Library;

import java.util.Collections;
import java.util.Stack;

public abstract class Deck {

    public Stack<Card> cards;
    protected Deck() {
        cards = new Stack<>();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return carte totali mazzo
     */
    public int size() {
        return cards.size();
    }

    /**
     * @param card carta da agiungere
     */
    public void add(Card card) {
        if (card == null) return;
        cards.add(card);
    }

    public Card remove(int index) {
        return cards.remove(index);
    }

    public boolean hasIndex(int index) {
        return index < 0 || cards.size() <= index;
    }

    public boolean isEmpty() {
        return !hasIndex(0);
    }


}
