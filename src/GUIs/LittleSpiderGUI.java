package GUIs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.HashMap;
import java.util.Observable;
import java.util.ArrayList;

import solitaire.*;

import control.*;

public class LittleSpiderGUI implements Observer {

	private LittleSpider ftGame;
	private ArrayList<String> t1;
	private ArrayList<String> t2;
	private ArrayList<String> t3;
	private ArrayList<String> t4;
	private ArrayList<String> t5;
	private ArrayList<String> t6;
	private ArrayList<String> t7;
	private ArrayList<String> t8;
	private ArrayList<JLabel> homeCellAD;
	private ArrayList<JLabel> homeCellAH;
	private ArrayList<JLabel> homeCellKS;
	private ArrayList<JLabel> homeCellKC;
	private JPanel _mainPanel;
	private JPanel _tableau;
	private JPanel _hs;
	private JPanel _homecellAD;
	private JPanel _homecellAH;
	private JPanel _homecellKS;
	private JPanel _homecellKC;
	private HashMap<String, JLabel> _cardLabel;
	private JLayeredPane lt1;
	private JLayeredPane lt2;
	private JLayeredPane lt3;
	private JLayeredPane lt4;
	private JLayeredPane lt5;
	private JLayeredPane lt6;
	private JLayeredPane lt7;
	private JLayeredPane lt8;
	private ArrayList<String> _hAD;
	private ArrayList<String> _hAH;
	private ArrayList<String> _hKS;
	private ArrayList<String> _hKC;
	private Driverspider _windowHolder;
	private JLabel homeLabelAD;
	private JLabel homeLabelAH;
	private JLabel homeLabelKS;
	private JLabel homeLabelKC;
	private TMouseListener t1l;
	private TMouseListener t2l;
	private TMouseListener t3l;
	private TMouseListener t4l;
	private TMouseListener t5l;
	private TMouseListener t6l;
	private TMouseListener t7l;
	private TMouseListener t8l;
	private JPanel feedback;
	private JLabel message;
	private JPanel eastegg;

	// Store name as key, pile as value
	private HashMap<String, ArrayList<String>> StoA;

	public TMouseListener getT1l() {
		return t1l;
	}

	public TMouseListener getT2l() {
		return t2l;
	}

	public TMouseListener getT3l() {
		return t3l;
	}

	public TMouseListener getT4l() {
		return t4l;
	}

	public TMouseListener getT5l() {
		return t5l;
	}

	public TMouseListener getT6l() {
		return t6l;
	}

	public TMouseListener getT7l() {
		return t7l;
	}

	public TMouseListener getT8l() {
		return t8l;
	}

