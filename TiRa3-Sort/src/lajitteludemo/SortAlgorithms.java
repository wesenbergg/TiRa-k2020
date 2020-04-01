/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lajitteludemo;

/**
 *
 * @author kamaj
 */
import java.util.Random;

	public class SortAlgorithms {
	    final static int MAX=60000;
	    static long laskuri = 0;
	
	    public static void main(String[] args) {
	        //selectSort();
	        //mergeSort();
			Pikalajittelu.quickSortLoop();
	    }
	
	    public static void selectSort() {
	        int[] taul = new int[MAX]; //taul tallettaa lajiteltavat tiedot
	        int i, j, k, apu, pienin;
	        Random r = new Random(); //luodaan satunnaislukugeneraattori
	        
	        System.out.println("Generoidaan syöttöaineisto: ");
	        for (i=0;i<MAX;i++) {
	            taul[i] = r.nextInt(1000); //generoidaan luvut
	            System.out.print(taul[i]+" ");
	            if (i>0 && i%40==0) // rivinvaihto
	                System.out.println();
	        }
	        
	        System.out.println("\nSuoritetaan valintalajittelu, paina Enter ");
	        Lue.merkki();
	        
	        for (i=0;i<MAX;i++) {
	            pienin=i;
	            for (j=i+1;j<MAX;j++) {
	                /* löytyykö taulukon loppupäästä pienempää alkiota? */
	                if (taul[j] < taul[pienin]) {
	                    pienin=j;
	                }
	                laskuri++;
	            }
	            if (pienin != i) {
	                /* jos löytyi suoritetaan alkioiden vaihto */
	            	apu=taul[pienin];
	            	taul[pienin]=taul[i];
	                taul[i]=apu;
	            }
	        }
	        
	        System.out.println();
	        for (i=0;i<MAX;i++) {
	            System.out.print(taul[i]+" ");
	            if (i>0 && i%40==0) // rivinvaihto
	                System.out.println();
	        }
	        
	        System.out.println("\nLaskuri: " + laskuri + "\nKuittaa tulos, paina Enter ");
	        Lue.merkki();
	    }
	
	    public static void mergeSort() {
	        int[] a= new int[MAX];
	        int i;
	        Random r = new Random(); //luodaan satunnaislukugeneraattori
	        laskuri = 0;
	        
	        System.out.println("\nGeneroidaan syöttöaineisto: ");
	        for (i=0;i<MAX;i++) {
	            a[i] = r.nextInt(1000); //generoidaan luvut
	            System.out.print(a[i]+" ");
	            
	            if (i>0 && i%40==0) System.out.println();// rivinvaihto
	        }
	        
	        System.out.println("\nSuoritetaan lomituslajittelu, paina Enter ");
	        Lue.merkki();
	
	        mergeSort(a, 0, MAX-1);
	        for (i=0;i<MAX;i++) {
	            System.out.print(a[i]+" ");
	            if (i>0 && i%40==0) System.out.println();// rivinvaihto
	        }
	        
	        System.out.println("\nLaskuri: " + laskuri);
	    }
	
	    private static int[] tau = new int[MAX]; // aputaulukko (ei varata tätä pinosta!)
	
	    //oletus: osataulukot t[p..q] ja t[q+1...r] ovat järjestyksess„
	    public static void merge(int t[], int p, int q, int r) {
	        //i osoittaa 1. osataulukkoa, j osoittaa 2. osataulukkoa
	        // k osoittaa aputaulukkoa, johon yhdiste kirjoitetaan.
	        int i=p, j=q+1, k=0;
	        while(i<q+1 && j<r+1) {
	        	laskuri++;
	        	if (t[i]<t[j]) {
	        		tau[k++]=t[i++];
	        	} else {
	        		tau[k++]=t[j++];
	        	}
	        }
	        
	        //toinen osataulukko käsitelty, siirretään toisen käsittelemättömät
	        while (i<q+1) tau[k++]=t[i++];
	        while (j<r+1) tau[k++]=t[j++];
	        
	        //siirretään yhdiste alkuperäiseen taulukkoon
	        for (i=0;i<k;i++) t[p+i]=tau[i];
	    }
	
	    public static void mergeSort(int t[],  int alku,  int loppu) {
	    	int ositus;
	    	long la, ll, lt;
	    	laskuri++;
	        if (alku<loppu) { //onko väh. 2 alkiota, että voidaan suorittaa ositus
	        	la=alku; ll=loppu;
	        	lt=(la+ll)/2;
	        	ositus=(int)lt;
	        	mergeSort(t, alku, ositus);//lajitellaan taulukon alkupää
	        	mergeSort(t, ositus+1, loppu);//lajitellaan taulukon loppupää
	        	merge(t, alku, ositus, loppu);//yhdistetään lajitellut osataulukot
	        }
	    }
	}

