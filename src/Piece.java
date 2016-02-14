import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

public abstract class Piece 
{
		
		//take the image imported in subclass
		ImageIcon pic;
		Boolean side;
		
		//so every pieces has it's own movement
		abstract Boolean canMove(int x, int y, int x2, int y2);
		
		//draw the piece in the position assigned
		public void drawPiece(int x, int y, Graphics g)
		{
			g.drawImage(pic.getImage(), 44*x, 44*y, null);
		}
		
		
}
