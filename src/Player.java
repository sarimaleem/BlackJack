import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<Card> cards;
    int coins;
    boolean isHuman;

    public Player() {
        cards = new ArrayList<>();
    }
    
    public Player(String name) {
        cards = new ArrayList<>();
        this.name = name;
        isHuman = true;
        setCoins(500);
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

        int finalTotal = total + aces;
            for (int i = 0; i <= aces; i++) {
                int temp = total;

                temp += i * 11;
                temp += (aces - i);

                System.out.println(temp);

                if (finalTotal > 21) continue;
                if (finalTotal <= 21 && temp <= 21 && temp > finalTotal) {
                    finalTotal = temp;
                }
            }

        System.out.println();
        return finalTotal;
    }


    public boolean isBust() {
        return calcHandValue() > 21;
    }

    public void addCardToHand(Card card) {
        cards.add(card);
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getCoins() {
        return coins;
    }

    public int getHandValue() {
        return calcHandValue();
    }

    public boolean isHuman() {
        return isHuman;
    }


}
