import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;

public class Player {
    private Stack<Card> stack;
    private ArrayList<Card> winPile;

    public Player() {
        stack = new Stack<>();
        winPile = new ArrayList<>();
    }

    public boolean isStackEmpty() {
        return stack.isEmpty();
    }

    public void shuffleWinPile() {
        Collections.shuffle(winPile);
        stack.addAll(winPile);
        winPile.clear();
    }

    public void receiveCard(Card card) {
        stack.push(card);
    }

    public Card playCard() {
        if (stack.isEmpty()) {
            return null; // Return null if the stack is empty
        }
        return stack.pop();
    }


    public void addToWinPile(Card card) {
        winPile.add(card);
    }
}
