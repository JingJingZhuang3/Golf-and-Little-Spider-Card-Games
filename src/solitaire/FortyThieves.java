package solitaire;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


import javax.swing.ImageIcon;
import javax.swing.JLabel;


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

public class FortyThieves {
	
	
	private ArrayList<String>twoNames;
	private ArrayList<String>cStock;

	//tableau piles
	private ArrayList<String> t1;
	private ArrayList<String> t2;
	private ArrayList<String> t3;
	private ArrayList<String> t4;
	private ArrayList<String> t5;
	private ArrayList<String> t6;
	private ArrayList<String> t7;
	private ArrayList<String> t8;
	private ArrayList<String> t9;
	private ArrayList<String> t10;
	private ArrayList<String> t11;
	private ArrayList<String> t12;
	private ArrayList<String> t13;
	//homecell piles
	private ArrayList<String> h1;
	private ArrayList<String> h2;
	private ArrayList<String> h3;
	private ArrayList<String> h4;
	private ArrayList<String> h5;
	private ArrayList<String> h6;
	private ArrayList<String> h7;
	private ArrayList<String> h8;
	//decks
	private ArrayList<String> deck1;
	private ArrayList<String> deck2;
	private ArrayList<String> deck;
	//stack pile
	private ArrayList<String> stock;
	//waste pile
	private ArrayList<String> waste;
	//rank list
//	private ArrayList<String> rank1;
//	private ArrayList<String> rank2;
	private ArrayList<String> rank;
	
	private ArrayList<Observer> _observers;	
	
