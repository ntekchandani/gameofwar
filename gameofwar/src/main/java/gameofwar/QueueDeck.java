package gameofwar;

import java.util.ArrayList;
import java.util.Random;

public class QueueDeck implements Deck {

    private ArrayList<Card> mCards; 

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
        
        mCards = new ArrayList<Card>();

        for(int suit = 0; suit < numberOfSuits; suit++) {
            for(int rank = 0; rank < numberOfRanks; rank++) {
                mCards.add(new Card(suit, rank));
            }
        }
        
        shuffle();
    }

    /* Shuffle the deck */
    public void shuffle() {
        int totalCards = mCards.size();
        int cardsToShuffle = totalCards;
        Random randomGenerator = new Random();
        for(int i = 0; i < totalCards; i++) {
            int cardIndex = randomGenerator.nextInt(cardsToShuffle);
            Card pickedCard = mCards.get(cardIndex);
            mCards.remove(cardIndex);
            mCards.add(pickedCard);
            cardsToShuffle--;
        }
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