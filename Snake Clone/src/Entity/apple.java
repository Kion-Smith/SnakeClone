package Entity;

import java.awt.Color;
import java.awt.Graphics2D;

public class apple 
{
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	public int aPosX =0;
	public int aPosY =0;
	
	
	public apple(String[][] m)
	{
		nextPostion(m);
	}
	public void update()
	{
		
	}
	public void draw(Graphics2D g)
	{
		g.setColor(Color.RED);
		g.fillRect(aPosX, aPosY, pWidth, pHeight);
	}
	public void nextPostion(String[][] m)
	{
		 int x = (int)(Math.random()*40);
		 int y = (int)(Math.random()*30);
		 System.out.println("This is rand x: "+x+" | This is rand y:"+y);
		//aPosX = convert(aPosX);
		//aPosY = convert(aPosY);
		
		//System.out.println(aPosX+"  |  "+aPosY);
		 
		 aPosX = Integer.parseInt(m[x][y].substring(0, m[x][y].indexOf(",") ) ); 
		 aPosY= Integer.parseInt(m[x][y].substring(m[x][y].indexOf(",")+1 ) );
		 
		
		 System.out.println("This is aPosX: "+aPosX+" | This is aPosY:"+aPosY);
	}
	
}
