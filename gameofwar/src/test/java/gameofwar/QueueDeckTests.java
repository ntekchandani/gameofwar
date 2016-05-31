package gameofwar.tests;

import org.junit.Test;
import org.junit.Assert;

import gameofwar.Deck;
import gameofwar.QueueDeck;

public class QueueDeckTests {
    @Test(expected = IllegalArgumentException.class)
    public final void whenDeckCreatedWithLessThan1SuitCountThenExceptionIsThrown() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(0,1);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public final void whenDeckCreatedWithLessThan1RankCountThenExceptionIsThrown() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(1,0);
    }
    
    @Test(expected = IllegalStateException.class)
    public final void whenDealCalledMoreTimesThanCardsThenExceptionIsThrown() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(4,1);
        testDeck.deal();
        testDeck.deal();
        testDeck.deal();
        testDeck.deal();
        testDeck.deal();
    }
    
    // TODO: shuffle should be tested more robustly.  While it is inherently nondeterministic,
    // there are some ways depending on implementation to test this functionality.
    // at minimum, should be possible to at least verify deck ordering changed.
    // Current QueueDeck implementation will remove a card on 'Deal' so a 'Peek' method
    // or a method to compare Decks could be useful for testing.
    
    @Test
    public final void whenCallingShuffleMethodCallPasses() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(4,13);
        testDeck.shuffle();
    }
    
}