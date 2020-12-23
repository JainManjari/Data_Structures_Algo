package Practice;
import java.util.*;

class Node<T>
{
	public T data;
	public Node<T> next;
	
	public Node(T data)
	{
		this.data=data;
		this.next=null;
	}
	
	
}

class DoubleNode<T>
{
	T head;
	T tail;
}

public class LinkedList {
	
	
	private static Node<Integer> insertIt(Scanner in)
	{
		int data=in.nextInt();
		Node<Integer> head=null;
		Node<Integer>tail=null;
		
		while(data!=-1)
		{
			Node<Integer> newnode=new Node<>(data);
			if(head==null)
			{
				head=newnode;
				tail=newnode;
			}
			tail.next=newnode;
			tail=newnode;
			data=in.nextInt();
		}
		return head;
	}
	
	private static Node<Integer> insert(Node<Integer> head,int data)
	{
		Node<Integer> newnode=new Node<>(data);
		Node<Integer> h1=null;
		
		
		if(head==null)
		{
			h1=newnode;
			return h1;
		}
		Node<Integer> t1=head;
		
		while(t1.next!=null)
		{
			t1=t1.next;
		}
		t1.next=newnode;
		return h1;
	}
	
	private static void printIt(Node<Integer> head)
	{
		Node<Integer> temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static Node<Integer> middle(Node<Integer> head)
	{
		Node<Integer> slow=head;
		Node<Integer> fast=head;
		
		while(fast!=null)
		{
			if(fast.next==null || fast.next.next==null)
			{
				return slow;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	
	
	public static Node<Integer> reverse(Node<Integer> head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		Node<Integer> t=head.next;
		Node<Integer> nh=reverse(head.next);
		t.next=head;
		head.next=null;
		return nh;
	}
	
	public static DoubleNode<Node<Integer>> reverse2(Node<Integer> head)
	{
		if(head==null)
		{
			DoubleNode<Node<Integer>> a=new DoubleNode();
			a.head=null;
			a.tail=null;
			return a;
		}
		if(head.next==null)
		{
			DoubleNode<Node<Integer>> a=new DoubleNode();
			a.head=head;
			a.tail=head;
			return a;
		}
		DoubleNode<Node<Integer>> a =reverse2(head.next);
		a.tail.next=head;
		a.tail=head;
		head.next=null;
		return a;
	}
	
	public static void main(String args[])
	{
		
		//1 2 3 4 5 6 7 18 19 -1
		Scanner in=new Scanner(System.in);
//		Node<Integer> head=insert(null,6);;
//		insert(head,7);
//		insert(head,8);
//		printIt(head);
		Boolean a=true;
		
		Node<Integer> head=insertIt(in);
		//printIt(head);
		//printIt(middle(head));
		
		printIt(reverse2(head).head);
		
		
		//Ordered Maps
		//LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer, Integer>();
		
		
	}

}
