package LinkedList;

class SLL
{
	int data;
	SLL next;
	
	public SLL(int data)
	{
		this.data=data;
		this.next=null;
	}
}

public class CircularSLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLL head=insert(null,20);
		//System.out.println(head.data);
		//print(head);
		insert(head,30);
		//print(head);
		insert(head,40);
		print(head);
		head=insertAtBegin(head, 35);
		print(head);
		head=insertAtEnd(head, 45);
		print(head);
		
		head=deleteHead(head);
		print(head);
	}
	
	public static SLL deleteHead(SLL head)
	{
		if(head==null || head.next==head)
		{
			return null;
		}
		
		head.data=head.next.data;
		head.next=head.next.next;
		
		return head;
	}
	
	public static SLL insertAtEnd(SLL head,int data)
	{
		SLL newnode=new SLL(data);
		if(head==null)
		{
			newnode.next=newnode;
			return newnode;
		}
		
		newnode.next=head.next;
		head.next=newnode;
		int temp=head.data;
		head.data=head.next.data;
		head.next.data=temp;
		return newnode;
	}
	
	public static SLL insertAtBegin(SLL head,int data)
	{
		SLL newnode=new SLL(data);
		if(head==null)
		{
			newnode.next=newnode;
			return newnode;
		}
		
		newnode.next=head.next;
		head.next=newnode;
		
		//copying data
		int temp=head.data;
		head.data=head.next.data;
		head.next.data=temp;
		
		return head;
	}
	
	public static SLL insert(SLL head,int data)
	{
		if(head==null)
		{
			//System.out.println("null insert");
			SLL newnode=new SLL(data);
			newnode.next=newnode;
			return newnode;
		}
		
		SLL temp=head;
		
		while(temp.next!=head)
		{
			temp=temp.next;
		}
		
		SLL newnode=new SLL(data);
		temp.next=newnode;
		newnode.next=head;
		return head;
	}
	
	public static void print(SLL head)
	{
		if(head==null)
		{
			//System.out.println("null");
			return;
		}
		if(head.next==head)
		{
			System.out.println(head.data+" ");
			return;
		}
		SLL temp=head;
		while(temp.next!=head)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println(temp.data+" ");
	}

}
