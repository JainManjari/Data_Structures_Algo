package Recursion;
import java.util.*;


public class keypad {

	public static void main(String[] args) {
		
		String n="354";
		Boolean a =true;
		System.out.println(n.substring(1,3)=="54");
//		String ans[]=keypad(n);
//		for(int i=0;i<ans.length;i++)
//		{
//			System.out.println(ans[i]);
//		}
//		
		print_keypad(n,"");
	}
	
	public static String[] keypad(String n)
	{
		if(n.length()==0)
		{
			String a[]= {""};
			return a;
		}
		String small_ans[]=keypad(n.substring(1));
		String helper[]=map(n.charAt(0));
		String ans[]=new String[small_ans.length*helper.length];
		int k=0;
		for(int i=0;i<helper.length;i++)
		{
			String s=helper[i];
			for(int j=0;j<small_ans.length;j++)
			{
				ans[k++]=s+small_ans[j];
			}
		}
		return ans;
	}
	
	
	public static void print_keypad(String n,String out)
	{
		if(n.length()==0)
		{
			System.out.println(out);
			return;
		}
		String helper[]=map(n.charAt(0));
		for(int i=0;i<helper.length;i++)
		{
			String s=helper[i];
			print_keypad(n.substring(1),out+s);
		}

	}
	
	
	public static String[] map(char n)
	{
		if(n=='2')
		{
			String a[]= {"a","b","c"};
			return a;
		}
		if(n=='3')
		{
			String a[]= {"d","e","f"};
			return a;
		}
		if(n=='4')
		{
			String a[]= {"g","h","i"};
			return a;
		}
		if(n=='5')
		{
			String a[]= {"j","k","l"};
			return a;
		}
		if(n=='6')
		{
			String a[]= {"m","n","o"};
			return a;
		}
		if(n=='7')
		{
			String a[]= {"p","q","r","s"};
			return a;
		}
		if(n=='8')
		{
			String a[]= {"t","u","v"};
			return a;
		}
		String a[]= {"w","x","y","z"};
		return a;
	}

}
