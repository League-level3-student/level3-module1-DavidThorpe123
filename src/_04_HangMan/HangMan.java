package _04_HangMan;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame;
	JPanel panel;
	JLabel label;
	HangMan() {
		frame = new JFrame();
		panel = new JPanel();
		label = new JLabel();
		frame.add(panel);
		panel.add(label);

	}
public static void main(String[] args) {
	String numberString = JOptionPane.showInputDialog("Enter a number");
	int numberInt = Integer.parseInt(numberString);

		for (int i = 0; i < numberInt; i++) {
			Stack<String> stack = new Stack();
			stack.push(Utilities.readRandomLineFromFile("src/dictionary.txt"));
			
		}
		
		
	
}	
	
	
}
