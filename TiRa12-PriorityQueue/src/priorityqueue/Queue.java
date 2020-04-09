package priorityqueue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * TESTI
 *  * TESTI
 *   * TESTI
 *    * TESTI
 *     * TESTI
 *      * TESTI
 *       * TESTI
 *        * TESTI * TESTI
 *         * TESTI
 *         V
 *         V
 *          * TESTI
 *           * TESTI
 *            * TESTIV
 *             * TESTI
 * @author Boriss
 *
 */
public class Queue {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(12);
		pq.add(8);
		pq.add(17);
		pq.add(44);
		pq.add(30);
		pq.add(1);

		for (Integer integer : pq) System.out.println(integer);
		
		System.out.println("\nLisää joku luku: ");
		pq.add(lukija.nextInt());
		for (Integer integer : pq) System.out.println(integer);
		System.out.println();
		
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			System.out.println(pq.remove());
		}
	}
}