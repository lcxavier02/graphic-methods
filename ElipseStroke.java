import java.awt.*;

public class ElipseStroke {
  private Pixel pixel;
  private int lineWidth = 1;

  public ElipseStroke(int windowWidth, int windowHeight) {
    if (pixel == null) {
      pixel = new Pixel(windowWidth, windowHeight);
    }
  }

  public void setLineWidth(int width) {
    lineWidth = width;
  }

  public void drawElipse(int centerX, int centerY, int radiusX, int radiusY, int lineWidth) {
    int x = 0;
    int y = radiusY;
    double d1 = (radiusY * radiusY) - (radiusX * radiusX * radiusY) + (0.25 * radiusX * radiusX);
    double dx = 2 * radiusY * radiusY * x;
    double dy = 2 * radiusX * radiusX * y;

    while (dx < dy) {
      plotPoints(centerX, centerY, x, y, lineWidth);
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
      plotPoints(centerX, centerY, x, y, lineWidth);

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

  private void plotPoints(int centerX, int centerY, int x, int y, int lineWidth) {
    for (int i = 0; i < lineWidth; i++) {
      pixel.putPixel(centerX + x + i, centerY + y, Color.WHITE);
      pixel.putPixel(centerX - x - i, centerY + y, Color.WHITE);
      pixel.putPixel(centerX + x + i, centerY - y, Color.WHITE);
      pixel.putPixel(centerX - x - i, centerY - y, Color.WHITE);

      pixel.putPixel(centerX + x, centerY + y + i, Color.WHITE);
      pixel.putPixel(centerX - x, centerY + y + i, Color.WHITE);
      pixel.putPixel(centerX + x, centerY - y - i, Color.WHITE);
      pixel.putPixel(centerX - x, centerY - y - i, Color.WHITE);
    }
  }

  public static void main(String[] args) {
    ElipseStroke es = new ElipseStroke(300, 300);
    es.drawElipse(150, 150, 80, 80, 4);
  }

}
