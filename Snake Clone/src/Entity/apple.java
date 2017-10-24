package Entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class apple 
{
	
	private int pWidth = 20;
	private int pHeight = 20;
	
	public int aPosX =0;
	public int aPosY =0;
	
	BufferedImage appleImg;
	
	
	public apple(String[][] m)
	{
		nextPostion(m);
	}
	public void update()
	{
		
	}
	public void draw(Graphics2D g)
	{
		appleImg = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		try
		{
			appleImg = ImageIO.read(getClass().getResourceAsStream("/Entity/apple.png"));
			g.drawImage(appleImg, aPosX, aPosY, pHeight,pWidth,null);
		}
		catch(Exception e)
		{
			
		}
		//g.setColor(Color.RED);
		//g.fillRect(aPosX, aPosY, pWidth, pHeight);
	}
	public void nextPostion(String[][] m)
	{
		 int x = (int)(Math.random()*40);
		 int y = (int)(Math.random()*30);
		 System.out.println("This is rand x: "+x+" | This is rand y:"+y);
		 
		 aPosX = Integer.parseInt(m[x][y].substring(0, m[x][y].indexOf(",") ) ); 
		 aPosY= Integer.parseInt(m[x][y].substring(m[x][y].indexOf(",")+1 ) );
		 
		
		 System.out.println("This is aPosX: "+aPosX+" | This is aPosY:"+aPosY);
	}
	
}
