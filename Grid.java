package Frame;

import java.awt.*;

public class Grid extends Canvas{
    
  private int width, height;
  final private int rows;
  final private int cols;

  Grid(int w, int h, int r, int c) {
    width = w;
    height = h;
    rows = r;
    cols = c;
  }
  
    @Override
    //Paints the grid onto the canvas layer
    public void paint(Graphics g) {

    // draw the rows
    int rowHt = height / (rows);
    for (int i = 0; i < rows; i++)
      g.drawLine(0, i * rowHt, width, i * rowHt);

    // draw the columns
    int rowWid = width / (cols);
    for (int i = 0; i < cols; i++)
      g.drawLine(i * rowWid, 0, i * rowWid, height);
  }
}
