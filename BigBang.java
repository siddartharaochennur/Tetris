import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;


public class BigBang extends JComponent implements ActionListener, KeyListener{
  World world;
  Timer timer;

  public BigBang(){
  }
  
  public BigBang(World world){
    this.world = world;
    this.timer = new Timer(500,this);
  }
  public void start(){
    this.timer.start();
  }
  public void stop(){
    //if(this.world.hasEnded()){
      //System.out.println(this.world.hasEnded());
    this.timer.stop();
  //}
  }
  public void actionPerformed(ActionEvent e){
    this.world.update();
    if(this.world.hasEnded())
      this.timer.stop();
    this.repaint();
  }
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){  }
  public void keyPressed(KeyEvent e){
    if(!(this.world.hasEnded())){
    int code = e.getKeyCode();
    if(code == 37)
      this.world.keyPressed("left");
    else if(code == 38)
      this.world.keyPressed("rotate");
    else if(code == 39) // up key does rotate
      this.world.keyPressed("right");
    else if(code == 40)
      this.world.keyPressed("down");
    else if(code == 32) // space bar
      this.world.keyPressed("drop");
    else if(code == 13) // enter
      this.world.keyPressed("up");
    else 
      this.world.keyPressed(""+code);
    this.repaint();
    }
  }

  public void paintComponent(Graphics g){
        this.world.draw(g);
        if(this.world.hasEnded()){
          g.setFont(new Font("default", Font.BOLD, 15));
          g.drawString("GAME OVER " ,20,100);
          g.drawString("YOUR SCORE " +Block.score ,20,130);
        }
  }
 
}