import java.awt.*;

public class DrawLinePM {
  private Pixel pixel;

  public DrawLinePM(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    int dx = (x2 - x1);
    int dy = (y2 - y1);
    int err = dx - dy;
    int e2;

    while (true) {
      pixel.putPixel(x1, y1, Color.WHITE);

      if (x1 == x2 && y1 == y2) {
        break;
      }

      e2 = 2 * err;
      if (e2 > -dy) {
        err -= dy;
        x1 += 1;
      }
      if (e2 < dx) {
        err += dx;
        y1 += 1;
      }
    }
  }

  public static void main(String[] args) {
    DrawLinePM dl = new DrawLinePM(300, 300);
    dl.drawLine(50, 75, 90, 260);
  }
}
