/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparable;

import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList<TrafficCard> cardUsers = new ArrayList<TrafficCard>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }
        
        //Tehtävä 21: virtojen käyttö
        List<TrafficCard> sortedCardUsers = cardUsers.stream().sorted((o1, o2) -> (int) (o1.mBalance - o2.mBalance)).collect(Collectors.toList());
        
        //Tehtävä 20: Comparatorin käyttö
        //Collections.sort(cardUsers, new NameComparator());
        //ArrayList<TrafficCard> sortedCardUsers = cardUsers;
        
        Iterator itr = sortedCardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
    
}
