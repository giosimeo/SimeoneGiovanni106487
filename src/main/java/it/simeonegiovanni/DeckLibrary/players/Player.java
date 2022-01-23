package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Deck;
import it.simeonegiovanni.DeckLibrary.Game.Card;

import java.util.List;

public abstract class Player implements InPlayer {

    private Deck hand = new Deck(true);
    private Deck pointsDeck = new Deck(true);

    @Override
    public Deck getHand() {
        return hand;
    }

    @Override
    public Deck getPointsDeck() {
        return pointsDeck;
    }

    @Override
    public int getPoints() {
        return pointsDeck.getPoints();
    }

    /**
     * Aggiunge una carta al mazzo.
     * @param card Carta da aggiungere.
     */
    @Override
    public void draw(Card card) {
        hand.add(card);
    }

    /**
     * Prendi una lista di carte e mettila nel mazzzo dei punti.
     * @param cards Carta da prendere.
     */
    @Override
    public void take(List<Card> cards) {
        for (Card c : cards)
            pointsDeck.add(c);
    }

    /**
     * Sceglie una carta dal deck da giocare.
     * @param opponentPoints Mazzo punti presi dall'avversario.
     * @param opponentCard Carta giocata dall'avversario. Null se il giocatore è primo.
     * @param tableCard Carta Briscola.
     * @return Carta scelta.
     */
    @Override
    public final Card play(Deck opponentPoints, Card opponentCard, Card tableCard) {
        int choice = chooseCard(opponentPoints, opponentCard, tableCard);
        if (!hand.hasIndex(choice)) return null;
        return hand.remove(choice);
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
