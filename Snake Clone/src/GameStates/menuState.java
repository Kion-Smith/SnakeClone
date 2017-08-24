package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import Controllers.gameStateManager;
import Controllers.keyHandler;

public class menuState extends gameState
{
	public boolean down = false;
	private int cur = 0;
	public boolean up = false;
	
	private String[] options = {"START","HELP","QUIT"};
		
	public menuState (gameStateManager gsm)
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
		g.setColor(Color.RED);
		g.fillRect(0, 0, 800, 600);
		
		g.setColor(Color.BLACK);
		
		g.setFont(new Font("Arial",Font.PLAIN,48));
		g.drawString("SNAKE", 320, 100);
		g.setFont(new Font("Arial",Font.PLAIN,18));
		g.drawString("by Kion Smith", 350, 150);
		
		g.setFont(new Font("Arial",Font.PLAIN,24));
		
		g.drawString(options[0], 370, 300);
		g.drawString(options[1], 370, 350);
		g.drawString(options[2], 370, 400);
		
		if(cur == 0)
		{
			g.setColor(Color.BLUE);
			g.drawString(options[0], 370, 300);
			g.fillRect(330, 285,15,15);
		}
		else if(cur == 1)
		{
			g.setColor(Color.BLUE);
			g.drawString(options[1], 370, 350);
			g.fillRect(330, 330,15,15);
		}
		else if(cur == 2)
		{
			g.setColor(Color.BLUE);
			g.drawString(options[2], 370, 400);
			g.fillRect(330, 385,15,15);
		}
		
		
		
		//g.fillRect(0, 0, 800, 600);
		
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
			gsm.setState(gameStateManager.HELP);
		}
		else if(cur ==2)
		{
			System.exit(0);
		}
	}
}
