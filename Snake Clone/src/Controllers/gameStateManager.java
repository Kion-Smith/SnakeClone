package Controllers;

import java.awt.Graphics2D;

import GameStates.gameOverState;
import GameStates.gameState;
import GameStates.helpState;
import GameStates.menuState;
import GameStates.pauseState;
import GameStates.playState;

public class gameStateManager 
{
	private boolean paused;
	private pauseState pS;
	
	private gameState[] gS;
	private int curState;
	private int prevState;
	
	public static final int numStates = 4;
	public static final int MENU = 0;
	public static final int PLAY = 1;
	public static final int HELP = 2;
	public static final int GAMEOVER = 3;
	
	public gameStateManager()
	{
		paused = false;
		pS = new pauseState(this);
		
		gS = new gameState[numStates];
		
		setState(MENU);
	}
	
	public void setState(int i)
	{
		prevState = curState;
		unloadState(prevState);
		curState = i;
		if(i == MENU)
		{
			gS[i] = new menuState(this);
			gS[i].init();
		}
		else if(i == PLAY)
		{
			gS[i] = new playState(this);
			gS[i].init();
		}
		else if( i == HELP)
		{
			gS[i] = new helpState(this);
			gS[i].init();
		}
		else if (i== GAMEOVER)
		{
			gS[i] = new gameOverState(this);
			gS[i].init();
		}
	}
	
	public void unloadState(int i)
	{
		gS[i] = null;
	}
	
	public void setPaused(boolean b)
	{
		paused = b;
	}
	
	public void update()
	{
		if(paused)
		{
			pS.update();
		}
		else if(gS[curState] != null)
		{
			gS[curState].update();
		}
	}
	
	public void draw(Graphics2D g)
	{
		if(paused)
		{
			pS.draw(g);
		}
		else if(gS[curState] != null)
		{
			gS[curState].draw(g);
		}
	}
	
}
