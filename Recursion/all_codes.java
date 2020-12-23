package Recursion;
import java.util.*;

public class all_codes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="1123";
//		String a1[]=ret_codes(a);
//		for(int i=0;i<a1.length;i++)
//		{
//			System.out.println(a1[i]);
//		}
		print_codes(a,"");
	}
	
	public static String[] ret_codes(String a)
	{
		if(a.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		
		String small_ans1[]=ret_codes(a.substring(1));
		String small_ans2[]=new String[0];
		int two=0;
		if(a.length()>=2)
		{
			two=10*(a.charAt(0)-'0')+(a.charAt(1)-'0');
			if(two>10 && two<=26)
			{
				small_ans2=ret_codes(a.substring(2));
			}
		}
		
		int n=a.charAt(0)-'0';
		char s1=helper(n);
		String ans[]=new String[small_ans1.length+small_ans2.length];
		int k=0;
		for(int i=0;i<small_ans1.length;i++)
		{
			ans[k++]=s1+small_ans1[i];
		}
		for(int i=0;i<small_ans2.length;i++)
		{
			ans[k++]=helper(two)+small_ans2[i];
		}
		return ans;
		
	}
	
	public static void print_codes(String a,String out)
	{
		if(a.length()==0)
		{
			System.out.println(out);
			return;
		}
		
		
		int two=0;
		if(a.length()>=2)
		{
			two=10*(a.charAt(0)-'0')+(a.charAt(1)-'0');
			if(two>10 && two<=26)
			{
				print_codes(a.substring(2),out+helper(two));
			}
		}
		
		int n=a.charAt(0)-'0';
		char s1=helper(n);
		print_codes(a.substring(1),out+s1);
		
	}
	
	public static char helper(int n)
	{
		return (char)(n+96);
	}
}
