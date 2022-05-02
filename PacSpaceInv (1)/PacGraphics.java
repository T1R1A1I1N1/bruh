/**
Pacman   
Evan Pouliot   
V1.0   
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class PacGraphics  extends JPanel
{   
     boolean eendgame;
     ArrayList<pellet> pels,powpel;
     Pacman pac;
     Ghost[] ghs;
     int eatstep,level;
     GameBorder gb;
     
    public PacGraphics(Pacman pacc,Ghost[] ghss, boolean endgame,ArrayList<pellet> pelss,ArrayList<pellet> powpell,GameBorder gbb)               
    {
      
      setBackground(Color.black);
      gb = gbb;
      pels = pelss;
      pac = pacc;
      ghs = ghss;
      eendgame = endgame;
      powpel = powpell;
    }
   
    public void updateLocation(Pacman pacc, int l)
    {
      pac = pacc;
      level = l;
    }
    public void hitGhost(boolean endgame)
    {
        eendgame = endgame;
    }
    public void ghostStuff(Ghost[] g,ArrayList<pellet> p,int estep,ArrayList<pellet> pelss)
    {
      ghs = g;
      powpel = p;
      eatstep = estep;
      pels = pelss;
    }
    
    public void paint (Graphics g)         
    {
        super.paint(g);                     
       
       g.setColor(Color.yellow);
       g.fillOval(pac.getX(),pac.getY(),30,30); 
       g.setColor(Color.red);
       /** draws barriers */
       g.drawRect(gb.getXstart(),gb.getYstart(),gb.getXlength(),gb.getYlength());
       g.drawRect(30,30,240,240);
       g.drawRect(300,30,240,240);
       g.drawRect(30,300,240,240);
       g.drawRect(300,300,240,240);
       g.drawRect(570,30,170,240);
       g.drawRect(570,300,170,240);
       g.drawRect(30,570,240,90);
       g.drawRect(300,570,240,90);
       g.drawRect(570,570,170,90);
       
       /** draws pellets*/
       for (int index = 0; index < pels.size(); index++)
       {
           g.setColor(Color.yellow);  
           g.fillOval(pels.get(index).getX(),pels.get(index).getY(),10,10);
         
       }
       /** draws powerpellets */
       for (int index = 0; index < powpel.size(); index++)
       {
           g.setColor(Color.yellow);  
           g.fillOval(powpel.get(index).getX(),powpel.get(index).getY(),20,20);
         
       }
       /** draws ghosts */
       for (int index = 0; index < ghs.length; index++)
       {
          if (ghs[index].getDestroyed() == false)
          {
            if (ghs[index].getEat() == false)
            {
              g.setColor(Color.red);
              g.fillRect(ghs[index].getX(),ghs[index].getY(),30,30);
            }
            else
            {
              if (eatstep > 500 && eatstep % 50 > 25)
              {
                g.setColor(Color.white);
                g.fillRect(ghs[index].getX(),ghs[index].getY(),30,30);
              }
              else
              {
                g.setColor(Color.blue);
                g.fillRect(ghs[index].getX(),ghs[index].getY(),30,30); 
              }
            }
          }
       }
       g.setColor(Color.white);
       g.setFont(new Font("Arial", Font.BOLD, 20));
       g.drawString("Score:" + pac.getScore(), 10,720);
       g.drawString("level" + level, 200,720);
       if(eendgame == true)
       {
          g.setFont(new Font("Arial", Font.BOLD, 60));
          g.drawString("Game Over",200,300);
        }
       
       for (int index = 0; index < pac.getLives(); index++)
       {
         g.setColor(Color.yellow);
         g.fillOval(500 + index*40,700,20,20);
       }
     }           
}
