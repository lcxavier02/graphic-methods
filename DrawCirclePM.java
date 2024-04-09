import java.awt.*;

public class DrawCirclePM {
  private Pixel pixel;

  public DrawCirclePM(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawCircle(int centerX, int centerY, int radius) {
    int x = 0;
    int y = radius;
    int p = 1 - radius;

    drawCirclePoints(centerX, centerY, x, y);

    while (x < y) {
      x++;
      if (p < 0) {
        p += 2 * x + 1;
      } else {
        y--;
        p += 2 * (x - y) + 1;
      }
      drawCirclePoints(centerX, centerY, x, y);
    }
  }

  private void drawCirclePoints(int centerX, int centerY, int x, int y) {
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
    DrawCirclePM drawCircle = new DrawCirclePM(300, 300);
    drawCircle.drawCircle(150, 150, 100);
  }
}
