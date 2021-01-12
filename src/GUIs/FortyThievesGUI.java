package GUIs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
//import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.BevelBorder;

import control.FTStockMouse;
import control.FTTableMouse;
import control.FTHomeMouse;
import control.TMouseListener;
import solitaire.FortyThieves;
import solitaire.Observer;

public class FortyThievesGUI implements Observer {
	private FortyThieves lsGame;
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
	private JPanel _mainPanel;
	private JPanel _tableau;
	private JPanel _hs;
	private JPanel _homecellA1;
	private JPanel _homecellA2;
	private JPanel _homecellA3;
	private JPanel _homecellA4;
	private JPanel _homecellA5;
	private JPanel _homecellA6;
	private JPanel _homecellA7;
	private JPanel _homecellA8;
	private JLayeredPane lt1;
	private JLayeredPane lt2;
	private JLayeredPane lt3;
	private JLayeredPane lt4;
	private JLayeredPane lt5;
	private JLayeredPane lt6;
	private JLayeredPane lt7;
	private JLayeredPane lt8;
	private JLayeredPane lt9;
	private JLayeredPane lt10;
	private JLayeredPane lt11;
	private JLayeredPane lt12;
	private JLayeredPane lt13;
	private ArrayList<String> hs1;
	private ArrayList<String> hs2;
	private ArrayList<String> hs3;
	private ArrayList<String> hs4;
	private ArrayList<String> hs5;
	private ArrayList<String> hs6;
	private ArrayList<String> hs7;
	private ArrayList<String> hs8;
	private DriverFortyThieves _windowHolder;
	private FTTableMouse t1l;
	private FTTableMouse t2l;
	private FTTableMouse t3l;
	private FTTableMouse t4l;
	private FTTableMouse t5l;
	private FTTableMouse t6l;
	private FTTableMouse t7l;
	private FTTableMouse t8l;
	private FTTableMouse t9l;
	private FTTableMouse t10l;
	private FTTableMouse t11l;
	private FTTableMouse t12l;
	private FTTableMouse t13l;
	private JPanel _stock;
	private ArrayList<String> stockArray;
	private ArrayList<String> wastePile;
	private JLabel stockLabel;
	private JPanel _waste;
	private ArrayList<JLabel> wasteArray;
	private JPanel stockNwaste;
	private HashMap<String, ArrayList<String>> StoA;
	private int counter;
	private JPanel eastegg;

	// consutrctor begins here

