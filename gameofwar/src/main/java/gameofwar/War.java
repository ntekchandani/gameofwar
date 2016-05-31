package gameofwar;

public class War
{
    public void play(int numberOfSuits, int numberOfRanks, int numberOfPlayers) {
        if(numberOfSuits < 1) {
            throw new IllegalArgumentException("Must have at least 1 suit");
        }
        
        if(numberOfRanks < 1) {
            throw new IllegalArgumentException("Must have at least 1 rank");
        }
        
        if(numberOfPlayers < 2) {
            throw new IllegalArgumentException("Must have at least 2 players");
        }
    }
}