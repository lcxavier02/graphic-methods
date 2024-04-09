import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pixel extends JFrame {
  private static BufferedImage buffer;
  private Graphics2D graphsPixel;

  public Pixel(int windowWidth, int windowHeight) {
    buffer = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
    graphsPixel = buffer.createGraphics();

    setSize(windowWidth, windowHeight);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void putPixel(int x, int y, Color c) {
    buffer.setRGB(x, y, c.getRGB());
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.drawImage(buffer, 0, 0, this);
  }

  public static void main(String[] args) {
    Pixel p = new Pixel(300, 300);
    p.putPixel(200, 200, Color.WHITE);
  }
}