import java.awt.*;

public class LineMasquerade {
  private Pixel pixel;

  public LineMasquerade(int windowWidth, int windowHeight) {
    if (pixel == null) {
      pixel = new Pixel(windowWidth, windowHeight);
    }
  }

  public void drawLineWithMask(int x1, int y1, int x2, int y2, String mask) {
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

    int maskIndex = 0;

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
        if (mask.charAt(maskIndex) == '1') {
          pixel.putPixel(x, y, Color.WHITE);
        }
        maskIndex = (maskIndex + 1) % mask.length();
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
        if (mask.charAt(maskIndex) == '1') {
          pixel.putPixel(x, y, Color.WHITE);
        }
        maskIndex = (maskIndex + 1) % mask.length();
      }
    }
  }

  public static void main(String[] args) {
    LineMasquerade lm = new LineMasquerade(300, 300);
    lm.drawLineWithMask(150, 40, 140, 120, "1111100");
  }
}