	public FortyThieves() {
		
		//initialize variables
		t1 = new ArrayList<String>();
		t2 = new ArrayList<String>();
		t3 = new ArrayList<String>();
		t4 = new ArrayList<String>();
		t5 = new ArrayList<String>();
		t6 = new ArrayList<String>();
		t7 = new ArrayList<String>();
		t8 = new ArrayList<String>();
		t9 = new ArrayList<String>();
		t10 = new ArrayList<String>();
		t11 = new ArrayList<String>();
		t12 = new ArrayList<String>();
		t13 = new ArrayList<String>();
		h1 = new ArrayList<String>();
		h2 = new ArrayList<String>();
		h3 = new ArrayList<String>();
		h4 = new ArrayList<String>();
		h5 = new ArrayList<String>();
		h6 = new ArrayList<String>();
		h7 = new ArrayList<String>();
		h8 = new ArrayList<String>();
		deck1 = new ArrayList<String>();
		deck2 = new ArrayList<String>();
		deck = new ArrayList<String>();
		stock = new ArrayList<String>();
		waste = new ArrayList<String>();
//		rank1 = new ArrayList<String>();
//		rank2 = new ArrayList<String>();
		rank = new ArrayList<String>();
		twoNames = new ArrayList<String>();
		cStock = new ArrayList<String>();
		
		_observers = new ArrayList<Observer>();
		
	//deck creation and rank creation
	Deck x1 = new Deck();
//	x1.createRank();
//	this.rank1 = x1.getRank();
	deck1 = x1.getdeckOfCards();
	rank=new ArrayList<String>();
	rank=x1.getRank();
	Deck x2 = new Deck();
//	x2.createRank();
//	this.rank2 = x2.getRank();
	deck2 = x2.getdeckOfCards();
	
	//these two for loops add the two decks together to a single deck
	/*for(String s : deck2) {
		deck.add(s);
	}
	
	for(String a : deck1) {
			deck.add(a);
	}*/
	
	for(int i=0;i<52;i++) {
		
		deck.add(deck1.get(i));
		deck.add(deck2.get(i));
	}
	
	Collections.shuffle(deck);
	//these two for loops add the two separate rank lists together
//	for(String r : rank2) {
//		rank.add(r);
//	}
//	
//	for(String t : rank1) {
//		rank.add(t);
//	}
	
	//distribute aces to the 8 homecell piles
	for(String b : deck) {
		if(b.equals("ad") || b.equals("ah") || b.equals("ac") || b.equals("as")) {
			h1.add(b);
			deck.remove(b);
			break;		//Once it find the card and added to the homecell pile, end of loop.
		}
	}
	for(String c : deck) {
		if(c.equals("ad") || c.equals("ah") || c.equals("ac") || c.equals("as")) {
			h2.add(c);
			deck.remove(c);
			break;
		}
	} 
	for(String d : deck) {
		if(d.equals("ad") || d.equals("ah") || d.equals("ac") || d.equals("as")) {
			h3.add(d);
			deck.remove(d);
			break;
		}
	} 
	for(String e : deck) {
		if(e.equals("ad") || e.equals("ah") || e.equals("ac") || e.equals("as")) {
			h4.add(e);
			deck.remove(e);
			break;
		}
	}
	for(String f : deck) {
		if(f.equals("ad") || f.equals("ah") || f.equals("ac") || f.equals("as")) {
			h5.add(f);
			deck.remove(f);
			break;
		}
	}
	for(String g : deck) {
		if(g.equals("ad") || g.equals("ah") || g.equals("ac") || g.equals("as")) {
			h6.add(g);
			deck.remove(g);
			break;
		}
	}
	for(String h : deck) {
		if(h.equals("ad") || h.equals("ah") || h.equals("ac") || h.equals("as")) {
			h7.add(h);
			deck.remove(h);
			break;
		}
	}
	for(String j : deck) {
		if(j.equals("ad") || j.equals("ah") || j.equals("ac") || j.equals("as")) {
			h8.add(j);
			deck.remove(j);
			break;
		}
	}
	
	//distribute 3 cards to each of the 13 tableau piles, and the rest of the cards added into stock pile(remove deck is not needed)
	for(int i = 0; i < deck.size(); i++) {
		if(i<3)
			t1.add(deck.get(i));
		else if(i<6)
			t2.add(deck.get(i));
		else if(i<9)
			t3.add(deck.get(i));
		else if(i<12)
			t4.add(deck.get(i));
		else if(i<15)
			t5.add(deck.get(i));
		else if(i<18)
			t6.add(deck.get(i));
		else if(i<21)
			t7.add(deck.get(i));
		else if(i<24)
			t8.add(deck.get(i));
		else if(i<27)
			t9.add(deck.get(i));
		else if(i<30)
			t10.add(deck.get(i));
		else if(i<33)
			t11.add(deck.get(i));
		else if(i<36)
			t12.add(deck.get(i));
		else if(i<39)
			t13.add(deck.get(i));
		else
			stock.add(deck.get(i));
			
	}
	
	//waste pile is initially empty
}
	public boolean removeCardFromHomecell() {
		return false;
	}
	/**
	 * The removeCard method will check if the Tableau pile is empty first, if not 
	 * it will then remove the last card in the pile
	 */
	public boolean removeCardFromTableau(ArrayList<String> listToRemoveFrom) {
		if(cardRemovableFromTableau(listToRemoveFrom)) {
			listToRemoveFrom.remove(listToRemoveFrom.size()-1);
			return true;
		}
		return false;
	}
	
