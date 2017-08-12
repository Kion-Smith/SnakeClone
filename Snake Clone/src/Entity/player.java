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
	
	private int moveSpeed =2;
	
	public player()
	{
		pPosX  = 200;
		pPosY  = 200;
	}
	public void addToSnake()
	{
		
	}
	
	public void setUp()
	{
		moveUp = true;
		System.out.println("true");
	}
	public void setDown()
	{
		moveDown = true;
	}
	public void setLeft()
	{
		moveLeft = true;
	}
	public void setRight()
	{
		moveRight = true;
	}
	public void getNextPostion()
	{
		if(moveUp)
		{
			pPosY -=moveSpeed;
			System.out.println("ztrue");
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
		g.setColor(Color.YELLOW);
		g.fillRect(pPosX, pPosY, pWidth, pHeight);
	}
}
