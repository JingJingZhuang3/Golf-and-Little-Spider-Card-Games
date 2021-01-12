package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import solitaire.FortyThieves;



public class FTTableMouse implements MouseListener {

	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK);
	private FortyThieves _ft;
	private String _name;
	private JLayeredPane _lp;
	private ArrayList<String> _st;
	


	public FTTableMouse(FortyThieves ft, String str, JLayeredPane lp,ArrayList<String>st) {
		_ft = ft;
		_name = str;
		_lp = lp;
		_st = st;
	
	}


	public static void select(Component label) {
		((JComponent) label).setBorder(SELECTED_BORDER);
		label.repaint();
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		if(_st.size()>0) {
			select(topCard());
		}
		_ft.setTwoNames(_name);
		_ft.checkStock("x");
		
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
