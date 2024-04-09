import java.awt.*;

public class DrawCircleCP {
  private Pixel pixel;

  public DrawCircleCP(int windowWidth, int windowHeight) {
    pixel = new Pixel(windowWidth, windowHeight);
  }

  public void drawCircle(int centerX, int centerY, int radius) {
    for (double t = 0; t <= 2 * Math.PI; t += 0.001) {
      int x = (int) (centerX + (radius * Math.sin(t)));
      int y = (int) (centerY + (radius * Math.cos(t)));
      pixel.putPixel(x, y, Color.WHITE);
    }
  }

  public static void main(String[] args) {
    DrawCircleCP drawCircle = new DrawCircleCP(300, 300);
    drawCircle.drawCircle(150, 150, 100);
  }
}
