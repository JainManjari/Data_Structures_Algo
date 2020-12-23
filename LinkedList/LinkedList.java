package LinkedList;

import java.util.*;


/// FINDING MIDDLEEEE!!!!!!

//class Node<T>
//{
//	T data;
//	Node<T> next;
//	
//	public Node(T data)
//	{
//		this.data=data;
//		next=null;
//	}
//}

class DoubleNode<T>
{
	T head;
	T tail;
}

public class LinkedList {
	
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
//	public static Node<Integer> insert(int data)
//	{
//		//Node<Integer> head=null;
//		return insert(head,data);
//	}
	
	public static Node<Integer> insert(Node<Integer> head,int data)
	{
		Node<Integer> newNode=new Node<Integer>(data);
		//Node<Integer> h1=null;
		Node<Integer> t1=head;
		if(head==null)
		{
			//h1=newNode;
			return newNode;
		}
		
//		Node<Integer> temp=head;
//		
//		while(temp.next!=null)
//		{
//			temp=temp.next;
//		}
		
		
		//temp.next=newNode;
		return head;
	}

	public static Node<Integer> takeInput(Scanner in)
	{
		Node<Integer> head=null;
		Node<Integer> tail=null;
		int data=in.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node(data);
			if(head==null)
			{
				tail=newNode;
				head= newNode;
			}
			else
			{
				tail.next=newNode;
				tail=newNode;
			}
			
			data=in.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> insertPosRec(Node<Integer> head,int pos,int data)
	{
		if(head==null)
		{
			return head;
		}
		Node<Integer> newNode=new Node(data);
		if(pos==0)
		{
			newNode.next=head;
			return newNode;
		}
		head.next=insertPosRec(head.next,pos-1,data);
		return head;
		
	}
	
	public static Node<Integer> insertPosIt(Node<Integer> head,int pos,int data)
	{
		if(head==null)
		{
			return head;
		}
		Node<Integer> newNode=new Node(data);
		if(pos==0)
		{
			newNode.next=head;
			return newNode;
		}
		
		int i=0;
		Node<Integer> prev=head;
		while(i<pos-1 && prev.next!=null)
		{
			prev=prev.next;
			i++;
		}
		Node<Integer> prevNext=prev.next;
		prev.next=newNode;
		newNode.next=prevNext;
		return head;
	}
	
	public static Node<Integer> deletePosR(Node<Integer> head, int i){
	
        Node<Integer> temp=head;
        if(head==null)
        {
            return head;
        }
        if(i==0)
        {
            return head.next;
        }
        head.next=deletePosR(head.next,i-1);
        return head;
		
	}

	public static Node<Integer> deletePosI(Node<Integer> head, int i){
		
        Node<Integer> temp=head;
        if(head==null)
        {
            return head;
        }
        if(i==0)
        {
            return head.next;
        }
        int pos=0;
        Node<Integer> prev=head;
        Node<Integer> curr=head.next;
        while(pos<i-1)
        {
        	prev=prev.next;
        	curr=curr.next;
        	pos++;
        }
        if(prev.next!=null)
        {
        	prev.next=curr.next;
        }
        return head;
        
		
	}
	
	public static Node<Integer> reverseR(Node<Integer> head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		Node<Integer> temp=head.next;
		Node<Integer> reverseHead=reverseR(head.next);
		temp.next=head;
		head.next=null;
		return reverseHead;
	}
	
	public static Node<Integer> reverseI(Node<Integer> head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		Node<Integer> temp;
		Node<Integer> prev=null;
		Node<Integer> curr=head;
		
		while(curr!=null)
		{
			temp=curr.next;
			curr.next=prev;
			prev=curr;
			curr=temp;
		}
		return prev;
	}
	
	public static boolean isPalindrome_2(Node<Integer> head) {
	    
	      if(head==null || head.next==null)
	      {
	          return true;
	      }
	      
	      Node<Integer> tail=head;
	      Node<Integer> prev=null;
	     // int length=0;
	      while(tail.next!=null)
	      {
	          prev=tail;
	          tail=tail.next;
	      }
	      
	      if(head.data==tail.data)
	      {
	          prev.next=null;
	          return isPalindrome_2(head.next); 
	      }
	      return false;
	}
	
	public static boolean isPalindromeBetter(Node<Integer> head) {
	    
	      if(head==null || head.next==null)
	      {
	          return true;
	      }
	      
	      Node<Integer> temp=head;
	      temp=reverseI(temp);
	      
	      System.out.println();
	      print(temp);
	      System.out.println();
	      
	      while(temp!=null && head!=null)
	      {
	    	  System.out.println(temp.data+" "+head.data);
	    	  if(temp.data!=head.data)
	    	  {
	    		  return false;
	    		
	    	  }
	    	  temp=temp.next;
    		  head=head.next;
	      }
	      return true;
	}
	
	public static boolean isPalindrome3(Node<Integer> head) {
	    
	      if(head==null || head.next==null)
	      {
	          return true;
	      }
	      
	        int xor=0;
	        Node<Integer> temp=head;
	        while(temp!=null)
	        {
	            xor^=temp.data;
	            temp=temp.next;
	        }
	        if(xor==0)
	        {
	            return true;
	        }
	        return false;
//	       Node<Integer> tail=head;
//	       Node<Integer> prev=null;
//	      // int length=0;
//	       while(tail.next!=null)
//	       {
//	           prev=tail;
//	           tail=tail.next;
//	       }
	      
//	       if(head.data==tail.data)
//	       {
//	           prev.next=null;
//	           return isPalindrome_2(head.next); 
//	       }
//	       return false;
	   }
	
	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2) {
		
        Node<Integer> h1=head1;
        Node<Integer> t1=head1;
        Node<Integer> h2=head2;
        Node<Integer> t2=head2;
        Node<Integer> h3;
        Node<Integer> t3;
        
        if(h1.data<=h2.data)
        {
            h3=h1;
            t3=t1;
            t1=t1.next;
        }
        else
        {
            h3=h2;
            t3=t2;
            t2=t2.next;
        }
        
        while(t1!=null && t2!=null)
        {
            if(t1.data<=t2.data)
            {
                t3.next=t1;
                t3=t1;
                t1=t1.next;
            }
            else
            {
                t3.next=t2;
                t3=t2;
                t2=t2.next;
            }
        }
        if(t1!=null)
        {
            t3.next=t1;
            t3=t1;
        }
        if(t2!=null)
        {
            t3.next=t2;
            t3=t2;
        }
        return h3;
        
        
		
	}
	
