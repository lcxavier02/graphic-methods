import java.awt.*;

public class DrawCircleOL {
  private Pixel pixel;

  public DrawCircleOL(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawCircle(int centerX, int centerY, int radius) {
    int x = 0;
    int y = radius;
    int d = 3 - 2 * radius;

    drawOctant(centerX, centerY, x, y);

    while (x <= y) {
      if (d <= 0) {
        d += 4 * x + 6;
      } else {
        d += 4 * (x - y) + 10;
        y--;
      }
      x++;

      drawOctant(centerX, centerY, x, y);
    }
  }

  private void drawOctant(int centerX, int centerY, int x, int y) {
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
    DrawCircleOL drawCircle = new DrawCircleOL(300, 300);
    drawCircle.drawCircle(150, 150, 100);
  }
}
