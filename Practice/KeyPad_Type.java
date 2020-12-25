package Practice;

import java.util.*;

public class KeyPad_Type {
	    public static String[] decode(String s)
	    {
		    //System.out.println("func call");
	        if(s.length()==0)
	        {
	            String a[]={""};
	            return a;
	        }
	        String c1[]=decode(s.substring(1));
	        //System.out.println("c1 "+c1.length);
	        String c2[]={};
	        if(s.length()>=2)
	        {
	        	int n=10*(s.charAt(0)-'0')+(s.charAt(1)-'0');
	            if(n>=10 && n<26)
	            {
	                c2=decode(s.substring(2));
	            }
	        }
	        String ans[]=new String[c1.length+c2.length];
	        int k=0;
	        for(int i=0;i<c1.length;i++)
	        {
	            ans[k++]=(char)(s.charAt(0)-'0'+97)+c1[i];
	        }
	        
	        for(int i=0;i<c2.length;i++)
	        {
	            ans[k++]=(char)(s.charAt(0)-'0'+97)+(char)(s.charAt(1)-'0'+97)+c2[i];
	        }
	        
	        return ans;
	    }
	    
		public static void main (String[] args)
		 {
		 //code
		 Scanner in=new Scanner(System.in);
		 int t=in.nextInt();
		 while(t-->0)
		 {
		      int n=in.nextInt();
		      String s=in.next();
		      String s1[]=decode(s);
		      System.out.println(s1.length);
		      
		 }     
		 }
}
