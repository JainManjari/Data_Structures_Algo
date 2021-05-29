package Strings;
import java.util.*;


public class LexioRank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String str="MANJARI";
		
		System.out.println("Rank "+lexioRankBetter(str));
		lexioRank(str);
		
	}
	
	
	
	public static int lexioRankBetter(String s)
	{
	      int rank=1;
	      
	      int count[]=new int[256];
	      
	      int n=s.length();
	      
	      int mul=fact(n);
	      
	      for(int i=0;i<n;i++)
	      {
	    	  count[s.charAt(i)]++;
	      }
	      
	      for(int i=1;i<256;i++)
	      {
	    	  count[i]+=count[i-1];
	      }
	      
	      for(int i=0;i<n-1;i++)
	      {
	    	  mul=mul/(n-i);
	    	  rank=rank+mul*(count[s.charAt(i)-1]);
	    	  
	    	  for(int j=s.charAt(i);j<256;j++)
	    	  {
	    		  count[j]--;
	    	  }
	      }
	      
	      return rank;
		
	}
	
	
	
	
	public static void lexioRank(String s)
	{
		String s1=s;
		char s1Array[]=s1.toCharArray();
		Arrays.sort(s1Array);
		
		String firstString="";
		
		for(int i=0;i<s1Array.length;i++)
		{
			firstString+=s1Array[i];
		}
		
		System.out.println("first String : "+firstString);
		System.out.println();
		
		String permutations[]=permut(firstString);
		
		for(int i=0;i<permutations.length;i++)
		{
			//System.out.println(permutations[i]);
			if(permutations[i].matches(s))
			{
				System.out.println("Rank: "+(i+1));
				break;
			}
		}
	}
	
	
	public static String[] permut(String s)
	{
		if(s.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		
		String ans[]=new String[fact(s.length())];
		int k=0;
		
		for(int i=0;i<s.length();i++)
		{
			char c=s.charAt(i);
			String r=s.substring(0,i)+s.substring(i+1);
			String small_ans[]=permut(r);
			for(int j=0;j<small_ans.length;j++)
			{
				ans[k++]=c+small_ans[j];
			}
		}
		
		
		return ans;
		
	}
	
	public static int fact(int n)
	{
		if(n==0 || n==1)
		{
			return n;
		}
		
		return n*fact(n-1);
	}

}
