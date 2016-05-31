package gameofwar;

public class Card {
    private int mSuit;
    private int mRank;
    private boolean mFaceUp;

    public Card(int suit, int rank) throws IllegalArgumentException {
        if(suit < 0) {
            throw new IllegalArgumentException("Suit cannot be negative");
        }
        
        if(rank < 0) {
            throw new IllegalArgumentException("Rank cannot be negative");
        }
        
        mSuit = suit;
        mRank = rank;
        
        mFaceUp = false;
    }
    
    public int getSuit() {
        return mSuit;
    }
    
    public int getRank() {
        return mRank;
    }
    
    public boolean isFaceUp() {
        return mFaceUp;
    }
    
    public void setFaceUp(boolean isFaceUp) {
        mFaceUp = isFaceUp;
    }
    
}