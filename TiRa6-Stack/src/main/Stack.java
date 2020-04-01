package main;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Stack {
	
	private LinkedList<String> list;
	
	public Stack() {
		list = new LinkedList<String>();
	}
	
	//Tätä funktiota käytetään vain yksikkötesteissä, tarkistamaan päällimäinen alkio
	public String getTop() {
		return list.getFirst();
	}
	
	// luo lista-alkio, vie se pinon huipulle
	public void push(String aData) {
		list.addFirst(aData);
	}

	//1: Päivitä linkki 2: Palauta poistettu alkio
	public String pop() {
		try{ return list.pop(); } catch (NoSuchElementException e) { }
		return null;
	}
	
	public int amount() {
		return list.size();
	}
	
	// operaatio, joka tulostaa pinon sisällön
	public void printItems() {
		ListIterator<String> iterator = list.listIterator();
		int i = 0;
		while(iterator.hasNext()) System.out.println(++i + ": " + iterator.next());
	}
	
	//Tätä funktiota käytetään vain yksikkötesteissä pinon alustamisessa
	public void nollaa() {
		list.clear();
	}
}