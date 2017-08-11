package GameStates;

import java.awt.Graphics2D;

import Controllers.gameStateManager;

public abstract class gameState 
{
	protected gameStateManager gsm;
	
	public gameState(gameStateManager gsm)
	{
		this.gsm =gsm;
	}
	
	public abstract void init();
	public abstract void update();
	public abstract void draw(Graphics2D g);
	public abstract void handleInput();
}
