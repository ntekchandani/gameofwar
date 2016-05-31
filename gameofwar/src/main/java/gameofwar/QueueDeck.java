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

    /* deal a card from the deck 
       this implementation will deal by removing the Card from the top of the deck */
    public Card deal() {
        if(mCards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        Card cardToReturn = mCards.get(0);
        mCards.remove(0);
        return cardToReturn;
    }
    
    /* add a card to the deck 
       this implementation will add the Card to the end of the deck */
    public void add(Card cardToAdd) {
        if(mCards == null) {
            mCards = new ArrayList<Card>();
        }
        mCards.add(cardToAdd);
    }
    
    public boolean isEmpty() {
        return mCards.isEmpty();
    }

}