package GameStates;

import java.awt.Color;
import java.awt.Graphics2D;

import Controllers.gameStateManager;
import Controllers.keyHandler;
import Entity.player;

public class playState extends gameState
{
	private player p;

	public playState(gameStateManager gsm) 
	{
		super(gsm);
		
	}

	public void init() 
	{
		p = new player();		
	}

	public void update() 
	{
		handleInput();	
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.lightGray);
		g.fillRect(0,0,800,600);
		g.setColor(Color.white);
		g.drawString("This is the play state",400,300);
		
		p.draw(g);
		
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ESC))
		{
			gsm.setPaused(true);
		}
		if(keyHandler.isPressed(keyHandler.UP))
		{
			p.setUp();
			System.out.println("move up");
		}
		if(keyHandler.isPressed(keyHandler.DOWN))
		{
			p.setDown();
		}
		if(keyHandler.isPressed(keyHandler.RIGHT))
		{
			p.setRight();
		}
		if(keyHandler.isPressed(keyHandler.LEFT))
		{
			p.setLeft();
		}
	}
	
}
