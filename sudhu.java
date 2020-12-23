
import java.util.*;

public class sudhu {

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String s=in.next();
		String c=in.next();
		if(rotation(s, c))
		{
			System.out.println("1");
		}
		else
		{
			System.out.println("-1");
		}
		

	}
	
	public static boolean rotation(String word1, String word2)
	{

		if(word1.equals(word2))
		{
			return true;
		}
		String out="";
		for(int i=1;i<word1.length();i++)
		{
			out=word1.substring(i)+word1.substring(0, i);
			if(out.equals(word2))
			{
				return true;
			}
			out="";
		}
		return false;
	}

}
