import java.util.*;
public class Triplet_Elements_In_Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String s1="rat";
		StringBuilder s2=new StringBuilder("tar");
		s2.reverse();
		String s3=s2.toString();
		//String s2="ooleh";
		//System.out.println(s3.equals(s1));
		int qw=121;
		double a22=Math.pow(qw, 0.5);
		String s4=String.valueOf(a22);
		if(a22==Math.floor(a22))
		{
			System.out.println("true");
		}
		else
		{
			System.out.println("n");
		}
		//System.out.println(s4);
		//String s5[]=s4.split('.');
//		for(int i=0;i<s5.length;i++)
//		{
//			System.out.print(s5[i]+" ");
//		}
		//System.out.println(s5[s5.length-1]);
		//String s6=s5[s5.length-1];
		//System.out.println(s6.length());
		int t=in.nextInt();
		while(t-->0)
		{
			int n=in.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
			{
				a[i]=in.nextInt();
			}
			Arrays.sort(a);
			int count=0;
			for(int i=0;i<n;i++)
			{
				int j=i-1;
				if(j>0)
				{
					int k1=0;
					int k2=j;
					int n1=j+1;
					while(k1<n1 && k2>=0)
					{
						if(k1>=k2)
						{
							break;
						}
						
						if(a[k1]+a[k2]==a[i])
						{
							count++;
							k1++;
							k2--;
						}
						else if(a[k1]+a[2]>a[i])
						{
							k2--;
						}
						else
						{
							k1++;
						}
						
					}
				}
			}
			System.out.println(count);
		}

	}

}
