package it.simeonegiovanni.DeckLibrary.Game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {

    private final Stack<Card> cards;

    /**
     * Crea un mazzo
     * @param empty Vero se il mazzo è vuoto.
     */
    public Deck(boolean empty) {
        cards = new Stack<>();
        if (empty) return;
        //Generate random order
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Type type : Card.Type.values())
                cards.add(new Card(suit, type));

    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void add(Card card) {
        if (card == null) return;
        cards.add(card);
    }

    private Card remove(Card card) {
        for (Card c : cards) if (c.equals(card)) {
            cards.remove(c);
            return c;
        }
        return null;
    }

    public Card remove(int index) {
        return cards.remove(index);
    }

    /**
     * Pesca la carta in cima al mazzo.
     * @return Carta pescata.
     */
    Card draw() {
        if (cards.size() == 0) return null;
        return remove(cards.get(cards.size() - 1));
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    public Card getCard(int index) {
        if (!hasIndex(index)) return null;
        return cards.get(index);
    }

    public int getPoints() {
        int points = 0;
        for (Card card : cards) points += card.getPoints();
        return points;
    }

    public boolean hasIndex(int index) {
        return index >= 0 && cards.size() > index;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int index = 0;
        for (Card card : cards) out.append("\t").append(String.valueOf(++index)).append(". ").append(card.toString()).append("\n");
        return out.toString();
    }


    @Override
    public Deck clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException ignored) {}
        Deck cloned = new Deck(true);
        for (Card card : cards)
            try {
                cloned.cards.add(card.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return cloned;
    }

    public boolean isEmpty() {
        return !hasIndex(0);
    }
}
