package Questions;

import java.util.*;
import java.util.LinkedList;

class Syno
{
	String a;
	String b;
}

public class Synon {
	
	

	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		/*
		 * 
		 *  13
			ram shyam 
			sita gita
			ram rahul
			rahul karan
			rahul vaibhav
			shyam mansi
			mansi jhansi
			harry potter
			ginny potter
			hermoine granger
			ron weasley
			rose weasley
			albus potter
		 */
		
		// no of pairs for a syn class
		int n=in.nextInt();
		ArrayList<Syno> a4=new ArrayList<Syno>();
		
		for(int i=0;i<n;i++)
		{
			Syno c=new Syno();
			c.a=in.next();
			c.b=in.next();
			a4.add(c);
		}
		
		LinkedHashMap<String,Integer> map=new LinkedHashMap();
		LinkedHashMap<Integer,String> map2=new LinkedHashMap();
		
		int count=0;
		
		for(int i=0;i<a4.size();i++)
		{
			if(!map.containsKey(a4.get(i).a))
			{
				map.put(a4.get(i).a,count);
				map2.put(count,a4.get(i).a);
				count++;
			}
			if(!map.containsKey(a4.get(i).b))
			{
				map.put(a4.get(i).b,count);
				map2.put(count,a4.get(i).b);
				count++;
			}
		}
		
		
		System.out.println("count "+count);
		
		for(String key:map.keySet())
		{
			System.out.println(key+" "+map.get(key));
		}
		
		int parent[]=new int[count];
		
		for(int i=0;i<parent.length;i++)
		{
			parent[i]=i;
		}
		
		for(int i=0;i<a4.size();i++)
		{
			Syno c=a4.get(i);
			int index_b=map.get(c.b);
			int index_a=map.get(c.a);
			parent[index_b]=index_a;
		}
		
		for(int i=0;i<parent.length;i++)
		{
			System.out.println(i+"("+map2.get(i)+") "+parent[i]+"("+map2.get(parent[i])+")");
		}

		
		//the word to find syno
		String word="potter"; //harry
		
		if(map.containsKey(word))
		{
			boolean visited[]=new boolean[parent.length];
			
			int index=fP(parent,map.get(word));
			
			printNamesBetter(parent,index,map2,visited,word);
		}
		else
		{
			System.out.println("Word doesn't exits!");
		}


	}
	
	
	
	public static void printNamesBetter(int parent[],int index,LinkedHashMap<Integer,String> map,boolean visited[],String word)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(index);
		q.add(-1);
		
		while(!q.isEmpty())
		{
			while(!q.isEmpty() && q.peek()!=-1)
			{
				int t=q.remove();
				visited[t]=true;
				if(!map.get(t).equals(word))
				{
					System.out.print(map.get(t)+" ");
				}
				for(int i=0;i<parent.length;i++)
				{
					if(parent[i]==t && !visited[i])
					{
						q.add(i);
					}
				}
			}
			q.remove();
			q.add(-1);
			if(q.peek()==-1)
			{
				q.remove();
			}
		}
	}
	
	public static void printNames(int parent[],int index,LinkedHashMap<Integer,String> map,boolean visited[],String word)
	{

		visited[index]=true;
		if(!map.get(index).equals(word))
		{
			System.out.print(map.get(index)+" ");
		}
		for(int i=0;i<parent.length;i++)
		{
			if(parent[i]==index && !visited[i])
			{
				printNames(parent,i,map,visited,word);
			}
		}
	}
	
	
	public static int fP(int parent[],int v)
	{
		if(parent[v]==v)
		{
			return v;
		}
		return fP(parent,parent[v]);
	}
	


}

