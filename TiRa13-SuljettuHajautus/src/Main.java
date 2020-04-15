import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner lukija = new Scanner(System.in);
		
		System.out.println("Anna hajautuslistan koko");
		SuljettuHajautus sh = new SuljettuHajautus(lukija.nextInt());
		
		char syote;
		do {
			int indeksi;
			
			System.out.println("0: Lopeta\n1: Lisää jäsen\n2: Hae yksittainen jasen\n3: Poista luku yksittäinen jäsen\n4: Tulosta sisältö\n5: Poista sisältö\n");
			syote = lukija.next().charAt(0);
			switch (syote) {
			case '1':
				System.out.println("Anna lisättävän indeksi.");
				indeksi = lukija.nextInt();
				System.out.println("Anna sisältö.");
				sh.lisaa(indeksi, lukija.next());
				break;
			case '2':
				System.out.println("Anna haettavan indeksi.");
				indeksi = lukija.nextInt();
				System.out.println(sh.haeJasen(indeksi));
				break;
			case '3':
				System.out.println("Anna poistettavan indeksi.");
				indeksi = lukija.nextInt();
				System.out.println(sh.poistaJasen(indeksi));
				break;
			case '4':
				sh.tulostaSisalto();
				break;
			case '5':
				sh.poistaSisalto();
				System.out.println("Sisältö tyhjennetty.");
				break;
			}
		} while (syote != '0');
		
		lukija.close();
	}
/**Testailua
	public static void main(String[] args) {
		SuljettuHajautus sh = new SuljettuHajautus(5);
		sh.lisaa(1, "asd");
		sh.lisaa(1, "dasd");
		sh.lisaa(1, "dasdd");
		sh.lisaa(1, "dasddd");
		sh.lisaa(1, "dasddddd");
		sh.lisaa(1, "dasd");
		
		sh.tulostaSisalto();
	}*/
}
