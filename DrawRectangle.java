public class DrawRectangle {
  private DrawLineBresenham dl;

  public DrawRectangle(int windowWidth, int windowHeight) {
    dl = new DrawLineBresenham(windowWidth, windowHeight);
  }

  public void drawRectangle(int x1, int y1, int x2, int y2) {
    dl.drawLine(x1, y1, x2, y1);
    dl.drawLine(x2, y1, x2, y2);
    dl.drawLine(x1, y2, x2, y2);
    dl.drawLine(x1, y1, x1, y2);
  }

  public static void main(String[] args) {
    DrawRectangle dr = new DrawRectangle(500, 500);
    dr.drawRectangle(350, 350, 430, 400);
  }
}
