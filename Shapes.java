import java.awt.Color;

public class Shapes {
  private DrawLineBresenham dl;
  private DrawElipse de;
  private DrawRectangle dr;
  private Pixel pixel;

  public Shapes() {
    dl = new DrawLineBresenham(700, 700);
    de = new DrawElipse(700, 700);
    dr = new DrawRectangle(700, 700);
    pixel = new Pixel(700, 700);
  }

  public void drawLine(int x1, int y1, int x2, int y2) {
    dl.drawLine(x1, y1, x2, y2);
  }

  public void drawElipse(int centerX, int centerY, int radiusX, int radiusY) {
    de.drawElipse(centerX, centerY, radiusX, radiusY);
  }

  public void drawRectangle(int x1, int y1, int x2, int y2) {
    dr.drawRectangle(x1, y1, x2, y2);
  }

  public void putPixel(int x, int y, Color c) {
    pixel.putPixel(x, y, c);
  }

  public static void main(String[] args) {
    Shapes shapes = new Shapes();
    shapes.drawLine(20, 40, 80, 120);
    shapes.drawLine(100, 80, 200, 80);
    shapes.drawLine(280, 40, 220, 120);
    shapes.drawLine(400, 80, 300, 80);

    shapes.drawElipse(150, 300, 15, 15);
    shapes.drawElipse(150, 300, 35, 35);
    shapes.drawElipse(150, 300, 60, 60);
    shapes.drawElipse(150, 300, 90, 90);
    shapes.putPixel(150, 300, Color.WHITE);
    shapes.putPixel(137, 287, Color.WHITE);
    shapes.putPixel(163, 313, Color.WHITE);
    shapes.putPixel(117, 267, Color.WHITE);
    shapes.putPixel(183, 333, Color.WHITE);
    shapes.putPixel(90, 240, Color.WHITE);
    shapes.putPixel(210, 360, Color.WHITE);
    shapes.putPixel(65, 215, Color.WHITE);
    shapes.putPixel(235, 385, Color.WHITE);

    shapes.drawRectangle(300, 300, 480, 400);
    shapes.drawRectangle(455, 375, 325, 325);

    shapes.drawElipse(370, 530, 70, 10);
    shapes.drawElipse(370, 530, 90, 30);
    shapes.drawElipse(370, 530, 110, 50);
    shapes.drawElipse(370, 530, 130, 70);
    shapes.putPixel(300, 520, Color.WHITE);
    shapes.putPixel(285, 505, Color.WHITE);
    shapes.putPixel(265, 485, Color.WHITE);
    shapes.putPixel(250, 470, Color.WHITE);
    shapes.putPixel(440, 540, Color.WHITE);
    shapes.putPixel(455, 555, Color.WHITE);
    shapes.putPixel(476, 576, Color.WHITE);
    shapes.putPixel(490, 590, Color.WHITE);
  }
}
