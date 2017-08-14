package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class player 
{
	protected boolean moveUp;
	protected boolean moveDown;
	protected boolean moveRight;
	protected boolean moveLeft;
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	private int pPosX =0;
	private int pPosY =0;
	
	private int moveSpeed =10;
	
	public player(int x,int y)
	{
		pPosX  = x;
		pPosY  = y;
	}
	
	public int currentX()
	{
		return pPosX;
	}
	public int currentY()
	{
		return pPosY;
	}
	
	public void setX(int prev)
	{
		
	}
	public void setY(int prev)
	{
		
	}
	
	public void addToSnake()
	{
		
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
		if(moveUp)
		{
			pPosY -=moveSpeed;
			
		}
		if(moveDown)
		{
			pPosY +=moveSpeed;
		}
		if(moveRight)
		{
			pPosX +=moveSpeed;
		}
		if(moveLeft)
		{
			pPosX -=moveSpeed;
		}
	}
	public void update()
	{
		getNextPostion();
		//System.out.println(pPosX+""+pPosY);
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.YELLOW);
		g.fillRect(pPosX, pPosY, pWidth, pHeight);
	}
}
