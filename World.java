import java.awt.Graphics;
interface World{
  public void draw(Graphics g);
  public void update();
  public void keyPressed(String what);
  public boolean hasEnded();
}
