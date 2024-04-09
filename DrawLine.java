import java.awt.*;

public class DrawLine {
  private Pixel pixel;

  public DrawLine(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    double m = (double) (y2 - y1) / (x2 - x1);
    double b = y1 - (m * x1);

    for (int x = x1; x <= x2; x++) {
      int y = (int) (m * x + b);
      pixel.putPixel(x, (int) y, Color.WHITE);
    }
  }

  public static void main(String[] args) {
    DrawLine dl = new DrawLine(300, 300);
    dl.drawLine(50, 75, 90, 260);
  }
}
