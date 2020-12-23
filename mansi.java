import java.util.*;
import java.io.*;
public class mansi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		String input1=in.next();
		String input2=in.next();
		int input3=in.nextInt();
		int input4=in.nextInt();
		//int input5=in.nextInt();
		String out="";
		if(input1.length()==input2.length())
		{
			int s1;
			int s2;
			for(int i=0;i<input1.length();i++)
			{
				String s3=String.valueOf(input1.charAt(i)).toLowerCase();
				char c1=s3.charAt(0);
				String s4=String.valueOf(input2.charAt(i)).toLowerCase();
				char c2=s4.charAt(0);
				s1=(int)c1;
				s2=(int)c2;
				//System.out.println(s1+" "+s2);
				if(s1>s2 || s2<s1)
				{
					if(s1>s2)
					{
						out=input2.charAt(input2.length()-1)+input1;
					}
					else
					{
						out=input1.charAt(input1.length()-1)+input2;
					}
					break;
				}
			}
			if(out=="")
			{
				out=input1.charAt(input1.length()-1)+input2;
			}

		}
		else
		{
			if(input1.length()>input2.length())
			{
				out=input2.charAt(input2.length()-1)+input1;
			}
			else
			{
				out=input1.charAt(input1.length()-1)+input2;
			}
		}
		String out2="";
		for(int i=0;i<out.length();i++)
		{
			String c=String.valueOf(out.charAt(i));
			if(c.equals(c.toLowerCase()))
			{
				out2+=c.toUpperCase();
			}
			else
			{
				out2+=c.toLowerCase();
			}
		}
		String pin=String.valueOf(input3);
		out2+=String.valueOf(pin.charAt(input4-1))+String.valueOf(pin.charAt(pin.length()-input4));
		System.out.println(out2);
	//return out2;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//		ArrayList<Integer> a=new ArrayList<>();
//		a.add(input1);
//		a.add(input2);
//		a.add(input3);
//		int maxsum=0;
//		int minsum=0;
//		for(int i=0;i<a.size();i++)
//		{
//			int max=Integer.MIN_VALUE;
//			int min=Integer.MAX_VALUE;
//			int n=a.get(i);
//			while(n!=0)
//			{
//				int c2=n%10;
//				if(max<c2)
//				{
//					max=c2;
//				}
//				if(c2<min)
//				{
//					min=c2;
//				}
//				n=n/10;
//			}
//			maxsum+=max;
//			minsum+=min;
//		}
		//return maxsum-minsum;
		//System.out.println(maxsum-minsum);
//		String a1=String.valueOf(input1);
//		char e=a1.charAt(1);
//		String a2=String.valueOf(input2);
//		char f=a2.charAt(2);
//		int max=0;
//		int n=input3;
//		
//	
//		int d1=Integer.valueOf(String.valueOf(e));
//		int d2=Integer.valueOf(String.valueOf(f));
		
		//return d1*d2*max;
//		int input4=in.nextInt();
//		int input5=in.nextInt();
//		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
//		int min=Integer.MAX_VALUE;
//		int max=Integer.MIN_VALUE;
//		ArrayList<Integer> a=new ArrayList<Integer>();
//		a.add(input1);
//		a.add(input2);
//		a.add(input3);
//		a.add(input4);
//		a.add(input5);
//		int sum=0;
//		for(int i=0;i<a.size();i++)
//		{
//			map.clear();
//			if(String.valueOf(a.get(i)).length()%2==0)
//			{
//			
//				int c=a.get(i);
//				while(c!=0)
//				{
//					int r=c%10;
//					if(map.containsKey(r))
//					{
//						map.put(r, map.get(r)+1);
//					}
//					else
//					{
//						map.put(r, 1);
//					}
//					c=c/10;
//				}
//				
//					HashMap<Integer,Integer> map1=new HashMap<Integer, Integer>();
//					for(Integer a4: map.keySet())
//					{
//						System.out.pri
//						if(!map1.containsKey(map.get(a4)))
//						{
//							map1.put(map.get(a4),1);
//						}
//					}
//					int g=map1.size();
//					g=g/String.valueOf(a.get(i)).length();
//					System.out.println(g+" g "+map1.size()+" "+String.valueOf(a.get(i)).length());
//					if(map1.size()==1 || g==1)
//					{
//						sum+=a.get(i);
//					}
//				
//
//			}
//	}
//		System.out.println(sum);

}
}
