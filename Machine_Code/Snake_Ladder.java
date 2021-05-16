package Machine_Code;
import java.util.*;

class Snake
{
	int head;
	int tail;
}

class Ladder
{
	int head;
	int tail;
}

class Player
{
	String name;
	int position;
}

public class Snake_Ladder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		9
//		11 5
//		33 6
//		49 9
//		88 16
//		41 20
//		56 53
//		98 64
//		93 73
//		95 75
//		8
//		2 37
//		27 46
//		10 32
//		51 68
//		61 79
//		65 84
//		71 91
//		81 100
//		3
//		Gaurav
//		Sagar
//		Harry
		Scanner in=new Scanner(System.in);
		int noOfSnakes=in.nextInt();
		
		Snake s[]=new Snake[noOfSnakes];
		
		for(int i=0;i<noOfSnakes;i++)
		{
			s[i]=new Snake();
			s[i].head=in.nextInt();
			s[i].tail=in.nextInt();
		}
		
		int noOfLadders=in.nextInt();
		
		Ladder l[]=new Ladder[noOfLadders];
		
		for(int i=0;i<noOfLadders;i++)
		{
			l[i]=new Ladder();
			l[i].tail=in.nextInt();
			l[i].head=in.nextInt();
		}
		
		int noOfPlayers=in.nextInt();
		
		Player p[]=new Player[noOfPlayers]; 
		
		for(int i=0;i<noOfPlayers;i++)
		{
			p[i]=new Player();
			p[i].name=in.next();
			p[i].position=0;
		}
		int min=1;
		int max=6;
		
		boolean winnerFound=false;
		
		while(!winner(p))
		{
			for(int i=0;i<noOfPlayers;i++)
			{
				Player r=p[i];
				int noRolled=(int)Math.floor(Math.random()*(max-min+1)+min);
				int posi=r.position+noRolled;
				int posiFinal=finalRoll(posi, s, l);
				if(posiFinal>=100)
				{
					posiFinal=100;
				}
				int currPosi=r.position;
				r.position=posiFinal;
				System.out.println(r.name+" rolled "+noRolled+" moved from "+currPosi+" to "+r.position);
				
			}
		}
		
		
		
		
		
		

	}
	
	public static boolean winner(Player p[])
	{
		for(int i=0;i<p.length;i++)
		{
			if(p[i].position==100)
			{
				System.out.println(p[i].name+" wins the game");
				return true;
			}
		}
		return false;
	}
	
	public static int snakePres(int p,Snake s[])
	{
		for(int i=0;i<s.length;i++)
		{
			if(p==s[i].head)
			{
				return s[i].tail;
			}
		}
		return p;
	}
	
	public static int LadderPres(int p,Ladder l[])
	{
		for(int i=0;i<l.length;i++)
		{
			if(p==l[i].tail)
			{
				return l[i].head;
			}
		}
		return p;
	}
	
	public static int finalRoll(int p,Snake s[],Ladder l[])
	{
		int sp=snakePres(p, s);
		int lp=LadderPres(p, l);
		
		System.out.println("finalroll "+p+" "+" "+sp+" "+lp);
		
		if(sp==p && lp==p)
		{
			return p;
		}
		
		if(sp!=p && lp==p)
		{
			return sp;
		}
		
		return lp;
		
	}

}
