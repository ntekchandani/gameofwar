package gameofwar;

import java.util.ArrayList;

public interface Deck {

    /* Create the deck of cards */
    public void create(int numberOfSuits, int numberOfRanks);

    /* Shuffle the deck */
    public void shuffle();

    /* deal a card from the deck */
    public Card deal();
    
    /* add a card to the deck */
    public void add(Card cardToAdd);

    /* return true if deck is empty */
    public boolean isEmpty();
    
    /* return deck size */
    public int size();
    
    /* clear the deck of all cards */
    public void clear();
    
    /* return the entire deck as a string */
    @Override
    public String toString();
}