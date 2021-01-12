package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUIs.GolfGUI;
import solitaire.Golf;

public class GolfHomecellMouse implements MouseListener{
	private Golf _g;
	private GolfGUI _gui;
	
	
	public GolfHomecellMouse(Golf g, GolfGUI gui) {
		_g = g;
		_gui = gui;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		_gui.getFeedbackPanel().removeAll();
		_gui.setMessageLabel("You want to move a card from Homecell?! Think twice!");
		_gui.setLabelProperties(_gui.getMessageLabel(), Color.YELLOW, Color.RED);
		_gui.getFeedbackPanel().add(_gui.getMessageLabel());
	    _gui.getFeedbackPanel().revalidate();
	    _gui.getFeedbackPanel().repaint();
		_g.setIllegal();
		
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
