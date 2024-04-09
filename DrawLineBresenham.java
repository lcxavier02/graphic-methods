import java.awt.*;

public class DrawLineBresenham {
  private Pixel pixel;

  public DrawLineBresenham(int windowWidth, int windowHeight) {
    if (pixel == null) {
      pixel = new Pixel(windowWidth, windowHeight);
    }
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);

    int xi = (x2 > x1) ? 1 : -1;
    int yi = (y2 > y1) ? 1 : -1;

    int A = 2 * dy;
    int B = 2 * dy - 2 * dx;
    int C = 2 * dx;
    int D = 2 * dx - 2 * dy;

    int x = x1;
    int y = y1;

    int pk;

    pixel.putPixel(x, y, Color.WHITE);

    if (dx > dy) {
      pk = 2 * dy - dx;
      while (x != x2) {
        if (pk > 0) {
          x = x + xi;
          y = y + yi;
          pk = pk + B;
        } else {
          x = x + xi;
          pk = pk + A;
        }
        pixel.putPixel(x, y, Color.WHITE);
      }
    } else {
      pk = 2 * dx - dy;
      while (y != y2) {
        if (pk > 0) {
          x = x + xi;
          y = y + yi;
          pk = pk + D;
        } else {
          y = y + yi;
          pk = pk + C;
        }
        pixel.putPixel(x, y, Color.WHITE);
      }
    }
  }

  public static void main(String[] args) {
    DrawLineBresenham dl = new DrawLineBresenham(300, 300);
    dl.drawLine(150, 40, 140, 120);
  }
}
