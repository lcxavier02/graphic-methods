import java.awt.*;

public class DrawLineDDA {
  private Pixel pixel;

  public DrawLineDDA(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    int dx = x2 - x1;
    int dy = y2 - y1;
    int steps = Math.max(Math.abs(dx), Math.abs(dy));

    double xIncremnt = (double) dx / steps;
    double yIncremnt = (double) dy / steps;

    double x = x1;
    double y = y1;

    pixel.putPixel((int) Math.round(x), (int) Math.round(y), Color.WHITE);
    for (int i = 0; i < steps; i++) {
      x += xIncremnt;
      y += yIncremnt;
      pixel.putPixel((int) Math.round(x), (int) Math.round(y), Color.WHITE);
    }
  }

  public static void main(String[] args) {
    DrawLineDDA dl = new DrawLineDDA(300, 300);
    dl.drawLine(50, 75, 90, 260);
  }
}
