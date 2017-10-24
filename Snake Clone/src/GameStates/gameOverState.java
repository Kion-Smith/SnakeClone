package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Controllers.gameStateManager;
import Controllers.keyHandler;
import Entity.player;

public class gameOverState extends gameState
{
	private int cur =0;
	public static int Score =0;
	public static long time;
	
	public gameOverState(gameStateManager gsm) 
	{
		super(gsm);
		
	}

	public void init() 
	{
		
	}

	public void update() 
	{
		handleInput();
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.BLACK);
		
		g.fillRect(0,0,800,650);
		
		g.setColor(Color.white);
		g.setFont(new Font("Arial",Font.PLAIN, 24));
		g.drawString("GAME OVER",330,50);
		g.drawString("The length of your snake was "+(Score),250,100);
		g.drawString("SCORE "+(int)((Score*100)*(time*.05)),250,150);
		
		
		g.drawString("Restart", 370, 250);
		g.drawString("Main Menu", 370, 300);
		g.drawString("Quit", 370, 350);
		
		if(cur ==0)
		{
			g.setColor(Color.BLUE);
			g.fillRect(330, 235,15,15);
			g.drawString("Restart", 370, 250);
		}
		else if(cur ==1)
		{
			g.setColor(Color.BLUE);
			g.fillRect(330, 285,15,15);
			g.drawString("Main Menu", 370, 300);
		}
		else if(cur ==2)
		{
			g.setColor(Color.BLUE);
			g.fillRect(330, 335,15,15);
			g.drawString("Quit", 370, 350);
		}
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.DOWN))
		{
			if(cur>=2)
			{
				cur =2;
			}
			else
			{
				cur++;
			}
		}
		
		if(keyHandler.isPressed(keyHandler.UP)) 
		{
			if(cur<=0)
			{
				cur =0;
			}
			else
			{
				cur--;
			}
		}
		if(keyHandler.isPressed(keyHandler.ENTER))
		{
			selectOption();
		}
	}
	
	private void selectOption()
	{
		if(cur ==0)
		{
			gsm.setState(gameStateManager.PLAY);
		}
		else if(cur == 1)
		{
			gsm.setState(gameStateManager.MENU);
		}
		else if(cur ==2)
		{
			System.exit(0);
		}
	}

}
