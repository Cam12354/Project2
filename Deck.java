import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
    }

    public void initializeDeck(int numDecks) {
        deck.clear();
        for (int i = 0; i < numDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Face face : Face.values()) {
                    deck.add(new Card(face, suit));
                }
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            return null; // Deck is empty, no card to deal
        }
        return deck.remove(deck.size() - 1);
    }

    public boolean isDeckEmpty() {
        return deck.isEmpty();
    }

}

