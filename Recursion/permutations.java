package Recursion;
import java.util.*;

public class permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="abc";
		String a1[]=ret_per2(a);
		for(int i=0;i<a1.length;i++)
		{
			System.out.println(a1[i]);
		}
		System.out.println();
		print_per(a,"");
	}
	
	
	/*
	 *  abc => 3! (length of the string)
	 *  
	 *
	 *  
	 *  "a","bc"
	 *  finding permutations of "bc"=> "bc" and "cb"
	 *  Appending a=> "abc" and "acb"
	 *  
	 *  "b","ac"
	 *  finding permutations of "ac"=> "ac" and "ca"
	 *  Appending b=> "bac" and "bca"
	 *  
	 *  "c","ab"
	 *  finding permuatations of "ab" => "ab" and "ba"
	 *  Appending c=> "cab" and "cba"
	 * 
	 * Finding substring by (0,i-1)to (i+1,end)  
	 * 
	 */
	
	public static int factorial(int number) {
        int result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }
	
	public static String[] ret_per2(String a)
	{
		if(a.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		String ans[]=new String[factorial(a.length())];
		int k=0;
		for(int i=0;i<a.length();i++)
		{
			char c=a.charAt(i);
			String sub=a.substring(0,i)+a.substring(i+1);
			String small[]=ret_per2(sub);
			for(int j=0;j<small.length;j++)
			{
				ans[k++]=c+small[j];
			}
		}
		return ans;
	}
	
	public static void print_per(String a,String out)
	{
		if(a.length()==0)
		{
			System.out.println(out);
			return;
		}
		
		for(int i=0;i<a.length();i++)
		{
			print_per(a.substring(0,i)+a.substring(i+1),out+a.charAt(i));
		}
		
		
	}
	
	public static String[] ret_per(String a)
	{
		if(a.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		String small[]=ret_per(a.substring(1));
		String ans[]=new String[a.length()*small.length];
		int k=0;
		for(int i=0;i<small.length;i++)
		{
			String curr=small[i];
			for(int j=0;j<=curr.length();j++)
			{
				ans[k]=curr.substring(0,j)+a.charAt(0)+curr.substring(j);
				k++;
			}
		}
		return ans;
		
	}
	
}
