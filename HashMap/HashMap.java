package HashMap;

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
		next=null;
	}
}
class Map<K,V>
{
	ArrayList<MapNode<K,V>> buckets;
	int size;
	int numBuckets;
	
	public Map()
	{
		buckets=new ArrayList<>();
		numBuckets=5;
		for(int i=0;i<numBuckets;i++)
		{
			buckets.add(null);
		}
		size=0;
	}
	
	private int getIndex(K key)
	{
		return key.hashCode()%numBuckets;
	}
	
	public void put(K key,V value)
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
		MapNode<K,V> node=new MapNode(key,value);
		node.next=head;
		buckets.set(index, node);
		size++;
		double loadFactor=(1.0*size)/numBuckets;
		
		if(loadFactor>0.7)
		{
			rehash();
		}
		
	}
	
	public double loadFactor()
	{
		return (1.0*size)/numBuckets;
	}
	private void rehash() {
		System.out.println("Rehash numbuckets: "+numBuckets+" size "+size);
		ArrayList<MapNode<K,V>> temp=buckets;
		buckets=new ArrayList<>();
		numBuckets*=2;
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
				K key=head.key;
				V value=head.value;
				put(key,value);
				head=head.next;
			}
		}
		
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
	
	public V remove(K key)
	{
		int index=getIndex(key);
		//System.out.println(index+" "+key);
		MapNode<K,V> head=buckets.get(index);
		MapNode<K,V> prev=null;
	
		while(head!=null)
		{
			//System.out.println(head.key);
			if(head.key.equals(key))
			{
				//System.out.println(head.key+" "+head.value);
				//V c=head.value;
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
	   Map<Integer,Integer> map=new Map();
	   
	   for(int i=1;i<=20;i++)
	   {
		   map.put(i, i-1);
		   System.out.println("i "+i+" lf "+map.loadFactor());
	   }
//	   for(int i=1;i<=20;i++)
//	   {
//		   System.out.println("value of "+i+": "+map.get(i));
//	   }
	   System.out.println(map.get(5));
	   System.out.println(map.remove(5));
	   System.out.println(map.remove(20));
	   for(int i=1;i<=20;i++)
	   {
		   System.out.println("value of "+i+": "+map.get(i));
	   }

	}

}
