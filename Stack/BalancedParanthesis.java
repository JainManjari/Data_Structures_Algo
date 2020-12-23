package Stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
	
	public static boolean isBalanced(String s)
	{
		
		Stack<Character> s1=new Stack<>();
		char a[]=s.toCharArray();
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			if(a[i]=='(' || a[i]=='{' || a[i]=='[')
			{
				s1.push(a[i]);
			}
			else if(a[i]==')' || a[i]=='}' || a[i]==']')
			{
				if(s1.isEmpty())
				{
					return false;
				}
				else
				{
					char c=s1.peek();
					char c1=map(c);
					if(c1==a[i])
					{
						s1.pop();
					}
				}
			}
		}
		if(s1.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public static char map(char c)
	{
		if(c=='(')
		{
			return ')';
		}
		if(c=='{')
		{
			return '}';
		}
		return ']';
	}
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		String s=in.next();
		System.out.println(isBalanced(s));
	}

}
