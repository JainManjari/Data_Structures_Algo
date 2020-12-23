import java.util.*;  // Import the Scanner class

class Main {     
    public static void main(String[] args) {         
        
    	String a="abcddddefg";
    	String b="bcdefg";
    	int i;
    	//int e=0;
    	int t=0;
    	for(i=0;i<a.length();i++)
    	{
    		if(t==b.length())
    		{
    			break;
    		}
    		if(a.charAt(i)==b.charAt(t))
    		{
    			t++;
    		}
    		
    	}
    	int startIndex=i-t;
    	String sub=b.substring(0,t);
    	int len=sub.length();
    	int endIndex=startIndex+len-1;
    	
    	for(i=0;i<sub.length();i++)
    	{
    		System.out.println(sub.charAt(i));
    	}
    	
    	
    }
}

