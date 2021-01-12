package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import solitaire.Deck;
import solitaire.Golf;

import java.util.ArrayList;

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

public class GolfTest {
	
	@Test
	public void Decktest() {
		Deck test=new Deck();
		assertEquals("Size of Deck should be 52",52,test.getdeckOfCards().size());
		
		assertEquals("Size of Hearts should 13",13,test.getHearts().size());
		assertEquals("Size of Diamonds should 13",13,test.getDiamond().size());
		assertEquals("Size of Spades should 13",13,test.getSpades().size());
		assertEquals("Size of Clubs should 13",13,test.getClubs().size());
		

			
	}
	
	
	
	@Test
	public void GolfCheckTableauCardCount() {
		//tableau pile contents tests
		Golf test = new Golf();
		ArrayList<String> table1=test.getTable1();
		ArrayList<String> table2=test.getTable2();
		ArrayList<String> table3=test.getTable3();
		ArrayList<String> table4=test.getTable4();
		ArrayList<String> table5=test.getTable5();
		ArrayList<String> table6=test.getTable6();
		ArrayList<String> table7=test.getTable7();
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table1.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table2.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table3.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table4.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table5.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table6.size());
		assertEquals("Tableau piles should each initially hold 5 cards", 5, table7.size());
		
	}
	
	@Test
	public void GolfCheckStackableTableau() {
		Golf test=new Golf();
		//checks stackable(tableau) method to see if card can be stacked
		assertEquals("This should return true",true,test.stackable("2c","3d"));
		assertEquals("This should return false",false,test.stackable("2s","4d"));
		assertEquals("This should return false",false,test.stackable("9h","3h"));
		assertEquals("This should return true",true,test.stackable("ac","2d"));
		assertEquals("This should return false",false,test.stackable("js","kd"));
		assertEquals("This should return true",true,test.stackable("kh","qh"));
	}
	
	@Test
	public void GolfCheckIfTableauPileIsNotEmpty() {
		Golf test=new Golf();
		ArrayList<String> testpile = new ArrayList<String>();
		assertFalse("Should not be able to remove if tableau pile is empty", test.Remove(testpile));
	}
	
	@Test
	public void GolfCheckRemoveFromTableauPile() {
		Golf test=new Golf();
		
		String newTopCard = test.getTable1().get(test.getTable1().size()-1); //records what should become the top card
		int formerSize = test.getTable1().size(); //records the size of the tableau pile
		test.Remove(test.getTable1()); //removes the top card from the tableau pile
		assertEquals("Removing a card from tableau pile should move following card to top", test.getTable1().get(test.getTable1().size()-1), newTopCard);
		assertEquals("remove should not remove the card only add will", formerSize , test.getTable1().size());
	}
	
	@Test
	public void CheckGolfHomecellPileCardCount() { 
		Golf test=new Golf();
		
		assertEquals("Homecell piles should initially have 0 cards", 0, test.getHomecell().size());
		
	}
	
	@Test
	public void CheckGolfHomecellPileLegalMove() { 
		Golf test=new Golf();
		ArrayList<String> homecell=test.getHomecell();
		homecell.add("2h");
		assertEquals("This is a valid stack of HomeCell",true,test.stackable(homecell.get(homecell.size()-1),"3d"));
		
		
	}
	
	@Test
	public void GolfCheckRemoveFromHomecellPile() {
		Golf test=new Golf();

		assertEquals("SHOULD NOT REMOVE FROM HOMECELL", false,test.Remove(test.getHomecell()));
	}
	
	@Test
	public void GolfCheckAddCardToHomecellPile() { 
		Golf test=new Golf();
		
		String firstcardStock=test.getStock().get(test.getStock().size()-1);
		test.addfromTableOrStock(test.getStock());
		assertEquals("Should add firstcardStock to an empty homcell pile from stock",firstcardStock,test.getHomecell().get(0));
		String lastcardintable=test.getTable1().get(test.getTable1().size()-1);
		test.addfromTableOrStock(test.getTable1());
		if(test.stackable(firstcardStock, lastcardintable))
		assertEquals("Should still have lastcardintable in homcell pile it is stackable with it",lastcardintable,test.getHomecell().get(1));
		else
			assertEquals("Should still have firstcardStock in homcell pile since lastcardintable is not stackable with it",firstcardStock,test.getHomecell().get(0));
	}
	
	
}
