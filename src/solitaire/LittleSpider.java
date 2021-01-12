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

public class LittleSpider {

	private Deck cards;

	private ArrayList<String>twoNames;

	private ArrayList<String> t1;
	private ArrayList<String> t2;
	private ArrayList<String> t3;
	private ArrayList<String> t4;
	private ArrayList<String> t5;
	private ArrayList<String> t6;
	private ArrayList<String> t7;
	private ArrayList<String> t8;
	private ArrayList<String> homeCellAD;
	private ArrayList<String> homeCellAH;
	private ArrayList<String> homeCellKS;
	private ArrayList<String> homeCellKC;
	private ArrayList<String> rank;
	private ArrayList<String> deckOfCards;
	private ArrayList<String> deck;
	private ArrayList<String> keepTrack;
	private ArrayList<Observer> _observers;	
	
	private int illegal = 0;

	/**Constructor :
	 * 
	 * Initialize the game with 4 HomeCells of Ace of D and H and Kings of S and C 
	 * 
	 * and add the rest of the cards to 8 Tableau piles of 6 cards 
	 * 
	 */

	public LittleSpider() {
		cards = new Deck();
		cards.createRank();
		this.rank = cards.getRank();
		deckOfCards = cards.getdeckOfCards();
		deck=new ArrayList<String>();
		for(String c:deckOfCards) {
			deck.add(c);
		}
		homeCellAD = new ArrayList<String>();
		homeCellAH = new ArrayList<String>();
		homeCellKS = new ArrayList<String>();
		homeCellKC = new ArrayList<String>();
		t1=new ArrayList<String>();
		t2=new ArrayList<String>();
		t3=new ArrayList<String>();
		t4=new ArrayList<String>();
		t5=new ArrayList<String>();
		t6=new ArrayList<String>();
		t7=new ArrayList<String>();
		t8=new ArrayList<String>();
		keepTrack=new ArrayList<String>();
		twoNames = new ArrayList<String>();

		_observers = new ArrayList<Observer>();

		///Add to deckOfCards
		while(deckOfCards.contains("ad") || deckOfCards.contains("ah") || deckOfCards.contains("ks") || deckOfCards.contains("kc"))
			for(int i=0;i<deckOfCards.size();i++) {
				if(deckOfCards.get(i).equals("ad")) {
					homeCellAD.add(deckOfCards.get(i));
					deckOfCards.remove(i);
				}else if(deckOfCards.get(i).equals("ah")) {
					homeCellAH.add(deckOfCards.get(i));
					deckOfCards.remove(i);
				}else if(deckOfCards.get(i).equals("ks")) {
					homeCellKS.add(deckOfCards.get(i));
					deckOfCards.remove(i);
				}else if(deckOfCards.get(i).equals("kc")){
					homeCellKC.add(deckOfCards.get(i));
					deckOfCards.remove(i);
				}
			}
		int i=0;	
		while(!deckOfCards.isEmpty() && i<deckOfCards.size()) {
			t1.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t2.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t3.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t4.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t5.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t6.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t7.add(deckOfCards.get(i));
			deckOfCards.remove(i);
			t8.add(deckOfCards.get(i));
			deckOfCards.remove(i);
		}
	}



	/**
	 * The removeCard method will check if the Tableau pile is empty first if not 
	 * it will remove the last card in the pile
	 */
	public void removeCardFromTableau(ArrayList<String> listToRemoveFrom) {
		if(cardRemovableFromTableau(listToRemoveFrom)) {
			keepTrack.add(listToRemoveFrom.get(listToRemoveFrom.size()-1));
			listToRemoveFrom.remove(listToRemoveFrom.size()-1);
		}
	}

	public boolean cardRemovableFromTableau(ArrayList<String> listToRemoveFrom) {
		if(!listToRemoveFrom.isEmpty()) {
			return true;
		}
		return false;
	}

	/***
	 * 
	 * @param listToAddTo The list you trying to add your card to
	 * 
	 */
	public void addToTableau(String cardToAdd,ArrayList<String> listToAddTo) {
		if(stackableforSpadesandClubs(listToAddTo.get(listToAddTo.size()-1),cardToAdd) || stackableforHeartsandDiamonds(listToAddTo.get(listToAddTo.size()-1),cardToAdd)){
			listToAddTo.add(cardToAdd);
		}
	}


	//returns true newCard can be stacked else false based on rank for Spades and Clubs
	public boolean stackableforSpadesandClubs(String lastCard, String newCard) {
		boolean result = false;
		String l1, n1;
		l1 = lastCard.substring(0,1);
		n1 = newCard.substring(0,1);
		if (l1.equals("a")) {
			if(n1.equals("k"))  {
				result = true;
			}
		}
		else if (l1.equals("k")) {
			if(n1.equals("q") ) {
				result = true;
			}
		}
		else if (l1.equals("q")) {
			if(n1.equals("j") ) {
				result = true;
			}
		}

		else {
			int l1index = rank.indexOf(l1);
			int n1index = rank.indexOf(n1);
			if(l1index == n1index+1 || l1index ==n1index-1) {
				result = true;
			}
		}

		return result;

	}

