package Entity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import Controllers.gameStateManager;
import GameStates.playState;

public class player 
{
	protected boolean moveUp;
	protected boolean moveDown;
	protected boolean moveRight;
	protected boolean moveLeft;
	
	private boolean directionUp;
	private boolean directionDown;
	private boolean directionRight;
	private boolean directionLeft;
	
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	private int pPosX =0;
	private int pPosY =0;
	
	private ArrayList<snake> snakeLength;
	
	private int moveSpeed = 20;
	
	public player(int x,int y)
	{
		pPosX  = x;
		pPosY  = y;
		snakeLength = new ArrayList<snake>();
		snakeLength.add(new snake(x,y));
	}
	
	public int currentX()
	{
		return pPosX;
	}
	public int currentY()
	{
		return pPosY;
	}
	
	public void addToSnake(int x, int y)
	{
		snakeLength.add(new snake(x,y) );
	}
	public void setUp()
	{
		moveUp = true;
		moveDown = false;
		moveRight = false;
		moveLeft = false;
		
	}
	public void setDown()
	{
		moveUp = false;
		moveDown = true;
		moveRight = false;
		moveLeft = false;
	}
	public void setLeft()
	{
		moveUp = false;
		moveDown = false;
		moveRight = false;
		moveLeft = true;
	}
	public void setRight()
	{
		moveUp = false;
		moveDown = false;
		moveRight = true;
		moveLeft = false;
	}
	public void getNextPostion()
	{
		snake last = new snake(0,0);
	
		if(moveUp)
		{
			
			for(int i =0;i<snakeLength.size();i++)
			{
				
				if(i==0)
				{	
					last = new snake(pPosX,pPosY);
					pPosY -=moveSpeed;
					snakeLength.set(i, new snake(pPosX,pPosY) );
				}
				else
				{
					snake temp = new snake(snakeLength.get(i).getX() ,snakeLength.get(i).getY());
					snakeLength.set(i, new snake(last.getX(),last.getY()) );
					last = new snake(temp.getX(),temp.getY());
					
				}
			}
			
		}
		if(moveDown)
		{

			for(int i =0;i<snakeLength.size();i++)
			{
				
				if(i==0)
				{	
					last = new snake(pPosX,pPosY);
					pPosY +=moveSpeed;
					snakeLength.set(i, new snake(pPosX,pPosY) );
					
				}
				else
				{
					snake temp = new snake(snakeLength.get(i).getX() ,snakeLength.get(i).getY());
					snakeLength.set(i, new snake(last.getX(),last.getY()) );
					last = new snake(temp.getX(),temp.getY());
				}
			}
			
		}
		if(moveRight)
		{
			
			for(int i =0;i<snakeLength.size();i++)
			{
				
				if(i==0)
				{	
					last = new snake(pPosX,pPosY);
					pPosX +=moveSpeed;
					snakeLength.set(i, new snake(pPosX,pPosY) );
				}
				else
				{
					snake temp = new snake(snakeLength.get(i).getX() ,snakeLength.get(i).getY());
					snakeLength.set(i, new snake(last.getX(),last.getY()) );
					last = new snake(temp.getX(),temp.getY());
				}
			}
		}
		if(moveLeft)
		{
			
			for(int i =0;i<snakeLength.size();i++)
			{
				
				if(i==0)
				{	
					last = new snake(pPosX,pPosY);
					pPosX -=moveSpeed;
					snakeLength.set(i, new snake(pPosX,pPosY) );
				}
				else
				{
					snake temp = new snake(snakeLength.get(i).getX() ,snakeLength.get(i).getY());
					snakeLength.set(i, new snake(last.getX(),last.getY()) );
					last = new snake(temp.getX(),temp.getY());
				}
			}
		}
	}
	public void update()
	{
		eatingSelf();
		getNextPostion();
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.GREEN);
		
		for(int i =0;i<snakeLength.size();i++)
		{
			if(i%2 ==1)
			{
				g.setColor(Color.YELLOW);
			}
			else
			{
				g.setColor(Color.GREEN);
			}
			
			g.fillRect(snakeLength.get(i).getX(),snakeLength.get(i).getY(), pWidth, pHeight);
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial",Font.PLAIN,24));
		g.drawString("Snake Length "+snakeLength.size(),550, 590);
		
	}
	
	public boolean eatingSelf()
	{
		for(int i=1;i<snakeLength.size();i++)
		{
			if(pPosX == snakeLength.get(i).getX() && pPosY == snakeLength.get(i).getY())
			{
				return true;
			}
		}
		
		return false;
	}
	
	public int snakeSize()
	{
		return snakeLength.size();
	}
	
	public void setDirectionUp(boolean b)
	{
		directionUp = b;
	}
	public void setDirectionDown(boolean b)
	{
		directionDown = b;
	}
	public void setDirectionLeft(boolean b)
	{
		directionLeft = b;
	}
	public void setDirectionRight(boolean b)
	{
		directionRight = b;
	}
	
	public boolean getDirectionUp()
	{
		return directionUp;
	}
	public boolean getDirectionDown()
	{
		return directionDown;
	}
	public boolean getDirectionLeft()
	{
		return directionLeft;
	}
	public boolean getDirectionRight()
	{
		return directionRight;
	}
}
