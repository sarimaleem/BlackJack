public class playerTest {
    public static void main(String[] args) {
        Player player = new Player("bob");
        player.addCardToHand(new Card("3", "clubs"));
        //player.addCardToHand(new Card("K", "clubs"));

        //player.addCardToHand(new Card("K", "spades"));
        player.addCardToHand(new Card("A", "spades"));
        player.addCardToHand(new Card("A", "spades"));
        player.addCardToHand(new Card("A", "spades"));
        //player.addCardToHand(new Card("A", "spades"));
        //player.addCardToHand(new Card("A", "spades"));


        System.out.println(player.getHandValue());
    }
}
