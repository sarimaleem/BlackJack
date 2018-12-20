import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GraphicsRunner extends JPanel implements MouseListener {

    static JFrame window;
    static BlackJack blackJack;


    public static void main(String[] args) {
        window = new JFrame("Camel Up");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1920, 1080);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setResizable(true);
        GraphicsRunner runner = new GraphicsRunner();
        window.addMouseListener(runner);
        window.add(runner);
        window.setVisible(true);
        blackJack = new BlackJack();
        blackJack.startRound();
    }

    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        drawPlayer(graphics2D, blackJack.getCurrentPlayer());
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void drawPlayer(Graphics2D graphics2D, Player player) {
        ArrayList<Card> cards = player.getCards();
        for (int i = 0; i < cards.size(); i++) {
            GraphicsCard graphicsCard = new GraphicsCard(cards.get(i), 500 + i * 115, 500);
            graphicsCard.draw(graphics2D);
        }
    }




}
