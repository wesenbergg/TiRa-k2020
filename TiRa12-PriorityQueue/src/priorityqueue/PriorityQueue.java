package priorityqueue;

import java.util.Scanner;

/**
 * https://www.java2novice.com/data-structures-in-java/queue/priority-queue/
 * @author Boriss
 *
 */
public class PriorityQueue {
	@SuppressWarnings("rawtypes")
    private Comparable[] pQueue;
    private int index;
     
    public PriorityQueue(int capacity){
        pQueue = new Comparable[capacity];
    }
     
    public void insert(Comparable item ){
        if(index == pQueue.length){
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element: "+item);
    }
     
    @SuppressWarnings("unchecked")
    public Comparable remove(){
        if(index == 0){
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority 
        for (int i=1; i<index; i++) { 
            if (pQueue[i].compareTo (pQueue[maxIndex]) < 0) { 
                maxIndex = i; 
            } 
        } 
        Comparable result = pQueue[maxIndex]; 
        System.out.println("removing: "+result);
        // move the last item into the empty slot 
        index--; 
        pQueue[maxIndex] = pQueue[index]; 
        return result;
    }
    
    public static void main(String a[]){
    	PriorityQueue pqi = new PriorityQueue(5);
    	Scanner lukija = new Scanner(System.in);
    	String data;
    	int valinta;
    	do {
    		System.out.println("1: Lisää alkio\n2. Poista pienin alkio.\n3. Poista kaikki alkiot\n4. Lopeta");
    		valinta = lukija.nextInt();
    		switch (valinta) {
			case 1:
				data = lukija.next();
				pqi.insert(data);
				break;
			case 2:
				pqi.remove();
			case 3:
				while(pqi.remove() != null);
			default:
				break;
			}
    	} while(valinta != 5);

    }
}
