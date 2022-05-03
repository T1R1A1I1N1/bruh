/**
Pacman   
Evan Pouliot   
V1.0   
*/

public class Pacman extends MoveObject
{
     int score,lives;
     boolean destroyed;
    public Pacman(int xx, int yy,GameBorder gbb,double speed)
    {
      super(xx,yy,gbb,speed);
      score = 0;
      lives = 3;
    }
    
    public int getLives()
    {
      return lives;
    }
    
    public void pacDie()
    {
      lives--;
    }
    public int getScore()
    {
       return score;
    }
    
    public void addScore(int add)
    {
      score = score + add;
    }
}
