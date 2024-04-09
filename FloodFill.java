import java.awt.*;
import java.util.*;

public class FloodFill {
  private Pixel pixel;
  private int windowWidth;
  private int windowHeight;

  public FloodFill(int windowWidth, int windowHeight) {
    if (pixel == null) {
      pixel = new Pixel(windowWidth, windowHeight);
    }
    this.windowWidth = windowWidth;
    this.windowHeight = windowHeight;
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
    int minX = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxY = Integer.MIN_VALUE;

    // Encontrar los límites del polígono
    for (Point vertex : vertices) {
      if (vertex.x < minX)
        minX = vertex.x;
      if (vertex.x > maxX)
        maxX = vertex.x;
      if (vertex.y < minY)
        minY = vertex.y;
      if (vertex.y > maxY)
        maxY = vertex.y;
    }

    // Crear una pila para almacenar los puntos a visitar
    Stack<Point> stack = new Stack<>();
    // Añadir el punto de inicio (cualquier punto dentro del polígono)
    Point start = new Point((minX + maxX) / 2, (minY + maxY) / 2); // Punto medio como punto de inicio
    stack.push(start);

    // Array para verificar si un píxel ya ha sido llenado
    boolean[][] filled = new boolean[this.windowWidth][this.windowHeight];

    // Mientras la pila no esté vacía
    while (!stack.isEmpty()) {
      // Sacar el punto actual de la pila
      Point current = stack.pop();
      int x = current.x;
      int y = current.y;

      // Verificar si el punto está dentro del polígono y si no ha sido llenado ya
      if (x >= minX && x <= maxX && y >= minY && y <= maxY && !filled[x][y]) {
        // Llenar el píxel
        pixel.putPixel(x, y, Color.BLUE);
        filled[x][y] = true;

        // Agregar los vecinos a la pila si no han sido llenados aún
        stack.push(new Point(x + 1, y)); // Derecha
        stack.push(new Point(x - 1, y)); // Izquierda
        stack.push(new Point(x, y + 1)); // Abajo
        stack.push(new Point(x, y - 1)); // Arriba
      }
    }
  }

  public static void main(String[] args) {
    FloodFill ff = new FloodFill(400, 400);
    Point[] vertices = { new Point(100, 50), new Point(200, 100), new Point(300, 150),
        new Point(200, 200), new Point(100, 150) };
    ff.drawPolygon(vertices);
  }
}
