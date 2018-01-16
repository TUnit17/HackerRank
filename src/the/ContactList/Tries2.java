package the.ContactList;

import java.util.HashMap;


/*
 * ANALYSIS
 * ----------
 * 
 * STATUS: working
 * DATE: 1-13-18
 * 
 * FAQ
 * -----
 * 
 * 1) How am I suppose to see the whole thing before I start? 
 * 
 * 2) How do I not make mistakes when I trace through? 
 * 
 * 
 */

// this class contains the main method 
public class Tries2
{

	public static void main(String[] args)
	{
		Trie trie = new Trie();
		trie.add("question");
		trie.add("quest");
		trie.add("quester");
		int val= trie.find("qu");
		System.out.println(val);
	}
	
}

// this is the TrieNode of the Trie2 tree 
class TrieNode2
{
	private HashMap<Character, TrieNode2> children = new HashMap<>();
	public int size;
	
	// add a char to to the hashmap
	public void putChildIfAbsent(char ch)
	{
		children.putIfAbsent(ch, new TrieNode2());
	}
	
	
	// return the TrieNode for a char
	public TrieNode2 getChild(char ch)
	{
		return children.get(ch);
	}
	

}


// this is the Trie2 tree
class Trie2
{
	TrieNode2 root = new TrieNode2();
	
	// add the string to the Trie2 data-structure 
	public void add(String str)
	{
		// curr is a refernce to the root
		TrieNode2 curr = root;
		
		// loop through the entire string
		for(int i = 0; i< str.length(); i++)
		{
			// extract the character
			char c = str.charAt(i);
			
			// put the character in the hashmap
			curr.putChildIfAbsent(c);
			
			// set curr to the next TrieNode
			curr = curr.getChild(c);
			
			// increment size 
			curr.size++;
			
		}
		
		
		
		
		
		
	}
	
	public int find(String str)
	{
		TrieNode2 curr = root;
		
		// loop through the str
		for(int i=0; i<str.length(); i++)
		{	
			// extract the character 
			char c = str.charAt(i);
			
			// get the child of the character
			curr = curr.getChild(c);
			
			// return 0, if null 
			if(curr == null)
			{
				return 0;
			}
			
		}
		
		return curr.size;
		
	}
	
	

}





