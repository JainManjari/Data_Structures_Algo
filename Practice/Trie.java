package Practice;
import java.util.*;

class TrieNode
{
     char data;
     boolean isTerminating;
     int childCount;
     TrieNode children[];
     
     public TrieNode(char data)
     {
    	 this.data=data;
    	 isTerminating=false;
    	 childCount=0;
    	 children=new TrieNode[26];
     }
}



public class Trie {
	
	TrieNode root;
	int numWords;
	
	public Trie()
	{
		this.root=new TrieNode('\0');
		this.numWords=0;
	}
	
	public void insert(String word)
	{
		if(insert(root,word))
		{
			this.numWords++;
		}
	}
	
	public boolean insert(TrieNode root,String word)
	{
		if(word.length()==0)
		{
			root.isTerminating=true;
			return true;
		}
		int childI=word.charAt(0)-'a';
		TrieNode child=root.children[childI];
		if(child==null)
		{
			child=new TrieNode(word.charAt(0));
			root.children[childI]=child;
			root.childCount++;
		}
		return insert(child,word.substring(1));
	}
	
	public void print()
	{
		printHelper(this.root,"");
	}
	
	public void printHelper(TrieNode root,String out)
	{
		if(root.childCount==0 && !root.isTerminating)
		{
			return;
		}
		
		if(root.isTerminating)
		{
			System.out.println(out);
		}
		
		for(int i=0;i<root.children.length;i++)
		{
			TrieNode child=root.children[i];
			if(child!=null)
			{
				//System.out.println("child "+child.data);
				printHelper(child, out+child.data);
			}
		}
	}
	
	public boolean search(String word)
	{
		return searchHelper(this.root,word);
	}
	
	public boolean searchHelper(TrieNode root,String word)
	{
		if(word.length()==0)
		{
			return root.isTerminating;
		}
		
		int childI=word.charAt(0)-'a';
		TrieNode child=root.children[childI];
		if(child==null)
		{
			return false;
		}
		return searchHelper(child, word.substring(1));
	}
	
	public void delete(String word)
	{
		if(deleteHelper(this.root, word))
		{
			this.numWords--;
		}
	}
	
	
	public boolean deleteHelper(TrieNode root,String word)
	{
		if(word.length()==0)
		{
			if(root.isTerminating)
			{
				root.isTerminating=false;
				return true;
			}
			return false;
		}
		int childI=word.charAt(0)-'a';
		TrieNode child=root.children[childI];
		if(child==null)
		{
			return false;
		}
		boolean ans=deleteHelper(child,word.substring(1));
		if(root.childCount==0 && !root.isTerminating)
		{
			root.children[childI]=null;
			root.childCount--;
		}
		return ans;
	}
	
	public static void main(String args[])
	{
		Trie root=new Trie();
		String word="hello";
		String word2="world";
		String word3="hell";
		String word4="word";
		root.insert(word);
		root.insert(word2);
		root.insert(word3);
		root.insert(word4);
		root.insert("foggy");
		root.insert("fog");
		root.insert("art");
		root.insert("alice");
		System.out.println(root.numWords);
		root.print();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		System.out.println(root.search(word));
		System.out.println(root.search("rose"));
		System.out.println(root.search("music"));
		System.out.println(root.search("fog"));
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		root.delete("art");
		System.out.println("search after delete "+root.search(word3));
		root.delete("foggy");
		System.out.println("search after delete "+root.search("foggy"));
//		System.out.println(root.searchWord(word));
//		
//		System.out.println(root.numWords);
//		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(root.numWords);
		root.print();
	}
}





