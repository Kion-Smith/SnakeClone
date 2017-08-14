package GameStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import Controllers.gameStateManager;
import Controllers.keyHandler;
import Entity.apple;
import Entity.player;

public class playState extends gameState
{
	private player p;
	private apple a;

	public playState(gameStateManager gsm) 
	{
		super(gsm);
		
	}

	public void init() 
	{
		p = new player(0,0);
		a = new apple();
	}

	public void update() 
	{
		handleInput();
		collectApple();
		p.update();
		a.update();
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.lightGray);
		g.fillRect(0,0,800,600);
		g.setColor(Color.white);
		g.drawString("This is the play state",400,300);
		
		ImageIcon i = new ImageIcon("C:\\Users\\NeonKion\\Downloads\\grid.png");
		Image image=i.getImage();
		g.drawImage(image,0,0,null);
		
		p.draw(g);
		a.draw(g);
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ESC))
		{
			gsm.setPaused(true);
		}
		if(keyHandler.isPressed(keyHandler.UP)&&keyHandler.anyKeyDown() == true)
		{
			p.setUp();
		}
		if(keyHandler.isPressed(keyHandler.DOWN)&&keyHandler.anyKeyDown() == true)
		{
			p.setDown();
		}
		if(keyHandler.isPressed(keyHandler.RIGHT)&&keyHandler.anyKeyDown() == true)
		{
			p.setRight();
		}
		if(keyHandler.isPressed(keyHandler.LEFT)&&keyHandler.anyKeyDown() == true)
		{
			p.setLeft();
		}
	}
	
	public void collectApple()
	{
		if(p.pPosX == a.aPosX && p.pPosY == a.aPosY)
		{
			a.nextPostion(); 
			System.out.println("GOTTTTTTTTTEEEEEEM");
		}
	}
	
}
