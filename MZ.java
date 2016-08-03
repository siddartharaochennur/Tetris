import java.awt.*;
import java.util.*;

public class MZ extends Tetromino {
  final static int [][][] shape = 
  {
    {
      { 1, 0, 0 },
      { 1, 1, 0 },
      { 0, 1, 0 }
    },
    {
      { 0, 1, 1 },
      { 1, 1, 0 },
      { 0, 0, 0 }
    },
    {
      { 0, 1, 0 },              
      { 0, 1, 1 },
      { 0, 0, 1 }
    },
    {
      { 0, 0, 0 },             
      { 0, 1, 1 },
      { 1, 1, 0 }
    },
  };
  public Tetromino drop(){
    return new MZ ( this.x, 320,this.direction );
  }
  public Tetromino moveUp() {
    return new MZ( this.x, this.y - Block.size, this.direction );    
  }
  public Tetromino moveDown() {
    return new MZ( this.x, this.y + Block.size, this.direction );    
  }
  public Tetromino moveLeft() {
    return new MZ( this.x - Block.size, this.y, this.direction );    
  }
  public Tetromino moveRight() {
    return new MZ( this.x + Block.size, this.y, this.direction );    
  }
  public Tetromino rotate() {
    int newDirection = ( this.direction + 1 ) % 4;
    return new MZ( this.x, this.y, newDirection );         
  }
  public MZ( int x, int y, int d ) {
    super( x, y, d );
    this.reset();
  }
  public void reset() {
    for( int i = 0; i < shape[direction].length; i++ )
      for( int j = 0; j < shape[direction][i].length; j++ )
      if( shape[direction][i][j] == 1 ) {
      this.add( new Block( this.x + Block.size * j, this.y + Block.size * i, Color.MAGENTA ));
    }
  }
}