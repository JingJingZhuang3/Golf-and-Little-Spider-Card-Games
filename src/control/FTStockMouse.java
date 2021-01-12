package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import GUIs.FortyThievesGUI;
import solitaire.FortyThieves;

public class FTStockMouse implements MouseListener{
	private FortyThieves _ft;
	private FortyThievesGUI _ftGUI;
	
	
	public FTStockMouse(FortyThieves ft, FortyThievesGUI ftGUI) {
		_ft = ft;
		_ftGUI = ftGUI;
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		_ft.checkStock("s");
		/*_ftGUI.getMain().removeAll();
		if(_ft.removeCardFromStock(_ft.getStock())) {
			_ftGUI.SetGUI("Moving from Stock to Waste is always legal",Color.WHITE,_ftGUI.randomColor());
		}
		else {
			_ftGUI.SetGUI("No more cards in Stock!",Color.YELLOW,Color.RED);
		}
		_ftGUI.getMain().revalidate();
		_ftGUI.getMain().repaint();*/
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
