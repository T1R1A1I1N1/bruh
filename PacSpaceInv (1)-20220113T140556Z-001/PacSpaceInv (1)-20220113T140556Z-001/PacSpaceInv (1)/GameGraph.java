import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameGraph  extends JPanel
{
    Tile[][] map;
    public GameGraph(Tile[][] map)
    { this.map = map;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g); 
        for(Tile[] h : map){
          for(Tile d : h){
            g.drawRect(d.x,d.y,d.xsiz,d.ysiz);
            }
        }
        
    }
}
