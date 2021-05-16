package Machine_Code;
import java.util.*;

class Posi
{
	int x;
	int y;
}

class PlayerInfo
{
	String name;
	String sym;
	ArrayList<Posi> p;
}

public class Tic_Tac_Toe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		PlayerInfo p1=new PlayerInfo();
		PlayerInfo p2=new PlayerInfo();
		p1.sym=in.next();
		p1.name=in.next();
		p1.p=new ArrayList<Posi>();
		p2.sym=in.next();
		p2.name=in.next();
		p2.p=new ArrayList<Posi>();
		
		String board[][]=new String[3][3];
		
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
			    board[i][j]="_";
			}
		}
		
		printBoard(board);
		
		boolean gameOver=false;
		int count=0;
		
		while(!gameOver)
		{
			int x=in.nextInt();
			int y=in.nextInt();
			if(x<0 || x>2 || y<0 || y>2 || board[x][y]!="_")
			{
				System.out.println("Invalid move");
			}
			else
			{
				String sym="";
				String name="";
				if(count%2==0)
				{
					board[x][y]=p1.sym;
					sym=p1.sym;
					name=p1.name;
					
				}
				else
				{
					board[x][y]=p2.sym;
					sym=p2.sym;
					name=p2.name;
				}
				printBoard(board);
				if(winner(board, sym, x, y))
				{
					System.out.println(name+" has won!");
					gameOver=true;
				}
				else if(isEmpty(board))
				{
					System.out.println("Game is drawn!");
					gameOver=true;
				}
				
			}
			count++;
		}
		
	
		
	}
	
	public static boolean isEmpty(String board[][])
	{
		int count=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				if(board[i][j]!="_")
				{
					count++;
				}
			}
		}
		if(count==9)
		{
			return true;
		}
		return false;
	}
	
	public static boolean winner(String board[][],String sym,int i,int j)
	{
		
		return winnerCol(board, sym, i) || winnerRow(board, sym, j) || winnerDiag(board, sym, i, j);
	}
	
	public static boolean winnerCol(String board[][],String sym,int i)
	{
		int count=0;
		for(int j=0;j<3;j++)
		{
			if(board[i][j]==sym)
			{
				count++;
			}
		}
		if(count==3)
		{
			return true;
		}
		return false;
	}
	
	public static boolean winnerRow(String board[][],String sym,int j)
	{
		int count=0;
		for(int i=0;i<3;i++)
		{
			if(board[i][j]==sym)
			{
				count++;
			}
		}
		if(count==3)
		{
			return true;
		}
		return false;
	}
	
	public static boolean winnerDiag(String board[][],String sym,int x,int y)
	{
		if((x==0 && y==0) || (x==2 && y==2))
		{
			return winnerDiag1(board, sym);
		}
		else if((x==0 && y==2) || (x==2 && y==0))
		{
			return winnerDiag2(board, sym);
		}
		
		return winnerDiag1(board, sym) || winnerDiag2(board, sym);
	}
	
	public static boolean winnerDiag1(String board[][],String sym) {
		int count=0;
		if(board[0][2]==sym)
		{
			count++;
		}
		if(board[1][1]==sym)
		{
			count++;
		}
		if(board[2][0]==sym)
		{
			count++;
		}
		if(count==3)
		{
			return true;
		}
		return false;
	}
	
	public static boolean winnerDiag2(String board[][],String sym)
	{
		int count=0;
		if(board[0][2]==sym)
		{
			count++;
		}
		if(board[1][1]==sym)
		{
			count++;
		}
		if(board[2][0]==sym)
		{
			count++;
		}
		if(count==3)
		{
			return true;
		}
		return false;
	}
	
	public static void printBoard(String board[][])
	{
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
			    System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
