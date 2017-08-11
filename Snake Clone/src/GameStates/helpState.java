package GameStates;

import java.awt.Color;
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
		g.drawString("This is the help state",330,50);
		
		g.drawString("SOME INSTRUCTIONS",330,200);
		
		g.setColor(Color.BLUE);
		g.fillRect(330, 290,10,10);
		g.drawString("back", 370, 300);
		
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ENTER))
		{
			gsm.setState(gameStateManager.MENU);
		}
		
	}
}
