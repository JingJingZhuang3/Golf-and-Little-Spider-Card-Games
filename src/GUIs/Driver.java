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



public class Driver implements Runnable{
	
	private Golf _g;
	private JFrame _window;
	private JPanel _mainPanel;
	
	
	public Driver(Golf g) {
		_g = g;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Golf g = new Golf();
		SwingUtilities.invokeLater(new Driver(g));

	}
	
	@Override
	public void run() {
		_window = new JFrame("Golf");
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
				Golf go=new Golf();
				Driver y=new Driver(go);
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


		new GolfGUI(_g, _mainPanel, this);
		_window.setVisible(true);
		_window.setSize(800, 600);
    	_window.setLocation(400,200);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	


	public void updateJFrame() {
		_window.setSize(800, 600);
		_window.repaint();
	}

}
