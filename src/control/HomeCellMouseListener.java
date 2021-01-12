package control;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import GUIs.LittleSpiderGUI;
import solitaire.FortyThieves;
import solitaire.LittleSpider;



public class HomeCellMouseListener implements MouseListener {


	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(3, 3, 3, 3);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK);
	private LittleSpider _s;
	private FortyThieves f;
	private String _name;
	private JPanel _jp;
	private ArrayList<String> _hc;


	public HomeCellMouseListener(LittleSpider s, String st, JPanel jp, ArrayList<String> hc) {

		_s = s;
		_name = st;
		_jp =jp;
		_hc = hc;
	}
	
	public HomeCellMouseListener(FortyThieves s, String st, JPanel jp, ArrayList<String> hc) {

		f = s;
		_name = st;
		_jp =jp;
		_hc = hc;
	}


	public static void select(Component label) {
		((JComponent) label).setBorder(SELECTED_BORDER);
		label.repaint();
	}

	public static void unselect(Component label) {
		((JComponent) label).setBorder(UNSELECTED_BORDER);
		label.repaint();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
			select(topCard());
			_s.setTwoNames(_name);
	}


	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {		
	}
	
	private Component topCard() {
		Component[] topcard = _jp.getComponents();
		return topcard[1];
	}



}