
public class StatMethods
{
    
    public StatMethods()
    {
        
    }

    public static boolean collision(Base a, Base b){
      return (a.x<=b.x+b.xsiz && a.x >= b.x-a.xsiz && a.y<=b.y+b.ysiz && a.y >= b.y-a.ysiz);
    }
}
