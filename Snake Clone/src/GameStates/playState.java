package GameStates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

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

	public playState(gameStateManager gsm) 
	{
		super(gsm);
		
	}

	public void init() 
	{
		p = new player(0,0);
		
		
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
		handleInput();
		collectApple();
		p.update();
	}

	public void draw(Graphics2D g) 
	{
		g.setColor(Color.lightGray);
		g.fillRect(0,0,800,600);
		g.setColor(Color.white);
		g.drawString("This is the play state",400,300);
		
		/*
		ImageIcon i = new ImageIcon("C:\\Users\\NeonKion\\Downloads\\grid.png");
		Image image=i.getImage();
		g.drawImage(image,0,0,null);
		*/
		
		for(int z = 0;z<40;z++)
		{
			for(int a=0;a<30;a++)
			{
				//System.out.println(map[z][a]);
				String normal= map[z][a];
				int tempx= Integer.parseInt(normal.substring(0, normal.indexOf(",") ) );
				int tempy= Integer.parseInt(normal.substring(normal.indexOf(",")+1 ) );
				if(a%2==0)
				{
					g.setColor(Color.darkGray);
				}
				else
				{
					g.setColor(Color.GRAY);
				}
				g.fillRect(tempx,tempy,20,20);
				//System.out.println(tempx+" "+tempy);
				
			}
		}
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
			p.currentX();
			p.currentY();
		}
		if(keyHandler.isPressed(keyHandler.DOWN)&&keyHandler.anyKeyDown() == true)
		{
			p.setDown();
			p.currentX();
			p.currentY();
		}
		if(keyHandler.isPressed(keyHandler.RIGHT)&&keyHandler.anyKeyDown() == true)
		{
			p.setRight();
			p.currentX();
			p.currentY();
		}
		if(keyHandler.isPressed(keyHandler.LEFT)&&keyHandler.anyKeyDown() == true)
		{
			p.setLeft();
			p.currentX();
			p.currentY();
			
		}	
		
	}
	
	public void collectApple()
	{
		if(p.currentX() == a.aPosX && p.currentY() == a.aPosY)
		{
			a.nextPostion(map); 
			System.out.println("GOTTTTTTTTTEEEEEEM");
		}
	}
	
}
