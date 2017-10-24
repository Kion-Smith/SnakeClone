package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controllers.gameStateManager;
import Controllers.keyHandler;

public class pauseState extends gameState
{
	private int cur;
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
		Color c = new Color(102, 102, 102,15);
		g.setColor(c);
		g.fillRect(0,0,800,650);
		
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.PLAIN,32) );
		g.drawString("PAUSED",340,50);
		
		g.setFont(new Font("Arial",Font.PLAIN,24) );
		
		g.drawString("Continue",355,150);
		g.drawString("Main Menu",350,200);
		g.drawString("Quit",380,250);
		
		if(cur ==0)
		{
			g.setColor(Color.BLUE);
			g.drawString("Continue",355,150);
			
		}
		else if(cur == 1)
		{
			g.setColor(Color.BLUE);
			g.drawString("Main Menu",350,200);
			
		}
		else if(cur == 2)
		{
			g.setColor(Color.BLUE);
			g.drawString("Quit",380,250);
			
		}
	}
		

	
	public void init() 
	{
		
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
		
		if(keyHandler.isPressed(keyHandler.ESC))
		{
			gsm.setPaused(false);
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
			gsm.setPaused(false);
		}
		else if(cur == 1)
		{
			gsm.setPaused(false);
			gsm.setState(gameStateManager.MENU);
		}
		else if(cur ==2)
		{
			System.exit(0);
		}
	}
}
