import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Pawn extends Piece 
{
	
	//constructor 
	public Pawn(boolean x)
	{
		//import pawn
		if (x == true)
		{
			pic = new ImageIcon("wpawn.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("bpawn.gif");
			side = false;
		}
			
	}

	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = Math.abs(x - x2);
		int ydiff = y - y2;
		
		//white
		if (side == true)
		{
			//can move twice if first move
			if (y == 6)
			{
				if (xdiff ==0 && (ydiff == 1 || ydiff == 2) && Chess.board[x2][y2] == null)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				if (xdiff ==0 && ydiff == 1 && Chess.board[x2][y2] == null)
				{
					return true;
				}
				//take a piece if diagonal
				else if (Chess.board[x2][y2] != null && xdiff == 1 && ydiff ==1)
				{
					return true;
				}
				else 
				{
					return false;
				}
				
				
			}	
		}
		//black
		else
		{
			//can move twice if first move
			if (y == 1)
			{
				if (xdiff ==0 && (ydiff == -1 || ydiff == -2) && Chess.board[x2][y2] == null)
				{
					return true;
				}
				else 
				{
					return false;
				}
			}
			else
			{
				if (xdiff ==0 && ydiff == -1 && Chess.board[x2][y2] == null)
				{
					return true;
				}
				//take a piece if diagonal
				else if (Chess.board[x2][y2] != null && xdiff == 1 && ydiff ==-1)
				{
					return true;
				}
				else 
				{
					return false;
				}	
			}	
		}
		
	}
	
}
