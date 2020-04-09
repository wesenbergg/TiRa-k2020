package puolitushaku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.addAll(Arrays.asList(6, 7, 2, 9, 0, 5, 4, 3, 8, 10));
		Collections.sort(arr);
		int haettava = 2;
		System.out.println(haettava + " indeksi: " + intPuolitushaku(arr, haettava));
		
		ArrayList<String> nimiLista = new ArrayList<>();
		nimiLista.addAll(Arrays.asList("Hans", "Anssi", "Eemeli", "Guilmore", "Bea", "Fiona", "Caro", "Daniel"));
		Collections.sort(nimiLista);
		String haettavaNimi = "Eemeli";
		System.out.println(haettavaNimi + " indeksi: " + strPuolitushaku(nimiLista, haettavaNimi));
		
		nimiLista.add("Alexandra"); //Lisätään uusi alkio ja toistetaan tulostus
		Collections.sort(nimiLista);
		System.out.println(haettavaNimi + " indeksi: " + strPuolitushaku(nimiLista, haettavaNimi));
		
		int eiListallaOlevaLuku = -5;
		System.out.println(eiListallaOlevaLuku + " indeksi: " + intPuolitushaku(arr, eiListallaOlevaLuku));
	}
	
	//Palauttaa indeksin josta haettava arvo löytyy, palauttaa -1 jos arvoa ei löydy
	//REQUIREMENT: Taulukon arvot tulee olla suuruusjärjestyksessä pienemmästä suurimpaan.
	public static int intPuolitushaku(List<Integer> taulu, int haettava) {
		int vasen = 0;
		int oikea = taulu.size() - 1;
		do {
			int i = (oikea + vasen) / 2;
			if(taulu.get(i) == haettava)
				return i;
			if(taulu.get(i) > haettava)
				oikea = i;
			else
				vasen = i;
		} while(vasen < oikea);
		return -1;
	}
	
	public static int strPuolitushaku(List<String> taulu, String haettava) {
		int vasen = 0;
		int oikea = taulu.size() - 1;
		do {
			int i = (oikea + vasen) / 2;
			if(taulu.get(i).equals(haettava))
				return i;
			if(taulu.get(i).compareTo(haettava) > 0)
				oikea = i;
			else
				vasen = i;
		} while(vasen < oikea);
		return -1;
	}
}
