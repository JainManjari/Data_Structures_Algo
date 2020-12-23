

public class AVL {
	
	private class Node
	{
		int data;
		Node left;
		Node right;
		int height;
		
		Node(int data)
		{
			this.data=data;
			left=null;
			right=null;
			this.height=1;
		}
		
	}	
		private Node root;
		
		public void insert(int ele)
		{
			this.root=insert(this.root,ele);
		}
		
		public void display()
		{
			display(root);
		}

		private void display(Node root) {
			// TODO Auto-generated method stub
			if(root==null)
			{
				return;
			}
			String s="";
			if(root.left==null)
			{
				s+="<< . ";
			}
			else
			{
				s+="<< "+root.left.data+" ";
			}
			s+=root.data+" ";
			if(root.right==null)
			{
				s+=". >>";
			}
			else
			{
				s+=root.right.data+" >>";
			}
			System.out.println(s);
			display(root.left);
			display(root.right);
		}

		private Node insert(Node root, int ele) {
			// TODO Auto-generated method stub
			if(root==null)
			{
				Node n=new Node(ele);
				return n;
			}
			if(ele<root.data)
			{
				root.left=insert(root.left,ele);
			}
			else
			{
				root.right=insert(root.right,ele);
			}
			
			root.height=height(root)+1;
			int bf=bf(root);
		//	System.out.println(bf);
			if(bf>1 && ele<root.left.data)
			{
				return right(root);
			}
			
			else if(bf<-1 && ele>root.right.data)
			{
				return left(root);
			}
			
			else if(bf>1 && ele>root.left.data)
			{
				root.left=left(root.left);
				return right(root);
			}
			
			else if(bf<-1 && ele<root.right.data)
			{
				root.right=right(root.right);
				return left(root);
			}
			return root;
		}

		private Node left(Node root) {
			// TODO Auto-generated method stub
			Node b=root.right;
			Node t3=b.left;
			
			b.left=root;
			root.right=t3;
			
			root.height=Math.max(height(root.left), height(root.right))+1;
			b.height=Math.max(height(b.left), height(b.right))+1;
			return b;
		}

		private Node right(Node root) {
			// TODO Auto-generated method stub
			Node b=root.left;
			Node t3=b.right;
			
			b.right=root;
			root.left=t3;
			
			root.height=Math.max(height(root.left), height(root.right))+1;
			b.height=Math.max(height(b.left), height(b.right))+1;
			return b;
		}

		private int bf(Node root) {
			// TODO Auto-generated method stub
			if(root==null)
			{
				return 0;
			}
			return height(root.left)-height(root.right);
		}

		private int height(Node root) {
			// TODO Auto-generated method stub
			if(root==null)
			{
				return 0;
			}
			return Math.max(height(root.left), height(root.right))+1;
		}
	}


	


