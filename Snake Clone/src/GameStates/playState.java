package GameStates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.xml.stream.Location;

import Controllers.gameStateManager;
import Controllers.keyHandler;
import Entity.apple;
import Entity.player;

public class playState extends gameState
{
	private player p;
	private apple a;
	
	public  String[][] map;
	public long startTime;
	public long curTime;
	
	private BufferedImage img;

	public playState(gameStateManager gsm) 
	{
		super(gsm);
	}

	public void init() 
	{
		p = new player(0,0);
		startTime = System.nanoTime();
		map = new String[40][30];
		
		for(int i = 0;i<40;i++)
		{
			
			
			for(int j=0;j<30;j++)
			{
				
				map[i][j] = (i*20)+","+(j*20);
				
			}
		}
		
		a = new apple(map);
	}

	public void update() 
	{	
		
		curTime = System.nanoTime() - startTime;// keeps running when paused
		
		checkSnake();
		handleInput();
		collectApple();
		onScreen();
		
		p.update();
		
		
	}

	public void draw(Graphics2D g) 
	{
		
		
		
		g.setColor(new Color(102, 60, 0));
		g.fillRect(0,0,800,600);
		g.setColor(Color.BLACK);
		
		g.drawImage(img, 0, 0,800,600, null);
		
		p.draw(g);
		a.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.PLAIN,24));
		g.drawString("Current Time "+ curTime/100000000,300,590);
		if(img == null)
		{
		    try 
		    {
		    	System.out.println("is null");
		        img = ImageIO.read(getClass().getResourceAsStream("/2b5e04856ab35fe3fe0e89dfdd413d9732828109_full.jpg") );
		        
		    } 
		    catch (Exception e) 
		    {
		    	System.out.println("is error");
		        e.printStackTrace();
		    }
		}
		
		
		
		
		
		
		
	}

	public void handleInput() 
	{
		if(keyHandler.isPressed(keyHandler.ESC))
		{
			gsm.setPaused(true);
		}

		if(keyHandler.isPressed(keyHandler.UP)&& keyHandler.anyKeyDown() == true && !(p.getDirectionDown() ))
		{
			
			p.setDirectionUp(true);
			p.setDirectionLeft(false);
			p.setDirectionRight(false);
			p.setUp();
			
		}
		else if(keyHandler.isPressed(keyHandler.DOWN)&&keyHandler.anyKeyDown() == true && !(p.getDirectionUp() ))
		{	
			p.setDirectionDown(true);
			p.setDirectionLeft(false);
			p.setDirectionRight(false);
			p.setDown();
			
		}
		else if(keyHandler.isPressed(keyHandler.RIGHT)&&keyHandler.anyKeyDown() == true && !(p.getDirectionLeft() ))
		{
			p.setDirectionRight(true);
			p.setDirectionUp(false);
			p.setDirectionDown(false);
			p.setRight();
		
		}
		else if(keyHandler.isPressed(keyHandler.LEFT)&&keyHandler.anyKeyDown() == true && !(p.getDirectionRight() ))
		{
			p.setDirectionLeft(true);
			p.setDirectionUp(false);
			p.setDirectionDown(false);
			p.setLeft();
		}	
		
	}
	
	public void collectApple()
	{
		if(p.currentX() == a.aPosX && p.currentY() == a.aPosY)
		{
			a.nextPostion(map);
			p.addToSnake(p.currentX(),p.currentY());
		}
	}
	public void onScreen()
	{
		if(p.currentX() >= 800|| p.currentY() >= 600 ||p.currentY() <= -1||p.currentX() <= -1)
		{
			gameOverState.Score = p.snakeSize();
			gameOverState.time = curTime/1000000000;
			gsm.setState(gameStateManager.GAMEOVER);
		}
	}
	public void checkSnake()
	{
		if(p.eatingSelf() == true)
		{
			gameOverState.Score = p.snakeSize();
			gameOverState.time = curTime/1000000000;
			gsm.setState(gameStateManager.GAMEOVER);
		}
	}
	
}
