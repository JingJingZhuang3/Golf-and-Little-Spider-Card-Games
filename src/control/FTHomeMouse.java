package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

import solitaire.FortyThieves;


public class FTHomeMouse implements MouseListener{
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(3, 3, 3, 3);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK);
	private FortyThieves _ft;
	private String _name;
	private JPanel _jp;

	
	public FTHomeMouse(FortyThieves ft, String st, JPanel jp) {

		_ft = ft;
		_name = st;
		_jp =jp;
	}
	
	public static void select(Component label) {
		((JComponent) label).setBorder(SELECTED_BORDER);
		label.repaint();
	}

	public static void unselect(Component label) {
		((JComponent) label).setBorder(UNSELECTED_BORDER);
		label.repaint();
	}
	
	private Component topCard() {
		Component[] topcard = _jp.getComponents();
		return topcard[1];
	}

	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		select(topCard());
		_ft.setTwoNames(_name);
		if(_name.contains("h")) {
		_ft.checkStock("h");
		}else {
			_ft.checkStock("x");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
