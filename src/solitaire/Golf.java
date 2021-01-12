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

public class Golf {

	private ArrayList<String> table1;
	private ArrayList<String> table2;
	private ArrayList<String> table3;
	private ArrayList<String> table4;
	private ArrayList<String> table5;
	private ArrayList<String> table6;
	private ArrayList<String> table7;
	private ArrayList<String> rank;
	private ArrayList<String> deck;
	private ArrayList<String> stock;
	private ArrayList<String> homecell;
	private ArrayList<Observer> _observers;	
	private int illegal = 0;
	

	
	public Golf(){
		table1=new ArrayList<String>();
		table2=new ArrayList<String>();
		table3=new ArrayList<String>();
		table4=new ArrayList<String>();
		table5=new ArrayList<String>();
		table6=new ArrayList<String>();
		table7=new ArrayList<String>();
		Deck x=new Deck();
		deck=new ArrayList<String>();
		deck=x.getdeckOfCards();
		rank=new ArrayList<String>();
		rank=x.getRank();
		stock=new ArrayList<String>();
		// setup tables
		for(int i=0;i<deck.size();i++){
			if(i<5)
				table1.add(deck.get(i));
			else if(i<10)
				table2.add(deck.get(i));	
			else if(i<15)
				table3.add(deck.get(i));
			else if(i<20)
				table4.add(deck.get(i));
			else if(i<25)
				table5.add(deck.get(i));
			else if(i<30)
				table6.add(deck.get(i));
			else if(i<35)
				table7.add(deck.get(i));	
			else
				stock.add(deck.get(i));
		}
		
		
		
		//initialize homecell piles
		homecell=new ArrayList<String>();
		
		_observers = new ArrayList<Observer>();
	
		
	}

	public ArrayList<String> getTable1() {
		return table1;
	}


	public ArrayList<String> getTable2() {
		return table2;
	}


	public ArrayList<String> getTable3() {
		return table3;
	}


	public ArrayList<String> getTable4() {
		return table4;
	}


	public ArrayList<String> getTable5() {
		return table5;
	}

	
	public ArrayList<String> getTable6() {
		return table6;
	}


	public ArrayList<String> getTable7() {
		return table7;
	}


	public ArrayList<String> getRank() {
		return rank;
	}


	public ArrayList<String> getDeck() {
		return deck;
	}

	public ArrayList<String> getStock() {
		return stock;
	}

	public ArrayList<String> getHomecell() {
		return homecell;
	}


	//returns true newCard can be stacked else false based on rank
	public boolean stackable(String lastCard, String newCard) {
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
			if(l1index == n1index+1 || l1index == n1index-1) {
				result = true;
			}
		}
		
