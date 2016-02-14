import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;


public class Mouse implements MouseListener, MouseMotionListener
//MouseListener is an interface
//requires five methods
{
	BoardComponent boardc;
	int x, y, x2, y2;
	int counter = 0;
	boolean turn, t, color;
	
	//make ai
	public void getNum()
	{
			//generate random positions
			Random randomGenerator = new Random();
			x = randomGenerator.nextInt(8);
			y = randomGenerator.nextInt(8);
			x2 = randomGenerator.nextInt(8);
			y2 = randomGenerator.nextInt(8);
			
			//check if can move
			if (Chess.board[x][y] == null)
			{
				t = false;
			}
			else
			{
				t = Chess.board[x][y].canMove(x, y, x2, y2);
				color = Chess.board[x][y].side;
			}
			
			//while it is blacks turn
			while (counter%2 != 0)
			{
				//valid black move
				if (t == true && color == false)
				{
					if (x > -1 && y > -1 && x < 8 && y < 8)
					{
						if (Chess.board[x2][y2] != Chess.board[x][y])
						{
							if (Chess.board[x2][y2] != null)
							{
								if (Chess.board[x2][y2].side != Chess.board[x][y].side)
								{
									Chess.board[x2][y2] = Chess.board[x][y];
									Chess.board[x][y] = null; 
									counter += 1;
								}
							}
							else
							{
								Chess.board[x2][y2] = Chess.board[x][y];
								Chess.board[x][y] = null; 
								counter += 1;
							}
						}
					}
					x = randomGenerator.nextInt(8);
					y = randomGenerator.nextInt(8);
					x2 = randomGenerator.nextInt(8);
					y2 = randomGenerator.nextInt(8);
					
					if (Chess.board[x][y] == null)
					{
						t = false;
					}
					else
					{
						t = Chess.board[x][y].canMove(x, y, x2, y2);
						color = Chess.board[x][y].side;
					}
				}	
				else 
				{
				x = randomGenerator.nextInt(8);
				y = randomGenerator.nextInt(8);
				x2 = randomGenerator.nextInt(8);
				y2 = randomGenerator.nextInt(8);
				
				if (Chess.board[x][y] == null)
				{
					t = false;
				}
				else
				{
					t = Chess.board[x][y].canMove(x, y, x2, y2);
					color = Chess.board[x][y].side;
				}
				}
			}
			boardc.repaint();
	}
	
	public Mouse() //constructor Mouse
	{
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		x = (arg0.getX()/44);
		y = (arg0.getY()-25)/44;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		x2 = arg0.getX()/44;
		y2 = (arg0.getY()-25)/44;
		
		//only proceed if original space not null
		if (Chess.board[x][y] == null)
		{
			t = false;
		}
		else
		{
			color = Chess.board[x][y].side;
			t = Chess.board[x][y].canMove(x, y, x2, y2);
			
		}
		
		//test whose turn it is
		if (counter%2 == 0)
		{
			turn = true;
		}
		else
		{
			turn = false;
		}
		
		//white's turn
		if (t == true && color == true)
		{
			//make sure on board
			if (x > -1 && y > -1 && x < 8 && y < 8)
			{
				if (Chess.board[x2][y2] != Chess.board[x][y])
				{
					//if not null, make sure not taking own piece
					if (Chess.board[x2][y2] != null)
					{
						if (Chess.board[x2][y2].side != Chess.board[x][y].side)
						{
							Chess.board[x2][y2] = Chess.board[x][y];
							Chess.board[x][y] = null; 
							counter += 1;
							boardc.repaint();
							//ai turn
							getNum();
						}
					}
					else
					//if piece empty, then just move it
					{
						Chess.board[x2][y2] = Chess.board[x][y];
						Chess.board[x][y] = null; 
						counter += 1;
						boardc.repaint();
						//ai turn
						getNum();
					}
				}
			}
		}	
		boardc.repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

}
