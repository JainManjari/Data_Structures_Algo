package Questions;

import java.util.*;
public class CountAnagrams {
	
	public static boolean countZeros(int count[])
    {
        for(int i=0;i<count.length;i++)
        {
            if(count[i]!=0)
            {
                return false;
            }
        }
        return true;
    }

    public static int search(String pat, String txt) {
        // code here
        int N=txt.length();
        int n=pat.length();
        
        int count[]=new int[26];
        
        
        //Removing the freq word of pattern in the pattern length window
        for(int i=0;i<n;i++)
        {
            count[pat.charAt(i)-'a']--;
        }
        //Adding the freq word of txt wrt pattern length window
        for(int i=0;i<n;i++)
        {
            count[txt.charAt(i)-'a']++;
        }
        
        int res=0;
        
        //Checking if the array mounts to zero, if zero, we found our first match
        if(countZeros(count))
        {
            res++;
        }
        
        for(int i=n;i<N;i++)
        {
        	//adding the next character of txt in our window
            count[txt.charAt(i)-'a']++;
            
            //removing the first charater from the first window
            count[txt.charAt(i-n)-'a']--;
            if(countZeros(count))
            {
                res++;
            }
        }
        return res;
   }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * txt = forxxorfxdofr
			pat = for
			Output: 3 => for,orf,ofr
			
			txt = aabaabaa
			pat = aaba
			Output: 4

		 */

	}

}
