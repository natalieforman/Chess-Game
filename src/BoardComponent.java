import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;


public class BoardComponent extends JComponent 
{
	//override the drawing method
	public void paintComponent(Graphics g)
	{
		Color dark = new Color(100, 0, 0);
		g.setColor(dark);
		//inteded for drawing
		//bounds relative to j component
		g.fillRect(0, 0, 352, 352);
			
		Color light = new Color(150, 150, 150);
		g.setColor(light);
		
		//draws the squares
		for (int i = 0; i < 8; ++i)
		{
			for (int j = 0; j < 8; ++j)
			{
				if (i%2 == j%2)
				{
					g.fillRect(i*44, j*44, 44, 44);
				}	
			}
		}
		
		//draws the pieces
		for (int x = 0; x < 8; ++x)
		{
			for (int y = 0; y < 8; ++y)
			{
				if (Chess.board[x][y] != null)
				{
					Chess.board[x][y].drawPiece(x, y, g);
				}
			}
		}
		
		
	}
		

}

