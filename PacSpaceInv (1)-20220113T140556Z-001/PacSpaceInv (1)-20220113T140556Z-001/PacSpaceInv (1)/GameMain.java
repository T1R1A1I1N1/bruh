import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameMain implements ActionListener, KeyListener
{
  JFrame f1;
  JPanel main, sub;
  GameGraph g1;
  JButton b1,b2;
  boolean endgame,start;
  Tile[][] map;
  public GameMain()
  {
    makeMap();
    setVariables();
    setPanel();
    game();
  }
  private void makeMap(){
    map = new Tile[18][18];
    for(int i = 0; i < map.length; i++){
    for(int j = 0; j < map.length; j++){
    map[i][j] = new NormalTile(i*40,j*40);}}
    for(int i = 0; i < map.length; i++){
      map[0][i] = new WallTile(0,i*40);
      map[17][i] = new WallTile(680,i*40);
      map[i][0] = new WallTile(i*40,0);
      map[i][17] = new WallTile(i*40,680);
    }
    }
  private void setPanel()
  {
    f1 = new JFrame("Graphics Example");
      f1.setSize(800,800);
      f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c1 = f1.getContentPane();
    
    b1 =  new JButton("Start");
      b1.addActionListener(this);
        
    b2 =  new JButton("End");
      b2.addActionListener(this);
      
    g1 = new GameGraph(map);
      g1.addKeyListener(this);  
      
    sub = new JPanel(); 
      sub.add(b1);
      sub.add(b2);
    
    
    main = new JPanel();
      main.setLayout(new BorderLayout());          
      main.setSize(600,600);
      main.add(g1,BorderLayout.CENTER);
      main.add(sub,BorderLayout.SOUTH);
    c1.add(main);
    f1.show();
  }
  private void setVariables()
  {
    
  }
  private void game()
  {
    Thread runner = new Thread();
    while(!endgame)
    {    
      try 
      { 
        runner.sleep(5); 
      }
      catch(InterruptedException e) {}  
      if(start)
      {
        
        g1.repaint();
      }
    }
  }
  
  
  public void actionPerformed (ActionEvent event)
  {
    if (event.getSource() == b1)
    {
       start = true; 
       g1.requestFocus();
    }
    if (event.getSource() == b2)
    {
       endgame = true;
    }
   }
  public void keyPressed(KeyEvent evt)
  {
    if(evt.getKeyCode() == 38)
     {
       
     }
    if(evt.getKeyCode() == 40)
    {
       
    }
    if(evt.getKeyCode() == 37)
    {
       
    }
    if(evt.getKeyCode() == 39)
    {
       
    }
    if(evt.getKeyCode() == 32)
    {
       
    }
  }
  
  public void keyReleased(KeyEvent evt)
  {}
  public void keyTyped(KeyEvent evt)
  {}
}
