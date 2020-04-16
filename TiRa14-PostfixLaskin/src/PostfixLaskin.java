import java.util.Stack;

public class PostfixLaskin {
	
	public double calculate(String[] strArr) {
        Stack<Double> pino = new Stack<Double>();
        pino.add(0.0); //Handle empty stack exceptionin.

        for(String str : strArr) {
            if (str.trim().isEmpty()) continue;
            
            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                	double vasen = pino.pop(); //Ottaa pinon kaksi päällimmäistä lukua
                    double oikea = pino.pop();
  
                    double tulos = 0;
                    switch(str) {
                        case "+":
                        	tulos = vasen + oikea;
                            break;
                        case "-":
                            tulos = vasen - oikea;
                            break;
                        case "*":
                            tulos = vasen * oikea;
                            break;
                        case "/":
                            try {
                            	if(oikea == 0) throw new ArithmeticException();
                            } catch (ArithmeticException e) {
                            	System.out.println("Nollalla jako ei onnistu");
                            	return 0;
                            }
                            tulos = vasen / oikea;
                            break;
                        default:
                            break;
                    }
                    System.out.println("Operaattori '" + str + "'\nPinosta poistetut: " + vasen + " ja " + oikea + ". Tilalle lisätty " + tulos); //Pinon päivitys tulostus
                    pino.push(tulos);
                    break;
                default:
                    try {
                    	pino.push(Double.parseDouble(str));
                    	System.out.println("Pinoon lisätty luku: " + str); //Pinon päivitys tulostus
                    }catch(Exception e) {System.out.println(str + " is not a number."); }
                    break;  
            }
        }
        
        return pino.pop();	//Palautetaan pinon päällimmäinen luku esimerkiksi syötteellä "8 10 2 3 5 4 + *" pinon lopputulos on "8 10 2 27".
        					//Jämä luvut jää lillumaan, koska ne ovat ns virhesyöttöä.
    }
}
