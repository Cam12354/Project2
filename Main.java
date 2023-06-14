public class Main {
    public static void main(String[] args) {
        int numGames = 100;

        for (int numDecks = 1; numDecks <= 10; numDecks++) {
            // Create a deck and shuffle it
            Deck deck = new Deck();
            deck.initializeDeck(numDecks);
            deck.shuffleDeck();

            // Create two players
            Player player1 = new Player();
            Player player2 = new Player();

            int totalTurns = 0;

            // Run the game multiple times
            for (int i = 0; i < numGames; i++) {
                // Deal cards to players' stacks
                dealCardsToPlayers(deck, player1, player2);

                // Play the game and get the number of turns
                int turns = playGame(player1, player2);

                totalTurns += turns;

                // Shuffle win piles if necessary
                if (player1.isStackEmpty()) {
                    player1.shuffleWinPile();
                }
                if (player2.isStackEmpty()) {
                    player2.shuffleWinPile();
                }
            }

            // Calculate the average number of turns
            double averageTurns = (double) totalTurns / numGames;

            // Display the deck count and average turn count
            System.out.println("Number of Decks: " + numDecks);
            System.out.println("Average Number of Turns: " + averageTurns);
            System.out.println();
        }
    }

    private static void dealCardsToPlayers(Deck deck, Player player1, Player player2) {
        while (!deck.isDeckEmpty()) {
            Card card1 = deck.dealCard();
            Card card2 = deck.dealCard();

            player1.receiveCard(card1);
            player2.receiveCard(card2);
        }
    }

    private static int playGame(Player player1, Player player2) {
        int turns = 0;

        while (!player1.isStackEmpty() && !player2.isStackEmpty()) {
            turns++;

            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            System.out.println("Player 1 plays: " + card1);
            System.out.println("Player 2 plays: " + card2);

            if (card1.compareTo(card2) > 0) {
                player1.addToWinPile(card1);
                player1.addToWinPile(card2);
                System.out.println("Player 1 wins the turn.");
            } else if (card1.compareTo(card2) < 0) {
                player2.addToWinPile(card1);
                player2.addToWinPile(card2);
                System.out.println("Player 2 wins the turn.");
            } else {
                System.out.println("War!");

                // Play additional cards for war
                playWar(player1, player2);
            }
        }

        return turns;
    }

    private static void playWar(Player player1, Player player2) {
        for (int i = 0; i < 3; i++) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            if (card1 != null) {
                player1.addToWinPile(card1);
            }
            if (card2 != null) {
                player2.addToWinPile(card2);
            }
        }

        // Check if any player's stack is empty after playing war
        if (player1.isStackEmpty() || player2.isStackEmpty()) {
            return; // Exit the method if a stack is empty
        }
    }
}


