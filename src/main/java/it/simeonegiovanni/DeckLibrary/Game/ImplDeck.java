package it.simeonegiovanni.DeckLibrary.Game;


import it.simeonegiovanni.DeckLibrary.Library.Card;
import it.simeonegiovanni.DeckLibrary.Library.CardImpl;
import it.simeonegiovanni.DeckLibrary.Library.Deck;
import java.util.List;

public class ImplDeck extends Deck {

    /**
     * Crea un mazzo
     * @param empty Vero se il mazzo è vuoto.
     */
    public ImplDeck(boolean empty) {
        super();
        if (empty) return;
        //Genera ordine random
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Type type : Card.Type.values())
                cards.add(new CardImpl(suit, type));
                shuffle();
    }


    /**
     * metodo per rimuovere carta dal mazzo.
     * @param card carta mazzo
     * @return carta
     */
    private Card remove(Card card) {
        for (Card c : cards) if (c.equals(card)) {
            cards.remove(c);
            return c;
        }
        return null;
    }

    /**
     * Pesca la carta in cima al mazzo.
     * @return Carta pescata.
     */
    public Card draw() {
        if (cards.size() == 0) return null;
        return remove(cards.get(cards.size() - 1));
    }

    /**
     * @return carte mazzo
     */
    public List<Card> getCards() {
        return cards;
    }

    /**
     * @return punti carta
     */
    public int getPoints() {
        int points = 0;
        for (Card card : cards) points += card.getPoints();
        return points;
    }


    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        int index = 0;
        for (Card card : cards) out.append("\t").append(++index).append(". ").append(card.toString()).append("\n");
        return out.toString();
    }


    @Override
    public ImplDeck clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException ignored) {}
        ImplDeck cloned = new ImplDeck(true);
        for (Card card : cards)
            try {
                cloned.cards.add(card.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        return cloned;
    }

}
