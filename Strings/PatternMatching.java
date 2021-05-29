package Strings;
import java.util.*;

public class PatternMatching {
	
	public static void main(String args[])
	{
		
		//naiveMy("ABABAB", "ABC");
		
		//naiveDistinctPattern("ABCDABCDAA","ABCD");
		
//		int lps[]=lpsArray("ababa");
//		
//		for(int i=0;i<lps.length;i++)
//		{
//			System.out.print(lps[i]+" ");
//		}
//		
//		System.out.println();
//		KMP("ababcababaab","ababa");
		
		//System.out.println(stringRotate("abab", "abba"));
		
		System.out.println(anagramSearch("geeksforgeeks", "reeks"));
	}
	
	public static void naiveMy(String s,String p)
	{
		for(int i=0;i<=s.length()-p.length();i++)
		{
			int end=i+p.length();
			if(s.substring(i,end).matches(p))
			{
				System.out.print(i+" ");
			}
		}
	}
	
	public static void naiveDistinctPattern(String s,String p)
	{
		for(int i=0;i<=s.length()-p.length();)
		{
			int j=0;
			for(j=0;j<p.length();j++)
			{
				if(s.charAt(i+j)!=p.charAt(j))
				{
					break;
				}
			}
			if(j==p.length())
			{
				System.out.print(i+" ");
			}
			if(j==0)
			{
				i++;
			}
			else
			{
				i=i+j;
			}
			
		}
	}
	
	public static int[] lpsArray(String s)
	{
		int n=s.length();
		int lps[]=new int[n];
		
		lps[0]=0;
		int len=0;
		for(int i=1;i<n;i++)
		{
			while(true)
			{
				if(s.charAt(i)==s.charAt(len))
				{
					lps[i]=len+1;
					len++;
					break;
				}
				else
				{
					if(len==0)
					{
						lps[i]=len;
						break;
					}
					else
					{
						len=lps[len-1];
					}
				}
			}
		}
		
		return lps;
	}
	
	
	public static void KMP(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		
		int lps[]=lpsArray(p);
		
		int i=0;
		int j=0;
		
		while(i<n)
		{
			if(s.charAt(i)==p.charAt(j))
			{
				i++;
				j++;
			}
			
			if(j==m)
			{
				System.out.print(i-j);
				j=lps[j-1];
			}
			else if(i<n && s.charAt(i)!=p.charAt(j))
			{
				if(j==0)
				{
					i++;
				}
				else
				{
					j=lps[j-1];
				}
			}
		}
	}
	
	public static boolean stringRotate(String s,String p)
	{
		if(s.length()!=p.length())
		{
			return false;
		}
		
//		String s1=s.substring(1)+s.charAt(0);
//		
//		while(!s1.matches(s))
//		{
//			if(s1.matches(p))
//			{
//				return true;
//			}
//			
//			s1=s1.substring(1)+s1.charAt(0);
//		}
		
		
//		return false;
		
		return ((s+s).indexOf(p)>=0);
		
	}
	
	public static boolean anagramSearch(String s,String p)
	{
		int n=s.length();
		int m=p.length();
		
		int countT[]=new int[256];
		int countP[]=new int[256];
		
		for(int i=0;i<m;i++)
		{
			countT[s.charAt(i)]++;
			countP[p.charAt(i)]++;
		}
		
		for(int i=m;i<n;i++)
		{
			//System.out.println("str "+i+" "+s.charAt(i));
			if(areSame(countP,countT))
			{
				return true;
			}
			countT[s.charAt(i)]++;
			countT[s.charAt(i-m)]--;
		}
		
		return false;
	}
	
	public static boolean areSame(int p[],int s[])
	{
		for(int i=0;i<256;i++)
		{
			if(p[i]!=s[i])
			{
				return false;
			}
		}
		return true;
	}
}
