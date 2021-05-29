package Practice;
import java.util.*;

class StackEmptyException extends Exception
{
	
}

public class StackCase {
	
	int s[];
	int top;
	int size;
	
	public StackCase()
	{
		this.s=new int[5];
		this.top=-1;
		this.size=0;
	}
	
	public StackCase(int n)
	{
		this.s=new int[n];
		this.top=-1;
		this.size=0;
	}
	
	public boolean isEmpty()
	{
		return this.size==0;
	}
	
	public void insert(int data)
	{
		if(this.s.length==this.size)
		{
			this.s=doubleCapacity();
		}
		this.top++;
		this.s[top]=data;
		this.size++;
	}
	
	public int pop() throws StackEmptyException
	{
		if(isEmpty())
		{
			throw new StackEmptyException();
		}
		int c=s[top];
		this.top--;
		this.size--;
		return c;
		
	}
	
	public int[] doubleCapacity()
	{
		System.out.println("double cap");
		int temp[]=new int[this.s.length*2];
		
		for(int i=0;i<this.s.length;i++)
		{
			temp[i]=s[i];
		}
		top=this.s.length-1;
		return temp;
	}
	
	public static void main(String[] args) throws StackEmptyException {
		// TODO Auto-generated method stub
		StackCase st=new StackCase();
		for(int i=0;i<10;i++)
		{
			st.insert(i);
		}
		
		while(!st.isEmpty())
		{
			System.out.println(st.pop());
		}
	}

}
