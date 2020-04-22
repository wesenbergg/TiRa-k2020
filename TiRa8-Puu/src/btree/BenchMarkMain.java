package btree;

import java.util.Random;
import java.util.Scanner;

public class BenchMarkMain {
	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		BinaryTree tree = new BinaryTree();
		String[] lista = new String[1000000];
		Random rand = new Random();
		
		for (int i = 0; i < lista.length; i++) {
			lista[i] = ""+rand.nextDouble();
		}
		
		System.out.println("Press ENTER to proceed.");
		lukija.nextLine();
		long start = System.nanoTime();
		
		for (String str : lista) {
			tree.insert(str);
		}
		long elapsedTime = System.nanoTime() - start;
		
		System.out.println(elapsedTime);
	}
}
