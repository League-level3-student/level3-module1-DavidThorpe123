package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
JFrame frame;
int lives = 10;
	 JPanel panel;
Stack<String> stack;
String word = "";
char[] amountOfLetters;
JLabel[] labels;

public boolean checkWord(JLabel[] label) {
	for (int i = 0; i < label.length; i++) {
		if (label[i].getText().equals("     ___     ")) {
			System.out.println("Test");
			return false;
		}
	}
	System.out.println("Testtt");
	return true;
}
public static void main(String[] args) {
	
	new HangMan().buildFrame();
}
	private void buildFrame() {
	// TODO Auto-generated method stub
	frame = new JFrame();
	panel = new JPanel();
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	String numberString = JOptionPane.showInputDialog("Enter a number");
	int numberInt = Integer.parseInt(numberString);
 stack = new Stack();
		for (int i = 0; i < numberInt; i++) {
			stack.push(Utilities.readRandomLineFromFile("src/_04_HangMan/dictionary.txt"));
			
		}
		 word = stack.pop();
		 System.out.println(word);
		  amountOfLetters = word.toCharArray();
		  labels = new JLabel[amountOfLetters.length];
		 frame.add(panel);
		 frame.addKeyListener(this);
		 for (int i = 0; i < amountOfLetters.length; i++) {
			 JLabel label = new JLabel();
				
				label.setText("     ___     ");
				panel.add(label);
				labels[i] = label;
				
				
			}
		
		 frame.setVisible(true);
		 frame.pack();
		
		
	
}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (lives <= 0) {
			System.out.println("You lost");
			if (JOptionPane.showConfirmDialog(null, "You lose.", "Want to play again?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
				frame.dispose();
				buildFrame();
			lives = 10;	
			}
		}
		char letter = e.getKeyChar();
		System.out.println(letter);
		boolean foundLetter = false;
		for (int i = 0; i < amountOfLetters.length; i++) {
			
		if (letter == amountOfLetters[i]) {
			int temp = i;
			labels[i].setText("    " + String.valueOf(letter) + "    ");
			System.out.println("Correct letter");
			foundLetter = true;
		}
	
		}
		if (!foundLetter) {
			lives--;
			System.out.println("You lost a life");
		}
		if (checkWord(labels)) {
			if (stack.isEmpty()) {
				if (JOptionPane.showConfirmDialog(null, "You win.", "Want to play again?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					frame.dispose();
					buildFrame();
					lives = 3;
					
				}
				
			}
			else {
			panel.removeAll();
			String newWord = "";
			newWord = stack.pop();
			System.out.println(newWord);
			amountOfLetters = newWord.toCharArray();
			labels = new JLabel[amountOfLetters.length];
			//JLabel[] labelss = new JLabel[lll.length];
			 for (int i1 = 0; i1 < amountOfLetters.length; i1++) {
				 JLabel label = new JLabel();
					
					label.setText("     ___     ");
					panel.add(label);
					labels[i1] = label;
					
					
				}
			}
		}
		
		if (lives == 0) {
			System.out.println("You lost");
			int choice = JOptionPane.showConfirmDialog(null, "Start Over");
		}
		frame.repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}	

}
