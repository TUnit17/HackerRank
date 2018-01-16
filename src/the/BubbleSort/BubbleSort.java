package the.BubbleSort;

import java.awt.print.Printable;
import java.lang.reflect.Array;

/*
 * ANALYSIS
 * ---------
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 * DATE: 
 * STATUS: not finished 
 * 
 * PROBLEM STATEMENT: sort the array in ascending order
 * 
 * INPUT
 * -----
 * 3
 * 3 2 1
 * 
 * OUTPUT
 * ------
 * Array is sorted in: 3 swaps 
 * First element: 1
 * Last element:  3
 * 
 * 
 * 1) What is bubble sort?
 * 
 * 2) When do you actually need bubble sort? 
 * 
 * 3) Is there ever problem where bubble sort is the ideal or right pick? 
 * 
 * 4) How does bubble sort work?
 * 
 * CASE 1: 3,2,1
 * 
 * {3,2,1} => {2,3,1} : swap i=0 with i=1
 * {2,3,1} => {2,1,3} : swap i=1 with i=2
 * {2,1,3} => {1,2,3} : swap i=0 with i=1
 * 
 * 
 * 5) When I am about to do the swap, how do I know where to place the numbers?
 * Do I want to swap the numbers or the index? 
 * 
 * 6) Why did I hit an array out-of-bounds exception? 
 * Whenever I am checking ahead, aka looking ahead, I need to make sure I do not go out-of-bounds
 * 
 * 7) In my bubble sort, I have 1 for-loop
 * This allows me to get 5 to the end
 * But the problem is that the rest of the elements are not in order
 * I think I need another for loop?
 * 
 * 8) How do I get the rest of the other elements in order? 
 * What happens if I just add another for loop? 
 * 
 * 9) Keep walking thru the array as a long as its unsorted
 * 
 * 10) How can you determine the array is unsorted? 
 * a) once you enter into the loop you assume that the array is sorted 
 * => isSorted = true
 * b) if you sort even once, there is a possibility that the array is now unsorted 
 * => isSorted = false 
 * 
 * 11) How can bubbleSort be optimized? 
 * a) each time you sort you know that the last element is in the correct position
 * a) each time you sort you know that the largest element is in the correct position at the end 
 * b) therefore, you do not need to check that last position
 * c) To stop checking that last position, you "decrease" the length of the array you scan thru 
 * 
 * 12) What is the Big-O of bubble sort?
 * 
 * 
 * 
 * 
 * 
 */
public class BubbleSort
{
	
	/*
	 * COMMENT: this method works but is not optimized
	 * sort the array in ascending order
	 * @ param arr: 	input array 
	 */
	public void bubbleSort(int[] arr)
	{
		boolean isSorted = false;
		int lastUnsorted = arr.length -1;
		// what this really means is while the array is unsorted 
		//while(arr[0] > arr[1])
		while(!isSorted )
		{
			isSorted = true;
			for(int i=0; i<arr.length-1; i++)  // arrays have length not size, since they are not objects 
			{ 
				if(arr[i] > arr[i+1])
				{
					swap(arr, i,i+1);
					isSorted = false;
				}
				
			}
			lastUnsorted--;
			
		}
		
		printArray(arr);
		
		
	}

	/*
	 * sort the array in ascending order with optimization
	 * optimization = shrinking the size of the array, since the last index is always the largest 
	 */
	public void bubbleSortOptimized(int[] arr)
	{
		// the number of swaps that have occured 
		int swapCount = 0;
		int optimizedLength = arr.length-1;
		boolean isSorted = false;
		
		while(!isSorted )
		{
			isSorted = true;
			for(int i=0; i<optimizedLength; i++)
			{
				if(arr[i] > arr[i+1])
				{
					swap(arr, i, i+1);
					isSorted = false;
					
					swapCount++;
				}
			}	
			optimizedLength--;
		}
		System.out.println("swapCount:"+ swapCount);
		printArray(arr);
		
		
		
	}
	
	
	private void printArray(int[] arr)
	{
		for(int i: arr)
		{
			System.out.print(i+ "");
		}
		
	}




	/*
	 * swap the values in the array  
	 * @param arr: array of integer
	 * @param i: index at position i
	 * @param j: index at position j
	 */
	private void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	
}
