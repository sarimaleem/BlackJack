import java.awt.*;

public class GraphicsCard {

    Card card;
    int x, y;

    public GraphicsCard(Card card, int x, int y) {
        this.card = card;
        this.x = x;
        this.y = y;
    }


    public void draw(Graphics2D graphics2D) {
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRoundRect(x, y, 125, 215, 30, 30);
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRoundRect(x, y, 125, 215, 30, 30);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawRoundRect(x, y, 125, 215, 30, 30);

        if(card.suite.equals("diamond") || card.suite.equals("heart"))
            graphics2D.setColor(Color.red);

        drawSuite(graphics2D, card.getSuite());
        drawFace(graphics2D, card.getFace());

    }


    public void drawSuite(Graphics2D graphics2D, String suite) {
        graphics2D.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        graphics2D.drawString(suite.substring(0, 1).toUpperCase(), x + 50, y + 100);
    }


    public void drawFace(Graphics2D graphics2D, String face) {
        graphics2D.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
        graphics2D.drawString(face, x + 10, y + 20);
        graphics2D.drawString(face, x + 105, y + 190);
    }








}
