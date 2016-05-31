package gameofwar.tests;

import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.*;

import gameofwar.Deck;
import gameofwar.QueueDeck;
import gameofwar.Card;

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
    
    @Test
    public final void whenAddingNewCardMethodCallPasses() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(1,1);
        Card mockedCard = mock(Card.class);
        testDeck.add(mockedCard);
    }
    
    @Test
    public final void whenDealingAddedCardReturnedInOrder() {
        Deck testDeck = (Deck) new QueueDeck();
        testDeck.create(1,1);
        Card mockedCard = mock(Card.class);
        testDeck.add(mockedCard);
        when(mockedCard.getSuit()).thenReturn(10);
        when(mockedCard.getRank()).thenReturn(11);
        testDeck.deal();
        Card testCard = testDeck.deal();
        Assert.assertEquals(10,testCard.getSuit());
        Assert.assertEquals(11,testCard.getRank());
    }
    
}