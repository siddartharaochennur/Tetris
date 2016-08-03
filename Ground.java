import java.util.*;
import java.awt.*;
public class Ground extends ArrayList<Block>{
  int count = 0;
  Ground(){
  }
  
  public boolean endCheck(){
    for(Block g : this){
      if(g.y < 200)
        
        return true;
    }
      return false;
  }
  
  public boolean overlaps(Tetromino t){
    for(Block g : t)
    if(g.y >= Tetris.ROWS*Block.size-60){//320
      return true;
    }
    for(Block b: this)
    for(Block c: t)
      if(b.overlaps(c))
      return true;
    return false;
  }
  public void draw(Graphics g){
    for(Block b: this)
      b.draw(g);
  }
  public void eliminaterow(){
    boolean switc=true;
    while(switc){
    for( int i = 17;i > 0;i--){
    count =0 ;
    for(Block b : this){
        if(b.y == i*Block.size){//340
          count = count + 1;
        }
    }
    if(count == 9){
      Block.score+=100;
      ArrayList<Block> a = new ArrayList<Block>();
      for(Block c : this){
        if(c.y == i*Block.size){
        //a.add(this.indexOf(c));
          a.add(c);
          
        
      }
      }
      
      a.stream().forEach(o -> this.remove(o));
      for(Block d : this)
        if(d.y<i*Block.size)
        d.y = d.y + Block.size;
      switc = true;
      break;
    }
    
    if (i == 1){
      switc = false;
    }
    }

  }
  }
}
