package gameofwar;

public class War
{
    private static final String HELP_TEXT = "Expected Arguments: [number of suits] [number of ranks] [number of players]";

    public static void main(String[] args) {
        War warGame = new War();
        if(args.length != 3) {
            throw new IllegalArgumentException(HELP_TEXT);
        }

    }
    
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