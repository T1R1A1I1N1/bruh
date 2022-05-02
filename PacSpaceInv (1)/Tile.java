
public class Tile extends Base
{
    boolean pass, dan;
    int dam;
    public Tile(int x, int y, int xsiz, int ysiz, boolean pass, boolean dan, int dam)
    {
        super(x,y,xsiz,ysiz);
        this.pass = pass;
        this.dan = dan;
        this.dam = dam;
    }

}
