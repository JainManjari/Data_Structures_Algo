package Tree;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;


public class Tree<T>{
	
	private T data;
	private ArrayList<Tree<T>> children;
	
	public Tree(T data)
	{
		this.data=data;
		children=new ArrayList();
	}
	
	public static Tree<Integer> takeInput(Scanner in)
	{
		System.out.println("Enter root data ");
		int rootData=in.nextInt();
		
		Tree<Integer> root=new Tree(rootData);
		
		System.out.println("Enter the no of children of "+rootData);
		
		int noOfChild=in.nextInt();
		
		for(int i=0;i<noOfChild;i++)
		{
			root.children.add(takeInput(in));
		}
		return root;
	}
	
	public static void printR(Tree<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		
		String s="Root: "+root.data+" ";
		
		
		
		for(int i=0;i<root.children.size();i++)
		{
			s+="Child "+(i+1)+": "+root.children.get(i).data+" ";
		}
		
		System.out.println(s);
		
		for(int i=0;i<root.children.size();i++)
		{
			printR(root.children.get(i));
		}
		
	}
	
	public static Tree<Integer> insertL()
	{
		Scanner in=new Scanner(System.in);
		//System.out.println("Enter root data");
		int rootData=in.nextInt();
		Tree<Integer> root=new Tree(rootData);
		Queue<Tree<Integer>> q= new LinkedList();
		q.add(root);
		
		while(!q.isEmpty())
		{
			Tree<Integer> r=q.remove();
			//System.out.println("Enter the no of children of "+r.data);
			int noofChild=in.nextInt();
			
			for(int i=0;i<noofChild;i++)
			{
				//System.out.println("Enter the child "+(i+1)+" of "+r.data);
				int childData=in.nextInt();
				Tree<Integer> child=new Tree<Integer>(childData);
				r.children.add(child);
				q.add(child);
			}
		}
		
		return root;
	}
	
	public static void printL(Tree<Integer> root)
	{
		if(root==null)
		{
			return;
		}
		Queue<Tree<Integer>> q=new LinkedList();
		q.add(root);
        q.add(null);
		//System.out.println(root.data);
		while(!q.isEmpty())
		{
            String s="";
			while(q.peek()!=null)
            {
                Tree<Integer> r=q.poll();
                for(int i=0;i<r.children.size();i++)
                {
                    q.add(r.children.get(i));
                }
                System.out.print(r.data+" ");
            }
			q.poll();
            q.add(null);
            
            if(q.peek()==null)
            {
            	q.poll();
            }
            System.out.println();
			
		}
	}
	
	public static int noofNodes(Tree<Integer> root)
	{
		if(root==null)
		{
			return 0;
		}
		int sum=0;
		for(int i=0;i<root.children.size();i++)
		{
			sum+=noofNodes(root.children.get(i));
		}
		return 1+sum;
	}
	
	public static int largestNode(Tree<Integer> root)
	{
		if(root==null)
		{
			return -1;
		}
		if(root.children.size()==0)
		{
			return root.data;
		}
		int max=root.data;
		for(int i=0;i<root.children.size();i++)
		{
			max=Math.max(max, largestNode(root.children.get(i)));
		}
		return max;
		
	}

	
	public static int getHeight(Tree<Integer> root){
		
        if(root==null)
        {
            return 0;
        }
        int max=0;
        for(int i=0;i<root.children.size();i++)
        {
            max=Math.max(max,getHeight(root.children.get(i)));
        }
        return 1+max;
	}
	
	public static int getDepth(Tree<Integer> root,int x,int depth)
	{
			
	        if(root==null)
	        {
	            return -1;
	        }
	        if(root.data==x)
	        {
	        	return depth;
	        }
	        int max=-1;
	        for(int i=0;i<root.children.size();i++)
	        {
	            max=Math.max(max,getDepth(root.children.get(i),x,depth+1));
	        }
	        return max;
	}
	
	public static int countLeafNodes(Tree<Integer> root){

		// Write your code here
        if(root==null)
        {
            return -1;
        }
        if(root.children.size()==0)
        {
            return 1;
        }
        int count=0;
        for(int i=0;i<root.children.size();i++)
        {
            count+=countLeafNodes(root.children.get(i));
        }
        return count;

	}
	
	public static void printPostOrder(Tree<Integer> root){
		if(root==null)
        {
            return;
        }
        for(int i=0;i<root.children.size();i++)
        {
            printPostOrder(root.children.get(i));
       	}
        System.out.print(root.data+" ");
	}
	
	public static Tree<Integer> removeLeafNodes(Tree<Integer> root) {
		
        if(root==null)
        {
            return null;
        }
        if(root.children.size()==0)
        {
            return null;
        }
        
        for(int i=0;i<root.children.size();i++)
        {
            Tree<Integer> newchild=removeLeafNodes(root.children.get(i));
            root.children.set(i,newchild);
        }
        return root;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in= new Scanner(System.in);
		Tree<Integer> root=insertL();  //takeInput(in);
		
		printL(root);
		System.out.println("No of nodes: "+noofNodes(root));
		
		System.out.println("Largest Node Data : "+largestNode(root));
		int x=12;
		System.out.println("Depth of Node "+x+": "+getDepth(root,x,0));
		
		Tree<Integer> root1=removeLeafNodes(root);
		
		printL(root);
	}

}
