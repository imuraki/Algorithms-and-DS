package heap.priorityqueue;

import java.util.*;

public class PriorityQueueClass {
	
	public static void main(String[] argv){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10);
		PriorityQueue<Integer> pqmax = new PriorityQueue<Integer>(10, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		
		for(int i = 0; i < 100; i++){
			int data = new Random().nextInt(100)+1;
			pq.add(data);
			pqmax.add(data);
		}
		
		while(pq.size() != 0)
			System.out.println(pq.remove());
	}

}