		return result;
		
	}
	
	//check if removable from table pile or stock pile.
	public boolean Remove (ArrayList<String> pile) {
		if (pile.isEmpty()) {
			return false;
		}
		else {
			
			return true;
		}
	}
	
	
	public void StockToHome() {
		homecell.add(stock.remove(stock.size()-1));
		notifyObservers();
	}
	
	public boolean TableauToHome(ArrayList<String> pile) {
		if(! homecell.isEmpty()) {
			String s1 = pile.get(pile.size()-1);
			String s2 = homecell.get(homecell.size()-1);
			if(stackable(s1,s2)) {
				homecell.add(pile.remove(pile.size()-1));
				notifyObservers();
				return true;
			}
			else {
				return false;
			}
		}else {
			return false;
		}
		
	}
	//adds card to homecell and removes from stock	
	//add card to homecell from table and removes card from table
	public boolean addfromTableOrStock(ArrayList<String> pile) {	
		//pile is from table or stock
		
		if (Remove(pile)) {		//if pile is not empty
			String lastT = (pile.get(pile.size()-1)).substring(0, 1);		//get the rank of last card from pile
			String lastT2 = (pile.get(pile.size()-1)).substring(0, 2);     //get the last card from pile
			if (homecell.isEmpty()) {
				if((lastT2.equals((stock.get(stock.size()-1)).substring(0, 2)))) {		//check is the pile from the stock pile
					homecell.add(pile.remove(pile.size()-1));			//add the pile from the stock to the homecell
					return true;
				}	
			}else {
				if (lastT2.equals((stock.get(stock.size()-1)).substring(0, 2))) {		//check is the pile from the stock pile
					homecell.add(pile.remove(pile.size()-1));
					return true;
				}
				else {
					String lastH = (homecell.get(homecell.size()-1)).substring(0, 1);	//get the last card from homecell pile
					if (stackable(lastH,lastT)) {
						homecell.add(pile.remove(pile.size()-1));
						return true;
					}				
				}
			}
		
		}
		return false;
	}
	
	public boolean addToStockOrTable (ArrayList<String> pile) {
		if (Remove(pile)) {		
			String lastT = (pile.get(pile.size()-1)).substring(0, 2);
			if(stock.add(lastT)) {
				stock.remove(lastT);
				return false;
			}else if(table1.add(lastT)) {
				table1.remove(lastT);
				return false;
			}else if(table2.add(lastT)) {
				table2.remove(lastT);
				return false;
			}else if(table3.add(lastT)) {
				table3.remove(lastT);
				return false;
			}else if(table4.add(lastT)) {
				table4.remove(lastT);
				return false;
			}else if(table5.add(lastT)) {
				table5.remove(lastT);
				return false;
			}else if(table6.add(lastT)) {
				table6.remove(lastT);
				return false;
			}else if(table7.add(lastT)) {
				table7.remove(lastT);
				return false;
			}
			return true;
	}else { 
		return false;
	}
	}
	
	public HashMap<String,JLabel> getCardLabel(){
		HashMap<String,JLabel> retVal = new HashMap<String,JLabel>();
		ArrayList<String> cards = deck;
		for(String s : cards) {
			String card = "/GUIs/Cards/" + s  + ".gif";
			JLabel label = createDisplayImage(card);
			retVal.put(s, label);	
		}
		return retVal;
	}
	
	/*public HashMap<JLabel,String> getLabelCard(){
		HashMap<JLabel,String> retVal = new HashMap<JLabel,String>();
		ArrayList<String> cards = deck;
		for(String s : cards) {
			String card = "/GUIs/Cards/" + s  + ".gif";
			JLabel label = createDisplayImage(card);
			retVal.put(label,s);	
		}
		return retVal;
	}*/
	public boolean GameOver() {
		
			String h=homecell.get(homecell.size()-1);
			String t1="x";
			String t2="x";
			String t3="x";
			String t4="x";
			String t5="x";
			String t6="x";
			String t7="x";
			if(table1.size()>0) {
				t1 = table1.get(table1.size()-1);
			}
			if(table2.size()>0) {
				t2 = table2.get(table2.size()-1);
			}
			if(table3.size()>0) {
				t3 = table3.get(table3.size()-1);
			}
			if(table4.size()>0) {
				t4 = table4.get(table4.size()-1);
			}
			if(table5.size()>0) {
				t5 = table5.get(table5.size()-1);
			}
			if(table6.size()>0) {
				t6 = table6.get(table6.size()-1);
			}
			if(table7.size()>0) {
				t7 = table7.get(table7.size()-1);
			}
			if(!table1.isEmpty() || !table2.isEmpty() || !table3.isEmpty() || !table4.isEmpty() || !table5.isEmpty() || !table6.isEmpty() || !table7.isEmpty() ) {
			if(!stackable(h,t1) && !stackable(h,t2) && !stackable(h,t3) && !stackable(h,t4) && !stackable(h,t5) && !stackable(h,t6) && !stackable(h,t7)) {
				return true;
			}else {
				return false;
			}
			}else {
				return false;
			}
	}
	
	public boolean GameWin() {
		return (table1.isEmpty() && table2.isEmpty() && table3.isEmpty() && table4.isEmpty() && table5.isEmpty() && table6.isEmpty() && table7.isEmpty() );
	}
	
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
