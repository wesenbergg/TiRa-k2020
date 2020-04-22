package btree;

import java.util.TreeSet;

public class Menu {
	
	public static void main(String[] args) {
		char select;
		TreeSet<String> tree = new TreeSet<>();
		String data;
		
		do {
			System.out.println("\n1. Lisää avain.\n2. Etsi avaimella.\n3. Käy puu läpi esijärjestyksessä.\n4. Poista avaimella.\n5. Laske korkeus.\n6. Laske korkeus avaimella.\n7. lopetus");
			
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna uusi avain (merkkijono)");
				data = new String(Lue.rivi());
				tree.add(data);
				break;
			case '2':                           
				System.out.println("Anna etsittävä avain (merkkijono)");
				data = Lue.rivi();
				System.out.println(tree.contains(data) ? "Avain löytyi.": "Avainta ei löytynyt.");
				break;
			case '3':
				for (String str : tree) System.out.println(str);
				break;
			case '4':
				System.out.println("Anna poistettava avain (merkkijono)");
				data = Lue.rivi();
				System.out.println(tree.remove(data) ? "Avain poistettu": "Avainta ei löytyny");
				break;
			case '5':
				System.out.println("Korkeus: "); // TODO: IDK
				break;
			case '6':
				System.out.println("Anna silmukan avain (merkkijono)");
				data = Lue.rivi();
				System.out.println("Korkeus: " + tree.floor(data));
				break;
			}
		} while(select != '7');
	}
}