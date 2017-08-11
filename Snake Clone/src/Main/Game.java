package Main;

import javax.swing.JFrame;

import LinkedList.Node;

public class Game 
{
	public static void main(String []args)
	{
		JFrame frame = new JFrame("Snake");
		
		frame.add(new gamePanel() );
		frame.setResizable(false);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Node n = new Node(200,100);
		
	}
}
