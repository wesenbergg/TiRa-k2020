package btree;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author null
*/
public final class BenchMarkMain {
	
	private BenchMarkMain() {}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(final String[] args) {
		@SuppressWarnings("PMD.CloseResource")
		final Scanner lukija = new Scanner(System.in);
		@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
		final BinaryTree tree = new BinaryTree();
		String[] lista = new String[1_000_000];
		@SuppressWarnings("PMD.DataflowAnomalyAnalysis")
		final Random rand = new Random();
		
		for (int i = 0; i < lista.length; i++) {
			lista[i] = String.valueOf(rand.nextDouble());
		}
		System.out.println("Press ENTER to proceed.");
		lukija.nextLine();
		lukija.close();
		
		final long start = System.nanoTime();
		
		for (final String str : lista) {
			tree.insert(str);
		}
		final long elapsedTime = System.nanoTime() - start;
		
		System.out.println(elapsedTime);
	}
}