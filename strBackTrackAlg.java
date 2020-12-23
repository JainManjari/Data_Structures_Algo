import java.util.*;
public class strBackTrackAlg {
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		//_+_-_=10;
		String s=in.nextLine();
		int n=s.length();
		String a[]=new String[n];
		for(int i=0;i<n;i++)
		{
			a[i]=String.valueOf(s.charAt(i));
			//System.out.print(a[i]+" ");
		}
	//	System.out.println();
		int index=0;
		for(int i=n-1;i>=0;i--)
		{
			//System.out.println("!="+" "+a[i]);
			if(a[i].equals("="))
			{
				//System.out.println("="+" "+a[i]);
				index=i;
				break;
			}
		}
		//System.out.println("index"+" "+index);
		String s1="";
		for(int i=index+1;i<n;i++)
		{
			s1+=a[i];
		}
		//System.out.println(s1);
		int target=Integer.parseInt(s1);
		//System.out.println(target);
		ways(a,n,0,target,index,0);
	}
	
	
	
	public static int ways(String a[],int n,int row,int target,int index,int count)
	{		
		for(int i=1;i<=target;i++)
		{
			if(row<index)
			{
				a[row]=String.valueOf(i);
				//System.out.println("row<n-2"+" "+ a[row]+" "+row);
				if(row<index-2)
				{
				//	System.out.println("row<n-4");
					count=ways(a,n,row+2,target,index,count);
				}
				else
				{
					//System.out.print("row>n-4");
					int op1=Integer.parseInt(a[0]);
					for(int j=2;j<index;j=j+2)
					{
						   //System.out.println("Calculating op1"+" "+op1);
						
							if(a[j-1].equals("-"))
							{
								op1-=Integer.parseInt(a[j]);
							}
							else
							{
								op1+=Integer.parseInt(a[j]);
							}
						
						
					}
					if(op1==target)
					{
						count++;
						for(int j=0;j<n;j++)
						{
							System.out.print(a[j]+" ");
						}
						System.out.println("count"+" "+count);
						return count;
					}
					
				}
				//a[row]="_";
			}
			
		}
		return count;
	}

}