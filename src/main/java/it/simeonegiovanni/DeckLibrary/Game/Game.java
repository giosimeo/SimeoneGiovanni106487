package it.simeonegiovanni.DeckLibrary.Game;

import it.simeonegiovanni.DeckLibrary.Library.Card;
import it.simeonegiovanni.DeckLibrary.Library.Player;
import java.util.ArrayList;
import java.util.Random;


/**
 * Modella un gioco tra due giocatori.
 */
public class Game {

    protected final Player playerA, playerB;
    protected final ImplDeck deck;
    protected final Card tableCard;

    protected boolean ended = false;

    /**
     * True  -> Player A Comincia
     * False -> Player B Comincia
     */
    protected boolean turn;

    /**
     * Inizializza il gioco facendo pescare 3 carte ad ogni giocatori, la briscola  e scegliendo casualmente il primo giocatore di mano.
     * @param playerA Primo player.
     * @param playerB Secondo player.
     */
    public Game(Player playerA, Player playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        deck = new ImplDeck(false);
        for (int i = 0; i < 3; i++) {
            this.playerA.draw(deck.draw());
            this.playerB.draw(deck.draw());
        }
        tableCard = deck.draw();
        turn = new Random().nextBoolean();
        log("Inizio del Gioco. PlayerA è "+playerA.getType()+", PlayerB è "+playerB.getType());
    }

    /**
     * Simula il gioco fino alla fine e poi termina il gioco.
     */
    public void run() {
        while (!ended) step();
        if (playerA.getPoints() > playerB.getPoints()) return;
        playerB.getPoints();
        playerA.getPoints();
    }

    /**
     * Simula un intera mano.
     * 1 - Il playerA comincia per prima, Il playerB per secondo.
     * 2 - Il vincitore della mano prende entrambe le carte e le ahìggiunge sui suoi punti.
     * 3 - Il vincitore della mano pesca, poi chi ha perso la mano.
     * 4 - Il vincitore della mano sarà il primo a rispondere alla prossima.
     */
    private void step() {
        if (ended) return;
        log("New step. Player "+(turn ? "A" : "B")+" è primo.");
        Player p1 = turn ? playerA : playerB;
        Player p2 = turn ? playerB : playerA;

        Card c1 = p1.play(p2.getPointsDeck(), null, tableCard);
        log("Player "+(p1 == playerA ? "A" : "B")+" ha giocato "+c1);
        Card c2 = p2.play(p1.getPointsDeck(), c1, tableCard);
        log("Player "+(p1 == playerB ? "A" : "B")+" ha giocato "+c2);

        ArrayList<Card> hand = new ArrayList<>();
        hand.add(c1);
        hand.add(c2);

        assert c1 != null;
        assert c2 != null;
        boolean firstWins = Rules.doesFirstCardWin(c1, c2, tableCard.getSuit());
        Player winner = firstWins ? p1 : p2;
        Player loser  = firstWins ? p2 : p1;
        log("Player "+(winner == playerA ? "A" : "B")+" won the hand.");

        winner.take(hand);
        if (deck.isEmpty()) winner.draw(deck.draw());
        if (deck.isEmpty()) loser.draw(deck.draw());

        turn = winner == playerA;

        if (playerA.hasCardsInHand() || playerA.hasCardsInHand()) ended = true;
    }

    protected void log(String in) {
        System.out.println("[Game] "+in);
    }
}
