import java.util.*;
import java.awt.*;
public abstract class Tetromino extends ArrayList<Block>{
  protected int x,y;
  protected int direction;
  public Tetromino(int x,int y,int d){
    this.x = x;
    this.y = y;
    this.direction = d;
  }
   public static Tetromino random() {
    int i = ( int )( Math.random() * 6 );
    if( i == 0) {
      return new T( 100, 0, 1 );   
    } else if( i == 1 ) {
      return new Z( 100, 0 , 1 );        
    } else if( i == 2 ){
      return new L( 100, 0, 1 );        
    } else if( i == 3 ){
      return new ML( 100, 0, 1 );
    } else if( i == 4 ){
      return new S( 100, 0, 1 );
    } else if( i == 5 ){
      return new LIN( 100, 0, 1 );
    } else {
      return new MZ( 100, 0, 1 );
    }  
  }

  public void draw(Graphics g){
    for(Block b: this){
      b.draw(g);
    }
  }

  public abstract Tetromino drop();
  public abstract Tetromino moveLeft();
  public abstract Tetromino moveRight();
  public abstract Tetromino moveDown();
  public abstract Tetromino moveUp();
  public abstract Tetromino rotate();
}