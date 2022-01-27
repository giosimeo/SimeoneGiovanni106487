package it.simeonegiovanni.DeckLibrary.Library;

import it.simeonegiovanni.DeckLibrary.Game.ImplDeck;


public abstract class Player implements InPlayer {

    public final ImplDeck hand = new ImplDeck(true);
    public final ImplDeck pointsDeck = new ImplDeck(true);

    @Override
    public ImplDeck getHand() {
        return hand;
    }

    @Override
    public ImplDeck getPointsDeck() {
        return pointsDeck;
    }

    @Override
    public int getPoints() {
        return pointsDeck.getPoints();
    }

    /**
     * Aggiunge una carta alla mano del giocatore.
     * @param card Carta da aggiungere.
     */
    @Override
    public void draw(Card card) {
        hand.add(card);
    }

    @Override
    public boolean hasCardsInHand() {
        return !hand.isEmpty();
    }

    @Override
    public String getType() {
        return this.getClass().getSimpleName();
    }
}
