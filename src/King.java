import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class King extends Piece 
{
	
	//constructor 
	public King(boolean x)
	{
		//import king
		if (x == true)
		{
			pic = new ImageIcon("wking.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("bking.gif");
			side = false;
		}
	}

	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = Math.abs(x - x2);
		int ydiff = Math.abs(y - y2);
		//can only move one space any direction
		if (xdiff == 1 && ydiff == 0 || xdiff ==0 && ydiff == 1 || xdiff == 1 && ydiff == 1)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
}