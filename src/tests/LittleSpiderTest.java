package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import solitaire.LittleSpider;

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

public class LittleSpiderTest {
	
	LittleSpider test = new LittleSpider();

	/***
	 * First test to make sure there is 6 cards in each Tableau 
	 */
	@Test
	public void LittleSpiderCheckTableauCardCount() {

		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT1().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT2().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT3().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT4().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT5().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT6().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT7().size());
		assertEquals("Tableau piles should each initially hold 6 cards", 6, test.getT8().size());
	}

	/***
	 * 
	 * This will test if cards are stackable acording to game policies 
	 * 
	 */

	@Test
	public void LittleSpiderCheckStackableTableau() {

		String sixOfHearts = "6h";
		String fiveOfHearts = "5h";
		String oneOfHearts = "1h";
		String sixOfDimoands = "6d";
		String fiveOfSpades = "5s";

		assertTrue("It should be stackable",test.stackableforHeartsandDiamonds(fiveOfHearts, sixOfHearts));
		assertFalse("It should be stackable",test.stackableforHeartsandDiamonds(sixOfDimoands, oneOfHearts));
		assertTrue("It should be stackable",test.stackableforHeartsandDiamonds(fiveOfSpades, sixOfHearts));
	}

	/***
	 * 
	 * Tests the count of Homecell pille after initializing 
	 * 
	 */
	@Test
	public void CheckLittleSpiderHomecellPileCardCount() { 

		assertEquals("Homecell piles should initially have 1 card", 1, test.getHomeCellAD().size());
		assertEquals("Homecell piles should initially have 1 card", 1, test.getHomeCellAH().size());
		assertEquals("Homecell piles should initially have 1 card", 1, test.getHomeCellKS().size());
		assertEquals("Homecell piles should initially have 1 card", 1, test.getHomeCellKC().size());
	}

	/***
	 * 
	 * Check if removing a card is not causing issues when stack is empty 
	 * 
	 */

	@Test
	public void LittleSpiderCheckIfTableauPileIsNotEmpty() { 

		ArrayList<String> testTableau = new ArrayList<String>();
		testTableau = test.getT1();
		testTableau.clear();
		assertFalse("Should not be able to remove if tableau pile is empty", test.cardRemovableFromTableau(testTableau));
	}


	/***
	 * 
	 * Test if adding a card method is working properly 
	 * 
	 */

	@Test
	public void LittleSpiderCheckAddCardToTableauPile() { 

		String sixOfHearts = "6h";
		String fiveOfHearts = "5h";
		ArrayList<String> testArray = new ArrayList<>();
		testArray.add(sixOfHearts);
		testArray.add(fiveOfHearts);

		String oneOfHearts = "4h";
		test.addToTableau(oneOfHearts,testArray);
		assertEquals("The Tableau should allow the card to be added and the size will increase to 3", 3,testArray.size());

		String tenOfHearts = "10h";
		test.addToTableau(tenOfHearts,testArray);
		assertEquals("The Tableau should not allow the card to be added, so size will stay at 3", 3,testArray.size());
	}

	/***
	 * 
	 * Tests If removing a card from a Tableau result of decreasing the size of the tableau by 1
	 * 
	 * and place the last card at the top of the tableau 
	 * 
	 */

	@Test
	public void LittleSpiderCheckRemoveCardFromTableauPile() { 

		ArrayList<String> test = new ArrayList<>();
		test = this.test.getT5();
		assertEquals("Removing a card from tableau pile should move following card to top", 6, test.size());
		this.test.removeCardFromTableau(test);
		assertEquals("Removing a card from tableau pile should decrease # of cards", 5, test.size());
	}

	/***
	 * 
	 * Tests if adding a card to a tableau is allowed when it is a legal move 
	 * 
	 * and if it is denied when it is illegal 
	 * 
	 */

	@Test
	public void CheckLittleSpiderHomecellPileLegalMove() { 

		String twoOfHearts = "2h";
		this.test.addToHomecell(this.test.getHomeCellAH(), twoOfHearts);
		assertEquals("The Homecell should allow 2 of Hearts to be added", 2,this.test.getHomeCellAH().size());

		String fourOfHearts = "4h";
		this.test.addToHomecell(this.test.getHomeCellAH(), fourOfHearts);
		assertEquals("The homecell should not allow 4 of Hearts to be added", 2,this.test.getHomeCellAH().size());

	}

	/***
	 * 
	 * Check the method of removing a card from a homecell, 
	 * 
	 * if it is allowed or denied based on the game policy 
	 * 
	 */

	@Test
	public void LittleSpiderCheckRemoveCardFromHomecellPile() { 
		String twoOfHearts = "2h";
		this.test.addToHomecell(this.test.getHomeCellAH(), twoOfHearts);
		assertTrue("Current top card is 2H and it should be removable from the homecell", this.test.removableFromHomecell(this.test.getHomeCellAH()));
		this.test.removeFromHomecell(this.test.getHomeCellAH());
		assertFalse("Current top card is AH and it shouldn't be removable from the homecell", this.test.removableFromHomecell(this.test.getHomeCellAH()));

		/***
		 * check if adding a card to the homecell is allowed based on the game policy 
		 * 
		 * and if number of the cards is increased after the adding 
		 * 
		 */
	}

	@Test
	public void LittleSpiderCheckAddCardToHomecellPile() { 

		String twoOfHearts = "2h";
		String queenOfSpades = "qs";
		String kingOfSpades = "ks";
		ArrayList<String> testArray = new ArrayList<>();
		testArray.add(kingOfSpades);
		test.addToHomecell(testArray, queenOfSpades);
		assertEquals("The homecell should have Queen of spades at the top",queenOfSpades, testArray.get(testArray.size()-1));
		assertFalse("The homecell should not allow two of hearts to be added to Queen of Spades", test.addableToHomecell(testArray, twoOfHearts));
	}

}

