import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Bishop extends Piece 
{
	
	//constructor 
	public Bishop(boolean x)
	{
		//import bishop
		if (x == true)
		{
			pic = new ImageIcon("wbishop.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("bbishop.gif");
			side = false;
		}
	}
	
	//need to check if any of the spaces are full
	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = x2 - x;
		int ydiff = y2 - y;
		
		//tried to make it not move when the spaces are full
		int counter = Math.abs(xdiff); 
		if(Math.abs(xdiff) == Math.abs(ydiff))
		{
			while (counter > 1)
			{
				//if diagonally up right
				if (xdiff > 0 && ydiff < 0)
				{
					if (Chess.board[x+1][y-1] == null)
					{
						x += 1;
						y -= 1;
						counter -= 1;
					}	
					else
					{
						return false;
					}	
				}
				//if diagonally up left
				else if (xdiff < 0 && ydiff < 0)
				{
					if (Chess.board[x-1][y-1] == null)
					{
						x -= 1;
						y -= 1;
						counter -= 1;
					}	
					else
					{
						return false;
					}	
				}
				//if diagonally down right
				else if (xdiff > 0 && ydiff > 0)
				{
					if (Chess.board[x+1][y+1] == null)
					{
						x += 1;
						y += 1;
						counter -= 1;
					}	
					else
					{
						return false;
					}	
				}
				//if diagonally down left
				else if (xdiff < 0 && ydiff > 0)
				{
					if (Chess.board[x-1][y+1] == null)
					{
						x -= 1;
						y += 1;
						counter -= 1;
					}	
					else
					{
						return false;
					}	
				}
			}	
		return true;
		}
		else
		{
			return false;	
		}
		
	}
	
	
	
}