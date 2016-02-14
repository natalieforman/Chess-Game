
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JFrame;

public class Chess 
{
	public static final int WINDOW_WIDTH = 400, WINDOW_HEIGHT = 400;
	static Piece[][] board = new Piece[8][8];
	
	public static void main(String[] args)
	{
		
		//establish window
		JFrame mywindow;
		mywindow = new JFrame("Chess");
		mywindow.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		mywindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Mouse mouse = new Mouse();
		//object just passed to mouse class
		mywindow.addMouseListener(mouse);
		mywindow.addMouseMotionListener(mouse);
		
		//house component
		BoardComponent bc = new BoardComponent();
		bc.setBounds(0, 10, 352, 352);
		mouse.boardc=bc;
		mywindow.add(bc);
		
		//set black pieces
		board[0][0] = new Rook(false);
		board[1][0] = new Knight(false);
		board[2][0] = new Bishop(false);
		board[4][0] = new King(false);
		board[3][0] = new Queen(false);
		board[5][0] = new Bishop(false);
		board[6][0] = new Knight(false);
		board[7][0] = new Rook(false);
		
		board[0][1] = new Pawn(false);
		board[1][1] = new Pawn(false);
		board[2][1] = new Pawn(false);
		board[3][1] = new Pawn(false);
		board[4][1] = new Pawn(false);
		board[5][1] = new Pawn(false);
		board[6][1] = new Pawn(false);
		board[7][1] = new Pawn(false);
		
		//set white pieces
		board[0][7] = new Rook(true);
		board[1][7] = new Knight(true);
		board[2][7] = new Bishop(true);
		board[4][7] = new King(true);
		board[3][7] = new Queen(true);
		board[5][7] = new Bishop(true);
		board[6][7] = new Knight(true);
		board[7][7] = new Rook(true);		
		
		board[0][6] = new Pawn(true);
		board[1][6] = new Pawn(true);
		board[2][6] = new Pawn(true);
		board[3][6] = new Pawn(true);
		board[4][6] = new Pawn(true);
		board[5][6] = new Pawn(true);
		board[6][6] = new Pawn(true);
		board[7][6] = new Pawn(true);
		
		for (int y= 5; y > 1; y -=1)
		{
			for (int x = 0; x < 8; x += 1)
			{
				board[x][y] = null;
			}
			
		}		
			
		//do last
		mywindow.setVisible(true);
	}

}
