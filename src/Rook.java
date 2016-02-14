import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Rook extends Piece 
{
	
	//constructor 
	public Rook(boolean x)
	{
		//import rook
		if (x == true)
		{
			pic = new ImageIcon("wrook.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("brook.gif");
			side = false;
		}
			
	}
	
	//only move straight forward or sideways 
	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = x2 - x;
		int ydiff = y2 - y;
		
		if(Math.abs(ydiff) == 0 || Math.abs(xdiff) == 0)
		{
			int countery = Math.abs(ydiff);
			while (countery > 1)
			{
				//if up
				if (xdiff == 0 && ydiff < 0)
				{
					if (Chess.board[x][y-1] == null)
					{
						y -= 1;
						countery -= 1;
					}	
					else
					{
						return false;
					}	
				}
				//if down
				if (xdiff == 0 && ydiff > 0)
				{
					if (Chess.board[x][y+1] == null)
					{
						y += 1;
						countery -= 1;
					}	
					else
					{
						return false;
					}	
				}
			}	
			int counterx = Math.abs(xdiff);
			while (counterx > 1)
			{
				//if left
				if (ydiff == 0 && xdiff < 0)
				{
					if (Chess.board[x-1][y] == null)
					{
						x -= 1;
						counterx -= 1;
					}	
					else
					{
						return false;
					}	
				}
				//if right
				if (ydiff == 0 && xdiff > 0)
				{
					if (Chess.board[x+1][y] == null)
					{
						x += 1;
						counterx -= 1;
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