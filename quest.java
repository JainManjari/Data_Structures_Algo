import java.util.*;

class BinaryTree
{
	int data;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class quest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 
		 *        1
		 *     2     3
 		 *   4   5   6  7
		 *  
		 *  => 1,2,4 & 1,2,6..
		 * 
		 * 
		 * */
		
		BinaryTree root=new BinaryTree(1);
		root.left=new BinaryTree(2);
		root.right=new BinaryTree(3);
		root.left.left=new BinaryTree(4);
		root.left.right=new BinaryTree(5);
		root.right.left=new BinaryTree(6);
		root.right.right=new BinaryTree(7);
		
		//getLeafsPath(root);
		Stack<Integer> s=new Stack<Integer>();
		s=getStack(root, s);
		
	    while(!s.isEmpty())
	    {
	    	System.out.print(s.pop()+" ");
	    }
	    System.out.println();
	}
	
	
	public static Stack<Integer> getStack(BinaryTree root,Stack<Integer> s)
	{
		if(root==null)
		{
			return s;
		}
		
		
		Stack<Integer> s1=getStack(root.left, s);
		s1=getStack(root.right, s1);
		s1.push(root.data);
		return s1;
	}
	
	public static void getLeafsPath(BinaryTree root)
	{
		int path[]=new int[1000];
//		a.add(root.data);
		getLeafsPathHelper(root,0,path);
		//getLeafsPathHelper(root.right, a);
	}
	
	public static void getLeafsPathHelper(BinaryTree root,int index,int path[])
	{
		if(root==null)
		{
			return;
		}
		
		//ArrayList<ArrayList<Integer>> ans =new ArrayList<ArrayList<Integer>>();
		path[index]=root.data;
		index++;
		
		if(root.left==null && root.right==null)
		{
			//ans.add(root.data);
			for(int i=0;i<index;i++)
			{
				System.out.print(path[i]+" ");
			}
			System.out.println();
			//ans.remove(ans.size()-1);
			
			//return;
		}
		else
		{
			getLeafsPathHelper(root.left,index,path);
			getLeafsPathHelper(root.right,index,path);
		}
		
	
	}
	
	

}