	public FortyThievesGUI(FortyThieves lsGamea, JPanel mp, DriverFortyThieves driver) {
		lsGame = lsGamea;
		_windowHolder = driver;
		lsGame = new FortyThieves();

		stockArray = lsGame.getStock();
		wastePile = lsGame.getWaste();
		counter=0;

		t1 = lsGame.getTable1();
		t2 = lsGame.getTable2();
		t3 = lsGame.getTable3();
		t4 = lsGame.getTable4();
		t5 = lsGame.getTable5();
		t6 = lsGame.getTable6();
		t7 = lsGame.getTable7();
		t8 = lsGame.getTable8();
		t9 = lsGame.getTable9();
		t10 = lsGame.getTable10();
		t11 = lsGame.getTable11();
		t12 = lsGame.getTable12();
		t13 = lsGame.getTable13();

		hs1 = lsGame.getHomecell1();
		hs2 = lsGame.getHomecell2();
		hs3 = lsGame.getHomecell3();
		hs4 = lsGame.getHomecell4();
		hs5 = lsGame.getHomecell5();
		hs6 = lsGame.getHomecell6();
		hs7 = lsGame.getHomecell7();
		hs8 = lsGame.getHomecell8();

		StoA = new HashMap<String, ArrayList<String>>();
		StoA.put("t1", t1);
		StoA.put("t2", t2);
		StoA.put("t3", t3);
		StoA.put("t4", t4);
		StoA.put("t5", t5);
		StoA.put("t6", t6);
		StoA.put("t7", t7);
		StoA.put("t8", t8);
		StoA.put("t9", t9);
		StoA.put("t10", t10);
		StoA.put("t11", t11);
		StoA.put("t12", t12);
		StoA.put("t13", t13);
		StoA.put("h1", hs1);
		StoA.put("h2", hs2);
		StoA.put("h3", hs3);
		StoA.put("h4", hs4);
		StoA.put("h5", hs5);
		StoA.put("h6", hs6);
		StoA.put("h7", hs7);
		StoA.put("h8", hs8);
		StoA.put("w", wastePile);


		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));
		SetGUI("Start your first move!", Color.GREEN, Color.WHITE);

		lsGame.addObserver(this);

	}

	// Constructor end

	public void SetGUI(String Feedbackmessage, Color backColor, Color frontColor) {


		stockNwaste = new JPanel();

		String cardback = "/GUIs/Cards/card00.gif";
		String greencard = "/GUIs/Cards/green.gif";
		stockLabel = lsGame.createDisplayImage(cardback);
		JLabel emptyLabel = lsGame.createDisplayImage(greencard);
		stockLabel.setBounds(10, 0, 83, 107);
		stockLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		emptyLabel.setBounds(10, 0, 83, 107);
		emptyLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JPanel feedbackPanel = new JPanel();
		JLabel message = new JLabel(Feedbackmessage);
		setLabelProperties(message, backColor, frontColor);
		feedbackPanel.add(message);
		_mainPanel.add(feedbackPanel);


		lt1 = new JLayeredPane();
		lt2 = new JLayeredPane();
		lt3 = new JLayeredPane();
		lt4 = new JLayeredPane();
		lt5 = new JLayeredPane();
		lt6 = new JLayeredPane();
		lt7 = new JLayeredPane();
		lt8 = new JLayeredPane();
		lt9 = new JLayeredPane();
		lt10 = new JLayeredPane();
		lt11 = new JLayeredPane();
		lt12 = new JLayeredPane();
		lt13 = new JLayeredPane();
		lt1.setPreferredSize(new Dimension(300, 450));
		lt2.setPreferredSize(new Dimension(300, 450));
		lt3.setPreferredSize(new Dimension(300, 450));
		lt4.setPreferredSize(new Dimension(300, 450));
		lt5.setPreferredSize(new Dimension(300, 450));
		lt6.setPreferredSize(new Dimension(300, 450));
		lt7.setPreferredSize(new Dimension(300, 450));
		lt8.setPreferredSize(new Dimension(300, 450));
		lt9.setPreferredSize(new Dimension(300, 450));
		lt10.setPreferredSize(new Dimension(300, 450));
		lt11.setPreferredSize(new Dimension(300, 450));
		lt12.setPreferredSize(new Dimension(300, 450));
		lt13.setPreferredSize(new Dimension(300, 450));

		eastegg = new JPanel();
		eastegg.setLayout(new BoxLayout(eastegg, BoxLayout.X_AXIS));
		_mainPanel.add(eastegg);


		if(t1.size()==0) {
			lt1.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t1.size(); i++) {
				String card = "/GUIs/Cards/" + t1.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt1.add(label, new Integer(i));
			}
		}

		if(t2.size()==0) {
			lt2.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t2.size(); i++) {
				String card = "/GUIs/Cards/" + t2.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt2.add(label, new Integer(i));
			}
		}

		if(t3.size()==0) {
			lt3.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t3.size(); i++) {
				String card = "/GUIs/Cards/" + t3.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt3.add(label, new Integer(i));
			}
		}

		if(t4.size()==0) {
			lt4.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t4.size(); i++) {
				String card = "/GUIs/Cards/" + t4.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt4.add(label, new Integer(i));
			}
		}

		if(t5.size()==0) {
			lt5.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t5.size(); i++) {
				String card = "/GUIs/Cards/" + t5.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt5.add(label, new Integer(i));
			}
		}

		if(t6.size()==0) {
			lt6.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t6.size(); i++) {
				String card = "/GUIs/Cards/" + t6.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt6.add(label, new Integer(i));
			}
		}

		if(t7.size()==0) {
			lt7.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t7.size(); i++) {
				String card = "/GUIs/Cards/" + t7.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt7.add(label, new Integer(i));
			}
		}

		if(t8.size()==0) {
			lt8.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t8.size(); i++) {
				String card = "/GUIs/Cards/" + t8.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt8.add(label, new Integer(i));
			}
		}

		if(t9.size()==0) {
			lt9.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t9.size(); i++) {
				String card = "/GUIs/Cards/" + t9.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt9.add(label, new Integer(i));
			}
		}

		if(t10.size()==0) {
			lt10.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t10.size(); i++) {
				String card = "/GUIs/Cards/" + t10.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt10.add(label, new Integer(i));
			}
		}

		if(t11.size()==0) {
			lt11.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t11.size(); i++) {
				String card = "/GUIs/Cards/" + t11.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt11.add(label, new Integer(i));
			}
		}

		if(t12.size()==0) {
			lt12.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t12.size(); i++) {
				String card = "/GUIs/Cards/" + t12.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt12.add(label, new Integer(i));
			}
		}

		if(t13.size()==0) {
			lt13.add(emptyLabel,0);
		}else {
			for (int i = 0; i < t13.size(); i++) {
				String card = "/GUIs/Cards/" + t13.get(i)+ ".gif";
				JLabel label = lsGame.createDisplayImage(card);
				label.setBounds(10, i * 30, 83, 107);
				label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lt13.add(label, new Integer(i));
			}
		}


		_tableau = new JPanel();
		_tableau.setLayout(new BoxLayout(_tableau, BoxLayout.X_AXIS));
		_tableau.add(lt1);
		_tableau.add(lt2);
		_tableau.add(lt3);
		_tableau.add(lt4);
		_tableau.add(lt5);
		_tableau.add(lt6);
		_tableau.add(lt7);
		_tableau.add(lt8);
		_tableau.add(lt9);
		_tableau.add(lt10);
		_tableau.add(lt11);
		_tableau.add(lt12);
		_tableau.add(lt13);


		_mainPanel.add(_tableau);



		_stock = new JPanel();
		_stock.setLayout(new BoxLayout(_stock, BoxLayout.Y_AXIS));
		_stock.add(new JLabel("Stock: " + stockArray.size()));

		if(stockArray.size()==0) {
			emptyLabel.addMouseListener(new FTStockMouse(lsGame,this));
			_stock.add(emptyLabel);
		}else {
			stockLabel.addMouseListener(new FTStockMouse(lsGame,this));
			_stock.add(stockLabel);
		}


		stockNwaste.add(_stock);

		_waste = new JPanel();
		_waste.setLayout(new BoxLayout(_waste, BoxLayout.Y_AXIS));
		_waste.add(new JLabel("Waste: "+wastePile.size()));

		if(wastePile.size()==0) {
			_waste.add(emptyLabel);
		}else {
			String card = "/GUIs/Cards/" + wastePile.get(wastePile.size()-1)+ ".gif";
			JLabel label = lsGame.createDisplayImage(card);
			label.setBounds(10, 0, 83, 107);
			label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			_waste.add(label);
		}

		_waste.addMouseListener(new FTHomeMouse(lsGame, "w", _waste));

		stockNwaste.add(_waste);
		_mainPanel.add(stockNwaste);


		_homecellA1 = new JPanel();
		_homecellA1.setLayout(new BoxLayout(_homecellA1, BoxLayout.Y_AXIS));
		_homecellA1.add(new JLabel("Homecell:"));
		String card1 = "/GUIs/Cards/" + hs1.get(hs1.size()-1)+ ".gif";
		JLabel label1 = lsGame.createDisplayImage(card1);
		label1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA1.add(label1);


		_homecellA2 = new JPanel();
		_homecellA2.setLayout(new BoxLayout(_homecellA2, BoxLayout.Y_AXIS));
		_homecellA2.add(new JLabel("Homecell:"));
		String card2 = "/GUIs/Cards/" + hs2.get(hs2.size()-1)+ ".gif";
		JLabel label2 = lsGame.createDisplayImage(card2);
		label2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA2.add(label2);


		_homecellA3 = new JPanel();
		_homecellA3.setLayout(new BoxLayout(_homecellA3, BoxLayout.Y_AXIS));
		_homecellA3.add(new JLabel("Homecell:"));
		String card3 = "/GUIs/Cards/" + hs3.get(hs3.size()-1)+ ".gif";
		JLabel label3 = lsGame.createDisplayImage(card3);
		label3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA3.add(label3);


		_homecellA4 = new JPanel();
		_homecellA4.setLayout(new BoxLayout(_homecellA4, BoxLayout.Y_AXIS));
		_homecellA4.add(new JLabel("Homecell:"));
		String card4 = "/GUIs/Cards/" + hs4.get(hs4.size()-1)+ ".gif";
		JLabel label4 = lsGame.createDisplayImage(card4);
		label4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA4.add(label4);



		_homecellA5 = new JPanel();
		_homecellA5.setLayout(new BoxLayout(_homecellA5, BoxLayout.Y_AXIS));
		_homecellA5.add(new JLabel("Homecell:"));
		String card5 = "/GUIs/Cards/" + hs5.get(hs5.size()-1)+ ".gif";
		JLabel label5 = lsGame.createDisplayImage(card5);
		label5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA5.add(label5);



		_homecellA6 = new JPanel();
		_homecellA6.setLayout(new BoxLayout(_homecellA6, BoxLayout.Y_AXIS));
		_homecellA6.add(new JLabel("Homecell:"));
		String card6 = "/GUIs/Cards/" + hs6.get(hs6.size()-1)+ ".gif";
		JLabel label6 = lsGame.createDisplayImage(card6);
		label6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA6.add(label6);


		_homecellA7 = new JPanel();
		_homecellA7.setLayout(new BoxLayout(_homecellA7, BoxLayout.Y_AXIS));
		_homecellA7.add(new JLabel("Homecell:"));
		String card7 = "/GUIs/Cards/" + hs7.get(hs7.size()-1)+ ".gif";
		JLabel label7 = lsGame.createDisplayImage(card7);
		label7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA7.add(label7);


		_homecellA8 = new JPanel();
		_homecellA8.setLayout(new BoxLayout(_homecellA8, BoxLayout.Y_AXIS));
		_homecellA8.add(new JLabel("Homecell:"));
		String card8 = "/GUIs/Cards/" + hs8.get(hs8.size()-1)+ ".gif";
		JLabel label8 = lsGame.createDisplayImage(card8);
		label8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellA8.add(label8);

		_homecellA1.addMouseListener(new FTHomeMouse(lsGame, "h1", _homecellA1));
		_homecellA2.addMouseListener(new FTHomeMouse(lsGame, "h2", _homecellA2));
		_homecellA3.addMouseListener(new FTHomeMouse(lsGame, "h3", _homecellA3));
		_homecellA4.addMouseListener(new FTHomeMouse(lsGame, "h4", _homecellA4));	
		_homecellA5.addMouseListener(new FTHomeMouse(lsGame, "h5", _homecellA5));
		_homecellA6.addMouseListener(new FTHomeMouse(lsGame, "h6", _homecellA6));
		_homecellA7.addMouseListener(new FTHomeMouse(lsGame, "h7", _homecellA7));
		_homecellA8.addMouseListener(new FTHomeMouse(lsGame, "h8", _homecellA8));

		_hs = new JPanel();
		_hs.setLayout(new BoxLayout(_hs, BoxLayout.X_AXIS));
		_hs.add(_homecellA1);
		_hs.add(_homecellA2);
		_hs.add(_homecellA3);
		_hs.add(_homecellA4);
		_hs.add(_homecellA5);
		_hs.add(_homecellA6);
		_hs.add(_homecellA7);
		_hs.add(_homecellA8);
		_mainPanel.add(_hs);



		t1l = new FTTableMouse(lsGame, "t1", lt1,t1);
		t2l = new FTTableMouse(lsGame, "t2", lt2,t2);
		t3l = new FTTableMouse(lsGame, "t3", lt3,t3);
		t4l = new FTTableMouse(lsGame, "t4", lt4,t4);
		t5l = new FTTableMouse(lsGame, "t5", lt5,t5);
		t6l = new FTTableMouse(lsGame, "t6", lt6,t6);
		t7l = new FTTableMouse(lsGame, "t7", lt7,t7);
		t8l = new FTTableMouse(lsGame, "t8", lt8,t8);
		t9l = new FTTableMouse(lsGame, "t9", lt9,t9);
		t10l = new FTTableMouse(lsGame, "t10", lt10,t10);
		t11l = new FTTableMouse(lsGame, "t11", lt11,t11);
		t12l = new FTTableMouse(lsGame, "t12", lt12,t12);
		t13l = new FTTableMouse(lsGame, "t13", lt13,t13);

		lt1.addMouseListener(t1l);
		lt2.addMouseListener(t2l);
		lt3.addMouseListener(t3l);
		lt4.addMouseListener(t4l);
		lt5.addMouseListener(t5l);
		lt6.addMouseListener(t6l);
		lt7.addMouseListener(t7l);
		lt8.addMouseListener(t8l);
		lt9.addMouseListener(t9l);
		lt10.addMouseListener(t10l);
		lt11.addMouseListener(t11l);
		lt12.addMouseListener(t12l);
		lt13.addMouseListener(t13l);


	}

	public Color randomColor() {
		float red = (float) Math.random();
		float green = (float) Math.random();
		float blue = (float) Math.random();
		Color col = new Color(red, green, blue);
		return col;

	}

	public void setLabelProperties(JLabel label, Color back, Color front) {
		label.setFont(new Font("Courier", Font.BOLD, 24));
		label.setBackground(back);
		label.setForeground(front);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}


	@Override
	public void update() {


		//No cards in a homecell pile can be selected
		if (lsGame.getTwoNames().size() == 1) {
			String s1 = lsGame.getTwoNames().get(0);
			if(s1.contains("h")) {
				_mainPanel.removeAll();
				lsGame.setTwoNames0();
				//lsGame.checkStocks0();
				SetGUI("You CANNOT move cards from Homecell!", Color.YELLOW, Color.RED);
				_mainPanel.revalidate();
				_mainPanel.repaint();
				counter=0;
			}

		}

		if (lsGame.getTwoNames().size() == 2) {
			counter=0;
			_mainPanel.removeAll();
			String s1 = lsGame.getTwoNames().get(0);
			String s2 = lsGame.getTwoNames().get(1);
			lsGame.setTwoNames0();
			//lsGame.checkStocks0();
			if (s1.equals(s2)) {
				SetGUI("Please move the card to some other piles!", Color.WHITE, Color.BLUE);
			}

			else if (s2.contains("w")) {
				SetGUI("Only cards from Stock can be moved to Waste!", Color.YELLOW, Color.RED);
			}
			if ((s1.contains("t") && s2.contains("h")) || (s1.contains("w") && s2.contains("h"))) {
				if (lsGame.XtoHomecell(StoA.get(s1), StoA.get(s2))) {
					SetGUI("Legal move!", Color.WHITE, randomColor());
				} else {
					SetGUI("Illegal move!!", Color.YELLOW, Color.RED);
				}
			} else if ((s1.contains("t") && s2.contains("t") && !s1.equals(s2)) || (s1.contains("w") && s2.contains("t"))) {
				if (lsGame.XtoTable(StoA.get(s1), StoA.get(s2))) {
					SetGUI("Legal move!", Color.WHITE, randomColor());
				} else {
					SetGUI("Illegal move!!", Color.YELLOW, Color.RED);
				}
			}
			_mainPanel.revalidate();
			_mainPanel.repaint();
		}

		//check move to Stock -- illegal
		int cStockSize = lsGame.getCheckStock().size();
		if(cStockSize>1) {
			String s = String.join("", lsGame.getCheckStock());
			if(s.contains("xs")&& !s.contains("xxs") && !s.contains("h")) {
				lsGame.checkStocks0();
				lsGame.setTwoNames0();	
				counter=0;
				_mainPanel.removeAll();
				SetGUI("NO cards can be moved to Stock!", Color.YELLOW, Color.RED);
				_mainPanel.revalidate();
				_mainPanel.repaint();
			}else {
				lsGame.checkStocks0();
			}
		}else if(cStockSize==1){
			String s2 = lsGame.getCheckStock().get(0);
			if(s2.contains("h")) {
				lsGame.checkStocks0();
				counter=0;
			}
			else if(s2.contains("s")) {
				lsGame.checkStocks0();	
				_mainPanel.removeAll();
				if(lsGame.removeCardFromStock(lsGame.getStock())) {
					SetGUI("Moving from Stock to Waste is always legal",Color.WHITE,randomColor());
					counter++;
				}
				else {
					SetGUI("No more cards in Stock!",Color.YELLOW,Color.RED);
				}
				_mainPanel.revalidate();
				_mainPanel.repaint();
			}
		}
		
		
		///Easter egg implementation 
		//Appear after 3 consecutive clicks of stock
		if(counter==3) {	
			eastegg.add(lsGame.createDisplayImage("/GUIs/Easteggs/pys.gif"));
			eastegg.revalidate();
			eastegg.repaint();
			counter=0;
			Timer timer = new Timer(3000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					eastegg.removeAll();
					eastegg.revalidate();
					eastegg.repaint();
				}
			});
			timer.setRepeats(false);
			timer.start();
		}
		updateJFrameIfNotHeadless();

	}

	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}


	public ArrayList<JLabel> getWasteArray() {
		return wasteArray;
	}

	public void setWasteArray(ArrayList<JLabel> wasteArray) {
		this.wasteArray = wasteArray;
	}

	public JPanel getMain() {
		return _mainPanel;
	}

	public JLabel getStockLabel() {
		return stockLabel;
	}

}
