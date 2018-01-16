package the.ContactList;

/*
 * ANALYSIS
 * ---------- 
 * 
 * STATUS: working
 * DATE: 1-13-18
 * 
 * https://www.hackerrank.com/challenges/ctci-contacts/problem
 * 
 * Problem statement: It must count the number of contacts starting with partial and print the count on a new line.
 * 
 * 
 * FAQ
 * ----
 * 1) What is a Trie?
 * hashmap with 
 * key:   character
 * value: TrieNode
 * 
 * a series of connected TrieNodes 
 * 
 * 
 * 3) How is a Trie a tree?
 * -there is a root
 * -the TrieNodes are connected, the reference of the next TrieNode is stored in a hashmap
 * 
 * 4) When I insert letters, where does it go in the Trie?
 * -letters get put in the TrieNode, which get put in the hashmap
 * 
 * 5) How do you get letters to branch off? 
 * -each subsequent letter in a string when added, forms a "branch" (not a real term, just used for visualizing the Trie as a tree) 
 * 
 * 6) How do you implement a Trie?
 * 
 * 7) How do you search letters? 
 * -the find method starts are the root TrieNode 
 * 
 * 8) Each letter is a node
 * 
 * 9) How do the nodes connect?
 * 
 * 10) How do you know what is next or left or right?
 * How do you know what the next letter is?  
 * 
 * 11) Why is a hashmap used?
 * key:		Character
 * value:	TrieNode
 * 
 * 12) How does it know what is next? 
 * specified in the hashmap
 * 
 * 13) How is "qwe" and "qwert" put in the Trie data structure? 
 * 
 * 13.1) What is the relationship between "q" and "w"?
 * 
 * 13.2) How does "q" know about "w"? How does "q" know that "w" is it's child?
 * 
 * 14) How do I create my own Trie data-structure?
 * 
 * 15) Since Trie is a not a Java data-structure, is it just a concept that I implement? 
 * YES
 * 
 * 16) What is the difference between a Trie and a Hashmap?
 * a Trie is composed of TrieNodes, which linked/referenced by hashmaps
 * 
 * 17) What is the difference between a hashmap and a hashtable? 
 * 
 * 17.1) When do you use a hashmap vs a hashtable? 
 * 
 * 18) The TrieNode class is just putting stuff in a hashmap
 * 
 * 20) Each node is just a hashmap and a size .
 * 
 * 22) How many characters can be inside a TrieNode?
 * In a TrieNode there is just 1 character
 * But if the TrieNode is the root, there is more than 1 character (there is more than 1 character in the hashmap) 
 * 
 * 23) Is it just always one character inside a TrieNode? 
 * 
 * 24) In a TrieNode, I think there should be 2 properties
 * the char itself and the children
 * 
 * 25) What is the char itself in the TrieNode?
 * 
 * 26) What is size used for? 
 * -used to track the number of duplicate letters
 *  
 * 27) Why does size need to be increased?
 * -incremented when there are duplicate letters
 * 
 * CASE:
 * 4
 * add question
 * add quest
 * add quester
 * find qu
 * 
 * return value = 3
 * 
 * COMMENT: 
 * add question
 * q
 * size =1
 * 
 * add quest
 * q
 * size = 2
 * 
 * add quester
 * q
 * size =3
 * 
 * 
 *  27.1) What is size initialized to? 
 *  size is initialized to 0
 * 
 * 28) When are TrieNodes created? 
 * 
 * 29) How many TrieNodes do I need?
 * 
 * 30) In 1 TrieNode, does it contain all the letters in the hashtable?
 * 
 * 31) How do I add subsequent letters?
 * 
 * 32) What does the hashmap contain?
 * What is the key	  : Character
 * What is the value   : TrieNode 
 * 
 * 33) What does this mean for a hashmap? 
 * For a certain Character, there is another TrieNode associated with it 
 *  
 * 34) How do you extract the TrieNode for a certain character?
 * getChild() method 
 * 
 * 35) What happens when you call the add method? 
 * 
 * 36) What is in a hashmap?
 * 1 character
 * a reference to a new node 
 * COMMENT: this means "q" will have exactly 1 node reference to it 
 * 
 * 37) What happens when you are about to enter another "q", another letter that already exists?
 * I think it searches for the existing "q"
 *  
 *  
 *  38) How do duplicate letters get added?
 *  
 *  Case 1: qquit
 *  COMMENT: start at q, then make a new TrieNode as its child, inside the new TrieNode is another q
 *  Case 2: quiqt
 *  
 *  Case 3: quiit
 *  
 *  Case 4: quiti
 *  
 *  Case 5: ppuiti
 *  COMMENT: since there is not an existing "p" in the root, make a new "p" TrieNode 
 *  
 *  39) What is putIfAbsent?
 *  If the specified key is not already associated with a value (or is mapped to null) 
 *  associates it with the given value and returns null,
 *   else returns the current value.
 *  
 *  40) How do I add another string with duplicate letters? 
 *  When you call add, you are adding to the same root 
 *  
 *  41) What does it look like if the root is different? 
 *  What is at the root? 
 *  At the root is a TrieNode, this TrieNode contains a hashmap
 *  The hashmap contains letters and TrieNodes 
 *  
 *  42) How can a hashmap contain more than 1 character? 
 *  There is a difference between:
 *  adding a new string: curr.putChildIfAbsent(ch)
 *  adding characters in the existing string: curr = curr.getChild(ch)
 *  
 *  
 *  43) How does the find(String str) method word?
 *  Starting at the root TrieNode
 *  get the TrieNode with the character 
 *  
 *  44) How do you determine the number of prefixes that are the same? 
 *  
 *  Case:
 *  ------
 *  4
 *  add question
 *  add quest
 *  add quester
 *  find qu
 *  
 *  COMMENT:
 *  get the TrieNode of "q"
 *  now starting at the TrieNode of "q", get the TrieNode of "u"
 *  return u's size = 3 
 *  
 *  
 *  COMMENT: 
 *  q --> u 
 *  u: size = 3
 *  return u's size = 3
 *  
 *  
 */


