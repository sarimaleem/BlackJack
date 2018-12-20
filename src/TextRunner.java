import java.util.Scanner;

public class TextRunner {
    public static void main(String[] args) {
        BlackJack blackJack = new BlackJack();

        Scanner in = new Scanner(System.in);

        blackJack.startRound();

        System.out.println("Insert Bet Amount");
        blackJack.bet(in.nextInt());

        System.out.println(blackJack);

        while (!blackJack.roundOver()) {

            if (blackJack.isBust() || blackJack.getCurrentStaying()) {
                blackJack.proceed();
                continue;
            }

            if (!blackJack.getCurrentPlayer().isHuman()) {
                if (((AI) blackJack.getCurrentPlayer()).shouldHit()) {
                    blackJack.hit();
                    System.out.println("AI Hits");
                } else {
                    blackJack.stay();
                    System.out.println("AI Stays");
                }

                blackJack.proceed();
                System.out.println(blackJack);
                continue;
            }



            System.out.println("Hit or Stay (h/s)");

            if (in.next().equals("h")) {
                blackJack.hit();
            } else {
                blackJack.stay();
            }

            blackJack.proceed();
            System.out.println(blackJack);
            System.out.println();
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("final values");
        blackJack.resetHands();
        System.out.println(blackJack);

    }
}
