package it.simeonegiovanni.DeckLibrary.players;

import it.simeonegiovanni.DeckLibrary.Game.Deck;
import it.simeonegiovanni.DeckLibrary.Game.Card;
import it.simeonegiovanni.DeckLibrary.utils.IO;

import java.util.List;

public class RealPlayer extends Player implements InRealPlayer {
    @Override
    public int chooseCard(Deck opponentPoints, Card opponentCard, Card tableCard) {
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        System.out.println("~~~~~Nuova Mano~~~~~");
        System.out.println("$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Le tue carte:");
        List<Card> cards = getHand().getCards();
        for (int i = 0; i < cards.size(); i++)
            System.out.printf("\t%d. %s\n", i + 1, cards.get(i).toString());
        System.out.printf("\nCarte a terra: %s\n\n", tableCard.toString(),"");
        if (opponentCard != null)
            System.out.printf("L'Avversario gioca: %s\n\n", opponentCard.toString());
        int choice = -1;
        while (!getHand().hasIndex(choice-1))
            choice = IO.askNumber("Scegli una carta da giocare > ");
        return choice-1;
    }
}
