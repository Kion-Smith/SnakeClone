package Entity;

import java.awt.Graphics2D;

public class player 
{
	protected boolean moving;
	protected boolean moveUp;
	protected boolean moveDown;
	protected boolean moveRight;
	protected boolean moveLeft;
	
	private int pWidth = 50;
	private int pHeight = 50;
	
	private int pPosX =0;
	private int pPosY =0;
	
	private int moveSpeed =2;
	
	public player()
	{
		
	}
	public void add()
	{
		
	}
	
	
	public void setUp()
	{
		if(moving) 
			return;
		moveUp = true;
	}
	public void setDown()
	{
		if(moving) 
			return;
		moveDown = true;
	}
	public void setLeft()
	{
		if(moving) 
			return;
		moveLeft = true;
	}
	public void setRight()
	{
		if(moving) 
			return;
		moveRight = true;
	}
	public void setPostion()
	{
		
	}
	public void setMapPostion()
	{
		
	}
	public boolean isNextPos()
	{
		return false;
	}
	public void update()
	{
		
	}
	public void draw(Graphics2D g)
	{
		
	}
}
