package GameStates;

import java.awt.Color;
import java.awt.Graphics2D;

import Controllers.gameStateManager;
import Controllers.keyHandler;

public class pauseState extends gameState
{
	public pauseState(gameStateManager gsm)
	{
		super(gsm);
	}

	public void update() 
	{
		handleInput();	
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.GREEN);
		g.fillRect(0,0,800,600);
		
		
		g.setColor(Color.BLACK);
		g.drawString("This is the pause state",330,50);
	}

	
	public void init() 
	{
		
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ESC))
		{
			gsm.setPaused(false);
		}
		
	}
}