	 public static Node<Integer> middle(Node<Integer> head)
	    {
		    //System.out.println(head.data+" ");
	        if(head==null || head.next==null)
	        {
	        	return head;
	        }
	        Node<Integer> slow=head;
	        Node<Integer> fast=head;
	        
	        while(fast.next!=null || fast.next.next!=null)
	        {
	        	System.out.println("inside while");
	            slow=slow.next;
	            fast=fast.next.next;
	            System.out.println(slow.data+" "+fast.data);
	        }
	        return slow;
	    }
	 
	 public static  Node<Integer> swap_nodes(Node<Integer> head,int i,int j){
	        Node<Integer> temp=head;
	        Node<Integer> prev=null;
	        Node<Integer> n1=null;
	        Node<Integer> p1=null;
	        Node<Integer> n2=null;
	        Node<Integer> p2=null;
	        
	        int c1=0;
	        int c2=0;
	        boolean f1=false;
	        boolean f2=false;
	        while(temp!=null)
	        {
	            if(c1==i && !f1)
	            {
	                n1=temp;
	                p1=prev;
	                f1=true;
	            }
	            if(c2==j && !f2)
	            {
	                n2=temp;
	                p2=prev;
	                f2=true;
	            }
	            if(f1 && f2)
	            {
	                break;
	            }
	            if(!f1)
	            {
	                c1++;
	            }
	            if(!f2)
	            {
	                c2++;
	            }
	            prev=temp;
	            temp=temp.next;
	        }
	        if(i<=j)
	        {
	            if(p1!=null)
	            {
	                Node<Integer> t=n2.next;
	                if(p2!=n1)
	                {
	                    p1.next=n2;
	                    n2.next=n1.next;
	                    p2.next=n1;
	                    n1.next=t;
	                }
	                else
	                {
	                    p1.next=n2;
	                    n2.next=n1;
	                    n1.next=t;
	                }
	            //return head;
	             }
	             else
	             {
	                 Node<Integer> t=n2.next;
	                 
	                 if(p2==n1)
	                 {
	                     n2.next=n1;
	                     n1.next=t;
	                     head=n2;
	                     
	                 }
	                 else
	                 {
	                     n2.next=n1.next;
	                     p2.next=n1;
	                     n1.next=t;
	                     head=n2;
	                 }
	           // return head;
	             }
	        }
	        else
	        {
	            if(p2!=null)
	            {
	                Node<Integer> t=n1.next;
	                if(p1!=n2)
	                {
	                    p2.next=n1;
	                    n1.next=n2.next;
	                    p1.next=n2;
	                    n2.next=t;
	                }
	                else
	                {
	                    p2.next=n1;
	                    n1.next=n2;
	                    n2.next=t;
	                }
	           // return head;
	            }
	            else
	            {
	                Node<Integer> t=n1.next;
	                if(p1!=n2)
	                {
	                    n1.next=n2.next;
	                    p1.next=n2;
	                    n2.next=t;
	                    head=n1;
	                }
	                else
	                 {
	                     n1.next=n2;
	                     n2.next=t;
	                     head=n1;
	                     
	                 }
	             }
	        }
	        
			return head;
		}
	 
