import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

public class Driver{

	private static JFrame frame = new JFrame();
	private static JPanel sizePanel = new JPanel();
	private static JPanel modePanel = new JPanel();
	private static JPanel gamePanel = new JPanel();
	private static JLabel sizeLabel = new JLabel("Enter board size (at least 6)");
	private static JLabel modeLabel = new JLabel("Choose game mode");//player vs player or player vs computer
	private static JTextField sizeField = new JTextField();
	private static JButton sizeButton = new JButton("Enter");
	private static JButton modeButton = new JButton("Enter");
	private static JButton resetButton = new JButton("Reset");
	private static JButton loadButton = new JButton("Load");
	private static JButton saveButton = new JButton("Save");
	private static JButton undoButton = new JButton("Undo");
	private static JCheckBox checkBox = new JCheckBox("Check Box");
	private static ButtonGroup group = new ButtonGroup();
	private static Game game1 = new Game();
	private static JRadioButton pvcButton = new JRadioButton();
	private static JRadioButton pvpButton = new JRadioButton("Player vs. Player");

	public static void main(String args[]){
	
		frame.setTitle("Hex Game");
	
		frame.setSize(2000,2000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(sizePanel);
		
		sizePanel.setLayout(null);
		
		sizeLabel.setBounds(10,20,200,50);
		
		sizePanel.add(sizeLabel);
		
		checkBox.setBounds(200,200,150,50);
		
		sizePanel.add(checkBox);
	
		sizeField.setBounds(250,20,250,50);
		
		sizePanel.add(sizeField);
		
		sizeButton.setBounds(300,100,150,50);
		
		sizePanel.add(sizeButton);
		
		sizeButton.addActionListener(new sizeButtonListener());
		
		group.add(pvcButton);
		group.add(pvpButton);
		
		modeLabel.setBounds(10,20,200,50);
		
		pvcButton.setText("Player vs. Computer");
		pvpButton.setText("Player vs. Player");
		
		pvcButton.setBounds(150,20,250,50);
		pvpButton.setBounds(150,50,250,50);
		
		modeButton.setBounds(300,100,150,50);
		
		modePanel.setLayout(null);
		modePanel.add(modeLabel);
		modePanel.add(pvcButton);
		modePanel.add(pvpButton);
		modePanel.add(modeButton);
		modeButton.addActionListener(new modeButtonListener());
		
		resetButton.setBounds(10,10,100,50);
		loadButton.setBounds(10,40,100,50);
		saveButton.setBounds(10,70,100,50);
		undoButton.setBounds(10,100,100,50);
	
	}
	
	public static class sizeButtonListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){
	
			game1.setSize(sizeField.getText());
			
			frame.getContentPane().removeAll();
			frame.add(modePanel);
 			frame.repaint();
 			frame.validate();
 			
	
		}
	
	}
	
	public static class modeButtonListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){
	
			if(pvcButton.isSelected()){	game1.setPlayer(0);}
			else if(pvpButton.isSelected()){	game1.setPlayer(1);}
			else{	System.exit(0);}
			
			gamePanel.setLayout(new GridLayout(game1.getSize(),game1.getSize()*2+2));
			gamePanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
			for(int i=0; i<game1.getSize(); i++){
		
				for(int j=0; j<game1.getSize()*2+2; j++){
			
					if(i>3 && j==0 || j==1)	gamePanel.add(new JLabel(""));
					else if(i==0 && j==0)	gamePanel.add(resetButton);
					else if(i==1 && j==0)	gamePanel.add(loadButton);
					else if(i==2 && j==0)	gamePanel.add(saveButton);
					else if(i==3 && j==0)	gamePanel.add(undoButton);
					else if(i%2 == 0 && j%2 == 1 || i%2 == 1 && j%2 == 0)	gamePanel.add(new JLabel(""));
					else{	gamePanel.add(new JButton());}
			
				}
		
			}
			
			frame.getContentPane().removeAll();
			frame.add(gamePanel);
 			frame.repaint();
 			frame.validate();
 			
 			resetButton.addActionListener(new gameButtonListener());
 			loadButton.addActionListener(new gameButtonListener());
 			saveButton.addActionListener(new gameButtonListener());
 			undoButton.addActionListener(new gameButtonListener());
	
		}
	
	}
	
	public static class gameButtonListener implements ActionListener{
	
		public void actionPerformed(ActionEvent e){
	
			if(resetButton.isSelected())		game1.reset();
			else if(loadButton.isSelected())	game1.load();
			else if(saveButton.isSelected())	game1.save();
			else if(undoButton.isSelected())	game1.undo();
	
		}
	
	}

}
