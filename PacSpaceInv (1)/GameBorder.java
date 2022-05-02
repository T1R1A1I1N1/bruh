/**
Pacman   
Evan Pouliot   
V1.0   
*/

public class GameBorder
{
     int xstart, ystart, xlength, ylength;
     
     
    public GameBorder(int xstart, int ystart, int xlength, int ylength)
    {
      this.xstart = xstart;
      this.ystart = ystart;
      this.xlength = xlength;
      this.ylength = ylength;
    }
    
    public int getXstart()
    {
        return xstart;
    }
    
    public int getYstart()
    {
        return ystart;
    }
    
    public int getXlength()
    {
        return xlength;
    }

    public int getYlength()
    {
        return ylength;
    }
    
}
