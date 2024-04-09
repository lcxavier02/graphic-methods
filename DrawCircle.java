import java.awt.*;

public class DrawCircle {
  private Pixel pixel;

  public DrawCircle(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawCircle(int centerX, int centerY, int radius) {
    int minX = centerX - radius;
    int maxX = centerX + radius;

    for (int x = minX; x <= maxX; x++) {
      int y = centerY + (int) Math.sqrt((Math.pow(radius, 2) - (Math.pow((x - centerX), 2))));
      pixel.putPixel(x, y, Color.WHITE);

      y = centerY - (int) Math.sqrt((Math.pow(radius, 2) - (Math.pow((x - centerX), 2))));
      pixel.putPixel(x, y, Color.WHITE);
    }
  }

  public static void main(String[] args) {
    DrawCircle drawCircle = new DrawCircle(300, 300);
    drawCircle.drawCircle(150, 150, 100);
  }
}
