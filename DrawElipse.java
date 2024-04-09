import java.awt.*;

public class DrawElipse {
  private Pixel pixel;

  public DrawElipse(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawElipse(int centerX, int centerY, int radiusX, int radiusY) {
    int x = 0;
    int y = radiusY;
    double d1 = (radiusY * radiusY) - (radiusX * radiusX * radiusY) + (0.25 * radiusX * radiusX);
    double dx = 2 * radiusY * radiusY * x;
    double dy = 2 * radiusX * radiusX * y;

    while (dx < dy) {
      plotPoints(centerX, centerY, x, y);
      x++;
      dx = dx + 2 * radiusY * radiusY;
      if (d1 < 0) {
        d1 = d1 + dx + radiusY * radiusY;
      } else {
        y--;
        dy = dy - 2 * radiusX * radiusX;
        d1 = d1 + dx - dy + radiusY * radiusY;
      }
    }

    double d2 = ((radiusY * radiusY) * ((x + 0.5) * (x + 0.5))) +
        ((radiusX * radiusX) * ((y - 1) * (y - 1))) -
        (radiusX * radiusX * radiusY * radiusY);

    while (y >= 0) {
      plotPoints(centerX, centerY, x, y);
      y--;
      dy = dy - 2 * radiusX * radiusX;
      if (d2 > 0) {
        d2 = d2 + radiusX * radiusX - dy;
      } else {
        x++;
        dx = dx + 2 * radiusY * radiusY;
        d2 = d2 + dx - dy + radiusX * radiusX;
      }
    }
  }

  private void plotPoints(int centerX, int centerY, int x, int y) {
    pixel.putPixel(centerX + x, centerY + y, Color.WHITE);
    pixel.putPixel(centerX - x, centerY + y, Color.WHITE);
    pixel.putPixel(centerX + x, centerY - y, Color.WHITE);
    pixel.putPixel(centerX - x, centerY - y, Color.WHITE);
  }

  public static void main(String[] args) {
    DrawElipse dw = new DrawElipse(300, 300);
    dw.drawElipse(150, 150, 80, 80);
  }
}