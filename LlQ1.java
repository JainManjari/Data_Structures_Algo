import java.util.*;
public class LlQ1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
        int a[]=new int[n];
        Node<Integer> head=null;
        Node<Integer> tail=null;
        for(int i=0;i<n;i++)
        {
        	a[i]=in.nextInt();
        	Node<Integer> newnode=new Node<>(a[i]);
        	if(i==0)
        	{
        		head=newnode;
        		tail=newnode;
        	}
        	else
        	{
        		tail.next=newnode;
        		tail=newnode;
        	}
        	
        }
        print(head);
       Node<Integer> t1=d(head);
        print(t1);
	}
	
	public static Node<Integer> d(Node<Integer> head)
	{
		Node<Integer> t1=head;
		Node<Integer> t2=head.next;
		
		if(t1==null || t2==null)
		{
			return t1;
		}
		
		if(t1.data<t2.data)
		{
		//	head=t2;
			return d(t2);
		}
		else
		{
			head=t1;
			t1.next=d(t2);
			return head;
		}
		//return head;
		
	}
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp=head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}

}

class Node<T>
{
	T data;
	Node<T> next;
	
	Node(T data)
	{
		this.data=data;
		next=null;
	}
}