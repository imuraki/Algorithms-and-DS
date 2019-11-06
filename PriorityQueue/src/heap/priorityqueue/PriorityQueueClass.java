package heap.priorityqueue;

import java.util.*;

public class PriorityQueueClass {
	
	public static void main(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, Collections.reverseOrder());
		
		pq.add(5);
		pq.add(2);
		pq.add(3);
		pq.add(10);
		pq.add(7);
		pq.add(1);
		
		while(pq.size() != 0)
			System.out.println(pq.remove());
	}

}
