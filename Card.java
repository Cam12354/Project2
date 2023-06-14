public class Card implements Comparable<Card> {
    private Face face;
    private Suit suit;

    public Card(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {
        return face;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        return this.face.getValue() - other.face.getValue();
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }
}
