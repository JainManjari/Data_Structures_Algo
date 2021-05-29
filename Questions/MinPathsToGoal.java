package Questions;
import java.util.*;

public class MinPathsToGoal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s="rrlrlr";
		int upperLimit=6;
		int x=1;
		int y=3;
		
		String subseq[]=sub(s);
		int count=0;
		
		HashSet<String> hs=new HashSet<String>();
		
		for(int i=0;i<subseq.length;i++)
		{
			if(!hs.contains(subseq[i]))
			{
				boolean ans=check(subseq[i],x,y,upperLimit);
				if(ans)
				{
					count++;
				}
				System.out.println(subseq[i]+" "+ans+" "+count);
				hs.add(subseq[i]);
			}
		}
		
		Iterator<String> iter=hs.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
		}
	}
	
	
	public static boolean check(String s,int x,int y,int n)
	{
		int initialPosi=x;
		
		for(int i=0;i<s.length();i++)
		{
			if(initialPosi>n || initialPosi<0)
			{
				return false;
			}
			if(s.charAt(i)=='r')
			{
				initialPosi+=1;
			}
			else
			{
				initialPosi-=1;
			}
		}
		
		if(initialPosi==y)
		{
			return true;
		}
		
		return false;
	}
	
	public static String[] sub(String s)
	{
		if(s.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		String smallAns[]=sub(s.substring(1));
		String ans[]=new String[2*smallAns.length];
		
		int k=0;
		for(int i=0;i<smallAns.length;i++)
		{
			ans[k++]=smallAns[i];
		}
		for(int i=0;i<smallAns.length;i++)
		{
			ans[k++]=s.charAt(0)+smallAns[i];
		}
		return ans;
	}
	
	
}
