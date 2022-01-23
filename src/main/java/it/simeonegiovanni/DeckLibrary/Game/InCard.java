package it.simeonegiovanni.DeckLibrary.Game;

public interface InCard {
    Card.Suit getSuit();

    Card.Type getType();

    int getPoints();

    boolean isLoad();
}
