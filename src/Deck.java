import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    ArrayList<Card> deck;
    final String[] faces = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    final String[] suites = new String[]{"club", "spade", "heart", "diamond"};


    public Deck() {
        deck = new ArrayList<>();
        for (String s : suites) {
            for (String f : faces) {
                deck.add(new Card(f, s));
            }
        }
    }


    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card removeTop() {
        return deck.remove(deck.size() - 1);
    }
}
