package the.RansomeNote;

import java.util.HashMap;
import java.util.Random;

public class RansomeNote
{
	public static void main(String[] args)
	{	
		
		String[] magazine = {"The", "black", "cat"}; 
		int magLength = magazine.length;
		
		String[] ransomeNote = {"The", "black", "cat", "cat"};
		int noteLength = ransomeNote.length;
		
		boolean answer= isRandomNote(magazine, ransomeNote);
		System.out.println(answer);
		
	}
	
	public static boolean isRandomNote(String[] magazine, String[] ransomeNote)
	{	
		HashMap<String, Integer> hmap = new HashMap<String, Integer>(); 
		
		int count = 0; 
		// put all the magazine Strings in a hmap
		for(String s: magazine)
		{
			if(hmap.containsKey(s))
			{
				count = hmap.get(s);
			}
			else count = 0; 
			hmap.put(s, count+1);
		}
		
		// remove all the ransomeNote strings from the hashtable 
		for(String r: ransomeNote)
		{
			
			if(hmap.containsKey(r))
			{
				hmap.replace(r, hmap.get(r)-1);
			}
			else
			{
				return false;
			}
			
		}
		
		// another for-loop to check the hmap for -1 in the value section 
		// loop through all the values for -1 
		for(Integer i: hmap.values())
		{
			if( i < 0) return false;
		}
		
		return true; 
	}
	
}
