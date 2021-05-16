package Questions;

import java.util.*;

class Info
{
    int data;
    int row;
    int col;
    
    public Info(){};
    public Info(int data,int row,int col)
    {
        this.data=data;
        this.row=row;
        this.col=col;
    }
}

class MyC implements Comparator<Info>
{
    public int compare(Info i1, Info i2)
    {
        if(i1.data<i2.data)
        {
            return 1;
        }
        if(i1.data>i2.data)
        {
            return -1;
        }
        return 0;
    }
}

public class Kth_Ele_Mat {
	
	public static int kthSmallest(int[][]mat,int n,int k)
	{
        //code here.
        MyC my=new MyC();
        PriorityQueue<Info> pq=new PriorityQueue<>(my);
        
        for(int j=0;j<n;j++)
        {
            if(pq.size()<k)
            {
                Info i1=new Info(mat[0][j],0,j);
                pq.add(i1);
            }
            else
            {
                if(mat[0][j]<pq.peek().data)
                {
                    pq.remove();
                    Info i1=new Info(mat[0][j],0,j);
                    pq.add(i1);
                }
            }
        }
        
        Info ele=pq.peek();
        int row=ele.row;
        int col=ele.col;
        
        while(col>-1 && row<n)
        {
            // System.out.println("peek "+pq.peek().data);
            // System.out.println("index "+row+" "+col);
            if(pq.size()<k)
            {
                if(row!=n-1 && col>=0)
                {
                    Info i1=new Info(mat[row+1][col],row+1,col);
                    pq.add(i1);
                    row++;
                }
                else if(col>=1)
                {
                   
                    Info i1=new Info(mat[1][col-1],1,col);
                    pq.add(i1);
                    
                    row=1;
                    col--;
                     
                }
                
            }
            else
            {
                if(row==n-1 && col>=1)
                {
                    if(mat[1][col-1]<pq.peek().data)
                    {
                        pq.remove();
                        Info i1=new Info(mat[1][col-1],1,col-1);
                        pq.add(i1);
                    }
                    row=1;
                    col--;
                    
                }
                else
                {
                    if(row!=n-1 && col>=0)
                    {
                        if(mat[row+1][col]<pq.peek().data)
                        {
                            pq.remove();
                            Info i1=new Info(mat[row+1][col],row+1,col);
                            pq.add(i1);
                        }
                    }
                    row++;
                   
                }
            }
            
        }
     
        
        return pq.peek().data;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][]= {{7,17,27,36,38},
                    {14, 23, 35, 38,43},
                {19, 26, 42, 49,50},
                {23, 33, 48, 52,53},
                {30,40,52,56,64}
                };
        int K = 13;
        System.out.println(kthSmallest(a, a.length, K));

	}

}
