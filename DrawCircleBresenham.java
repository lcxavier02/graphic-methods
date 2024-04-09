import java.awt.*;

public class DrawCircleBresenham {
  private Pixel pixel;

  public DrawCircleBresenham(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawCircle(int centerX, int centerY, int radius) {
    int x = 0;
    int y = radius;
    int d = 3 - (2 * radius);

    drawCirclePoints(centerX, centerY, x, y);

    while (y >= x) {
      x++;
      if (d > 0) {
        y--;
        d = d + 4 * (x - y) + 10;
      } else {
        d = d + 4 * x + 6;
      }
      drawCirclePoints(centerX, centerY, x, y);
    }
  }

  public void drawCirclePoints(int centerX, int centerY, int x, int y) {
    pixel.putPixel(centerX + x, centerY + y, Color.WHITE);
    pixel.putPixel(centerX - x, centerY + y, Color.WHITE);
    pixel.putPixel(centerX + x, centerY - y, Color.WHITE);
    pixel.putPixel(centerX - x, centerY - y, Color.WHITE);
    pixel.putPixel(centerX + y, centerY + x, Color.WHITE);
    pixel.putPixel(centerX - y, centerY + x, Color.WHITE);
    pixel.putPixel(centerX + y, centerY - x, Color.WHITE);
    pixel.putPixel(centerX - y, centerY - x, Color.WHITE);
  }

  public static void main(String[] args) {
    DrawCircleBresenham drawCircle = new DrawCircleBresenham(300, 300);
    drawCircle.drawCircle(150, 150, 100);
  }
}
