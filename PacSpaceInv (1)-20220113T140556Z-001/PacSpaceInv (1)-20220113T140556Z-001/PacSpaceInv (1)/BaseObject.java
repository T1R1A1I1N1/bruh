/**
Pacman   
Evan Pouliot   
V1.0   
*/

public class BaseObject
{
     int x, y;
     boolean destroyed;
     
    public BaseObject(int xx, int yy)
    {
      x = xx;
      y = yy;
      destroyed = false;
    }
    
    public int getX()
    {
        return (int)x;
    }
    
    public int getY()
    {
        return (int)y;
    }
    
    public boolean getDestroyed()
    {
        return destroyed;
    }

    public void destroyObject()
    {
       destroyed = true;
    }
    
    public void fixObject()
    {
      destroyed = false;
    }
    
    public void setX(int xx)
    {
      x = xx;
    }
    
    public void setY(int yy)
    {
      y = yy;
    }
}
