package Trie;

import java.util.*;

class TrieNode
{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data)
	{
		this.data=data;
		isTerminating=false;
		children=new TrieNode[26];
		childCount=0;
	}
}

class Trie
{
	private TrieNode root;
	int numWords;
	
	public Trie()
	{
		root=new TrieNode('\0');
		numWords=0;
	}
	
	public void add(String word)
	{
		if(add(root,word))
		{
			numWords++;
		}
	}

	private boolean add(TrieNode root, String word) {
		if(word.length()==0)
		{
			if(root.isTerminating)
			{
				return false;
			}
			else
			{
				root.isTerminating=true;
				return true;
			}
		}
		int child=(word.charAt(0)-'a');
		TrieNode childR=root.children[child];
		if(childR==null)
		{
			childR=new TrieNode(word.charAt(0));
			root.children[child]=childR;
			root.childCount++;
		}
		return add(childR,word.substring(1));
		
	}
	
	public boolean search(String word)
	{
		return search(root,word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length()==0)
		{
			return root.isTerminating;
		}
		int child=word.charAt(0)-'a';
		TrieNode c=root.children[child];
		if(c==null)
		{
			return false;
		}
		return search(c,word.substring(1));
	}
	
	public void delete2(String word)
	{
		delete2(root,word);
	}

	private void delete2(TrieNode root, String word) {
		if(word.length()==0)
		{
			root.isTerminating=false;
			return;
		}
		int child=word.charAt(0)-'a';
		TrieNode c=root.children[child];
		if(c==null)
		{
			return;
		}
		delete2(c,word.substring(1));
		
	}
	
	public void delete(String word)
	{
		if(delete(root,word))
		{
			numWords--;
		}
	}

	private boolean delete(TrieNode root, String word) {
		if(word.length()==0)
		{
			if(root.isTerminating)
			{
				root.isTerminating=false;
				return true;
			}
			//root.isTerminating=false;
			return false;
		}
		int child=word.charAt(0)-'a';
		TrieNode c=root.children[child];
		if(c==null)
		{
			return false;
		}
		boolean ans=delete(c,word.substring(1));
		
		if(!c.isTerminating && c.childCount==0)
		{
			root.children[child]=null;
			c=null;
			root.childCount--;
		}
		return ans;
		
		// We can only delete node when it is non terminating and no of children is zero
//		if(!c.isTerminating)
//		{
//			int numChild=0;
//			for(int i=0;i<26;i++)
//			{
//				if(c.children[i]!=null)
//				{
//					numChild++;
//				}
//			}
//			if(numChild==0)
//			{
//				//we can delete node
//				root.children[child]=null;
//				c=null;
//			}
//		}
		
	}
	
}
public class TrieUse {

	public static void main(String[] args) {
	    Trie t=new Trie();
	    t.add("this");
	    t.add("this");
	    t.add("news");
	    t.add("batman");
	    System.out.println(t.search("news"));
	    System.out.println(t.numWords);
	    t.delete("news");
	    System.out.println(t.search("news"));
	    System.out.println(t.numWords);

	}

}
