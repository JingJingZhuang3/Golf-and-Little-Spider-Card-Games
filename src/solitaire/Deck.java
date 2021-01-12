package solitaire;

import java.util.ArrayList;
import java.util.Collections;

/***
 * 
 * @author Zayed Ahmed
 * @author JingJing Zhuang
 * @author Mengyang Qiu 
 * @author Jeffrey Chen
 * @author Montana Lee
 * 
 * CSE116 Fall 2018  
 *
 */


public class Deck {
	
	private ArrayList<String> deckOfCards;
	private ArrayList<String> Hearts;
	private ArrayList<String> Clubs;
	private ArrayList<String> Spades;
	private ArrayList<String> Diamond;
	private ArrayList<String> Rank;
	
	public Deck(){
		
		deckOfCards=new ArrayList<String>();
		Diamond=create("d");
		Spades=create("s");
		Clubs=create("c");
		Hearts=create("h");
		deckOfCards.addAll(Diamond);
		deckOfCards.addAll(Spades);
		deckOfCards.addAll(Clubs);
		deckOfCards.addAll(Hearts);
		Collections.shuffle(deckOfCards);
		Rank = createRank();
		
	}
	
	public ArrayList<String> createRank(){
		ArrayList<String> listOfCards = new ArrayList<>();
		
		for(int i=1;i<14;i++) {
			if(i==1) {
				listOfCards.add("a");				
			}
			else if(i==10) {
				listOfCards.add("t");
			}
			else if(i==11) {
				listOfCards.add("j");
			}
			else if(i==12) {
				listOfCards.add("q");
			}
			else if(i==13) {
				listOfCards.add("k");
			}
			else
				listOfCards.add(Integer.toString(i));
		}	
		return listOfCards;
	}
	
	
	public ArrayList<String> create(String suit){
		ArrayList<String> listOfCards = new ArrayList<>();
		
		for(int i=1;i<14;i++) {
			if(i==1) {
				listOfCards.add("a" + suit);				
			}
			else if(i==10) {
				listOfCards.add("t" + suit);
			}
			else if(i==11) {
				listOfCards.add("j"+suit);
			}
			else if(i==12) {
				listOfCards.add("q"+suit);
			}
			else if(i==13) {
				listOfCards.add("k"+suit);
			}
			else
				listOfCards.add(Integer.toString(i) +suit);
		}
		
		return listOfCards;
	}
	

	
	public ArrayList<String> getHearts() {
		return Hearts;
	}

	public ArrayList<String> getClubs() {
		return Clubs;
	}

	public ArrayList<String> getSpades() {
		return Spades;
	}

	public ArrayList<String> getDiamond() {
		return Diamond;
	}

	public ArrayList<String> getdeckOfCards(){
		return deckOfCards;
	}
	
	public ArrayList<String> getRank(){
		return Rank;
	}

}