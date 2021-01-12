package control;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Cursor;

import GUIs.FortyThievesGUI;
import GUIs.GolfGUI;
import solitaire.FortyThieves;
import solitaire.Golf;

public class GolfStockMouse implements MouseListener {
	private static final Border UNSELECTED_BORDER = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	private static final Border SELECTED_BORDER = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK);
	private Golf _g;
	private FortyThieves _f;
	private GolfGUI _gui;
	private FortyThievesGUI _fGUI;

	public GolfStockMouse(Golf g, GolfGUI gui) {
		_g = g;
		_gui = gui;
	}
	
	public GolfStockMouse(FortyThieves g, FortyThievesGUI gui) {
		_f = g;
		_fGUI = gui;
	}

	public static void select(JLabel label) {
		label.setBorder(SELECTED_BORDER);
		label.repaint();
	}

	public static void unselect(JLabel label) {
		label.setBorder(UNSELECTED_BORDER);
		label.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (!_g.getStock().isEmpty()) {
			// select(_gui.getStockLabel());
			_gui.getStockLabel().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			if (_g.GameWin()) {
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("You won the game!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.BLACK, Color.GREEN);
				_gui.getEasteggPanel().removeAll();
				JLabel win = _g.getWin();
				_gui.getEasteggPanel().add(win);
				_gui.getEasteggPanel().revalidate();
				_gui.getEasteggPanel().repaint();
			} else {
				_g.StockToHome();
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("Moving from Stock to Homecell is always legal!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.WHITE, _gui.randomColor());
			}
		} else {
			// unselect(_gui.getStockLabel());
			_gui.getStockPanel().removeAll();
			_gui.setStockLabel();
			_gui.getStockPanel().add(new JLabel("Stock:"));
			_gui.getStockPanel().add(_gui.getStockLabel());
			_gui.getStockPanel().revalidate();
			_gui.getStockPanel().repaint();
			
			if (_g.GameOver()) {
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("Game Over!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.BLACK, Color.RED);
				_gui.getEasteggPanel().removeAll();
				JLabel lose = _g.getLose();
				_gui.getEasteggPanel().add(lose);
				_gui.getEasteggPanel().revalidate();
				_gui.getEasteggPanel().repaint();
			} else if (_g.GameWin()) {
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("You won the game!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.BLACK, Color.GREEN);
				_gui.getEasteggPanel().removeAll();
				JLabel win = _g.getWin();
				_gui.getEasteggPanel().add(win);
				_gui.getEasteggPanel().revalidate();
				_gui.getEasteggPanel().repaint();
			} else {
				_gui.getStockLabel().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
				_gui.getFeedbackPanel().removeAll();
				_gui.setMessageLabel("NO MORE CARDS IN STOCK!");
				_gui.setLabelProperties(_gui.getMessageLabel(), Color.YELLOW, Color.RED);
			}
		}
		_gui.getFeedbackPanel().add(_gui.getMessageLabel());
		_gui.getFeedbackPanel().revalidate();
		_gui.getFeedbackPanel().repaint();
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
