import java.awt.*;
import java.util.*;

public class ScanLineFill {
  private Pixel pixel;

  public ScanLineFill(int windowWidth, int windowHeight) {
    if (pixel == null) {
      pixel = new Pixel(windowWidth, windowHeight);
    }
  }

  public void drawPolygon(Point[] vertices) {
    int n = vertices.length;
    for (int i = 0; i < n; i++) {
      Point p1 = vertices[i];
      Point p2 = vertices[(i + 1) % n];
      drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    fillPolygon(vertices);
  }

  private void drawLine(int x1, int y1, int x2, int y2) {
    int dx = Math.abs(x2 - x1);
    int dy = Math.abs(y2 - y1);
    int xi = (x2 > x1) ? 1 : -1;
    int yi = (y2 > y1) ? 1 : -1;

    int x = x1;
    int y = y1;

    if (dx > dy) {
      int pk = 2 * dy - dx;
      while (x != x2) {
        pixel.putPixel(x, y, Color.WHITE);
        if (pk > 0) {
          y = y + yi;
          pk = pk - 2 * dx;
        }
        pk = pk + 2 * dy;
        x = x + xi;
      }
    } else {
      int pk = 2 * dx - dy;
      while (y != y2) {
        pixel.putPixel(x, y, Color.WHITE);
        if (pk > 0) {
          x = x + xi;
          pk = pk - 2 * dy;
        }
        pk = pk + 2 * dx;
        y = y + yi;
      }
    }
  }

  private void fillPolygon(Point[] vertices) {
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;
    for (Point vertex : vertices) {
      if (vertex.y < minY) {
        minY = vertex.y;
      }
      if (vertex.y > maxY) {
        maxY = vertex.y;
      }
    }

    for (int y = minY + 1; y < maxY; y++) {
      ArrayList<Integer> intersectionPoints = new ArrayList<>();
      for (int i = 0; i < vertices.length; i++) {
        Point p1 = vertices[i];
        Point p2 = vertices[(i + 1) % vertices.length];
        if ((p1.y <= y && p2.y > y) || (p2.y <= y && p1.y > y)) {
          double x = (double) (p1.x + (double) (y - p1.y) / (p2.y - p1.y) * (p2.x - p1.x));
          intersectionPoints.add((int) x);
        }
      }

      Collections.sort(intersectionPoints);
      for (int i = 0; i < intersectionPoints.size(); i += 2) {
        int x1 = intersectionPoints.get(i);
        int x2 = intersectionPoints.get(i + 1);
        for (int x = x1; x <= x2; x++) {
          pixel.putPixel(x, y, Color.BLUE);
        }
      }
    }
  }

  public static void main(String[] args) {
    ScanLineFill slf = new ScanLineFill(400, 400);
    Point[] vertices = { new Point(100, 50), new Point(200, 100), new Point(300, 150),
        new Point(200, 200), new Point(100, 150) };
    slf.drawPolygon(vertices);
  }
}