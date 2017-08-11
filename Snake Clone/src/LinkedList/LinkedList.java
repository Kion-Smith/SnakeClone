package LinkedList;

public class LinkedList
{
	Node head;
	Node tail;
	
	public LinkedList(location l)
	{
		head = new Node(l);
	}
	
	public void addTail(Node n)
	{
		if(tail == null)
		{
			tail = n;
		}
		else
		{
			Node cur = head;
			while(cur.next != null)
			{
				cur = cur.next;
			}
			cur.next = n;
			tail = n;
		}
	}
	public int size()
	{
		int count =0;
		
		Node cur = head;
		while(cur.next != null)
		{
			cur = cur.next;
			count++;
		}
		return count;
	}
}
