import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Knight extends Piece 
{
	
	//constructor 
	public Knight(boolean x)
	{
		//import knight
		if (x == true)
		{
			pic = new ImageIcon("wknight.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("bknight.gif");
			side = false;
		}
			
	}
	
	//moves 2 and 1 
	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = Math.abs(x - x2);
		int ydiff = Math.abs(y - y2);
		if (xdiff == 2 && ydiff == 1 || xdiff == 1 && ydiff == 2)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	
}