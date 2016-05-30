package gameofwar;

public class Card {
    public Card(int suit, int rank) throws IllegalArgumentException {
        if(suit < 0) {
            throw new IllegalArgumentException("Suit cannot be negative");
        }
        
        if(rank < 0) {
            throw new IllegalArgumentException("Rank cannot be negative");
        }
    }
}