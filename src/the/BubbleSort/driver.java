package the.BubbleSort;

public class driver
{

	public static void main(String[] args)
	{
		
		BubbleSort bubbleSort = new BubbleSort();
		int[]arr = {1,4,3,2,1};
		
		bubbleSort.bubbleSort(arr);
		System.out.println("");
		bubbleSort.bubbleSortOptimized(arr);
		
	}
	
}
