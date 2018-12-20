import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackJack {

    Deck deck;
    ArrayList<Player> players;
    int currentPlayerIndex;
    int betSum;
    boolean[] stayList;

    public BlackJack() {
        deck = new Deck();
        deck.shuffle();
        players = new ArrayList<>();
        players.add(new Player("Sarim"));
        players.add(new AI("terminator"));
        stayList = new boolean[players.size()];

    }


    public void startRound() {
        for (Player player : players) {
            player.addCardToHand(deck.removeTop());
            player.addCardToHand(deck.removeTop());
        }
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
        stayList[currentPlayerIndex] = true;
    }

    public boolean roundOver() {

        //System.out.println(Arrays.toString(stayList));

        for (int i = 0; i < stayList.length; i++) {
            if (stayList[i] == false) {
                if(!players.get(i).isBust())
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
            betSum = 0;
            System.out.println("no one wins :(");
            players.get(0).resetHand();
            players.get(1).resetHand();
            return;
        }

        if(!players.get(0).isBust()) {
            if (players.get(1).isBust()) {
                players.get(0).setCoins(players.get(0).getCoins() + betSum);
                System.out.println(players.get(0).getName() + " won");
                betSum = 0;
                players.get(0).resetHand();
                players.get(1).resetHand();
                return;
            } else if (players.get(0).getHandValue() > players.get(1).getHandValue()) {
                players.get(0).setCoins(players.get(0).getCoins() + betSum);
                System.out.println(players.get(0).getName() + " won");
                betSum = 0;
                players.get(0).resetHand();
                players.get(1).resetHand();
                return;
            }
        }


        players.get(1).setCoins(players.get(0).getCoins() + betSum);
        System.out.println(players.get(1).getName() + " won");
        betSum = 0;
        players.get(0).resetHand();
        players.get(1).resetHand();
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

    public String toString() {
        return players.toString();
    }

    public boolean getCurrentStaying() {
        return stayList[currentPlayerIndex];
    }


}
