package main;


public class Main {
	
	public static void main(String[] args) {
		printMenu();
	}
	
	
	private static void printMenu() {
        char select;
        Stack s = new Stack(); // pino-olio
        String data; // Pinon data-kenttä
        do {
            System.out.println(	"1. Alkion lisääminen.\n2. Alkion poistaminen.\n3. Pinon sisältö.\n4. Alkioiden lukumäärä.\n5. lopetus" );
            
            select = Lue.merkki();
            switch (select) {
            case '1':
                System.out.println("Anna alkion sisältö (merkkijono)");
                data = new String(Lue.rivi());
                s.push(data);
                break;
            case '2':
                String item = s.pop();
                System.out.println((item == null) ? "Pino on tyhjä": "Poistettu alkio: "+item);
                break;
            case '3':
                s.printItems();
                break;
            case '4':
                System.out.println("Lukumäärä = "+s.amount());
                break;
            }
        } while (select != '5');
	}
}