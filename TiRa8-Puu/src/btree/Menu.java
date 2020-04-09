package btree;

public class Menu {
	
	public static void main(String[] args) {
		char select;
		BinaryTree tree = new BinaryTree();
		String data;
		
		do {
			System.out.println("\n1. Lisää avain.\n2. Etsi avaimella.\n3. Käy puu läpi esijärjestyksessä.\n4. Poista avaimella.\n5. lopetus");
			
			select = Lue.merkki();
			switch (select) {
			case '1':
				System.out.println("Anna uusi avain (merkkijono)");
				data = new String(Lue.rivi());
				tree.insert(data);
				break;
			case '2':                           
				System.out.println("Anna etsittävä avain (merkkijono)");
				data = Lue.rivi();
				System.out.println((tree.find(data)!=null) ? "Avain löytyi.": "Avainta ei löytynyt.");
				break;
			case '3':
				tree.preOrder();
				break;
			case '4':
				System.out.println("Anna poistettava avain (merkkijono)");
				data = Lue.rivi();
				tree.deleteNode(data);
				System.out.println("Puu avaimen poiston jälkeen:");
				tree.preOrder();
			}
		} while(select != '5');
	}
}