import java.util.*;
public class Pattern2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int line=1;
        int row=2*n+1;
        int space=row/2;
        String s="0";
        int n1=n+1;
        while(line<=n1)
        {
        	//System.out.println(line+" "+space+" "+s);
            for(int i=0;i<space;space++)
            {
                System.out.print(" ");
            }
            System.out.println(line);
            if(line==1)
            {
            	//System.out.println(line);
                System.out.print(s);
            }
            else
            {
                int n2=s.charAt(s.length()-1)-'0';
                 n2++;
                 String s1=n2+s+n2;
                 System.out.print(s1);
                 s=s1;
            }
            space--;
            line++;
            System.out.println();
            
        }

	}

}
