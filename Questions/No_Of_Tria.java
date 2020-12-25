package Questions;

import java.util.*;

public class No_Of_Tria {
	
	public static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        int count=0;
        
        Arrays.sort(arr);
        
        for(int i=n-1;i>=0;i--)
        {
            int l=0;
            int r=i-1;
            
            while(l<r)
            {
                if(arr[l]+arr[r]>arr[i])
                {
                    count+=(r-l);
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }
        
        return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  5
			6 4 9 7 8
			
			Output: 
			10
			
			Explanation: 
			There are 10 triangles
			possible  with the given elements like
			(6,4,9), (6,7,8),..
		 */
	}

}
