import java.awt.*;
import java.awt.Color;

public class Block{
  static int size = 20; 
  static int score = 0;
  protected int x,y,w,h;
  private Color color; 
  public Block(int x,int y,Color color){
    this.x =x;
    this.y =y;
    this.color =color;
    this.w=Block.size;
    this.h=Block.size;
  }
  public void draw(Graphics g){
    g.setFont(new Font("default", Font.BOLD, 13));
    g.drawString( "Score : " + Block.score , 10 , 20 );
    //g.drawString(this.x+"",this.x,this.y);
    g.setColor(this.color); 
    g.fillRect(this.x,this.y,this.w,this.h);
    g.setColor(Color.BLACK);
    g.drawRect(this.x,this.y,this.w,this.h);
  }
  public boolean overlaps(Block b){
    return Math.max(this.x,b.x) < Math.min(this.x+Block.size,b.x+Block.size) &&
      Math.max(this.y,b.y) < Math.min(this.y+Block.size,b.y+Block.size);
  }
}
