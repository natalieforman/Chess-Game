import javax.swing.ImageIcon;
import javax.swing.JComponent;
import java.awt.Graphics;

public class Queen extends Piece 
{
	
	//constructor 
	public Queen(boolean x)
	{
		//import queen
		if (x == true)
		{
			pic = new ImageIcon("wqueen.gif");
			side = true;
		}
		else
		{
			pic = new ImageIcon("bqueen.gif");
			side = false;
		}
			
	}
	
	//can't move if pieces in the way
	//moves straight or diagonally
	Boolean canMove(int x, int y, int x2, int y2) 
	{
		int xdiff = x2 - x;
		int ydiff = y2 - y;
		if((Math.abs(xdiff)==Math.abs(ydiff)) || (ydiff == 0 || xdiff == 0))
		{
			if(Math.abs(xdiff) == Math.abs(ydiff))
			{
				int diagonalcounter = Math.abs(xdiff); 
				while (diagonalcounter > 1)
				{
					//if diagonally up right
					if (xdiff > 0 && ydiff < 0)
					{
						if (Chess.board[x+1][y-1] == null)
						{
							x += 1;
							y -= 1;
							diagonalcounter -= 1;
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
							diagonalcounter -= 1;
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
							diagonalcounter -= 1;
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
							diagonalcounter -= 1;
						}	
						else
						{
							return false;
						}	
					}
				}	
			return true;
			}
		else if(Math.abs(ydiff) == 0 || Math.abs(xdiff) == 0)
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
		else 
		{
			return false;
		}
	}
	
}