	    public static DoubleNode<Node<Integer>> reverseforK(Node<Integer> head)
	    {
	    	if(head==null || head.next==null)
	    	{
	    		DoubleNode<Node<Integer>> p=new DoubleNode();
	    		return p;
	    	}
	    	DoubleNode<Node<Integer>> p=new DoubleNode();
	    	p.tail=head;
	    	Node<Integer> temp;
	    	Node<Integer> curr=head;
	    	Node<Integer> prev=null;
	    	
	    	while(curr!=null)
	    	{
	    		temp=curr.next;
	    		curr.next=prev;
	    		prev=curr;
	    		curr=temp;
	    	}
	    	p.head=prev;
	    	return p;
	    }
	 
	    public static Node<Integer> kReverse(Node<Integer> head,int k)
	    {
	    	if(head==null || head.next==null)
	    	{
	    		return head;
	    	}
	    	int count=1;
	    	Node<Integer> temp=head;
	    	while(count!=k && temp.next!=null)
	    	{
	    		count++;
	    		temp=temp.next;
	    	}
	    	Node<Integer> c=temp.next;
	    	//System.out.println(c.data);
	    	temp.next=null;
	    	if(count==k)
	    	{
	    		DoubleNode<Node<Integer>> p=reverseforK(head);
	    		p.tail.next=kReverse(c,k);
		    	//System.out.println(p.head.data+" "+p.tail.);
		    	return p.head;
	    	}
	    	return head;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		5 20 34 56 78 90
		Scanner in=new Scanner(System.in);
		Node<Integer> head1=takeInput(in);
		//Node<Integer> head2=takeInput(in);
		//head=reverseI(head);
		//Node<Integer> h1=insertPosIt(head,2,50);
//		int n=in.nextInt();
//		int a[]=new int[n];
//		Node<Integer> head=null;
//		for(int i=0;i<n;i++)
//		{
//			a[i]=in.nextInt();
//			head=insert(head,a[i]);
//		}
		//print(head);
		print(head1);
		//System.out.println(middle(head1).data);
		//print(swap_nodes(head1,4,2));
		print(kReverse(head1,4));
		//print(head2);
	//	System.out.println();
		//Node<Integer> head3=merge(head1,head2);
		
		//print(head3);

	}
	
	
}
