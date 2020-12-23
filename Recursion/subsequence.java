package Recursion;
import java.util.*;

public class subsequence {
	
	public static void main(String args[])
	{
		String s="abc";
		String ans[]=re_sub(s);
		for(int i=0;i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
		
		print_sub(s,"");
	}


	private static String[] re_sub(String s) {
		if(s.length()==0)
		{
			String s1[]= {""};
			return s1;
		}
		String small_ans[]=re_sub(s.substring(1));
		String ans[]=new String[small_ans.length*2];
		int k=0;
		for(int i=0;i<small_ans.length;i++)
		{
			ans[k++]=small_ans[i];
		}
		for(int i=0;i<small_ans.length;i++)
		{
			ans[k++]=s.charAt(0)+small_ans[i];
		}
		return ans;
		
		//re_sub(s.substring(1));
	}
	
	private static void print_sub(String s,String out) {
		if(s.length()==0)
		{
			System.out.println(out);
			return;
		}
		print_sub(s.substring(1),out);
		print_sub(s.substring(1),out+s.charAt(0));
		
	}


}
