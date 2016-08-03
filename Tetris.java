import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.Color;

public class Tetris implements World{
  static int ROWS = 20;
  static int COLUMNS = 10;
  public Tetris(){
  }
  public Tetris(String tetris){
    super();
    this.current = new LIN(100,0,0);
    this.ground = new Ground();

  }
  
  Tetromino current;
  Ground ground;
  BigBang bb;
  
  public boolean hasEnded(){ 
    return this.ground.endCheck();
  }
  

  public void draw(Graphics g){
    this.current.draw(g);
    this.ground.draw(g);
  }
 
    
  public void update(){
    Tetromino future = this.current.moveDown();
    if(this.ground.overlaps(future)){
      for (Block b : this.current){
        this.ground.add(b); 
      }
      this.ground.eliminaterow();
      if(this.hasEnded()){
      }else{
      this.current = Tetromino.random();
      }
    }
      else {
        this.current = future;
      }
  }
  
  

  public void keyPressed(String what){
    if(what.equals("left")){
      Tetromino future = this.current.moveLeft();
      int a = 0;
      for (Block b : future){
        if(b.x < 0){
          a = a+1;
        }
      }
      if(a == 0){
        if(this.ground.overlaps(future)){
      }
      else{
        this.current = future;
      }
      } 
    }
    
    else if(what.equals("right")){
      Tetromino future = this.current.moveRight();
      int a = 0;
      for (Block b : future){
        if(b.x> 160){
          a = a+1;
        }
      }
      if(a == 0){
        if(this.ground.overlaps(future)){
      }
      else{
        this.current = future;
      }
      }  
    }
    
    else if(what.equals("down")){
      Tetromino future = this.current.moveDown();
      
      if(this.ground.overlaps(future)){
      }
      else{
        this.current = future;
      }
    }
    else if(what.equals("rotate")){
      Tetromino future = this.current.rotate();
      int a = 0;
      for(Block b : future)
        if(b.x < 0 || b.x > 160){
        a = a + 1;
      }
      if(a == 0){
      if(this.ground.overlaps(future)){
      }
      else{
        this.current = future;
      }
      }
    }
    else if(what.equals("drop")){
      this.jumpDown();  
    }
    else{
    }
  }
  
  public void jumpDown(){
    Tetromino future = this.current;
    while(!(this.ground.overlaps(future))){
        future = future.moveDown();
    }
    this.current = future.moveUp();;
  } 
  public static void main(String[] args){
    JFrame a = new JFrame();
    a.setSize(Tetris.COLUMNS*20,Tetris.ROWS*20);
    BigBang b = new BigBang(new Tetris("tetris"));
    Tetris x = new Tetris();
    a.addKeyListener(b);
    a.getContentPane().add(b);
    a.getContentPane().setBackground( new Color(175,100,255 ));
    b.start();
    a.setVisible(true);  
  }
}