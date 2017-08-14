package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class apple 
{
	
	private int pWidth = 50;
	private int pHeight = 50;
	
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
		
		aPosX = convert(aPosX);
		aPosY = convert(aPosY);
		
		System.out.println(aPosX+"  |  "+aPosY);
	}
	public int convert(int input)
	{
		if(input >= 100)
		{
			System.out.println(input);
			int temp = input / 10;
			input = (temp*10); 
		}
		else if(input<=99)
		{
			int temp3 = input / 10;
			System.out.println(temp3);
			input = (temp3*10); 
		}
		else
		{
			input = 10;
		}
		
		return input;
	}
}
