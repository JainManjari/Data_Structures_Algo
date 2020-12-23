package Practice;
import java.util.*;

class MapNode<K,V>
{
	K key;
	V value;
	MapNode<K,V> next;
	
	public MapNode(K key,V value)
	{
		this.key=key;
		this.value=value;
		this.next=null;
	}
}

class Map<K,V>
{
	ArrayList<MapNode<K,V>> buckets;
	int size;
	int numBuckets;
	
	public Map()
	{
		buckets=new ArrayList<MapNode<K,V>>();
		this.size=0;
		this.numBuckets=5;
		for(int i=0;i<this.numBuckets;i++)
		{
			buckets.add(null);
		}
	}
	
	public int getIndex(K key)
	{
		return key.hashCode()%numBuckets;
	}
	
	public V get(K key)
	{
		int index=getIndex(key);
		MapNode<K,V> head=buckets.get(index);
		
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				return head.value;
			}
			head=head.next;
		}
		return null;
	}
	
	public void put(K key, V value)
	{
		int index=getIndex(key);
		MapNode<K,V> head=buckets.get(index);
		
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				return;
			}
			head=head.next;
		}
		
		head=buckets.get(index);
		MapNode<K,V> newnode=new MapNode(key,value);
		newnode.next=head;
		buckets.set(index, newnode);
		size++;
		
		double loadFactor=(1.0*size)/numBuckets;
		
		if(loadFactor>0.7)
		{
			rehash();
		}
		
	}
	
	private void rehash()
	{
		ArrayList<MapNode<K,V>> temp=buckets;
		numBuckets =numBuckets*2;
		buckets=new ArrayList();
		
		for(int i=0;i<numBuckets;i++)
		{
			buckets.add(null);
		}
		size=0;
		for(int i=0;i<temp.size();i++)
		{
			MapNode<K,V> head=temp.get(i);
			while(head!=null)
			{
				put(head.key,head.value);
				head=head.next;
			}
		}
		
	}
	
	public V delete(K key)
	{
		int index=getIndex(key);
		MapNode<K,V> head=buckets.get(index);
		MapNode<K,V> prev=null;
		
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				if(prev==null)
				{
					buckets.set(index, head.next);
				}
				else
				{
					prev.next=head.next;
				}
				size--;
				return head.value;
			}
			prev=head;
			head=head.next;
		}
		return null;
		
	}
	
	public int size()
	{
		return size;
	}
}



public class HashMap {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		Map<Integer,Integer> map=new Map();
//	    for(int i=0;i<15;i++)
//	    {
//	    	map.put(i, i+1);
//	    }
//	    
//	    int x=map.remove(10);
//	   
//	    
//	    for(int i=0;i<15;i++)
//	    {
//	    	System.out.println(i+" "+map.get(i));
//	    }
	}

}
