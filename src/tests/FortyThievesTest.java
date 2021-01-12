package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import solitaire.FortyThieves;

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

public class FortyThievesTest {
	/**
	 * Check homecell pile initial setup
	 */
	@Test
	public void HomecellPilesInitialTest() {
		FortyThieves test = new FortyThieves();
		int cnt = 0;
		if(test.getHomecell1().get(0).equals("ad")||test.getHomecell1().get(0).equals("ah")||test.getHomecell1().get(0).equals("ac")||test.getHomecell1().get(0).equals("as"))
			cnt++;
		if(test.getHomecell2().get(0).equals("ad")||test.getHomecell2().get(0).equals("ah")||test.getHomecell2().get(0).equals("ac")||test.getHomecell2().get(0).equals("as"))
			cnt++;
		if(test.getHomecell3().get(0).equals("ad")||test.getHomecell3().get(0).equals("ah")||test.getHomecell3().get(0).equals("ac")||test.getHomecell3().get(0).equals("as"))
			cnt++;
		if(test.getHomecell4().get(0).equals("ad")||test.getHomecell4().get(0).equals("ah")||test.getHomecell4().get(0).equals("ac")||test.getHomecell4().get(0).equals("as"))
			cnt++;
		if(test.getHomecell5().get(0).equals("ad")||test.getHomecell5().get(0).equals("ah")||test.getHomecell5().get(0).equals("ac")||test.getHomecell5().get(0).equals("as"))
			cnt++;
		if(test.getHomecell6().get(0).equals("ad")||test.getHomecell6().get(0).equals("ah")||test.getHomecell6().get(0).equals("ac")||test.getHomecell6().get(0).equals("as"))
			cnt++;
		if(test.getHomecell7().get(0).equals("ad")||test.getHomecell7().get(0).equals("ah")||test.getHomecell7().get(0).equals("ac")||test.getHomecell7().get(0).equals("as"))
			cnt++;
		if(test.getHomecell8().get(0).equals("ad")||test.getHomecell8().get(0).equals("ah")||test.getHomecell8().get(0).equals("ac")||test.getHomecell8().get(0).equals("as"))
			cnt++;
		assertEquals("When the game begins each homecell pile should contains one of the Ace cards. 8 homecell piles should have 8 of Ace cards.", 8, cnt);
		assertEquals("Each homecell pile should only has one card in the initial setup.", 1, test.getHomecell1().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell2().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell3().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell4().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell5().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell6().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell7().size());
		assertEquals("Each homecell pile only has one card in the initial setup.", 1, test.getHomecell8().size());
	}
	
	/**
	 * Check is homecell pile Removable
	 */
	@Test
	public void HomecellPilesRemovableTest() {
		FortyThieves testHR = new FortyThieves();
		assertFalse("Cards cannot be removed from a homecell pile.", testHR.removeCardFromHomecell());
	}
	
