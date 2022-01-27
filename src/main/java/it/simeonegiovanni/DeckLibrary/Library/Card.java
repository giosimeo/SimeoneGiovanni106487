package it.simeonegiovanni.DeckLibrary.Library;


public abstract class Card implements InCard {

    public final Suit suit;
    public final Type type;

    public Card(Suit suit, Type type) {
        this.suit = suit;
        this.type = type;
    }

    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Type getType() {
        return type;
    }


    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card in = (Card) obj;
        return in.getSuit().equals(suit) && in.getType().equals(type);
    }


    public boolean isLoad() {
        return type.ordinal() >= Type.Tre.ordinal();
    }

    @Override
    public String toString() {
        return String.format("%s di %s", type.name(), suit.name());
    }
    @Override
    public Card clone() throws CloneNotSupportedException {
        super.clone();
        return new CardImpl(this.suit, this.type);
    }

    public enum Suit {Spade, Bastoni, Denari, Coppe}

    public enum Type {Due, Quattro, Cinque, Sei, Sette, Fante, Cavallo, Re, Tre, Asso}
}
