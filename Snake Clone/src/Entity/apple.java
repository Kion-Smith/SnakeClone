package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class apple 
{
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	private int pPosX =0;
	private int pPosY =0;
	
	private int moveSpeed =10;
	
	public apple()
	{
		pPosX  = (int)(Math.random()*801);
		pPosY  = (int)(Math.random()*601);
		
	
	}
	public void update()
	{
		
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.RED);
		g.fillRect(pPosX, pPosY, pWidth, pHeight);
	}
	
}
