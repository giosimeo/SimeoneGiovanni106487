package it.simeonegiovanni.DeckLibrary.Library;


public interface InCard {
    Card.Suit getSuit();

    Card.Type getType();

    int getPoints();

    boolean isLoad();
}
