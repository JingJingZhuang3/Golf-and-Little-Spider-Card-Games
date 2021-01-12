package GUIs;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import solitaire.FortyThieves;
import solitaire.Golf;
import solitaire.LittleSpider;

public class MainMenu  {
/***
 * This is the main menu that will start at the beginning of the GUI
 * 
 * It includes the button to start new LittleSpider game or Golf or exit
 * 
 *  
 */
	
	private static LittleSpider spider = new LittleSpider();
	private static LittleSpiderGUI lsGUI;
	private static Golf golf=new Golf();
	private static FortyThieves f=new FortyThieves();
	public static void runGUI(){

		JFrame frame=new JFrame("Menu");
    	frame.setVisible(true);
    	frame.setSize(600,400);
    	frame.setLocation(500,300);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	JMenuBar menubar=new JMenuBar();
    	frame.setJMenuBar(menubar);
    	
    	JMenu file=new JMenu ("File");
    	menubar.add(file);
    	JMenuItem exit= new JMenuItem("Exit");
    	menubar.add(exit);
    	exit.addActionListener(new ActionListener(){
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			System.exit(0);
    		}
    	});
    	
    	JMenuItem LittleSpider=new JMenuItem("LittleSpider");
    	file.add(LittleSpider);
    	LittleSpider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Driverspider y=new Driverspider(spider);
				y.run();
			}
		});
    	
    	JMenuItem Golf=new JMenuItem("Golf");
    	file.add(Golf);
    	Golf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Driver y=new Driver(golf);
				y.run();
			}
		});
    	
    	JMenuItem FortyThieves=new JMenuItem("FortyThieves");
    	file.add(FortyThieves);
    	FortyThieves.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DriverFortyThieves y=new DriverFortyThieves(f);
				y.run();
			}
		});
    	
    				
		//Start New Little Spider game button 
		JButton newLittleSpider = new JButton("New Little Spider");

		/**
		 * This will listen to a click to start a new LittleSpider game
		 */
		newLittleSpider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Driverspider y=new Driverspider(spider);
				y.run();
			}
		});
		
		//Start New Golf game button 
		JButton newGolf = new JButton("New Golf");
		/**
		 * This will listen to a click to start a new Golf game
		 */
		newGolf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Golf golf=new Golf();
		        Driver x=new Driver(golf);
				x.run();
			}
			
		});
		
		//Starts new Forty Thieves Game
		JButton newFortyThieves = new JButton("New FortyThieves");
		/**
		 * This will listen to a click to start a new Golf game
		 */
		newFortyThieves.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		        DriverFortyThieves x=new DriverFortyThieves(f);
				x.run();
			}
			
		});
		
		
		//Button to exit the application 
		JButton quit = new JButton("Exit");
		/**
		 * This will listen to a click to exit the application 
		 */
		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JPanel exitPanel = new JPanel();
		JPanel lsPanel = new JPanel();
		JPanel golfPanel = new JPanel();
		JPanel lastPanel=new JPanel();

		
		lsPanel.add(newLittleSpider);
		golfPanel.add(newGolf);
		golfPanel.add(newFortyThieves);
		exitPanel.add(quit);

    
        
        frame.add(lsPanel, BorderLayout.NORTH);
        frame.add(golfPanel, BorderLayout.CENTER);
        frame.add(exitPanel, BorderLayout.SOUTH);
	
	
	}


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	
                runGUI();
            }
        });
    }


}




    
