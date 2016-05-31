# gameofwar

This is a Java implementation of the Game of War (card game) as described here:
http://en.wikipedia.org/wiki/War_(card_game)

# build

This project relies on the Gradle build system.
The Gradle wrapper is included in the root folder.
When you first run a build with ./gradlew installDist (or using gradlew.bat on Windows), the Gradle wrapper will set up your environment for you.
For details regarding doing so behind a proxy, see: https://docs.gradle.org/current/userguide/build_environment.html

This project utilizes the JUnit unit test framework and the Mockito mocking framework.  Both will be installed by Gradle during your first execution.

To run a build, run ./gradlew installDist
To execute tests, run ./gradlew test

# starting the game

To play the game, first ensure you have built the project via ./gradlew installDist.

Then, launch like so:
./build/install/gameofwar/bin/gameofwar [number of suits] [number of ranks] [number of players]

After that, follow the game prompts and enjoy!

# game rule clarifications

A 'war' is triggered only when the highest cards in a battle are tied.  If one player has a card higher than 2 or more other players who are tried, that player will win all cards at stake.
If a player runs out of cards, they will not be able to participate further in the round and will be eliminated, with their cards going to the winner of the round.
When the number of cards is not divisible by the number of players, some players will have 1 less card than others.

# project notes

The classes Card and QueueDeck have been written with TDD in mind from the beginning.  Due to time constraints on the project, the War class currently requires some refactor to remove dependency on class-level state and additional unit testing which that refactor will enable.

