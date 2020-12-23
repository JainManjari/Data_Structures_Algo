package BST;

class H
{
    int max;
    int min;
    Boolean isBST;
    int height;
}

class Triplet<Integer,Boolean>
{
	int max;
	int min;
	boolean isBST;
	
}

class BTNode<T>
{
	public T data;
	public BTNode<T> left;
	public BTNode<T> right;
	
	public BTNode(T data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}

public class BST {
	
	
	public static int largestBSTSubtree(BTNode<Integer> root) {
		// Write your code here
        H h=large(root);
      	return h.height;
	}

    public static H large(BTNode<Integer> root)
    {
        if(root==null)
        {
            H h=new H();
            h.height=-1;
            h.min=Integer.MAX_VALUE;
            h.max=Integer.MIN_VALUE;
            h.isBST=true;
            return h;
        }
        if(root.left==null && root.right==null)
        {
            H h=new H();
            h.height=1;
            h.min=root.data;
            h.max=root.data;
            h.isBST=true;
            return h;
        }
        H left=large(root.left);
        H right=large(root.right);
        H h=new H();
        h.min=Math.min(root.data,Math.min(left.min,right.min));
        h.max=Math.max(root.data,Math.max(left.max,right.max));
        h.isBST=left.isBST & right.isBST & (left.max<root.data && right.min>=root.data);
        if(h.isBST)
        {
            h.height=1+Math.max(left.height,right.height);
        }
        else
        {
            h.height=Math.max(left.height,right.height);
        }
        return h;
    }
	
	
	public static boolean isBSTout(BTNode<Integer> root)
	{
		return isBST(root).isBST;
	}
	
	public static Triplet<Integer,Boolean> isBST(BTNode<Integer> root)
	{
		if(root==null)
		{
			Triplet<Integer,Boolean> t=new Triplet();
			t.max=Integer.MIN_VALUE;
			t.min=Integer.MAX_VALUE;
			t.isBST=true;
			return t;
		}
		Triplet<Integer,Boolean> l=isBST(root.left);
		Triplet<Integer,Boolean> r=isBST(root.right);
		Triplet<Integer,Boolean> t=new Triplet();
		t.max=Math.max(root.data,Math.max(l.max, r.max));
		t.min=Math.min(root.data,Math.min(l.min, r.min));
//		t.max=r.max;
//		t.min=l.min;
		t.isBST=(l.isBST && r.isBST && (l.max<root.data) && (r.min>=root.data));
		return t;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
