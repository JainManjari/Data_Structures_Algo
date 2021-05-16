package Questions;
import java.util.*;


public class Str_Matching {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 2
			zyxabc
			fghcxabyzbvf
			htc
			hxtcczht
		 */
		String p="zyxabc";
		String s="fghcxabyzbvf";
		System.out.println(valid(p,s));
	}

	private static boolean eq(int count1[],int count2[])
	{
		for(int i=0;i<count1.length;i++)
		{
			if(count1[i]!=count2[i])
			{
				return false;
			}
		}
		return true;
	}
	
	private static boolean valid(String p, String s) {
		int n=p.length();
		int N=s.length();
		if(n>N)
		{
			return false;
		}
		
		int count1[]=new int[26];
		int count2[]=new int[26];
		for(int i=0;i<n;i++)
		{
			count1[p.charAt(i)-'a']++;
		}
		
		int i=0;
		int k=0;
		while(i<N)
		{
			System.out.println("i outside "+i+" K "+k);
			if(i+k+1<n)
			{
				System.out.println("i "+i);
				count2[s.charAt(i)-'a']++;
				i+=1;
			}
			else 
			{
				System.out.println("eq "+i);
				count2[s.charAt(i)-'a']++;
				
				if(eq(count1,count2))
				{
					return true;
				}
				
				count2[s.charAt(k)-'a']--;
				
				i+=1;
				k+=1;
			}
		}
		
		return false;
	}

}