	public LittleSpiderGUI(LittleSpider lsGamea, JPanel mp, Driverspider driver) {
		ftGame = lsGamea;
		_windowHolder = driver;
		ftGame = new LittleSpider();

		_cardLabel = ftGame.getCardLabel();

		homeCellAD = new ArrayList<JLabel>();
		homeCellAH = new ArrayList<JLabel>();
		homeCellKS = new ArrayList<JLabel>();
		homeCellKC = new ArrayList<JLabel>();

		t1 = ftGame.getT1();
		t2 = ftGame.getT2();
		t3 = ftGame.getT3();
		t4 = ftGame.getT4();
		t5 = ftGame.getT5();
		t6 = ftGame.getT6();
		t7 = ftGame.getT7();
		t8 = ftGame.getT8();

		_hAD = ftGame.getHomeCellAD();
		_hAH = ftGame.getHomeCellAH();
		_hKS = ftGame.getHomeCellKS();
		_hKC = ftGame.getHomeCellKC();

		StoA = new HashMap<String, ArrayList<String>>();
		StoA.put("t1", t1);
		StoA.put("t2", t2);
		StoA.put("t3", t3);
		StoA.put("t4", t4);
		StoA.put("t5", t5);
		StoA.put("t6", t6);
		StoA.put("t7", t7);
		StoA.put("t8", t8);
		StoA.put("h1", _hAD);
		StoA.put("h2", _hAH);
		StoA.put("h3", _hKS);
		StoA.put("h4", _hKC);

		lt1 = new JLayeredPane();
		lt2 = new JLayeredPane();
		lt3 = new JLayeredPane();
		lt4 = new JLayeredPane();
		lt5 = new JLayeredPane();
		lt6 = new JLayeredPane();
		lt7 = new JLayeredPane();
		lt8 = new JLayeredPane();
		lt1.setPreferredSize(new Dimension(300, 450));
		lt2.setPreferredSize(new Dimension(300, 450));
		lt3.setPreferredSize(new Dimension(300, 450));
		lt4.setPreferredSize(new Dimension(300, 450));
		lt5.setPreferredSize(new Dimension(300, 450));
		lt6.setPreferredSize(new Dimension(300, 450));
		lt7.setPreferredSize(new Dimension(300, 450));
		lt8.setPreferredSize(new Dimension(300, 450));

		JLabel AD = ftGame.createDisplayImage("/GUIs/Cards/ad.gif");
		JLabel AH = ftGame.createDisplayImage("/GUIs/Cards/ah.gif");
		JLabel KS = ftGame.createDisplayImage("/GUIs/Cards/ks.gif");
		JLabel KC = ftGame.createDisplayImage("/GUIs/Cards/kc.gif");

		AD.setBounds(10, 0, 83, 107);
		AH.setBounds(10, 0, 83, 107);
		KS.setBounds(10, 0, 83, 107);
		KC.setBounds(10, 0, 83, 107);

		for (int i = 0; i < t1.size(); i++) {
			JLabel card = _cardLabel.get(t1.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt1.add(card, new Integer(i));
		}
		for (int i = 0; i < t2.size(); i++) {
			JLabel card = _cardLabel.get(t2.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt2.add(card, new Integer(i));
		}
		for (int i = 0; i < t3.size(); i++) {
			JLabel card = _cardLabel.get(t3.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt3.add(card, new Integer(i));
		}
		for (int i = 0; i < t4.size(); i++) {
			JLabel card = _cardLabel.get(t4.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt4.add(card, new Integer(i));
		}
		for (int i = 0; i < t5.size(); i++) {
			JLabel card = _cardLabel.get(t5.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt5.add(card, new Integer(i));
		}
		for (int i = 0; i < t6.size(); i++) {
			JLabel card = _cardLabel.get(t6.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt6.add(card, new Integer(i));
		}
		for (int i = 0; i < t7.size(); i++) {
			JLabel card = _cardLabel.get(t7.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt7.add(card, new Integer(i));
		}
		for (int i = 0; i < t8.size(); i++) {
			JLabel card = _cardLabel.get(t8.get(i));
			card.setBounds(10, i * 30, 83, 107);
			card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			lt8.add(card, new Integer(i));
		}

		for (int i = 0; i < ftGame.getHomeCellAD().size(); i++) {
			String card = "/GUIs/Cards/" + ftGame.getHomeCellAD().get(i) + ".gif";
			JLabel label = ftGame.createDisplayImage(card);
			homeCellAD.add(label);
		}
		for (int i = 0; i < ftGame.getHomeCellAH().size(); i++) {
			String card = "/GUIs/Cards/" + ftGame.getHomeCellAH().get(i) + ".gif";
			JLabel label = ftGame.createDisplayImage(card);
			homeCellAH.add(label);
		}
		for (int i = 0; i < ftGame.getHomeCellKS().size(); i++) {
			String card = "/GUIs/Cards/" + ftGame.getHomeCellKS().get(i) + ".gif";
			JLabel label = ftGame.createDisplayImage(card);
			homeCellKS.add(label);
		}
		for (int i = 0; i < ftGame.getHomeCellKC().size(); i++) {
			String card = "/GUIs/Cards/" + ftGame.getHomeCellKC().get(i) + ".gif";
			JLabel label = ftGame.createDisplayImage(card);
			homeCellKC.add(label);
		}

		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));

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

		_mainPanel.add(_tableau);
		
		eastegg = new JPanel();
		eastegg.setLayout(new BoxLayout(eastegg, BoxLayout.X_AXIS));
		_mainPanel.add(eastegg);
		
		feedback = new JPanel();
		feedback.setLayout(new BoxLayout(feedback, BoxLayout.X_AXIS));
		_mainPanel.add(feedback);

		message = new JLabel("Start your first move!");
		setLabelProperties(message, Color.WHITE, Color.BLACK);
		feedback.add(message);


		homeLabelAD = AD;
		homeLabelAD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellAD = new JPanel();
		_homecellAD.setLayout(new BoxLayout(_homecellAD, BoxLayout.Y_AXIS));
		_homecellAD.add(new JLabel("Homecell:"));
		_homecellAD.add(homeLabelAD);

		homeLabelAH = AH;
		homeLabelAH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellAH = new JPanel();
		_homecellAH.setLayout(new BoxLayout(_homecellAH, BoxLayout.Y_AXIS));
		_homecellAH.add(new JLabel("Homecell:"));
		_homecellAH.add(homeLabelAH);

		homeLabelKS = KS;
		homeLabelKS.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellKS = new JPanel();
		_homecellKS.setLayout(new BoxLayout(_homecellKS, BoxLayout.Y_AXIS));
		_homecellKS.add(new JLabel("Homecell:"));
		_homecellKS.add(homeLabelKS);

		homeLabelKC = KC;
		homeLabelKC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_homecellKC = new JPanel();
		_homecellKC.setLayout(new BoxLayout(_homecellKC, BoxLayout.Y_AXIS));
		_homecellKC.add(new JLabel("Homecell:"));
		_homecellKC.add(homeLabelKC);

		_homecellAD.addMouseListener(new HomeCellMouseListener(ftGame, "h1", _homecellAD, _hAD));
		_homecellAH.addMouseListener(new HomeCellMouseListener(ftGame, "h2", _homecellAH, _hAH));
		_homecellKS.addMouseListener(new HomeCellMouseListener(ftGame, "h3", _homecellKS, _hKS));
		_homecellKC.addMouseListener(new HomeCellMouseListener(ftGame, "h4", _homecellKC, _hKC));

		_hs = new JPanel();
		_hs.setLayout(new BoxLayout(_hs, BoxLayout.X_AXIS));
		_hs.add(_homecellAD);
		_hs.add(_homecellAH);
		_hs.add(_homecellKS);
		_hs.add(_homecellKC);
		_mainPanel.add(_hs);

		t1l = new TMouseListener(ftGame, "t1", lt1, t1);
		t2l = new TMouseListener(ftGame, "t2", lt2, t2);
		t3l = new TMouseListener(ftGame, "t3", lt3, t3);
		t4l = new TMouseListener(ftGame, "t4", lt4, t4);
		t5l = new TMouseListener(ftGame, "t5", lt5, t5);
		t6l = new TMouseListener(ftGame, "t6", lt6, t6);
		t7l = new TMouseListener(ftGame, "t7", lt7, t7);
		t8l = new TMouseListener(ftGame, "t8", lt8, t8);

		lt1.addMouseListener(t1l);
		lt2.addMouseListener(t2l);
		lt3.addMouseListener(t3l);
		lt4.addMouseListener(t4l);
		lt5.addMouseListener(t5l);
		lt6.addMouseListener(t6l);
		lt7.addMouseListener(t7l);
		lt8.addMouseListener(t8l);

		ftGame.addObserver(this);

		
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

	public JLabel getHomeLabelAD() {
		return homeLabelAD;
	}

	public JLabel getHomeLabelAH() {
		return homeLabelAH;
	}

	public JLabel getHomeLabelKS() {
		return homeLabelKS;
	}

	public JLabel getHomeLabelKC() {
		return homeLabelKC;
	}

	public void updateJFrameIfNotHeadless() {
		if (_windowHolder != null) {
			_windowHolder.updateJFrame();
		}
	}
	
	
	public boolean gameWin() {
    	return (_hAD.size()==13 && _hAH.size()==13 && _hKS.size()==13 && _hKC.size()==13);
    }
    
    public ArrayList<ArrayList<String>> topCards() {
    	ArrayList<ArrayList<String>> retVal = new ArrayList<ArrayList<String>>();
    	String st1 = "xx";
    	String st2 = "xx";
    	String st3 = "xx";
    	String st4 = "xx";
    	String st5 = "xx";
    	String st6 = "xx";
    	String st7 = "xx";
    	String st8 = "xx";
    	String sh1 = "ad";
    	String sh2 = "ah";
    	String sh3 = "ks";
    	String sh4 = "kc";
    	if(t1.size()>0) {
    		st1 = t1.get(t1.size()-1);
    	}
    	if(t2.size()>0) {
    		st2 = t2.get(t2.size()-1);
    	}
    	if(t3.size()>0) {
    		st3 = t3.get(t3.size()-1);
    	}
    	if(t4.size()>0) {
    		st4 = t4.get(t4.size()-1);
    	}
    	if(t5.size()>0) {
    		st5 = t5.get(t5.size()-1);
    	}
    	if(t6.size()>0) {
    		st6 = t6.get(t6.size()-1);
    	}
    	if(t7.size()>0) {
    		st7 = t7.get(t7.size()-1);
    	}
    	if(t8.size()>0) {
    		st8 = t8.get(t8.size()-1);
    	}
    	if(_hAD.size()>1) {
    		sh1 = _hAD.get(_hAD.size()-1);
    	}
    	if(_hAH.size()>1) {
    		sh2 = _hAH.get(_hAH.size()-1);
    	}
    	if(_hKS.size()>1) {
    		sh3 = _hKS.get(_hKS.size()-1);
    	}
    	if(_hKC.size()>1) {
    		sh4 = _hKC.get(_hKC.size()-1);
    	}
    	ArrayList<String>table = new ArrayList<String>();
    	ArrayList<String>homec = new ArrayList<String>();
    	ArrayList<String>homec2 = new ArrayList<String>();
    	table.add(st1);
    	table.add(st2);
    	table.add(st3);
    	table.add(st4);
    	table.add(st5);
    	table.add(st6);
    	table.add(st7);
    	table.add(st8);
    	homec.add(sh1);
    	homec.add(sh2);
    	homec.add(sh3);
    	homec.add(sh4);
    	if(! sh1.equals("ad")) {
    		homec2.add(sh1);
    	}
    	if(! sh2.equals("ah")) {
    		homec2.add(sh2);
    	}
    	if(! sh3.equals("ks")) {
    		homec2.add(sh3);
    	}
    	if(! sh4.equals("kc")) {
    		homec2.add(sh4);
    	}
    	retVal.add(table);
    	retVal.add(homec);
    	retVal.add(homec2);
    	return retVal;	
    }
    
	public boolean lose1() {
    	ArrayList<Boolean> results = new ArrayList<Boolean>();
    	ArrayList<ArrayList<String>> cards = topCards();
    	ArrayList<String>table = cards.get(0);
    	for(int i=0; i<table.size();i++) {
    		for(int j=0; j<table.size();j++)
    			if(ftGame.TtoTCards(table.get(i),table.get(j))) {
    				results.add(false);
    				
    			}else {
    				results.add(true);
    			}
    	}
    	if(results.contains(false)) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
	public boolean lose2() {
    	ArrayList<Boolean> results = new ArrayList<Boolean>();
    	ArrayList<ArrayList<String>> cards = topCards();
    	ArrayList<String>table = cards.get(0);
    	ArrayList<String>homec = cards.get(1);
    	for(int i=0; i<table.size();i++) {
    		for(int j=0;j<homec.size();j++) {
    			if(ftGame.TtoHCards(table.get(i),homec.get(j))) {
    				results.add(false);
    			}else {
    				results.add(true);
    			}
    			
    		}
    	}
    	if(results.contains(false)) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
	public boolean lose3() {
    	ArrayList<Boolean> results = new ArrayList<Boolean>();
    	ArrayList<ArrayList<String>> cards = topCards();
    	ArrayList<String>table = cards.get(0);
    	ArrayList<String>homec = cards.get(2);
    	if(! homec.isEmpty()) {
    	for(int i=0; i<homec.size();i++) {
    		for(int j=0;j<table.size();j++) {
    			if(ftGame.TtoTCards(homec.get(i),table.get(j))) {
    				results.add(false);
    			}else {
    				results.add(true);
    			}
    			
    		}
    	}if(results.contains(false)) {
    		return false;
    	}
    	else {
    		return true;
    	}}
    	else {
    		return true;
    	}
    }
    

	@Override
	public void update() {
		if (ftGame.getTwoNames().size() == 2) {
			feedback.removeAll();
			message = new JLabel(" ");
			feedback.add(message);
			feedback.revalidate();
			feedback.repaint();
			String s1 = ftGame.getTwoNames().get(0);
			String s2 = ftGame.getTwoNames().get(1);
			ftGame.setTwoNames0();

			// first is to check if both clicks are from table pile
			// the other three conditions will be
			// from table to homecell: s1.contains("t") && s2.contains("h")
			// from homecell to table: s1.contains("h") && s2.contains("t")
			// from homecell to homecell: s1.contains("h") && s2.contains("h")--this should
			// always generate some error message
			if (s1.contains("t") && s2.contains("t")) {
				// check if the same card was clicked twice
				if (s1.equals(s2)) {
					int n1 = Integer.valueOf(s1.substring(1, 2));
					Component c1 = _tableau.getComponent(n1 - 1);
					if (c1 instanceof JLayeredPane) {
						((JLayeredPane) c1).removeAll();
						for (int i = 0; i < StoA.get(s1).size(); i++) {
							JLabel card = _cardLabel.get(StoA.get(s1).get(i));
							card.setBounds(10, i * 30, 83, 107);
							TMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JLayeredPane) c1).add(card, new Integer(i));
						}
						((JLayeredPane) c1).revalidate();
						((JLayeredPane) c1).repaint();

					}
				} else {
					// TtoT is a method I added in littlespider. it checked if one card is stackable
					// onto another.
					// If yes, it removes the card to the stackable pile.
					if (ftGame.TtoT(StoA.get(s1), StoA.get(s2))) {
						// since the pile is changed, we need to add the new pile to the hashmap.
						// the new pile will be the new key to the name of that pile.
						// n1,n2: for example, if pile name s1 is t1, pile name s2 is t4, than n1 is 1,
						// n2 is 4
						// this number will help us find the components in the relevant JPanel
						int n1 = Integer.valueOf(s1.substring(1, 2));
						int n2 = Integer.valueOf(s2.substring(1, 2));
						// since we added all the table JLayeredPane (lt1 to lt8) sequentially,
						// we can get the change-needed JLayeredPanes using n1, n2
						// Since component indexing starts from 0, like lt1 at _tableau position 0,
						// we need n1-1, n2-1
						Component c1 = _tableau.getComponent(n1 - 1);
						Component c2 = _tableau.getComponent(n2 - 1);
						// The following block is to change the two JLayeredPanes
						// I just remove the old everything and add the new everything
						if (c1 instanceof JLayeredPane && c2 instanceof JLayeredPane) {
							((JLayeredPane) c1).removeAll();
							for (int i = 0; i < StoA.get(s1).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s1).get(i));
								card.setBounds(10, i * 30, 83, 107);
								TMouseListener.unselect(card);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c1).add(card, new Integer(i));
							}
							((JLayeredPane) c2).removeAll();
							for (int i = 0; i < StoA.get(s2).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s2).get(i));
								TMouseListener.unselect(card);
								card.setBounds(10, i * 30, 83, 107);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c2).add(card, new Integer(i));
							}
							((JLayeredPane) c1).revalidate();
							((JLayeredPane) c2).revalidate();
							((JLayeredPane) c1).repaint();
							((JLayeredPane) c2).repaint();

						}

					} else {
						// not stackable case table to table
						// error message panel update should be in this block
						//
						//
						ftGame.setIllegal();
						feedback.removeAll();
						message = new JLabel("Try again!");
						setLabelProperties(message, Color.WHITE, randomColor());
						feedback.add(message);
						feedback.revalidate();
						feedback.repaint();
						int n1 = Integer.valueOf(s1.substring(1, 2));
						int n2 = Integer.valueOf(s2.substring(1, 2));
						Component c1 = _tableau.getComponent(n1 - 1);
						Component c2 = _tableau.getComponent(n2 - 1);
						if (c1 instanceof JLayeredPane && c2 instanceof JLayeredPane) {
							((JLayeredPane) c1).removeAll();
							for (int i = 0; i < StoA.get(s1).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s1).get(i));
								card.setBounds(10, i * 30, 83, 107);
								TMouseListener.unselect(card);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c1).add(card, new Integer(i));
							}
							((JLayeredPane) c2).removeAll();
							for (int i = 0; i < StoA.get(s2).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s2).get(i));
								TMouseListener.unselect(card);
								card.setBounds(10, i * 30, 83, 107);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c2).add(card, new Integer(i));
							}
							((JLayeredPane) c1).revalidate();
							((JLayeredPane) c2).revalidate();
							((JLayeredPane) c1).repaint();
							((JLayeredPane) c2).repaint();
						}
					}

				}
			}
			if (s1 != null && s2 != null && s1.contains("t") && s2.contains("h")) {
				if (ftGame.TableToHomecell(StoA.get(s1), StoA.get(s2))) {
					int n1 = Integer.valueOf(s1.substring(1, 2));
					int n2 = Integer.valueOf(s2.substring(1, 2));
					Component c1 = _tableau.getComponent(n1 - 1);
					Component c2 = _hs.getComponent(n2 - 1);
					if (c1 instanceof JLayeredPane) {
						((JLayeredPane) c1).removeAll();
						for (int i = 0; i < StoA.get(s1).size(); i++) {
							JLabel card = _cardLabel.get(StoA.get(s1).get(i));
							card.setBounds(10, i * 30, 83, 107);
							TMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JLayeredPane) c1).add(card, new Integer(i));
						}
						((JLayeredPane) c1).revalidate();
						((JLayeredPane) c1).repaint();
					}
					if (c2 instanceof JPanel) {
						((JPanel) c2).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s2).get(StoA.get(s2).size() - 1));
						card.setBounds(10, 0, 83, 107);
						TMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c2).add(new JLabel("Homecell:"));
						((JPanel) c2).add(card);
						((JPanel) c2).revalidate();
						((JPanel) c2).repaint();
					}

				} else {
					// not stackable case table to homecell
					// error message panel update should be in this block
					//
					//
					ftGame.setIllegal();
					feedback.removeAll();
					message = new JLabel("Try again!");
					setLabelProperties(message, Color.WHITE, randomColor());
					feedback.add(message);
					feedback.revalidate();
					feedback.repaint();
					int n1 = Integer.valueOf(s1.substring(1, 2));
					int n2 = Integer.valueOf(s2.substring(1, 2));
					Component c1 = _tableau.getComponent(n1 - 1);
					Component c2 = _hs.getComponent(n2 - 1);
					if (c1 instanceof JLayeredPane) {
						((JLayeredPane) c1).removeAll();
						for (int i = 0; i < StoA.get(s1).size(); i++) {
							JLabel card = _cardLabel.get(StoA.get(s1).get(i));
							card.setBounds(10, i * 30, 83, 107);
							TMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JLayeredPane) c1).add(card, new Integer(i));
						}
						((JLayeredPane) c1).revalidate();
						((JLayeredPane) c1).repaint();
					}
					if (c2 instanceof JPanel) {
						((JPanel) c2).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s2).get(StoA.get(s2).size() - 1));
						card.setBounds(10, 0, 83, 107);
						TMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c2).add(new JLabel("Homecell:"));
						((JPanel) c2).add(card);
						((JPanel) c2).revalidate();
						((JPanel) c2).repaint();
					}

				}

			}
			if (s1 != null && s2 != null && s1.contains("h") && s2.contains("t")) {
				if (StoA.get(s1).size() > 1) {
					if (ftGame.TtoT(StoA.get(s1), StoA.get(s2))) {
						int n1 = Integer.valueOf(s1.substring(1, 2));
						int n2 = Integer.valueOf(s2.substring(1, 2));
						Component c1 = _hs.getComponent(n1 - 1);
						Component c2 = _tableau.getComponent(n2 - 1);
						if (c1 instanceof JPanel) {
							((JPanel) c1).removeAll();
							JLabel card = _cardLabel.get(StoA.get(s1).get(StoA.get(s1).size() - 1));
							card.setBounds(10, 0, 83, 107);
							HomeCellMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JPanel) c1).add(new JLabel("Homecell:"));
							((JPanel) c1).add(card);
							((JPanel) c1).revalidate();
							((JPanel) c1).repaint();
						}
						if (c2 instanceof JLayeredPane) {
							((JLayeredPane) c2).removeAll();
							for (int i = 0; i < StoA.get(s2).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s2).get(i));
								card.setBounds(10, i * 30, 83, 107);
								TMouseListener.unselect(card);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c2).add(card, new Integer(i));
							}
							((JLayeredPane) c2).revalidate();
							((JLayeredPane) c2).repaint();
						}

					} else {

						// not stackable case homecell to table
						// error message panel update should be in this block
						//
						//
						ftGame.setIllegal();
						feedback.removeAll();
						message = new JLabel("Try again!");
						setLabelProperties(message, Color.WHITE, randomColor());
						feedback.add(message);
						feedback.revalidate();
						feedback.repaint();
						int n1 = Integer.valueOf(s1.substring(1, 2));
						int n2 = Integer.valueOf(s2.substring(1, 2));
						Component c1 = _hs.getComponent(n1 - 1);
						Component c2 = _tableau.getComponent(n2 - 1);
						if (c1 instanceof JPanel) {
							((JPanel) c1).removeAll();
							JLabel card = _cardLabel.get(StoA.get(s1).get(StoA.get(s1).size() - 1));
							card.setBounds(10, 0, 83, 107);
							HomeCellMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JPanel) c1).add(new JLabel("Homecell:"));
							((JPanel) c1).add(card);
							((JPanel) c1).revalidate();
							((JPanel) c1).repaint();
						}
						if (c2 instanceof JLayeredPane) {
							((JLayeredPane) c2).removeAll();
							for (int i = 0; i < StoA.get(s2).size(); i++) {
								JLabel card = _cardLabel.get(StoA.get(s2).get(i));
								card.setBounds(10, i * 30, 83, 107);
								TMouseListener.unselect(card);
								card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
								((JLayeredPane) c2).add(card, new Integer(i));
							}
							((JLayeredPane) c2).revalidate();
							((JLayeredPane) c2).repaint();

						}

					}
				}else {//when there is only one card in homecell error
					ftGame.setIllegal();
					feedback.removeAll();
					message = new JLabel("Try again!");
					setLabelProperties(message, Color.WHITE, randomColor());
					feedback.add(message);
					feedback.revalidate();
					feedback.repaint();
					int n1 = Integer.valueOf(s1.substring(1, 2));
					int n2 = Integer.valueOf(s2.substring(1, 2));
					Component c1 = _hs.getComponent(n1 - 1);
					Component c2 = _tableau.getComponent(n2 - 1);
					if (c1 instanceof JPanel) {
						((JPanel) c1).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s1).get(StoA.get(s1).size() - 1));
						card.setBounds(10, 0, 83, 107);
						HomeCellMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c1).add(new JLabel("Homecell:"));
						((JPanel) c1).add(card);
						((JPanel) c1).revalidate();
						((JPanel) c1).repaint();
					}
					if (c2 instanceof JLayeredPane) {
						((JLayeredPane) c2).removeAll();
						for (int i = 0; i < StoA.get(s2).size(); i++) {
							JLabel card = _cardLabel.get(StoA.get(s2).get(i));
							card.setBounds(10, i * 30, 83, 107);
							TMouseListener.unselect(card);
							card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
							((JLayeredPane) c2).add(card, new Integer(i));
						}
						((JLayeredPane) c2).revalidate();
						((JLayeredPane) c2).repaint();

					}
					
				}
			}
			if (s1 != null && s2 != null && s1.contains("h") && s2.contains("h")) {
				if (s1.equals(s2)) {
					int n1 = Integer.valueOf(s1.substring(1, 2));
					Component c1 = _hs.getComponent(n1 - 1);
					if (c1 instanceof JPanel) {
						((JPanel) c1).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s1).get(StoA.get(s1).size() - 1));
						card.setBounds(10, 0, 83, 107);
						HomeCellMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c1).add(new JLabel("Homecell:"));
						((JPanel) c1).add(card);
						((JPanel) c1).revalidate();
						((JPanel) c1).repaint();
					}
				} else {
					// not stackable case homecell to homecell
					// error message panel update should be in this block
					//
					
					ftGame.setIllegal();
					feedback.removeAll();
					message = new JLabel("Try again!");
					setLabelProperties(message, Color.WHITE, randomColor());
					feedback.add(message);
					feedback.revalidate();
					feedback.repaint();
					int n1 = Integer.valueOf(s1.substring(1, 2));
					int n2 = Integer.valueOf(s2.substring(1, 2));
					Component c1 = _hs.getComponent(n1 - 1);
					Component c2 = _hs.getComponent(n2 - 1);
					if (c1 instanceof JPanel) {
						((JPanel) c1).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s1).get(StoA.get(s1).size() - 1));
						card.setBounds(10, 0, 83, 107);
						HomeCellMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c1).add(new JLabel("Homecell:"));
						((JPanel) c1).add(card);
						((JPanel) c1).revalidate();
						((JPanel) c1).repaint();
					}
					if (c2 instanceof JPanel) {
						((JPanel) c2).removeAll();
						JLabel card = _cardLabel.get(StoA.get(s2).get(StoA.get(s2).size() - 1));
						card.setBounds(10, 0, 83, 107);
						HomeCellMouseListener.unselect(card);
						card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
						((JPanel) c2).add(new JLabel("Homecell:"));
						((JPanel) c2).add(card);
						((JPanel) c2).revalidate();
						((JPanel) c2).repaint();
					}

				}

			}
		}
		
		if (ftGame.getIllegal() == 5) {
			eastegg.add(ftGame.createDisplayImage("/GUIs/Easteggs/mh.jpg"));
			eastegg.revalidate();
			eastegg.repaint();
			
			ftGame.illegal0();
			Timer timer = new Timer(5000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					eastegg.removeAll();
					eastegg.revalidate();
					eastegg.repaint();
					feedback.removeAll();
					message = new JLabel("Try again!");
					setLabelProperties(message, Color.WHITE, Color.BLACK);
					feedback.add(message);
					feedback.revalidate();
					feedback.repaint();
				}
			});
			timer.setRepeats(false);
			timer.start();
		}
		
		if(gameWin()) {
			eastegg.removeAll();
			JLabel win = ftGame.getWin();
			eastegg.add(win);
			eastegg.revalidate();
			eastegg.repaint();
			feedback.removeAll();
			message = new JLabel("You won the game!");
			setLabelProperties(message, Color.BLACK, Color.GREEN);
			feedback.add(message);
			feedback.revalidate();
			feedback.repaint();
		}
		else {
			if(lose1()&&lose2()&&lose3()) {
		
			eastegg.removeAll();
			JLabel lose = ftGame.getLose();
			eastegg.add(lose);
			eastegg.revalidate();
			eastegg.repaint();
			feedback.removeAll();
			message = new JLabel(" Game Over! ");
			setLabelProperties(message, Color.BLACK, Color.RED);
			feedback.add(message);
			feedback.revalidate();
			feedback.repaint();
			
		}
		}

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
