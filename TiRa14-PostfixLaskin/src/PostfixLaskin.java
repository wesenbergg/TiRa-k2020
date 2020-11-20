import java.util.Stack;

public class PostfixLaskin {
	/**
	*
	* @param strArr
	* @return double
	*/
	public double calculate(final String[] strArr) {
        Stack<Double> pino = new Stack<Double>();
        pino.add(0.0); //Handle empty stack exceptionin.

        for (String str : strArr) {
            if (str.trim().isEmpty()) {
            	continue;
            }

            switch (str) {
                case "+":
                case "-":
                case "*":
                case "/":
                	//Ottaa pinon kaksi päällimmäistä lukua
                	double vasen = pino.pop();
                    double oikea = pino.pop();
                    double tulos = 0;
                    switch (str) {
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
                            	if (oikea == 0) {
                            		throw new ArithmeticException();
                            	}
                            } catch (ArithmeticException e) {
                            	System.out.println("Nollalla jako ei onnistu");
                            	return 0;
                            }
                            tulos = vasen / oikea;
                            break;
                        default:
                            break;
                    }
                    //Pinon päivitys tulostus
                    System.out.println("Operaattori '" + str
                    		+ "'\nPinosta poistetut: " + vasen + " ja "
                    		+ oikea + ". Tilalle lisätty " + tulos);
                    pino.push(tulos);
                    break;
                default:
                    try {
                    	pino.push(Double.parseDouble(str));
                    	//Pinon päivitys tulostus
                    	System.out.println("Pinoon lisätty luku: " + str);
                    } catch (Exception e) {
                    	System.out.println(str + " is not a number.");
                    }
                    break;
            }
        }
        //Palautetaan pinon päällimmäinen luku esimerkiksi syötteellä
        //"8 10 2 3 5 4 + *" pinon lopputulos on "8 10 2 27".
        //Jämäluvut jää lillumaan, koska ne ovat ns virhesyöttöä.
        return pino.pop();
    }
}
