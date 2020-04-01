package test;

import main.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
 
// TÃ¤ssÃ¤ kÃ¤ytetÃ¤Ã¤n ParameterizedTest -annotaatiota
// Parametriparit taulukossa (comma separated values)
 
public class PinoTest {

	private Stack pino = new Stack();

	@BeforeEach
    public void clearStack() {
		pino.nollaa();
    }
	
	@Test
	@DisplayName("Testaa pinon korkeus lisäämisen jälkeen")
    public void testLisaa1() {
		String[] data = { "ensimmäinen", "toinen", "kolmas", "neljäs" };
		int tulos = data.length;
		
		for (String str : data) pino.push(str);
        
        assertEquals(tulos, pino.amount(), "Pinon korkeus väärin");
    }
	
	@Test
	@DisplayName("Testaa pinon päällimmäinen lisäämisen jälkeen")
    public void testLisaa2() {
		String[] data = { "ensimmäinen", "toinen", "kolmas", "neljäs" };
		String tulos = data[data.length - 1];
		
		for (String str : data) pino.push(str);
        
        assertEquals(tulos, pino.getTop(), "Pinon korkeus väärin");
    }
	
	@Test
	@DisplayName("Testaa poistaa pinosta pt.1")
    public void testPop1() {
		String[] data = { "ensimmäinen", "toinen", "kolmas", "neljäs" };
		String tulos = data[3];
		
		for (String str : data) pino.push(str);
        
        assertEquals(pino.pop(), tulos, "Pinon poistettu");
    }
	
	@Test
	@DisplayName("Testaa pinon korkeus poistamisen jälkeen")
    public void testPop2() {
		String[] data = { "ensimmäinen", "toinen", "kolmas", "neljäs" };
		int tulos;
		int popTimes = 2;
		
		for (String str : data) pino.push(str);
		tulos = pino.amount() - popTimes;
        pino.pop();
        pino.pop();
        
        assertEquals(pino.amount(), tulos, "Pinon poistettu");
    }
	
	@Test
	@DisplayName("Testaa poistaa tyhjästä pinosta")
    public void testPopTyhja() {
        assertEquals(pino.pop(), null, "Pinon poistettu");
    }
}