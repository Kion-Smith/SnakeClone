package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

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
	
	private ArrayList<String> snakeLength;
	
	private int moveSpeed = 20;
	
	public player(int x,int y)
	{
		pPosX  = x;
		pPosY  = y;
		snakeLength = new ArrayList<String>();
		snakeLength.add(x+","+y);
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
	
	public void addToSnake(int x, int y)
	{
		snakeLength.add(x+","+y);
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
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.GREEN);
		g.fillRect(pPosX, pPosY, pWidth, pHeight);
	}
}
