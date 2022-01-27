package it.simeonegiovanni.DeckLibrary.Game;

import it.simeonegiovanni.DeckLibrary.Library.Card;
import it.simeonegiovanni.DeckLibrary.Library.Player;

import java.util.List;

public class PlayerImpl extends Player {
    @Override
    public int chooseCard(ImplDeck opponentPoints, Card opponentCard, Card tableCard) {
        return 0;
    }
    /**
     * Sceglie una carta dal deck da giocare.
     * @param opponentPoints Mazzo punti presi dall'avversario.
     * @param opponentCard Carta giocata dall'avversario. Null se il giocatore è primo.
     * @param tableCard Carta Briscola.
     * @return Carta scelta.
     */
    @Override
    public final Card play(ImplDeck opponentPoints, Card opponentCard, Card tableCard) {
        int choice = chooseCard(opponentPoints, opponentCard, tableCard);
        if (hand.hasIndex(choice)) return null;
        return hand.remove(choice);
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

}
