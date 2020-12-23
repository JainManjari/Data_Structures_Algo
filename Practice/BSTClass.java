package Practice;

//import java.util.*;

import java.util.Queue;
import java.util.LinkedList;

class BT<T>
{
    T data;
    BT<T> left;
    BT<T> right;
    int height;
	
	public BT(T data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
		this.height=1;
	}
	
	
}

class BSTNode
{
	private BT<Integer> root;
	
	
	public BSTNode()
	{
		this.root=null;
		
	}
	
	public boolean hasData(int data)
	{
		return hasDataHelper(root,data);
	}
	
	public void insertData(int data)
	{
		root=insertDataHelper(root,data);
	}
	
	public void deleteData(int data)
	{
		root=deleteDataHelper(root,data);
	}
	
	public void print()
	{
		printHelper(root);
	}
	
	private void printHelper(BT<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		if(root.left==null && root.right==null)
		{
			System.out.println(root.data);
			return;
		}
		
		Queue<BT<Integer>> q=new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			while(!q.isEmpty() && q.peek()!=null)
			{
				BT<Integer> t=q.remove();
				
				if(t.left!=null)
				{
					q.add(t.left);
				}
				
				if(t.right!=null)
				{
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
	
	private BT<Integer> deleteDataHelper(BT<Integer> root,int data)
	{
		if(root==null)
		{
			return null;
		}
		if(root.left==null && root.right==null)
		{
			if(root.data==data)
			{
				return null;
			}
			return root;
		}
		if(data>root.data)
		{
			root.right=deleteDataHelper(root.right, data);
		}
		else if(data<root.data)
		{
			root.left=deleteDataHelper(root.left, data);
		}
		else
		{
			if(root.left==null)
			{
				root.height=height(root.right);
				return root.right;
			}
			else if(root.right==null)
			{
				root.height=height(root.left);
				return root.left;
			}
			else
			{
				BT<Integer> max=root.left;
				while(max.right!=null)
				{
					max=max.right;
				}
				
				root.data=max.data;
				root.left=deleteDataHelper(root.left, max.data);
				root.height=1+Math.max(height(root.left), height(root.right));
				return root;
			}
			
		}
		root.height=1+Math.max(height(root.left), height(root.right));
		return root;
	}
	
	private BT<Integer> insertDataHelper(BT<Integer> root,int data)
	{
		if(root==null)
		{
			BT<Integer> r=new BT<>(data);
			return r;
		}
		if(data>=root.data)
		{
			root.right=insertDataHelper(root.right, data);
		}
		else
		{
			root.left=insertDataHelper(root.left, data);
		}
		root.height=1+Math.max(height(root.left), height(root.right));
		return root;
	}
	
	public int getHeight()
	{
		return height(root);
	}
	
	private static int height(BT<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		return root.height;
	}
	
	private boolean hasDataHelper(BT<Integer> root,int data)
	{
		if(root==null)
		{
			return false;
		}
		if(root.left==null && root.right==null)
		{
			if(root.data==data)
			{
				return true;
			}
			return false;
		}
		if(data>root.data)
		{
			return hasDataHelper(root.right, data);
		}
		return hasDataHelper(root.left, data);
	}
	
	public void insertAVL(int data)
	{
		root=insertAVLHelper(root,data);
	}
	
	private BT<Integer> insertAVLHelper(BT<Integer> root,int data)
	{
		if(root==null)
		{
			BT<Integer> r=new BT(data);
			return r;
		}
		if(data>=root.data)
		{
			root.right=insertAVLHelper(root.right, data);
		}
		else
		{
			root.left=insertAVLHelper(root.left, data);
		}
		root.height+=1;
		int bf=getBF(root);
		if(bf>1 && root.left.data>data)
		{
			return rightRotate(root);
		}
		if(bf>1 && data>root.left.data)
		{
			root.left=leftRotate(root.left);
			return rightRotate(root);
		}
		if(bf<-1 && data>root.right.data)
		{
			return leftRotate(root);
		}
		if(bf<-1 && data<root.right.data)
		{
			root.right=rightRotate(root.right);
			return leftRotate(root);
		}
		
		return root;
	}
	
	private BT<Integer> leftRotate(BT<Integer> root)
	{
		BT<Integer> b=root.right;
		BT<Integer> T2=b.left;
		
		b.left=root;
		root.right=T2;
		
		root.height=1+Math.max(height(root.left), height(root.right));
		b.height=1+Math.max(height(b.left), height(b.right));
		
		return b;
	}
	
	private BT<Integer> rightRotate(BT<Integer> root)
	{
		BT<Integer> b=root.left;
		BT<Integer> T3=b.right;
		
		b.right=root;
		root.left=T3;
		
		root.height=1+Math.max(height(root.left), height(root.right));
		b.height=1+Math.max(height(b.left),height(b.right));
		return b;
		
	}
	
	private int getBF(BT<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		return height(root.left)-height(root.right);
	}
}




public class BSTClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTNode root=new BSTNode();
//		root.insertData(5);
//		root.insertData(10);
//		root.insertData(78);
//		root.insertData(3);
//		root.insertData(4);
//		root.insertData(1);
//		root.print();
//		System.out.println();
//		System.out.println(root.hasData(100));
//		System.out.println();
//		System.out.println(root.hasData(78));
//		System.out.println();
//		System.out.println("H: "+root.getHeight());
//		root.deleteData(1000);
//		root.print();
//		System.out.println();
//		System.out.println("H: "+root.getHeight());
//		root.deleteData(3);
//		System.out.println();
//		root.print();
//		System.out.println("H: "+root.getHeight());

		
		root.insertAVL(5);
		root.insertAVL(6);
		root.insertAVL(12);
		root.insertAVL(19);
		root.insertAVL(121);
		root.insertAVL(10);
		root.insertAVL(4);
		
		root.print();
		System.out.println();
		System.out.println(root.getHeight());
	}

}
