package Questions;

import java.util.Scanner;
public class Inversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		long a[]= {2,4,1,3,5};
		System.out.print(inversionCount(a,(long)a.length));

	}
	
	static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        return inv(arr,(long)0,N-1);
    }
    
    static long inv(long arr[],long start,long end)
    {
        if(start>=end)
        {
            return 0;
        }
        long mid=(start+end)/2;
        long c1=inv(arr,start,mid);
        long c2=inv(arr,mid+1,end);
        long c3=invm(arr,start,mid,end);
        return c1+c2+c3;
    }
    
    static long invm(long arr[],long start,long mid,long end)
    {
        long ans=0;
        long n1=mid-start+1;
        long n2=end-mid;
        long l[]=new long[(int)n1];
        long r[]=new long[(int)n2];
        
        int k1=0;
        
        for(int i=(int)start;i<=mid;i++)
        {
            l[k1++]=arr[i];
        }
        
        int k2=0;
        
        for(int i=(int)mid+1;i<=end;i++)
        {
            r[k2++]=arr[i];    
        }
        
        int i1=0;
        int i2=0;
        int k3=(int)start;
        
        // [2 4 5] && [3 5] 
        // so if 4>3 then it means all the remaining elements after 4 will also be greater than 3.
        // if 4 occurs at i1 then (mid+1-start-i1) will the no of elements greater than 3
        // "+1" is to get the length from the index;
        //"start+i1" to get the actual index from the array
        
        while(i1<n1 && i2<n2)
        {
            if(l[i1]<=r[i2])
            {
                arr[k3++]=l[i1++];
            }
            else
            {
                ans+=(mid+1)-(start+i1);
                arr[k3++]=r[i2++];
            }
        }
        
        while(i1<n1)
        {
            arr[k3++]=l[i1++];
        }
        
        while(i2<n2)
        {
            arr[k3++]=r[i2++];
        }
        
        return ans;
    }
}
