package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Controllers.gameStateManager;
import Controllers.keyHandler;



public class gamePanel extends JPanel implements Runnable, KeyListener
{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	private Thread thread;
	private boolean running;
	private final int FPS = 15;//20
	private final int targetTime = 1000 / FPS;
	
	private BufferedImage image;
	private Graphics2D g;
	
	private gameStateManager gsm;
	

	public gamePanel()
	{
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
		setFocusable(true);
		requestFocus();
	}
	
	public void addNotify()
	{
		super.addNotify();
		if(thread == null)
		{
			addKeyListener(this);
			thread = new Thread(this);
			thread.start();
		}
	}

	public void run() 
	{
		init();
		
		long start;
		long elapsed;
		long wait;
		
		while(running)
		{
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;
			
			if(wait<0)
				wait = targetTime;
			try
			{
				Thread.sleep(wait);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}
	
	public void init()
	{
		running = true;
		image = new BufferedImage(WIDTH,HEIGHT,1);
		g = (Graphics2D) image.getGraphics();
		gsm = new gameStateManager();
	}
	
	private void update()
	{
		gsm.update();
		keyHandler.update();
	}
	
	private void draw()
	{
		gsm.draw(g);
	}
	private void drawToScreen()
	{
		Graphics g2 = getGraphics();
		g2.drawImage(image,0,0,WIDTH,HEIGHT,null);
		g2.dispose();
		
	}
	
	public void keyPressed(KeyEvent k) 
	{
		keyHandler.keySet(k.getKeyCode(),true);
	}

	
	public void keyReleased(KeyEvent k) 
	{
		keyHandler.keySet(k.getKeyCode(),false);
	}
	
	public void keyTyped(KeyEvent k) 
	{
		
	}
}
