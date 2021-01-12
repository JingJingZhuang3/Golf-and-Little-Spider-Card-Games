package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import solitaire.FortyThieves;
import solitaire.LittleSpider;


public class TMouseListener implements MouseListener {

	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(3, 3, 3, 3);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK);
	private LittleSpider _s;
	private FortyThieves f;
	private String _name;
	private JLayeredPane _lp;
	private ArrayList<String> _st;
	

	public TMouseListener(LittleSpider s, String str, JLayeredPane lp, ArrayList<String> st) {

		_s = s;
		_name = str;
		_lp = lp;
		_st = st;
	}


	public TMouseListener(FortyThieves s, String str, JLayeredPane lp, ArrayList<String> st) {
		f = s;
		_name = str;
		_lp = lp;
		_st = st;
	
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
		if(_st.size()>0) {
			select(topCard());
			_s.setTwoNames(_name);
		}
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
		int highest = _lp.highestLayer();
		Component[] topcard = _lp.getComponentsInLayer(highest);
		return topcard[0];
	}



}
