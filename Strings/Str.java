package Strings;
import java.util.*;

public class Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="geeks";
		String s2="geeks";
		String s3=new String("geeks");
		
//		System.out.println(s1==s2);
//		System.out.println(s1==s3);
//		
//		System.out.println(s1.matches(s2));
//		System.out.println(s1.matches(s3));
//		
//		System.out.println(s1.equals(s2));
//		System.out.println(s1.equals(s3));
//		
//		String s4="geeksforgeeks";
//		System.out.println(s4.contains("kgees"));
//		System.out.println();
//		StringBuilder rev= new StringBuilder("manjari");
//		rev.reverse();
//		System.out.println("manjari".equals(rev.toString()));
//		
//		int letter='a'-'a';
//		System.out.println("some "+letter);
//		
//		System.out.println("left most repeating "+leftMostRepeating("abbcd"));
		
		System.out.println("MAX Longest Distinct Substr: "+longestDistinctSubstr("geeksforgeeks"));
	}
	
	public static int leftMostRepeating(String s)
	{
		int characters[]=new int[256];
		for(int i=0;i<s.length();i++)
		{
//			String c=String.valueOf(s.charAt(i));
//			String s1=s.substring(i+1);
//			if(s1.contains(c))
//			{
//				return i;
//			}
			
			characters[s.charAt(i)]++;
		}
		
//		for(int i=0;i<s.length();i++)
//		{
//			if(characters[s.charAt(i)]>1)
//			{
//				return i;
//			}
//		}
		
		boolean visited[]=new boolean[256];
		int res=-1;
		
		for(int i=s.length()-1;i>=0;i--)
		{
			if(!visited[s.charAt(i)])
			{
				visited[s.charAt(i)]=true;
			}
			else
			{
				res=i;
			}
		}
		
		return res;
	}

	public static int longestDistinctSubstr(String s)
	{
		//int len=1;
		int n=s.length();
		
		if(n==0 || n==1)
		{
			return n;
		}
		
		int i=0; //starting index
		int max=1;
		int prev[]=new int[256];
		Arrays.fill(prev, -1);
		
		for(int j=0;j<n;j++)
		{
			i=Math.max(i, prev[s.charAt(j)]+1);
			int len=j-i+1;
			max=Math.max(max, len);
			prev[s.charAt(j)]=j;
		}
		
		return max;
	}
}
