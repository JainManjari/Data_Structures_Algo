package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


class BTNode<T>
{
	T data;
	BTNode<T> left;
	BTNode<T> right;
	int height;
	
	public BTNode(T data)
	{
		this.data=data;
		left=null;
		right=null;
		height=1;
	}
}

class BSTNode
{
	private BTNode<Integer> root;
	
	public boolean hasData(int data)
	{
		return hasData(data,root);
	}
	
	public void insert(int data)
	{
		root=insert(data,root);
	}
	
	public void delete(int data)
	{
		root=delete(data,root);
	}

	private BTNode<Integer> delete(int data, BTNode<Integer> root) {
		if(root==null)
		{
			return null;
		}
		if(root.data>data)
		{
			root.left=delete(data,root.left);
			return root;
		}
		else if(root.data<data)
		{
			root.right=delete(data,root.right);
			return root;
		}
		else
		{
			if(root.left==null && root.right==null)
			{
				return null;
			}
			if(root.left==null)
			{
				return root.right;
			}
			if(root.right==null)
			{
				return root.left;
			}
			BTNode<Integer> temp=root.left;
			while(temp.right!=null)
			{
				temp=temp.right;
			}
			root.data=temp.data;
			root.left=delete(temp.data,root.left);
			return root;
		}
	}

	private BTNode<Integer> insert(int data, BTNode<Integer> root) {
		
		if(root==null)
		{
			BTNode<Integer> node=new BTNode(data);
			return node;
		}
		if(data<root.data)
		{
			root.left=insert(data,root.left);
		}
		else 
		{
			root.right=insert(data,root.right);
		}
		return root;
	}

	private boolean hasData(int d, BTNode<Integer> root2) {
		
		if(root==null)
		{
			return false;
		}
		if(root.data==d)
		{
			return true;
		}
		if(root.data>d)
		{
			return hasData(d,root.left);
		}
		return hasData(d,root.right);
	}
	
	public void display()
	{
		printBTIter(root);
	}
	
	private void printBTIter(BTNode<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		Queue<BTNode<Integer>> q=new LinkedList<>();
		System.out.println("Main root: "+" "+root.data);
		q.add(root);
		while(!q.isEmpty())
		{
			BTNode<Integer> t=q.remove();
			System.out.print("Root: "+t.data+" => ");
			if(t.left!=null)
			{
				System.out.print("L"+t.left.data);
				q.add(t.left);
			}
			else
			{
				System.out.print("L(-1)");
			}
			if(t.right!=null)
			{
				System.out.print(",R"+t.right.data);
				q.add(t.right);
			}
			else
			{
				System.out.print(",R(-1)");
			}
			System.out.println();
		}
	}
	
	public void insertAVL(int data)
	{
		root=insertAVL(data,root);
	}

	private BTNode<Integer> insertAVL(int ele, BTNode<Integer> root) {
		if(root==null)
		{
			BTNode<Integer> node=new BTNode(ele);
			return node;
		}
		if(root.data>ele)
		{
			root.left=insertAVL(ele,root.left);
		}
		else 
		{
			root.right=insertAVL(ele,root.right);
		}
		root.height+=1;
		int bFactor=bf(root);
		if(bFactor>1 && ele<root.left.data)
		{
			return rightRotate(root);
		}
		if(bFactor<-1 && ele>root.right.data)
		{
			return leftRotate(root);
		}
		if(bFactor>1 && ele>root.left.data)
		{
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}
		if(bFactor<-1 && ele<root.right.data)
		{
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}
		return root;
		
	}
	
	private BTNode<Integer> leftRotate(BTNode<Integer> root2) 
	{
		BTNode<Integer> b=root.right;
		BTNode<Integer> T3=b.left;
		
		b.left=root;
		root.right=T3;
		
		root.height=1+Math.max(height(root.left), height(root.right));
		b.height=1+Math.max(height(b.left),height(b.right))+1;
		
		return b;
	}

	private BTNode<Integer> rightRotate(BTNode<Integer> root) 
	{
		BTNode<Integer> b=root.left;
		BTNode<Integer> T3=b.right;
		
		b.right=root;
		root.left=T3;
		
		root.height=1+Math.max(height(root.left), height(root.right));
		b.height=1+Math.max(height(b.left),height(b.right))+1;
		
		return b;
		
	}

	private int bf(BTNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		return height(root.left)-height(root.right);
	}
	public int height(BTNode<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		return root.height;
	}
	
	
}

public class BST {
	
	public static void main(String args[])
	{
	     BSTNode s=new BSTNode();
	     s.insert(5);
	     s.insert(10);
	     s.insert(6);
	     s.insert(3);
	     s.insert(2);
	     s.insert(1);
         s.display();
       
         BSTNode s1=new BSTNode();
	     s1.insertAVL(5);
	     s1.insertAVL(10);
	     s1.insertAVL(6);
	     s1.insertAVL(3);
	     s1.insertAVL(2);
	     s1.insertAVL(1);
         s1.display();
         
	}
	
	

}
