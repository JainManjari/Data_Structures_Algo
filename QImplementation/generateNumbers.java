package QImplementation;
import java.util.*;

public class generateNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Queue<String> q=new LinkedList<String>();
		q.add("5");
		q.add("6");
		int n=in.nextInt();
		for(int i=0;i<n;i++)
		{
			String s=q.remove();
			System.out.println(s);
			q.add(s+"5");
			q.add(s+"6");
		}
	}

}
