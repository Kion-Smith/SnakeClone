package LinkedList;

public class Node 
{
	public Node prev;
	public Node next;
	
	public location loc;
	
	public Node(location l)
	{
		loc = l;
	}
	public Node(int x,int y)
	{
		location temp = new location(x,y);
		loc  = temp;
	}
	
}
