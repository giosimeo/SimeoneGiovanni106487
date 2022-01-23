package it.simeonegiovanni.DeckLibrary.players;


import it.simeonegiovanni.DeckLibrary.Game.Deck;
import it.simeonegiovanni.DeckLibrary.Game.Card;

public class DeterministicAIPlayer extends Player implements InDeterministicAIPlayer {

    @Override
    public int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard) {
        float[] prob = new float[getHand().size()];

        //Dai punti ad ogni carta
        for (int i = 0; i < prob.length; i++) {
            Card card = getHand().getCard(i);
            prob[i] -= card.getType().ordinal()*0.5;
            if (card.getSuit().equals(tableCard.getSuit())) prob[i] -= (card.getType().ordinal() + 1);

            if (opponentCard != null) { //Dopo che l'avversario gioca una carta
                if (card.getSuit().equals(opponentCard.getSuit()) && !card.getSuit().equals(tableCard.getSuit()) && card.getType().ordinal() > opponentCard.getType().ordinal()) {
                    //puooi prendere (no briscola)
                    prob[i] += card.getPoints() + opponentCard.getPoints();
                }
                if (opponentCard.getSuit().equals(tableCard.getSuit())) {
                    //Player gioca briscola, dai meno punti possibili
                    prob[i] -= card.getPoints();
                    if (card.getSuit().equals(tableCard.getSuit())) prob[i] -= 8*card.getType().ordinal();
                }
                if (opponentCard.getPoints() >= 10 && card.getSuit().equals(tableCard.getSuit())) {
                    //Player gioca carica
                    prob[i] += 15 - 2*card.getPoints();
                }
            }

        }

        //Ritorno la carta più alta
        int best = -1;
        float bestPoints = Integer.MIN_VALUE;
        for (int i = 0; i < prob.length; i++) {
            if (Double.compare(prob[i], bestPoints) > 0) {
                bestPoints = prob[i];
                best = i;
            }
        }
        return best;
    }
}
