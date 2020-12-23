package Practice;

import java.util.Queue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

class HD<T>
{
	T height;
	T diameter;
}

class Check
{
    boolean isBal;
    int height;
}

public class BinaryTree<T> {
	
	private T data;
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	
	public BinaryTree(T data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
	
	public static BinaryTree<Integer> takeInput(Scanner in)
	{
		System.out.println("Enter root data: ");
		int rootData=in.nextInt();
		BinaryTree<Integer> root=null;
		if(rootData!=-1)
		{
			root=new BinaryTree<Integer>(rootData);
			System.out.println("Left child of "+root.data);
			root.left=takeInput(in);
			System.out.println("Right child of "+root.data);
			root.right=takeInput(in);
		}
		return root;
	}
	
	public static BinaryTree<Integer> insertL()
	{
		Scanner in=new Scanner(System.in);
		//System.out.println("Enter root data: ");
		int rootData=in.nextInt();
		if(rootData==-1)
		{
			return null;
		}
		Queue<BinaryTree<Integer>> q=new LinkedList();
		BinaryTree<Integer> root=new BinaryTree<Integer>(rootData);
		q.add(root);
		
		while(!q.isEmpty())
		{
			BinaryTree<Integer> t=q.remove();
			//System.out.println("Enter left child of "+t.data);
			int leftData=in.nextInt();
			if(leftData!=-1)
			{
				BinaryTree<Integer> left=new BinaryTree<Integer>(leftData);
				t.left=left;
				q.add(left);
			}
			//System.out.println("Enter right child of "+t.data);
			int rightData=in.nextInt();
			if(rightData!=-1)
			{
				BinaryTree<Integer> right=new BinaryTree<Integer>(rightData);
				t.right=right;
				q.add(right);
			}
		}
		return root;
		
	}
	
	public static void print(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		String s="Root: "+root.data;
		if(root.left!=null)
		{
			s+=" L: "+root.left.data;
		}
		if(root.right!=null)
		{
			s+=" R: "+root.right.data;
		}
		System.out.println(s);
		print(root.left);
		print(root.right);
	}
	
	public static void printL(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		Queue<BinaryTree<Integer>> q=new LinkedList<>();
		q.add(root);
		q.add(null);
		while(!q.isEmpty())
		{
			while(!q.isEmpty() && q.peek()!=null)
			{
				BinaryTree<Integer> t=q.remove();
				if(t.left!=null)
				{
//					System.out.println("left not null");
					q.add(t.left);
				}
				if(t.right!=null)
				{
					//System.out.println("right not null");
					q.add(t.right);
				}
				System.out.print(t.data+" ");
			}
			q.remove();
			q.add(null);
			if(q.peek()==null)
			{
				q.remove();
			}
			System.out.println();
			
		}
	}
	
	public static int count(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		if(root.left==null && root.right==null)
		{
			return 1;
		}
		return 1+count(root.left)+count(root.right);
	}
	
	public static int height(BinaryTree<Integer> root) {
		//Your code goes here
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return 1;
        }
        return 1+Math.max(height(root.left),height(root.right));
	}

	public static void mirrorBinaryTree(BinaryTree<Integer> root){
		
       if(root==null)
       {
           return;
       }
       mirrorBinaryTree(root.left);
       mirrorBinaryTree(root.right);
        
       BinaryTree<Integer> left=root.left;
       BinaryTree<Integer> right=root.right;
        
       root.left=right;
       root.right=left;
		
	}
	
	public static int Diameter(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int o1=height(root.left)+height(root.right);
		int o2=Diameter(root.left);
		int o3=Diameter(root.right);
		return Math.max(o1, Math.max(o2, o3));
	}
	
	public static HD<Integer> DiameterBetter(BinaryTree<Integer> root)
	{
		if(root==null)
		{
			HD<Integer> h=new HD();
			h.height=0;
			h.diameter=0;
			return h;
		}
		
		HD<Integer> l=DiameterBetter(root.left);
		HD<Integer> r=DiameterBetter(root.right);
		
		
		HD<Integer> h=new HD();
		
		h.height=1+Math.max(l.height, r.height);
		h.diameter=Math.max(l.diameter, Math.max(r.diameter, l.height+r.height));
		
		return h;
	}
	
	public static boolean checkBalanced(BinaryTree<Integer> root) 
	{
		
        Check ch=c(root);
        return ch.isBal;
        
	}
	
	public static Check c(BinaryTree<Integer> root)
    {
         if(root==null)
        {
            Check ch=new Check();
            ch.height=-1;
            ch.isBal=true;
            return ch;
        }
        
        if(root.left==null && root.right==null)
        {
            Check ch=new Check();
            ch.height=1;
            ch.isBal=true;
            return ch;
        }
        Check l=c(root.left);
        Check r=c(root.right);
        
        Check fi=new Check();
        fi.height=1+Math.max(l.height,r.height);
        fi.isBal=l.isBal && r.isBal && (Math.abs(l.height-r.height)<=1);
        
        return fi;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
		Scanner in=new Scanner(System.in);
		BinaryTree<Integer> root= insertL();
		//print(root);
		System.out.println();
		printL(root);
		System.out.println();
		System.out.println("No of nodes: "+count(root));
		System.out.println();
		System.out.println("Diameter: "+Diameter(root));
		System.out.println();
		HD<Integer> h=DiameterBetter(root);
		System.out.println("Diamtere Better: "+h.diameter);
		
		ArrayList<Integer> a =new ArrayList<>();
		System.out.println(a==null);
	}

}
