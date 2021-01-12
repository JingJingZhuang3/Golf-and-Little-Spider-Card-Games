package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import GUIs.GolfGUI;
import solitaire.Golf;

public class GolfTableauMouse implements MouseListener {

	// private static final Border UNSELECTED_BORDER =
	// BorderFactory.createEmptyBorder(4, 4, 4, 4);
	// private static final Border SELECTED_BORDER =
	// BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK);;
	private Golf _g;
	private GolfGUI _gui;
	private JLayeredPane _lp;
	private ArrayList<String> _st;

	public GolfTableauMouse(Golf g, GolfGUI gui, JLayeredPane lp, ArrayList<String> st) {

		_g = g;
		_gui = gui;
		_lp = lp;
		_st = st;

	}

	public void select(Component label) {
		Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, _gui.randomColor());
		((JComponent) label).setBorder(SELECTED_BORDER);
		label.repaint();
	}

	public void unselect(Component label) {
		Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		((JComponent) label).setBorder(UNSELECTED_BORDER);
		label.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int highest = _lp.highestLayer();
		Component[] topcard = _lp.getComponentsInLayer(highest);
		if (topcard.length > 0) {
		 select(topcard[0]);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		int highest = _lp.highestLayer();
		Component[] topcard = _lp.getComponentsInLayer(highest);
		if (topcard.length > 0) {
			 unselect(topcard[0]);
			}
		if (!_g.getHomecell().isEmpty()) {
			if (topcard.length > 0) {
				if (_g.TableauToHome(_st)) {
					_lp.remove(topcard[0]);
					_lp.revalidate();
					_lp.repaint();
					_gui.getFeedbackPanel().removeAll();
					_gui.setMessageLabel("You made a legal move!");
					_gui.setLabelProperties(_gui.getMessageLabel(), Color.WHITE, _gui.randomColor());
				} else {
					String s1 = _st.get(_st.size() - 1).substring(0, 1).toUpperCase();
					String s2 = _g.getHomecell().get(_g.getHomecell().size() - 1).substring(0, 1).toUpperCase();
					if (s1.equals("T")) {
						s1 = "10";
					}
					if (s2.equals("T")) {
						s2 = "10";
					}
					_gui.getFeedbackPanel().removeAll();
					_gui.setMessageLabel(s1 + " CANNOT be stacked onto " + s2);
					_gui.setLabelProperties(_gui.getMessageLabel(), Color.YELLOW, Color.RED);
					_g.setIllegal();
				}
			}
		}else {
			_gui.getFeedbackPanel().removeAll();
			_gui.setMessageLabel("Think about what the first move should be!");
			_gui.setLabelProperties(_gui.getMessageLabel(), Color.YELLOW, Color.RED);
			_g.setIllegal();
			
		}
		if (_g.getStock().isEmpty()) {
			if (_g.GameOver()) {
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("Game Over!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.BLACK, Color.RED);
				_gui.getEasteggPanel().removeAll();
				JLabel lose = _g.getLose();
				_gui.getEasteggPanel().add(lose);
			}
		}
		if (_g.GameWin()) {
			_gui.getFeedbackPanel().removeAll();
			_gui.setMessageLabel("You won the game!");
			_gui.setLabelProperties(_gui.getMessageLabel(), Color.BLACK, Color.GREEN);
			_gui.getEasteggPanel().removeAll();
			JLabel win = _g.getWin();
			_gui.getEasteggPanel().add(win);
		}
		_gui.getFeedbackPanel().add(_gui.getMessageLabel());
		_gui.getFeedbackPanel().revalidate();
		_gui.getFeedbackPanel().repaint();
		_gui.getEasteggPanel().revalidate();
		_gui.getEasteggPanel().repaint();

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