	//checks if it is legal to remove card from tableau
	public boolean cardRemovableFromTableau(ArrayList<String> listToRemoveFrom) {
		if(!listToRemoveFrom.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * The removeCard method will check if the stock pile is empty first, if not 
	 * it will then remove the last card in the pile
	 */
	public boolean removeCardFromStock(ArrayList<String> listToRemoveFrom) {
		if(cardRemovableFromStock(listToRemoveFrom)) {
			waste.add(listToRemoveFrom.get(listToRemoveFrom.size()-1));
			listToRemoveFrom.remove(listToRemoveFrom.size()-1);
			notifyObservers();
			return true;
		}
		return false;
	}
	
	//checks if it is legal to remove card from stock
	public boolean cardRemovableFromStock(ArrayList<String> listToRemoveFrom) {
		if(!listToRemoveFrom.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public boolean addToStock() {
		return false;
	}
	
	/**
	 * The removeCard method will check if the waste pile is empty first, if not 
	 * it will then remove the last card in the pile
	 */
	public boolean removeCardFromWaste(ArrayList<String> listToRemoveFrom) {
		if(cardRemovableFromWaste(listToRemoveFrom)) {
			listToRemoveFrom.remove(listToRemoveFrom.size()-1);
			return true;
		}return false;
	}
	
	//checks if it is legal to remove card from waste
	public boolean cardRemovableFromWaste(ArrayList<String> listToRemoveFrom) {
		if(!listToRemoveFrom.isEmpty()) {
			return true;
		}
		return false;
	}
	
	//checks to see if cards are stackable for tableaus according to 4T rules
	public boolean stackableForTableau(String lastCard, String newCard) {
		boolean result = false;
		String lastRank, newRank, Lsuit, Nsuit;
		lastRank = lastCard.substring(0, 1);
		newRank = newCard.substring(0,1);
		Lsuit = lastCard.substring(1,2);
		Nsuit = newCard.substring(1,2);
		int LRindex = rank.indexOf(lastRank);
		int NRindex = rank.indexOf(newRank);
		if(NRindex+1 == LRindex && Nsuit.equals(Lsuit)) {
			result = true;
		}
		return result;
		
	}
	
	//checks if adding that card to the tableau is legal,
	//and if it is, then adds it
	public boolean addToTableau(String cardToAdd,ArrayList<String> listToAddTo) {
		if(listToAddTo.isEmpty()) {
			listToAddTo.add(cardToAdd);
			return true;
		}
		if(stackableForTableau(listToAddTo.get(listToAddTo.size()-1),cardToAdd)){
			listToAddTo.add(cardToAdd);
			return true;
		}
		return false;
	}
	
	//checks to see if cards are stackable for homecells according to 4T rules
	public boolean stackableForHomecell(String lastCard, String newCard) {
		boolean result = false;
//		String cardrank = cardToAdd.substring(0,1);
//		String recipientrank = cardAddedTo.substring(0,1);
//		int cardRankIndex = rank.indexOf(cardrank);
//		int recipientRankIndex = rank.indexOf(recipientrank);
//		String cardsuit = cardToAdd.substring(1,2);
//		String recipientsuit = cardAddedTo.substring(1,2);
//		
//		if(recipientsuit != cardsuit) {
//			return result;
//		}
//		
//		if(cardRankIndex == recipientRankIndex && recipientsuit == cardsuit) {
//			result = true;
//			return result;
//		}
//		else {
//			return result;
//		}
		String lastRank, newRank, Lsuit, Nsuit;
		lastRank = lastCard.substring(0, 1);
		newRank = newCard.substring(0,1);
		Lsuit = lastCard.substring(1,2);
		Nsuit = newCard.substring(1,2);
		int LRindex = rank.indexOf(lastRank);
		int NRindex = rank.indexOf(newRank);
		if(NRindex == LRindex+1 && Nsuit.equals(Lsuit)) {
			result = true;
		}
		
		return result;
	}
	
	//checks if adding that card to the homecell is legal,
	//and if it is, then adds it
	public boolean addToHomecell(String cardToAdd,ArrayList<String> listToAddTo) {
		if(stackableForHomecell(listToAddTo.get(listToAddTo.size()-1), cardToAdd)){
			listToAddTo.add(cardToAdd);
			return true;
		}
		return false;
	}
	
	
	public boolean XtoHomecell(ArrayList<String> x, ArrayList<String> h) {
		if(x.size()>0) {
			String xcard = x.get(x.size()-1);
		String hcard = h.get(h.size()-1);
		if(stackableForHomecell(hcard,xcard)) {
			h.add(xcard);
			x.remove(x.size()-1);
			notifyObservers();
			return true;
			
		}else {
			return false;
		}
		}else {
			return false;
		}
		
	}
	
	public boolean XtoTable(ArrayList<String> x, ArrayList<String> t) {
		if(x.size()>0) {
			String xcard = x.get(x.size()-1);
		if(t.size()>0) {
		String tcard = t.get(t.size()-1);
		if(stackableForTableau(tcard,xcard)) {
			t.add(x.get(x.size()-1));
			x.remove(x.size()-1);
			notifyObservers();
			return true;
			
		}else {
			return false;
		}
		}else {
			t.add(x.get(x.size()-1));
			x.remove(x.size()-1);
			notifyObservers();
			return true;
		}
		}else {
			return false;
		}
		
	}
	
	//checks if the card being added is from the stock pile.
	//and if it is, then adds it
	public boolean addToWaste(String cardToAdd,ArrayList<String> listToAddTo) {
		if(cardToAdd == stock.get(stock.size()-1)){
			listToAddTo.add(cardToAdd);
			stock.remove(stock.size()-1);
			return true;
		}return false;
	}
	
	/***
	 * Create JLabel image 
	 * 
	 * @param fileNameRelativeToClassFile
	 * @return JLabel of card image
	 */
	public JLabel createDisplayImage(String fileNameRelativeToClassFile) {
		JLabel retVal = new JLabel();
		java.net.URL imgURL = this.getClass().getResource(fileNameRelativeToClassFile);
		if (imgURL == null) {
			throw new IllegalArgumentException("Couldn't find file: " + fileNameRelativeToClassFile);
		}
		ImageIcon cardImage = new ImageIcon(imgURL);    
		retVal.setIcon(cardImage);
		Dimension d = new Dimension(cardImage.getIconWidth() + 10, cardImage.getIconHeight() + 10);
		retVal.setSize(d);
		retVal.setPreferredSize(d);
		retVal.setMaximumSize(d);
		retVal.setMinimumSize(d);
		return retVal;
	}	
	
	public HashMap<String,JLabel> getCardLabel(){
		HashMap<String,JLabel> retVal = new HashMap<String,JLabel>();
		ArrayList<String> cardz = deck;
		for(String s : cardz) {
			String card = "/GUIs/Cards/" + s  + ".gif";
			JLabel label = createDisplayImage(card);
			retVal.put(s, label);	
		}
		
		return retVal;
	}
	
	
	public void setTwoNames(String s) {
		twoNames.add(s);
		notifyObservers();
	}

	public void setTwoNames0() {
		twoNames.clear();
		notifyObservers();
	}
	
	public ArrayList<String>getTwoNames(){
		return twoNames;
	}
	
	public void checkStock(String s) {
		cStock.add(s);
		notifyObservers();
	}

	public void checkStocks0() {
		cStock.clear();
		notifyObservers();
	}
	
	public ArrayList<String>getCheckStock(){
		return cStock;
	}
	
	public ArrayList<String> getTable1() {
		return t1;
	}

	public ArrayList<String> getTable2() {
		return t2;
	}

	public ArrayList<String> getTable3() {
		return t3;
	}

	public ArrayList<String> getTable4() {
		return t4;
	}

	public ArrayList<String> getTable5() {
		return t5;
	}

	public ArrayList<String> getTable6() {
		return t6;
	}

	public ArrayList<String> getTable7() {
		return t7;
	}
	
	public ArrayList<String> getTable8() {
		return t8;
	}

	public ArrayList<String> getTable9() {
		return t9;
	}

	public ArrayList<String> getTable10() {
		return t10;
	}

	public ArrayList<String> getTable11() {
		return t11;
	}

	public ArrayList<String> getTable12() {
		return t12;
	}

	public ArrayList<String> getTable13() {
		return t13;
	}

	public ArrayList<String> getHomecell1() {
		return h1;
	}
	
	public ArrayList<String> getHomecell2() {
		return h2;
	}
	
	public ArrayList<String> getHomecell3() {
		return h3;
	}
	
	public ArrayList<String> getHomecell4() {
		return h4;
	}
	
	public ArrayList<String> getHomecell5() {
		return h5;
	}
	
	public ArrayList<String> getHomecell6() {
		return h6;
	}
	
	public ArrayList<String> getHomecell7() {
		return h7;
	}
	
	public ArrayList<String> getHomecell8() {
		return h8;
	}
	
	public ArrayList<String> getStock() {
		return stock;
	}
	
	public ArrayList<String> getWaste() {
		return waste;
	}
	
	public void addObserver(Observer obs) {
		_observers.add(obs);
		notifyObservers();
	}

	public void notifyObservers() {
		for (Observer obs : _observers) {
			obs.update();
		}
	}
}
