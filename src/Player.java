import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> cards;
    int coins;


    public Player(String name) {
        cards = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public int calcHandValue() {
        int aces = 0;
        int total = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getFace().equals("A")) {
                aces++;
            } else {
                total += cards.get(i).getVal();
            }
        }

        for (int i = 0; i < aces; i++) {
            if (total + 11 > 21) {
                total += 1;
            } else {
                total += 11;
            }


        }




    }



}
