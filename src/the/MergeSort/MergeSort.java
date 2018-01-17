package the.MergeSort;




/*
 * ANALYSIS
 * ---------------
 * 
 * You want to sort in ascending order 
 * 
 * CASE 1 : 
 * 2,4,1 => 2,1,4 => 1,2,4
 * 
 * FAQ
 * -----
 * 
 * 1) What is merge sort?
 * 
 * 2) How does merge sort work?
 * 
 * 3) Why is merge sort faster than bubble sort? 
 * 
 * 4) Why is merge sort so complex? 
 * 
 * 5) How do you sort the left-half and then the right-half?
 * 
 * 6) How do you know what the left-half is?
 * 
 * 7) Do need to find the middle?
 * 
 * 8) What if you have even numbers of numbers to be sorted?
 * 
 * 8.1) Do you put more in the left-half or right-half?
 *  3/2 = 1, 5/2 =2 (round-down for integer division) 
 * 
 * 8.2) If you have even numbers in the array, how do you specify the left and right side?
 * total numbers = 5
 * middle = 5/2 = 2
 * arrayLeft = (0,2) = (0, middle)
 * arrayRight = (3,5) = ( middle+1, array.length-1)
 * COMMENT: it is not (0, middle)   (middle, array.length-1) or else you will double count
 * 
 * 
 * 
 * 8) Why do you want the left-half and right-half in sorted order?
 * You just compare which one is smaller and you can place it in your new sorted array
 * You are merging the two halfs together 
 * 
 * 9) What is the main idea?
 * mergeSort(array)
 * {
 * 		left  = sortLeft(array's left half)
 * 		right = sortRight(array's right half)
 * 		mergeSort left and right
 * }
 * 
 * 
 * 10) Why is the run-time n*log(n)?
 * 
 * 11) What are the different algorithm run-times?
 * n*log(n)
 * log(n)
 * n^2
 * 
 * 12) Which run-time is faster? 
 * 
 * 13) What happens when mergeHalves is called? 
 * 
 * 14) What am I trying to do when mergeHalves is called? 
 * 
 * 15) I need to put the next merged elements into a new array
 * So rather than create a new array each time, 
 * I just create the new array once and use it each time,
 * It will be a parameter that is passed in! 
 * 
 * 16) Why do I need 3 index variables for moveHalves()? 
 * index: for scanning the temp array
 * left: for scanning the left-half of the original-half-sorted array
 * right: for scanning the right-half of the original-half-sorted array
 * 
 * 
 * 17) What happens if you go out of bounds? 
 * 
 * 
 * 
 * 
 * 
 */
public class MergeSort
{
  
	
	public static void main(String[] args)
	{
		
	}
	
	
	public static void mergeSort(int[] array)
	{
		// helper method 
		// mergeSort(array, left, right)
		mergeSort(array, new int[array.length], 0,array.length-1);
		
	}


	private static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd)
	{
		// if out-of-bounds
		if(leftStart >= rightEnd)
			return;
		
		int middle = (leftStart+rightEnd)/2;
		
		//left-half
		mergeSort(array, temp,leftStart, middle);
		
		//right-half
		mergeSort(array, temp, middle+1, array.length-1);
		
		//merge arrays
		mergeHalves(array, temp,leftStart, rightEnd);
		
	}


	private static void mergeHalves(int[] array, int[] temp,int leftStart, int rightEnd)
	{
		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd-leftStart+1;
		
		// left index
		int left = leftStart;
		// right index
		int right = rightStart;
		// index for temporary array
		// initialized to start
		int index = leftStart;
		
		// while I am still inbounds 
		while(left <= leftEnd && right <= rightEnd )
		{
		
			if(array[left] <= array[right])
			{
				temp[index] = array[left];
				left++;
			}
			
			else
			{
				temp[index] = array[right];
				right++;
			}
			index++;
		}
		
		// copy the remaining elements
		System.arraycopy(array, left, temp, index, leftEnd-left +1); // either left or right point is at end, so only one of these lines will have an effect
		System.arraycopy(array, right, temp, index, rightEnd-right +1);
		
		// copying everything back to the original array
		System.arraycopy(temp,leftStart, array, leftStart, size);
		
		
	}
	 
	
	
	
	
	
	
}
