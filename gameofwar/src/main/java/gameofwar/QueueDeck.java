package gameofwar;

public class QueueDeck implements Deck {

    public QueueDeck() {
        super();
    }

    /* Create the deck of cards */
    public void create(int numberOfSuits, int numberOfRanks) {
        if(numberOfSuits < 1) {
            throw new IllegalArgumentException("Deck must be created with at least 1 suit");
        }
        
        if(numberOfRanks < 1) {
            throw new IllegalArgumentException("Deck must be created with at least 1 rank");
        }
    }

    /* Shuffle the deck */
    public void shuffle() {
        throw new UnsupportedOperationException();
    }

    /* deal a card from the deck */
    public Card deal() {
        throw new UnsupportedOperationException();
    }
    
    /* add a card to the deck */
    public void add(Card cardToAdd) {
        throw new UnsupportedOperationException();
    }

}