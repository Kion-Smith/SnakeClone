package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class apple 
{
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	public int aPosX =0;
	public int aPosY =0;
	
	private int moveSpeed =10;
	
	public apple()
	{
		nextPostion();
	}
	public void update()
	{
		
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.RED);
		g.fillRect(aPosX, aPosY, pWidth, pHeight);
	}
	public void nextPostion()
	{
		aPosX  = (int)(Math.random()*801);
		aPosY  = (int)(Math.random()*601);
	}
	public void isTouching()
	{
		
	}
}
