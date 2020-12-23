import java.util.*;
public class String1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s=in.next();
		String s2=r(s);
		if(s.equals(s2))
		{
			System.out.println("yes");
		}
		else
		{
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			String s1=r(s.substring(0,i)+s.substring(i+1));
			if(s1.equals(s.substring(0,i)+s.substring(i+1)))
			{
				count=1;
				System.out.println("yes");
				break;
			}
		}
		if(count==0)
		{
			System.out.println("No");
		}
		}

	}
	
	public static String r(String a)
	{
		if(a.length()==1)
		{
			return a;
		}
		
		StringBuilder b=new StringBuilder(a);
		b.reverse();
		//return b;
		return b.toString();
	}

}
