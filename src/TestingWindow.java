
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestingWindow extends JFrame {

    ImageManager im = new ImageManager();
    int x = -1;

    public TestingWindow() {
        im.loadImages("ImageList.txt");

        setUndecorated(false);
        setSize(500, 500);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        while (true) {
            try {
                Thread.sleep(4000);
                repaint();
            } catch (InterruptedException e) {
            }
        }
    }

    public void paint(Graphics g) {

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, getWidth(), getWidth());
        g.setColor(Color.RED);
        g.drawString("" + x, 300, 300);
        switch (x) {
            case 0:
                g.drawImage(im.getImage("box"), 0, 0, null);
                break;
            case 1:
                g.drawImage(im.getImage("strip2"), 0, 0, null);
                g.drawImage(im.getImage("strip0"), 105, 0, null);
                g.drawImage(im.getImage("strip1"), 210, 0, null);
                break;
            case 2:
                g.drawImage(im.getImage("stripBlack"), 0, 0, null);
                g.drawImage(im.getImage("stripRed"), 105, 0, null);
                g.drawImage(im.getImage("stripGreen"), 210, 0, null);
                break;
            case 3:
                g.drawImage(im.getImage("gridr0c2"), 0, 0, null);
                g.drawImage(im.getImage("gridr1c2"), 105, 0, null);
                g.drawImage(im.getImage("gridr0c0"), 210, 0, null);
                g.drawImage(im.getImage("gridr1c0"), 0, 105, null);
                g.drawImage(im.getImage("gridr0c1"), 105, 105, null);
                g.drawImage(im.getImage("gridr1c1"), 210, 105, null);
                break;
            case 4:
                g.drawImage(im.getImage("gridRed"), 0, 0, null);
                g.drawImage(im.getImage("gridBlue"), 105, 0, null);
                g.drawImage(im.getImage("gridBlack"), 210, 0, null);
                g.drawImage(im.getImage("gridYellow"), 0, 105, null);
                g.drawImage(im.getImage("gridGreen"), 105, 105, null);
                g.drawImage(im.getImage("gridBrown"), 210, 105, null);
                break;
            default:
                break;
        }
        x = (x + 1) % 5;
    }

}
