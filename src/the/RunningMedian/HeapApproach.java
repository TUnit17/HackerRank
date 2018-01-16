package the.RunningMedian;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class HeapApproach
{

	private Queue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
	private Queue<Integer> high = new PriorityQueue<>();

	public void add(int number)
	{
		// which Queue is chosen?
		// all this is doing is balancing / alternating which Queue you are adding a number to 
		Queue<Integer> target = low.size() <= high.size() ? low : high;
		
		// why add to the target Queue?
		// ex. low.add(number);
		target.add(number);
		
		balance();
	}

	// What does balance do? 
	private void balance()
	{
		// check that low.peek() > high.peek()
		// but if its true, why poll and add it? it's already in the correct heap
		while (!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek())
		{
			Integer lowHead = low.poll();
			Integer highHead = high.poll();
			// low adds  highHead
			low.add(highHead); 
			// high adds lowHead
			high.add(lowHead);
		}
	}

	public double median()
	{
		if (low.isEmpty() && high.isEmpty())
		{
			throw new IllegalStateException("Heap is empty");
		} else
		{
			return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
		}
	}

}
