package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Controllers.gameStateManager;
import Controllers.keyHandler;

public class helpState extends gameState
{
	public helpState(gameStateManager gsm)
	{
		super(gsm);
	}

	public void init() {
		
		
	}

	public void update() 
	{
	
		handleInput();
	}
	
	public void draw(Graphics2D g) 
	{
		g.setColor(Color.BLACK);
		g.fillRect(0,0,800,600);
		
		g.setColor(Color.white);
		
		g.setFont(new Font("Arial",Font.PLAIN,32) );
		g.drawString("HELP",345,50);
		g.drawString("- Use the arrow keys to move up, down, right, and left",0,150);
		g.drawString("- Any time in game you can pause by pressing 'Escape' ",0,200);
		g.drawString("- Contact me to let me know how I can make this better",0,250);
		g.drawString("Email:: kion_smith@hotmail.com",150,300);
		g.setColor(Color.BLUE);
		g.fillRect(330, 380,20,20);
		g.drawString("back", 370, 400);
		
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ENTER))
		{
			gsm.setState(gameStateManager.MENU);
		}
		
	}
}
