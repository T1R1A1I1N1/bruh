
public class MoveObject extends BaseObject
{
    double speed,xdir,ydir;
    GameBorder gb;
    String dd;
    public MoveObject(int xx,int yy,GameBorder gbb, double speeed)
    {
      super(xx,yy);
      gb = gbb;
      speed = speeed;
      dd = "null";
    }
    
    public void moveObject()
    {
        /** stops from going out of bounds */
      if (x < gb.getXstart() && (int)y != 270 && (int)y != 540)
      {
        x = gb.getXstart();
        xdir = 0;
      }
      if (y < gb.getYstart())
      {
        y = gb.getYstart(); 
        ydir = 0;
      }
      if (x > gb.getXstart() + gb.getXlength() - 30 && (int)y != 270 && (int)y != 540)
      {
        x = gb.getXstart() + gb.getXlength() - 30; 
        xdir = 0;
      }
      if (y > gb.getYstart() + gb.getYlength() - 30)
      {
        y = gb.getYstart() + gb.getYlength() - 30; 
        ydir = 0;
      }
      if (x < gb.getXstart()-20)
      {
        x = gb.getXstart() + gb.getXlength() - 30;
      }
      if (x > gb.getXstart() + gb.getXlength())
      {
        x = gb.getXstart();
      }
      
    }
    
    public void changeDir(String DD)
    {
      int xint,yint;
      /** can only turn at certain points */
      xint = (int)x;
      yint = (int)y;
      dd = DD;
      if ((xint == 0 || xint == 269 || xint == 270 || xint == 539 || xint == 540 || xint == 740) && (yint == 0 || yint == 269 || yint == 270 || yint == 539 || yint == 540 || yint == 660))
      {
        if(DD.equals("up"))
        {
          xdir = 0;
          ydir = -1*speed;
        }
        if(DD.equals("down"))
        {
          xdir = 0;
          ydir = speed;
        }
        if(DD.equals("left"))
        {
          xdir = -1*speed;
          ydir = 0;
        }
        if(DD.equals("right"))
        {
          xdir = speed;
          ydir = 0;
        }
        if ((getX() == 269 || getX() ==539) && !(DD.equals("left")))
        {
          x = x + 1;
        }
        if ((getY() == 269 || getY() ==539) && !(DD.equals("up")))
        {
          y = y + 1;
        }
      }
    }
}