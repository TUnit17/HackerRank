package the.IceCreamParlor;

import java.util.function.IntPredicate;

/*
 *  ANALYSIS
 *  --------
 * 
 *  PROBLEM STATEMENT
 *  ------------------
 *  Given the value of money and cost of each flavor, help Sunny and Johnny choose 
 *  two distinct flavors
 * 
 *  
 *  INPUT
 *  -----
 *  2          : number of trips 
 *  4          : money
 *  5          : number of integers
 *  1 4 5 3 2  : n space-separated integers (the cost) 
 *  4
 *  4
 *  2 2 4 3
 *  
 *  OUTPUT
 *  ------
 *  1 4        : ID numbers for the two distinct flavors, where the smaller ID is printed first (range from 1 to flavors)
 *  			   : Flavor IDs 1 & 4 have a total cost of 1+3 = 4 
 *  
 *  1 2        : Flavor IDs 1&2 have a total cost of 2+2=4
 *  
 *  
 *  FAQ
 *  -----
 *  
 *  1) What data structure should I use?
 *  
 *  2) How is this related to binary search?
 *  
 *  3) Should I put the costs into an array or hashtable? 
 *  
 *  4) What is the difference between a hashtable and hashmap? 
 *  
 *  5) How does binary search work?
 *  You cut the array in half
 *  You need to sort the array
 *  But once you sort you do not have the ID?
 *  
 *  6) How fast is binary search? 
 *   n => n/2 => n/4 ... 1             O(log n) 
 *   
 *  7) Why do I want to use Binary Search?
 *  What am I searching for?
 *  Give the first number: $4-first number = x, find x in the array? 
 *  
 *  8) See if I put all these numbers into a hashtable, I feel like I don't need to use binary search 
 *  I will get really fast retrival times 
 *   
 *   
 */
public class IceCreamParlor
{

	
	public boolean binarySearchRecursiveHelper(int[] array, int x, int left, int right)
	{
		// if out-of-bounds 
		if(left > right)
		{
			return false;
		}
		
		
		
		//int mid = (left+right)/2;
		// left + right can actually integer overflow in java
		int mid = left + ((right-left)/2);
		
		if(array[mid] == x)
			return true;
		// go left
		else if( x <array[mid]) 
		{
			return binarySearchRecursiveHelper(array, x, left, mid-1);
		}
		
		// go right
		else 
		{
			return binarySearchRecursiveHelper(array, x, mid+1, right);
		}
		
			
	}
	
	public boolean binarySearchRecursive(int[] array, int x)
	{
		int left = 0;
		int right = array.length-1;
		return binarySearchRecursiveHelper(array, x, left, right);
	}
	
	
	public boolean binarySearchIteritive(int[] array, int x)
	{
		
		int left = 0;
		int right  = array.length-1;
		
		while(left <=right)
		{
			int mid = (left+right)/2;
			
			if(array[mid] == x)
			{
				return true;
			}
			// go left
			else if (x < array[mid])
			{
				right = mid-1;
			}
			// go right 
			else 
			{
				left = mid+1;
			}
		}
		return false;
		
	}
	
	
	
}
