package Practice;
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
		this.children=new TrieNode[26];
		this.isTerminating=false;
		this.childCount=0;
		
	}
}



public class Trie {
	
	TrieNode root;
	int numWords;
	
	public Trie()
	{
		root=new TrieNode('\0');
	}
    
	
	
	
	public void insert(String word)
	{
		if(insertHelper(word, root))
		{
			numWords++;
		}
	}
	
	private boolean insertHelper(String word,TrieNode root)
	{
		if(word.length()==0)
		{
			if(!root.isTerminating)
			{
				root.isTerminating=true;
				return true;
			}
			return false;
		}
		
		int childI=word.charAt(0)-'a';
		
		TrieNode child=root.children[childI];
		
		if(child==null)
		{
			child=new TrieNode(word.charAt(0));
			root.children[childI]=child;
			root.childCount++;
		}
		return insertHelper(word.substring(1),child);
	}
	
	
	
	
	
	public boolean searchWord(String word)
	{
		return searchWordHelper(word,root);
	}
	
	private boolean searchWordHelper(String word,TrieNode root)
	{
		if(word.length()==0)
		{
			return root.isTerminating;
		}
		
		int childI=word.charAt(0)-'a';
		
		TrieNode child=root.children[childI];
		
		if(child!=null)
		{
			return searchWordHelper(word.substring(1),child);
		}
		return false;
		
	}
	
	
	public void delete(String word)
	{
		if(deleteHelper(word,root))
		{
			numWords--;
		}
	}
	
	private boolean deleteHelper(String word,TrieNode root)
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
		boolean ans=deleteHelper(word.substring(1),child);
		//We can only delete a node if it is non terminating and child chount is 0;
		
		if(!child.isTerminating && child.childCount==0)
		{
			child=null;
			root.children[childI]=null;
			root.childCount--;
		}
		
		return ans;
		
	}
	
	public void print() {
		print(this.root, "");
	}
	
	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	
	
	
	
	public static void main(String args[])
	{
		Trie root=new Trie();
		String word="hello";
		String word2="world";
		String word3="hell";
		root.insert(word);
		root.insert(word2);
		root.insert(word3);
		System.out.println(root.searchWord(word));
		System.out.println(root.searchWord("rose"));
		
		root.delete(word3);
		
		System.out.println(root.searchWord(word3));
		System.out.println(root.searchWord(word));
		
		System.out.println(root.numWords);
		
		root.print();
	}
}





