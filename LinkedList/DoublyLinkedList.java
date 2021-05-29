package LinkedList;
import java.util.*;

class DoubleNodeLL
{
	int data;
	DoubleNodeLL prev;
	DoubleNodeLL next;
	
	public DoubleNodeLL(int data) 
	{
		this.data=data;
		prev=null;
		next=null;
	}
}

public class DoublyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleNodeLL head=new DoubleNodeLL(10);
		
		insert(head,20);
		insert(head,30);
		
		head=insertAtBegin(head, 100);
		head=insertAtBegin(head, 120);

		
		insertAtEnd(head, 34);
		
		print(head);
		
		DoubleNodeLL rHead=reverse(head);
		
		print(rHead);
		
	   //System.out.println(head.next.next.prev.data);

	}
	
	public static DoubleNodeLL reverse(DoubleNodeLL head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		
		DoubleNodeLL curr=head;
		DoubleNodeLL prev=null;
		//DoubleNodeLL h=null;
		
		while(curr!=null)
		{
			prev=curr.prev;
			curr.prev=curr.next;
			curr.next=prev;
			curr=curr.prev;
			//System.out.println("data "+prev.data);
		}
		//System.out.println(h.data);
		return prev.prev;
	}
	
	public static void insertAtEnd(DoubleNodeLL head,int data)
	{
		if(head==null)
		{
			return;
		}
		
		DoubleNodeLL temp=head;
		DoubleNodeLL newnode=new DoubleNodeLL(data);
		
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=newnode;
		newnode.prev=newnode;
		return;
	}
	
	public static DoubleNodeLL insertAtBegin(DoubleNodeLL head,int data)
	{
		if(head==null)
		{
			return head;
		}
		
		//DoubleNodeLL temp=head;
		DoubleNodeLL newnode=new DoubleNodeLL(data);
		head.prev=newnode;
		newnode.next=head;
		
		return newnode;
	}
	
	public static DoubleNodeLL insert(DoubleNodeLL head,int data)
	{
		if(head==null)
		{
			return new DoubleNodeLL(data);
		}
		
		DoubleNodeLL temp=head;
		DoubleNodeLL newnode=new DoubleNodeLL(data);
		
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		
		temp.next=newnode;
		newnode.prev=temp;
		
		return head;
	}
	
	public static void print(DoubleNodeLL head)
	{
		System.out.println("print");
		if(head==null)
		{
			System.out.println("null");
			return;
		}
		
		DoubleNodeLL temp=head;
		
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}

}