import java.util.Scanner;
import java.util.HashMap;

public class Tries
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Trie trie = new Trie();
		for (int i = 0; i < n; i++)
		{
			String operation = scan.next();
			String contact = scan.next();
			if (operation.equals("add"))
			{
				trie.add(contact);
			} else if (operation.equals("find"))
			{
				System.out.println(trie.find(contact));
			}
		}
		scan.close();
	}
}

/* Based loosely on tutorial video in this problem */
class TrieNode
{
	private HashMap<Character, TrieNode> children = new HashMap<>();
	public int size;

	// insert a character and a new TrieNode into the hashmap
	public void putChildIfAbsent(char ch)
	{
		children.putIfAbsent(ch, new TrieNode());
	}

	// @return the TrieNode for that character 
	public TrieNode getChild(char ch)
	{
		return children.get(ch);
	}
}

class Trie
{
	// What does root mean?
	// just the name of a TrieNode 
	TrieNode root = new TrieNode();

	Trie()
	{
	} // default constructor

	
	// why is this constructor needed?
	Trie(String[] words)
	{
		for (String word : words)
		{
			add(word);
		}
	}

	
	/*
	 * add a string, character-by-character to the Trie structure
	 * @ param str:		the string to be entered into the Trie structure   
	 */
	public void add(String str)
	{
		
		// curr is not a new TrieNode
		// curr is a reference to an existing TrieNode, root
		TrieNode curr = root;
		
		// loop through the entire string
		for (int i = 0; i < str.length(); i++)
		{
			// extract the letter at an index
			Character ch = str.charAt(i);
			
			// if the letter is not in the hashmap, put it in the hashmap
			// when you put the character in the hashmap, what about the new TrieNode?
			// the new TrieNode is automatically specified 
			curr.putChildIfAbsent(ch);
			
			// set the current TrieNode to the next TrieNode
			curr = curr.getChild(ch);
			
			// increment the size
			// so that each time you enter (for duplicate letters) the size is increased 
			curr.size++;
		}
	}

	
	
	/*
	 * start at the root node and find the number of strings with the prefix
	 * @return the number of strings found containing
	 * @param prefix: 	the prefix to be found 
	 * 
	 */
	public int find(String prefix)
	{
		TrieNode curr = root;

		/* Traverse down tree to end of our prefix */
		for (int i = 0; i < prefix.length(); i++)
		{
			// ch = "q"
			Character ch = prefix.charAt(i);
			
			// curr = root.getChild(q)
			// get the TrieNode of q
			curr = curr.getChild(ch);
			
			if (curr == null)
			{
				return 0;
			}
		}
		return curr.size;
	}
}