	//returns true newCard can be stacked else false based on rank for Hearts and Diamonds
	public boolean stackableforHeartsandDiamonds(String lastCard, String newCard) {
		boolean result = false;
		String l1, n1;
		l1 = lastCard.substring(0,1);
		n1 = newCard.substring(0,1);
		if (l1.equals("k")) {
			if(n1.equals("a"))  {
				result = true;
			}
		}
		else if (l1.equals("q")) {
			if(n1.equals("K") ) {
				result = true;
			}
		}
		else if (l1.equals("j")) {
			if(n1.equals("q") ) {
				result = true;
			}
		}

		else {
			int l1index = rank.indexOf(l1);
			int n1index = rank.indexOf(n1);
			if(l1index == n1index+1 || l1index ==n1index-1) {
				result = true;
			}
		}					
		return result;

	}
	
	//new stackable method i created
	public boolean stackableforHD(String tcard, String hcard) {
		String trank = tcard.substring(0, 1);
		String hrank = hcard.substring(0, 1);
		String tsuit = tcard.substring(1, 2);
		String hsuit = hcard.substring(1, 2);
		if(tsuit.equals(hsuit) && (hsuit.equals("h") || hsuit.equals("d"))){
			int tindex = rank.indexOf(trank);
			int hindex = rank.indexOf(hrank);
			if(tindex == hindex+1) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
		
	}
	
	
	//new stackable method i created
	public boolean stackableforSC(String tcard, String hcard) {
		String trank = tcard.substring(0, 1);
		String hrank = hcard.substring(0, 1);
		String tsuit = tcard.substring(1, 2);
		String hsuit = hcard.substring(1, 2);
		if(tsuit.equals(hsuit) && (hsuit.equals("s") || hsuit.equals("c"))){
			int tindex = rank.indexOf(trank);
			int hindex = rank.indexOf(hrank);
			if(tindex == hindex-1) {
				return true;
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
		
	}

	/***
	 * 
	 * @param list The Homecell list the player is trying to add to 
	 * @param card The card the player is trying to add to the homecell
	 * 
	 * 
	 */
	public boolean addableToHomecell(ArrayList<String> list,String card) {
		String listSuit=list.get(0).substring(1, 1);
		String cardSuit=card.substring(1, 1);

		if (listSuit.equals(cardSuit) && stackableforSpadesandClubs(list.get(list.size()-1),card)) {
			return true;
		}else if(listSuit.equals(cardSuit) && stackableforHeartsandDiamonds(list.get(list.size()-1),card)) {
			return true;
		}
		return false;
	}

	public void addToHomecell(ArrayList<String> list,String card) {
		if(addableToHomecell(list,card)) {
			list.add(card);
		}
	}
	
	//new table to homecell method i created
	public boolean TableToHomecell(ArrayList<String>t, ArrayList<String>h) {
		String tcard = t.get(t.size()-1);
		String hcard = h.get(h.size()-1);
		if(stackableforHD(tcard,hcard) || stackableforSC(tcard,hcard)) {
			h.add(t.remove(t.size()-1));
			notifyObservers();
			return true;
		}
		else {
			return false;
		}
	}

	/***
	 * 
	 * @param homecell is the homecell the player trying to remove the top card from 
	 * 
	 * If the top card is the last card it won't be removed 
	 * 
	 */
	public boolean removableFromHomecell(ArrayList<String> homecell) {
		if(homecell.size()>1) {
			return true;
		}
		return false;
	}

	public void removeFromHomecell(ArrayList<String> homecell) {
		if(removableFromHomecell(homecell)) {
			homecell.remove(homecell.size()-1);
		}
	}
	/***
	 * 
	 * @return HashMap of card names mapped to Label
	 */
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

	/***
	 * Stackable from Table to HomeCell
	 * @param pile
	 * @return boolean 
	 */
	public boolean TableauToHome(ArrayList<String> pile) {
		if(! homeCellAD.isEmpty()) {
			String d1 = pile.get(pile.size()-1);
			String d2 = homeCellAD.get(homeCellAD.size()-1);
			if(stackableforHeartsandDiamonds(d1,d2)) {
				homeCellAD.add(pile.remove(pile.size()-1));
				notifyObservers();
				return true;
			}
		}
		else	 if(! homeCellAH.isEmpty()) {
			String h1 = pile.get(pile.size()-1);
			String h2 = homeCellAH.get(homeCellAH.size()-1);
			if(stackableforHeartsandDiamonds(h1,h2)) {
				homeCellAH.add(pile.remove(pile.size()-1));
				notifyObservers();
				return true;
			}
		}
		else	if(! homeCellKS.isEmpty()) {
			String s1 = pile.get(pile.size()-1);
			String s2 = homeCellKS.get(homeCellKS.size()-1);
			if(stackableforSpadesandClubs(s1,s2)) {
				homeCellKS.add(pile.remove(pile.size()-1));
				notifyObservers();
				return true;
			}
		}
		else 	if(! homeCellKC.isEmpty()) {
			String c1 = pile.get(pile.size()-1);
			String c2 = homeCellKC.get(homeCellKC.size()-1);
			if(stackableforSpadesandClubs(c1,c2)) {
				homeCellKC.add(pile.remove(pile.size()-1));
				notifyObservers();
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
	

	//I copied this from Golf.
	//This is to check if the last cards from tables can be stacked
	//or if a card from homecell can be added to table

	public boolean Tstackable(String lastCard, String newCard) {
		boolean result = false;
		String l1, n1;
		l1 = lastCard.substring(0,1);
		n1 = newCard.substring(0,1);
		if (l1.equals("a")) {			//K A 2
			if(n1.equals("k") || n1.equals("2"))  {
				result = true;
			}
		}
		else if (l1.equals("k")) {		//Q K A
			if(n1.equals("q") || n1.equals("a")) {
				result = true;
			}
		}
		else {
			//get index of two cards from rank, e.g., index of A is 0, and index of 2 is 1.
			int l1index = rank.indexOf(l1);  
			int n1index = rank.indexOf(n1);
			if(l1index == n1index+1 || l1index ==n1index-1) {
				result = true;
			}
		}

		return result;

	}

	//This is also from Golf, with slight modification
	//This checks stackability and removes card from old to new pile

	public boolean TtoT(ArrayList<String> pile1,ArrayList<String> pile2) {
		String s1 = pile1.get(pile1.size()-1);
		String s2 = pile2.get(pile2.size()-1);
		if(Tstackable(s1,s2)) {
			pile2.add(pile1.remove(pile1.size()-1));
			notifyObservers();
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean TtoTCards(String s1,String s2) {
		if(Tstackable(s1,s2)) {
			return true;
		}
		else {
			return false;
		}

	}
	
	public boolean TtoHCards(String tcard, String hcard) {
		if(stackableforHD(tcard,hcard) || stackableforSC(tcard,hcard)) {
			return true;
		}
		else {
			return false;
		}
	}


	public ArrayList<String> getKeepTrack() {
		return keepTrack;
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


	/**
	 * 
	 * Getters and Setters 
	 * 
	 * 
	 */

	
	public void setTwoNames(String s) {
		this.twoNames.add(s);
		notifyObservers();
	}

	public void setTwoNames0() {
		twoNames.clear();
		notifyObservers();
	}
	
	public ArrayList<String>getTwoNames(){
		return twoNames;
	}
	
	public int getIllegal() {
    	return illegal;
    }
    
    public void setIllegal() {
    	illegal+=1;
    	notifyObservers();
    }
    
    public void illegal0() {
    	illegal = 0;
    	notifyObservers();
    }
    
    
    
    public JLabel getWin() {
		ArrayList<JLabel>wins = new ArrayList<JLabel>();
		for(int i=1; i<6; i++) {
			String s = "/GUIs/Easteggs/win" + i  + ".gif";
			JLabel l = createDisplayImage(s);
			wins.add(l);
		}
		Collections.shuffle(wins);
		return wins.get(0);
	}
	
	public JLabel getLose() {
		ArrayList<JLabel>lose = new ArrayList<JLabel>();
		for(int i=1; i<6; i++) {
			String s = "/GUIs/Easteggs/lose" + i  + ".gif";
			JLabel l = createDisplayImage(s);
			lose.add(l);
		}
		Collections.shuffle(lose);
		return lose.get(0);
	}
	

	public ArrayList<String> getT1() {
		Collections.shuffle(t1);
		return t1;
	}
	public ArrayList<String> getT2() {
		Collections.shuffle(t2);
		return t2;
	}
	public ArrayList<String> getT3() {
		Collections.shuffle(t3);
		return t3;
	}
	public ArrayList<String> getT4() {
		Collections.shuffle(t4);
		return t4;
	}
	public ArrayList<String> getT5() {
		Collections.shuffle(t5);
		return t5;
	}
	public ArrayList<String> getT6() {
		Collections.shuffle(t6);
		return t6;
	}
	public ArrayList<String> getT7() {
		Collections.shuffle(t7);
		return t7;
	}
	public ArrayList<String> getT8() {
		Collections.shuffle(t8);
		return t8;
	}
	public ArrayList<String> getHomeCellAD() {
		Collections.shuffle(homeCellAD);
		return homeCellAD;
	}
	public ArrayList<String> getHomeCellAH() {
		Collections.shuffle(homeCellAH);
		return homeCellAH;
	}
	public ArrayList<String> getHomeCellKS() {
		Collections.shuffle(homeCellKS);
		return homeCellKS;
	}
	public ArrayList<String> getHomeCellKC() {
		Collections.shuffle(homeCellKC);
		return homeCellKC;
	}
	public ArrayList<String> getRank() {
		return rank;
	}

	public ArrayList<String> getDeckOfCards() {
		Collections.shuffle(deckOfCards);
		return deckOfCards;
	}


}

