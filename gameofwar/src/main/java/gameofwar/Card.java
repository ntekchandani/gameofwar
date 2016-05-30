package gameofwar;

public class Card {
    public Card(int suit, int rank) throws IllegalArgumentException {
        if(suit < 0) {
            throw new IllegalArgumentException("Invalid suit: cannot be negative");
        }
    }
}