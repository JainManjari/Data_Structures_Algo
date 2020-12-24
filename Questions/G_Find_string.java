package Questions;


public class G_Find_string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Graph[]= {"DANDO","NNINJ","AXGJC","INJAA","CODDI"};
		int N=5;
		int M=5;
		
		System.out.println(solve(Graph,N,M));

	}
	
	public static int solve(String[] Graph , int N, int M)
	{
        
        Character a[][]=new Character[N][M];
        boolean visited[][]=new boolean[N][M];
        
        String s="CODINGNINJA";
        
        for(int i=0;i<N;i++)
        {
            String s1=Graph[i];
            for(int j=0;j<M;j++)
            {
                a[i][j]=s1.charAt(j);
            }
        }
        
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(a[i][j]==s.charAt(0))
                {
                    visited=new boolean[N][M];
                    //System.out.println("index "+i+" "+j);
                    boolean ans=sol(a,i,j,s,N,M,visited);
                    //System.out.println("ans "+ans);
                    if(ans)
                    {
                        return 1;
                    }
                }
            }
        }
     
        
        
        return 0;
	}
    
    public static boolean sol(Character a[][],int row,int col,String s,int N,int M,boolean visited[][])
    {
        //System.out.println("sol ind "+row+" "+col+" "+M+" "+N);
        if(row>=N || col>=M || row<0 || col<0)
        {
            return false;
        }
        
        //System.out.println("ele "+a[row][col]+" "+visited[row][col]);
        
        if(a[row][col]==s.charAt(0) && s.length()==1 && !visited[row][col])
        {
            return true;
        }
        
        if(a[row][col]==s.charAt(0) && !visited[row][col])
        {
            visited[row][col]=true;
            boolean ans=false;
            
            ans = ans || (sol(a,row,col+1,s.substring(1),N,M,visited) || sol(a,row+1,col+1,s.substring(1),N,M,visited)
                          || sol(a,row+1,col,s.substring(1),N,M,visited) || sol(a,row+1,col-1,s.substring(1),N,M,visited)
                          || sol(a,row,col-1,s.substring(1),N,M,visited) || sol(a,row-1,col-1,s.substring(1),N,M,visited)
                          || sol(a,row-1,col,s.substring(1),N,M,visited) || sol(a,row-1,col+1,s.substring(1),N,M,visited)
                         );
           return ans;
            
        }
        
        return false;
    }
	


}
