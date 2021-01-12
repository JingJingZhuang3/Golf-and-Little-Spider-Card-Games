package GUIs;

import java.awt.Color;
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

public class GolfGUI implements Observer {
	private Golf _golf;
	private Driver _windowHolder;
	private JPanel _mainPanel;
	private JPanel _tableau;
	private JPanel _homecell;
	private JPanel _stock;
	private HashMap<String, JLabel> _cardLabel;
	private ArrayList<String> t1;
	private ArrayList<String> t2;
	private ArrayList<String> t3;
	private ArrayList<String> t4;
	private ArrayList<String> t5;
	private ArrayList<String> t6;
	private ArrayList<String> t7;
	private ArrayList<String> _h;
	private JLayeredPane lt1;
	private JLayeredPane lt2;
	private JLayeredPane lt3;
	private JLayeredPane lt4;
	private JLayeredPane lt5;
	private JLayeredPane lt6;
	private JLayeredPane lt7;
	private JLabel stockLabel;
	private JLabel homeLabel;
	private JPanel feedback;
	private JLabel message;
	private JPanel eastegg;

	public GolfGUI(Golf g, JPanel mp, Driver driver) {
		_golf = g;
		_windowHolder = driver;
		_cardLabel = _golf.getCardLabel();
		
		t1 = _golf.getTable1();
		t2 = _golf.getTable2();
		t3 = _golf.getTable3();
		t4 = _golf.getTable4();
		t5 = _golf.getTable5();
		t6 = _golf.getTable6();
		t7 = _golf.getTable7();
		_h = _golf.getHomecell();

		lt1 = new JLayeredPane();
		lt2 = new JLayeredPane();
		lt3 = new JLayeredPane();
		lt4 = new JLayeredPane();
		lt5 = new JLayeredPane();
		lt6 = new JLayeredPane();
		lt7 = new JLayeredPane();
		lt1.setPreferredSize(new Dimension(300, 210));
		lt2.setPreferredSize(new Dimension(300, 210));
		lt3.setPreferredSize(new Dimension(300, 210));
		lt4.setPreferredSize(new Dimension(300, 210));
		lt5.setPreferredSize(new Dimension(300, 210));
		lt6.setPreferredSize(new Dimension(300, 210));
		lt7.setPreferredSize(new Dimension(300, 210));

		
		

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

		_mainPanel = mp;
		_mainPanel.setLayout(new BoxLayout(_mainPanel, BoxLayout.Y_AXIS));

		feedback = new JPanel();
		feedback.setLayout(new BoxLayout(feedback, BoxLayout.X_AXIS));
		_mainPanel.add(feedback);

		message = new JLabel("Start your first move!");
		setLabelProperties(message, Color.WHITE, Color.BLACK);
		feedback.add(message);

		_tableau = new JPanel();
		_tableau.setLayout(new BoxLayout(_tableau, BoxLayout.X_AXIS));
		_tableau.add(lt1);
		_tableau.add(lt2);
		_tableau.add(lt3);
		_tableau.add(lt4);
		_tableau.add(lt5);
		_tableau.add(lt6);
		_tableau.add(lt7);

		_mainPanel.add(_tableau);

		eastegg = new JPanel();
		eastegg.setLayout(new BoxLayout(eastegg, BoxLayout.X_AXIS));
		_mainPanel.add(eastegg);

		stockLabel = _golf.createDisplayImage("/GUIs/Cards/card00.gif");
		stockLabel.setBounds(10, 0, 83, 107);
		stockLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		_stock = new JPanel();
		_stock.setLayout(new BoxLayout(_stock, BoxLayout.Y_AXIS));
		_stock.add(new JLabel("Stock:"));
		_stock.add(stockLabel);

		homeLabel = _golf.createDisplayImage("/GUIs/Cards/green.gif");
		homeLabel.setBounds(10, 0, 83, 107);
		_homecell = new JPanel();
		_homecell.setLayout(new BoxLayout(_homecell, BoxLayout.Y_AXIS));
		_homecell.add(new JLabel("Homecell:"));
		_homecell.add(homeLabel);

		JPanel _hs = new JPanel();
		_hs.setLayout(new BoxLayout(_hs, BoxLayout.X_AXIS));
		_hs.add(_stock);
		_hs.add(_homecell);
		_mainPanel.add(_hs);

		homeLabel.addMouseListener(new GolfHomecellMouse(_golf,this));
		stockLabel.addMouseListener(new GolfStockMouse(_golf, this));
		lt1.addMouseListener(new GolfTableauMouse(_golf, this, lt1, t1));
		lt2.addMouseListener(new GolfTableauMouse(_golf, this, lt2, t2));
		lt3.addMouseListener(new GolfTableauMouse(_golf, this, lt3, t3));
		lt4.addMouseListener(new GolfTableauMouse(_golf, this, lt4, t4));
		lt5.addMouseListener(new GolfTableauMouse(_golf, this, lt5, t5));
		lt6.addMouseListener(new GolfTableauMouse(_golf, this, lt6, t6));
		lt7.addMouseListener(new GolfTableauMouse(_golf, this, lt7, t7));

		_golf.addObserver(this);

	}

	public JPanel getStockPanel() {
		return _stock;
	}

	public JLabel getStockLabel() {
		return stockLabel;
	}

	public JLabel getMessageLabel() {
		return message;
	}

	public void setMessageLabel(String s) {
		message = new JLabel(s);
	}

	public void setStockLabel() {
		stockLabel = _golf.createDisplayImage("/GUIs/Cards/green.gif");
		stockLabel.setBounds(10, 0, 83, 107);
	}

	public JPanel getFeedbackPanel() {
		return feedback;
	}
	
	public JPanel getEasteggPanel() {
		return eastegg;
	}

	public void setLabelProperties(JLabel label, Color back, Color front) {
		label.setFont(new Font("Courier", Font.BOLD, 24));
		label.setBackground(back);
		label.setForeground(front);
		label.setOpaque(true);
		label.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
	}

	public Color randomColor() {
		float red = (float) Math.random();
		float green = (float) Math.random();
		float blue = (float) Math.random();
		Color col = new Color(red, green, blue);
		return col;

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if (_h.size() > 0) {
			homeLabel = _cardLabel.get(_h.get(_h.size() - 1));
			homeLabel.setBounds(10, 0, 100, 100);
			homeLabel.addMouseListener(new GolfHomecellMouse(_golf,this));
			_homecell.removeAll();
			_homecell.add(new JLabel("Homecell:"));
			_homecell.add(homeLabel);
			_homecell.revalidate();
			_homecell.repaint();
		}

		
		if (_golf.getIllegal() == 5) {
			eastegg.add(_golf.createDisplayImage("/GUIs/Easteggs/mh.jpg"));
			eastegg.revalidate();
			eastegg.repaint();
			feedback.removeAll();
			message = new JLabel("CSE 442 will teach you how to play the game!");
			setLabelProperties(message, Color.RED, Color.YELLOW);
			feedback.add(message);
			feedback.revalidate();
			feedback.repaint();

			_golf.illegal0();
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

		// This should be last statement of this method:
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

}
