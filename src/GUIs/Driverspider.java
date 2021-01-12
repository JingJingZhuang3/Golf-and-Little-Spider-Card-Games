package GUIs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import solitaire.Golf;
import solitaire.LittleSpider;

public class Driverspider implements Runnable {
	private LittleSpider _s;
	private JFrame _window;
	private JPanel _mainPanel;
	
	
	
	public Driverspider(LittleSpider s) {
		_s = s;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LittleSpider game = new LittleSpider();
		SwingUtilities.invokeLater(new Driverspider(game));

	}
	
	@Override
	public void run() {
		_window = new JFrame("Spider");
		JMenuBar menu=new JMenuBar();
		_window.setJMenuBar(menu);
		JMenu file=new JMenu("File");
		menu.add(file);
		JMenuItem restart=new JMenuItem("Restart");
		restart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				_window.dispose();
				LittleSpider spider=new LittleSpider();
				Driverspider y=new Driverspider(spider);
				y.run();
			}
			
		});
		JMenuItem quit=new JMenuItem("Back to Main Menu");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				_window.dispose();
			}
		});
		file.add(restart);
		file.add(quit);
		_mainPanel = new JPanel();
		_window.getContentPane().add(_mainPanel);
		

		new LittleSpiderGUI(_s, _mainPanel, this);
		_window.setVisible(true);
		_window.setSize(960, 720);
    	_window.setLocation(400,200);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void updateJFrame() {
		_window.setSize(960, 720);
		_window.repaint();
	}

}

