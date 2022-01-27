package it.simeonegiovanni.DeckLibrary.Library;

public class CardImpl extends Card {
    @Override
    public int getPoints() {
        switch (type) {
            case Due:
            case Quattro:
            case Cinque:
            case Sei:
            case Sette:
                return 0;
            case Fante:
                return 2;
            case Cavallo:
                return 3;
            case Re:
                return 4;
            case Tre:
                return 10;
            case Asso:
                return 11;
        }
        return -1000;
    }

    public CardImpl(Suit suit, Type type) {
        super(suit, type);
    }
}
