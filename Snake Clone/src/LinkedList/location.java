package LinkedList;

public class location 
{
	private int x;
	private int y;
	
	public location()
	{
		
	}
	
	public location(int tempx, int tempy)
	{
		x = tempx;
		y = tempy;
	}
	
	public void setX(int tempx)
	{
		x = tempx;
	}
	
	public void setY(int tempy)
	{
		y = tempy;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public String toString()
	{
		return x+" , "+y;
	}
}
