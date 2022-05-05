import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class GameGraph  extends JPanel
{
    Tile[][] map;
    Player p;
    Sword s;
    public GameGraph(Tile[][] map, Player p,Sword s)
    { this.map = map;
      this.p = p;
      this.s = s;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g); 
        for(Tile[] h : map){
          for(Tile d : h){
            g.setColor(d.c);
            g.drawRect(d.x,d.y,d.xsiz,d.ysiz);
            }
        }
        g.setColor(Color.green);
        g.fillRect(p.x,p.y,p.xsiz,p.ysiz);
        g.setColor(Color.red);
        g.fillRect(s.x,s.y,s.xsiz,s.ysiz);
    }
}
