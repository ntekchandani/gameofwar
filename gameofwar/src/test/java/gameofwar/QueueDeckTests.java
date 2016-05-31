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
}