	/**
	 * Check is homecell pile Addable
	 */	
	@Test
	public void HomecellPilesAddableTest() {
		FortyThieves testHA = new FortyThieves();
		String topCard = testHA.getHomecell1().get(testHA.getHomecell1().size()-1);
		assertTrue(testHA.stackableForHomecell("as", "2s"));
		assertFalse(testHA.stackableForHomecell("as", "3s"));
		assertTrue(testHA.stackableForHomecell("th", "jh"));
		assertTrue(testHA.stackableForHomecell("jc", "qc"));
		assertTrue(testHA.stackableForHomecell("qd", "kd"));
		assertFalse(testHA.stackableForHomecell("kd", "ad"));
		if(topCard.equals("ad")) {
			assertTrue(testHA.addToHomecell("2d", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("3d", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("4d", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("5d", testHA.getHomecell1()));
			assertFalse(testHA.addToHomecell("6c", testHA.getHomecell1()));
			assertEquals("The new top should be 5d","5d",testHA.getHomecell1().get(testHA.getHomecell1().size()-1));
		} else if(topCard.equals("ah")) {
			assertTrue(testHA.addToHomecell("2h", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("3h", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("4h", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("5h", testHA.getHomecell1()));
			assertFalse(testHA.addToHomecell("6d", testHA.getHomecell1()));
			assertEquals("The new top should be 5h","5h",testHA.getHomecell1().get(testHA.getHomecell1().size()-1));
		} else if(topCard.equals("ac")) {
			assertTrue(testHA.addToHomecell("2c", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("3c", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("4c", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("5c", testHA.getHomecell1()));
			assertFalse(testHA.addToHomecell("6d", testHA.getHomecell1()));
			assertEquals("The new top should be 5c","5c",testHA.getHomecell1().get(testHA.getHomecell1().size()-1));
		} else if(topCard.equals("as")) {
			assertTrue(testHA.addToHomecell("2s", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("3s", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("4s", testHA.getHomecell1()));
			assertTrue(testHA.addToHomecell("5s", testHA.getHomecell1()));
			assertFalse(testHA.addToHomecell("6d", testHA.getHomecell1()));
			assertEquals("The new top should be 5s","5s",testHA.getHomecell1().get(testHA.getHomecell1().size()-1));
		}
		assertEquals("Card size in homecell pile #1 should be 5.",5,testHA.getHomecell1().size());
	}
	
	/**
	 * Check Talbleau pile initial setup 
	 */
	@Test
	public void TableauPilesInitialTest() {
		FortyThieves test1 = new FortyThieves();
		assertEquals("Tableau pile 1 should hold 3 cards.", 3, test1.getTable1().size());
		assertEquals("Tableau pile 2 should hold 3 cards.", 3, test1.getTable2().size());
		assertEquals("Tableau pile 3 should hold 3 cards.", 3, test1.getTable3().size());
		assertEquals("Tableau pile 4 should hold 3 cards.", 3, test1.getTable4().size());
		assertEquals("Tableau pile 5 should hold 3 cards.", 3, test1.getTable5().size());
		assertEquals("Tableau pile 6 should hold 3 cards.", 3, test1.getTable6().size());
		assertEquals("Tableau pile 7 should hold 3 cards.", 3, test1.getTable7().size());
		assertEquals("Tableau pile 8 should hold 3 cards.", 3, test1.getTable8().size());
		assertEquals("Tableau pile 9 should hold 3 cards.", 3, test1.getTable9().size());
		assertEquals("Tableau pile 10 should hold 3 cards.", 3, test1.getTable10().size());
		assertEquals("Tableau pile 11 should hold 3 cards.", 3, test1.getTable11().size());
		assertEquals("Tableau pile 12 should hold 3 cards.", 3, test1.getTable12().size());
		assertEquals("Tableau pile 13 should hold 3 cards.", 3, test1.getTable13().size());
	}
	
	/**
	 * Check is tableau pile Removable
	 */
	@Test
	public void TableauPilesRemovableTest() {
		FortyThieves testTR = new FortyThieves();
		//initially tableau has 3 cards, remove 3 times the pile will be empty, the fourth time fails.
		assertTrue(testTR.removeCardFromTableau(testTR.getTable1()));
		assertEquals(2,testTR.getTable1().size());
		assertTrue(testTR.removeCardFromTableau(testTR.getTable1()));
		assertEquals(1,testTR.getTable1().size());
		assertTrue(testTR.removeCardFromTableau(testTR.getTable1()));
		assertEquals(0,testTR.getTable1().size());
		assertFalse(testTR.removeCardFromTableau(testTR.getTable1()));
		
		assertTrue(testTR.removeCardFromTableau(testTR.getTable3()));
		assertEquals(2,testTR.getTable3().size());
		assertTrue(testTR.removeCardFromTableau(testTR.getTable3()));
		assertEquals(1,testTR.getTable3().size());
		assertTrue(testTR.removeCardFromTableau(testTR.getTable3()));
		assertEquals(0,testTR.getTable3().size());
		assertFalse(testTR.removeCardFromTableau(testTR.getTable3()));

	}
	
	/**
	 * Check is tableau pile Addable
	 */	
	@Test
	public void TableauPilesAddableTest() {
		FortyThieves testTA = new FortyThieves();
		assertTrue(testTA.stackableForTableau("2d", "ad"));
		assertTrue(testTA.stackableForTableau("jc", "tc"));
		assertTrue(testTA.stackableForTableau("kh", "qh"));
		assertTrue(testTA.stackableForTableau("td", "9d"));
		assertFalse(testTA.stackableForTableau("3s", "2d"));
		assertTrue("Try to get a empty tableau pile",testTA.removeCardFromTableau(testTA.getTable3()));
		assertEquals(2,testTA.getTable3().size());
		assertTrue("Try to get a empty tableau pile",testTA.removeCardFromTableau(testTA.getTable3()));
		assertEquals(1,testTA.getTable3().size());
		assertTrue("Try to get a empty tableau pile",testTA.removeCardFromTableau(testTA.getTable3()));
		assertEquals("Empty tableau pile.",0,testTA.getTable3().size());
		assertTrue("If the tableau is empty, any card can be added to the tableau pile.",testTA.addToTableau("8d", testTA.getTable3()));
		assertTrue("7d can be added to 8d.",testTA.addToTableau("7d", testTA.getTable3()));
		assertEquals("New top card should be 7d.","7d",testTA.getTable3().get(testTA.getTable3().size()-1));
		assertFalse("6s cannot be added to 7d.",testTA.addToTableau("6s", testTA.getTable3()));
		assertFalse("5d cannot be added to 7d.",testTA.addToTableau("5d", testTA.getTable3()));
	}
	
	/**
	 * Check stock pile initial setup
	 */
	@Test
	public void StockPileInitialTest() {
		FortyThieves test2 = new FortyThieves();
		assertEquals("When the game begins the stock pile will contain the 57 cards.", 57, test2.getStock().size());
	}
	
	/**
	 * Check is stock pile Removable
	 */
	@Test
	public void StockPileRemovableTest() {
		FortyThieves testSR = new FortyThieves();
		String removedCard = testSR.getStock().get(testSR.getStock().size()-1);
		assertTrue("Top card from stock should be removed.", testSR.removeCardFromStock(testSR.getStock()));
		assertEquals("Initially stock has 57 cards, remove once will be 56 cards left.", 56, testSR.getStock().size());
		assertEquals("Card removed from stock must be moved to the waste pile.",removedCard, testSR.getWaste().get(testSR.getWaste().size()-1));
		assertTrue("Top card from stock should be removed.", testSR.removeCardFromStock(testSR.getStock()));
		assertEquals("Must be 55 cards left.", 55, testSR.getStock().size());
		assertEquals("Since stock was removed twice, the size of waste should be 2.",2, testSR.getWaste().size());
	}
	
	/**
	 * Check is stock pile Addable
	 */	
	@Test
	public void StockPileAddableTest() {
		FortyThieves testSA = new FortyThieves();
		assertFalse("Cards cannot be added to the stock pile.",testSA.addToStock());
	}
	
	/**
	 * Check Waste pile initial setup
	 */
	@Test
	public void WastePileInitialTest() {
		FortyThieves test3 = new FortyThieves();
		assertTrue("The waste pile will initially be empty", test3.getWaste().isEmpty());
	}
	
	/**
	 * Check is Waste pile Removable
	 */
	@Test
	public void WastePileRemovableTest() {
		FortyThieves testWR = new FortyThieves();
		String removedCard = testWR.getStock().get(testWR.getStock().size()-1);
		testWR.removeCardFromStock(testWR.getStock());
		assertEquals("Card removed from stock must be moved to the waste pile.",removedCard, testWR.getWaste().get(testWR.getWaste().size()-1));
		assertEquals(1,testWR.getWaste().size());
		testWR.removeCardFromStock(testWR.getStock());
		assertEquals(2,testWR.getWaste().size());
		assertTrue(testWR.removeCardFromWaste(testWR.getWaste()));
		assertEquals(1,testWR.getWaste().size());
		assertTrue(testWR.removeCardFromWaste(testWR.getWaste()));
		assertEquals(0,testWR.getWaste().size());
		assertFalse("Waste pile is empty.",testWR.removeCardFromWaste(testWR.getWaste()));
	}
	
	/**
	 * Check is Waste pile Addable
	 */	
	@Test
	public void WastePileAddableTest() {
		FortyThieves testWA = new FortyThieves();
		String CardfromStock = testWA.getStock().get(testWA.getStock().size()-1);
		assertTrue("Cards from stock is always legal to add.",testWA.addToWaste(CardfromStock, testWA.getWaste()));
		assertEquals("Check is the card removed from stock same to the card added to waste.",CardfromStock, testWA.getWaste().get(testWA.getWaste().size()-1));
		
		String CardfromTableau = testWA.getTable1().get(testWA.getTable1().size()-1);
		assertFalse("Cards from tableau piles is always illegal to add.",testWA.addToWaste(CardfromTableau, testWA.getWaste()));
		
		assertEquals("Waste size should be 1.", 1, testWA.getWaste().size());
		assertEquals("Waste size increase by 1 means stock size decrease by 1.",56,testWA.getStock().size());
	}
}
