 /**
Pacman   
Evan Pouliot   
V1.0   
*/

public class Ghost extends MoveObject
{
     int randomdir,move;
     boolean caneat;
     Pacman pac;
    public Ghost(int xx, int yy, GameBorder gbb, double speed)
    {
      super(xx,yy,gbb,speed);
      caneat = false;
    }
    
    public void setEat(boolean can)
    {
      caneat = can;
    }
    
    public boolean getEat()
    {
      return caneat;
    }
    
    public void increaseSpeed()
    {
      speed = speed + 0.2;
    }
    
    public void sendMove(int moove, Pacman pacc)
    {
      pac = pacc;
      move = moove;
    }
    
    public void moveGhost()
    {
      
      /** stops from going out of bounds */
      if (x < gb.getXstart())
      {
        x = gb.getXstart(); 
        if (move == 1){randomDir();}
        if (move == 2){chaseDir();}
        if (move == 3){runDir();}
      }
      if (y < gb.getYstart())
      {
        y = gb.getYstart(); 
        if (move == 1){randomDir();}
        if (move == 2){chaseDir();}
        if (move == 3){runDir();}
      }
      if (x > gb.getXstart() + gb.getXlength() - 30)
      {
        x = gb.getXstart() + gb.getXlength()- 30; 
        if (move == 1){randomDir();}
        if (move == 2){chaseDir();}
        if (move == 3){runDir();}
      }
      if (y > gb.getYstart() + gb.getYlength() - 30)
      {
        y = gb.getYstart() + gb.getYlength() - 30; 
        if (move == 1){randomDir();}
        if (move == 2){chaseDir();}
        if (move == 3){runDir();}
      }
      
      /** only turns at certain points */
      if ((getX() == 0 || getX() == 269 || getX() == 270 || getX() == 539 || getX() == 540 || getX() == 740) && (getY() == 0 || getY() == 269 || getY() == 270 || getY() == 539 || getY() == 540 || getY() == 660))
      {
          int rn = (int)(Math.random()*4+1);
        if (move == 1){randomDir();}
        if (move == 2)
        {
          if(rn < 3)chaseDir();
          else randomDir();
        }
        if (move == 3)
        {
          if(rn < 3)runDir();
          else randomDir();
        }
      }
      changeDir(dd);
    }
    /** directional algorithims */
    public void randomDir()
    {
      randomdir = (int)(Math.random()  * 4 + 1);
      if (randomdir == 1)
      {
        dd = "right";
      }
      if (randomdir == 2)
      {
        dd = "left";
      }
      if (randomdir == 3)
      {
        dd = "down";
      }
      if (randomdir == 4)
      {
        dd = "up";
      }
    }
    
    public void chaseDir()
    {
      randomdir = (int)(Math.random()  * 2 + 1);
      if (randomdir == 1)
      {
        if (x < pac.getX())
        {
          dd = "right";
        }
        else
        {
          dd = "left";
        }
      }
      if (randomdir == 2)
      {
        if (y < pac.getY())
        {
          dd = "down";
        }
        else
        {
          dd = "up";
        }
      }
    }
    
    public void runDir()
    {
      randomdir = (int)(Math.random()  * 2 + 1);
      if (randomdir == 1)
      {
        if (x < pac.getX())
        {
          dd = "left";
        }
        else
        {
          dd = "right";
        }
      }
      if (randomdir == 2)
      {
        if (y < pac.getY())
        {
          dd = "up";
        }
        else
        {
          dd = "down";
        }
      }
    }
}
