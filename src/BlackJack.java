import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;

public class BlackJack {

    Deck deck;
    ArrayList<Player> players;
    int currentPlayerIndex;
    int betSum;
    ArrayList<Boolean> stayList;

    public BlackJack() {
        deck = new Deck();
        deck.shuffle();
        players = new ArrayList<>();
        players.add(new Player("Sarim"));
        players.add(new AI("terminator"));
    }


    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }


    public void proceed() {
        currentPlayerIndex = ++currentPlayerIndex % players.size();
    }

    public void hit() {
        getCurrentPlayer().addCardToHand(deck.removeTop());
    }


    public boolean isBust() {
        return getCurrentPlayer().isBust();
    }

    public Deck getDeck() {
        return deck;
    }

    public void stay() {
        stayList.set(currentPlayerIndex, true);
    }

    public boolean roundOver() {
        for (Boolean b : stayList) {
            if (b == false) {
                return false;
            }
        }
        return true;
    }

    public void resetHands() {
        deck = new Deck();

        if (draw(players.get(0), players.get(1))) {
            players.get(0).setCoins(players.get(0).getCoins() + betSum / 2);
            players.get(1).setCoins(players.get(1).getCoins() + betSum / 2);
        }

        if (!players.get(0).isBust() && players.get(0).getHandValue() > players.get(1).getHandValue()) {
            players.get(0).setCoins(players.get(0).getCoins() + betSum);
        }

        betSum = 0;

    }



    public void bet(int num) {
        for (Player player : players) {
            player.setCoins(player.getCoins() - num);
            betSum += num;
        }
    }

    public boolean draw(Player p1, Player p2) {
        if (p1.getHandValue() == p2.getHandValue()) {
            return true;
        }

        if (p1.isBust() && p2.isBust()) {
            return true;
        }
        return false;
    }
}
