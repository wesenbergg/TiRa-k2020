import java.util.Scanner;

/**
 * Tehtävään on otettu mallia sivulta: https://mrtan.me/post/19.html .
 * @author Boriss
 *
 */

public class Main {
	/**
	 * Main.
	 * @param args default
	 */
    public static void main(final String[] args) {
    	Scanner lukija = new Scanner(System.in);
    	PostfixLaskin laskin = new PostfixLaskin();
    	String syote;
        String[] strArr;

        while (true) {
        	//Esimerkkisyöte "2 5 3 + *" tulostaa "16.0"
        	System.out.println("Anna syöte."
        	+ "Erottele luvut ja merkit välilyönnein.");
        	syote = lukija.nextLine();
        	if (syote.isEmpty()) {
        		break;
        	}
        	strArr = syote.split(" ");
        	System.out.println(laskin.calculate(strArr));
        }
        lukija.close();
    }
}
