import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Tile extends Base
{
    Color c;
    public Tile(int x, int y, Color c)
    {
        super(x,y,40,40);
        this.c = c;
    }

}
