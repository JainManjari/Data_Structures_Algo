package Practice;
import java.util.*;

class Node<T>
{
	T data;
	Node<T> next;
	
	public Node(T data)
	{
		this.data=data;
		next=null;
	}
}

public class LinkedList {
	
	Node<Integer> head;
	Node<Integer> tail;
	
	public LinkedList()
	{
		this.head=null;
		this.tail=null;
	}
	
	public void print()
	{
		Node<Integer> temp=this.head;
		System.out.println("print func");
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public void takeInputItr(Scanner in)
	{
		System.out.println("Enter data: ");
		int data=in.nextInt();
		
		while(data!=-1)
		{
			Node<Integer> newnode=new Node(data);
			if(this.head==null)
			{
				this.head=newnode;
				this.tail=newnode;
			}
			else
			{
				this.tail.next=newnode;
				this.tail=newnode;
			}
			System.out.println("Enter data: ");
			data=in.nextInt();
		}
	}
	
	public void takeInputEle(int data)
	{
		Node<Integer> newnode=new Node(data);
		if(this.head==null)
		{
			this.head=newnode;
			this.tail=newnode;
		}
		else
		{
			this.tail.next=newnode;
			this.tail=newnode;
		}
	}
	
	public void printReverse(Node head)
	{
		if(head==null)
		{
			return;
		}
		if(head.next==null)
		{
			System.out.print(head.data+" ");
			return;
		}
		printReverse(head.next);
		System.out.print(head.data+" ");
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
        LinkedList l=new LinkedList();
        l.takeInputItr(in);
        l.print();
        l.printReverse(l.head);
        //System.out.println(l.head.data+" "+l.tail.data);
//        l.takeInputEle(56);
//        l.print();
//        System.out.println(l.head.data+" "+l.tail.data);
        
        
	}

}
