package TileMap;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class tileMap 
{
	private int tileSize;
	private int tileImageWidth;
	private int tileImageHeight;
	
	private BufferedImage tileSet;
	private Tile tile[][];
	
	public tileMap(int ts)
	{
		ts = tileSize;
		//add game high and width / tilesize
	}
	
	public void loadTiles(String fileLoc)
	{
		try
		{
			tileSet = ImageIO.read(getClass().getResourceAsStream(fileLoc) );
			tileImageWidth = tileSet.getWidth() /tileSize;
			tileImageHeight = tileSet.getHeight() /tileSize;
			
			tile = new Tile[tileImageHeight][tileImageWidth];
			
			BufferedImage subimage;
			
			for(int i =0;i<tileImageWidth;i++)
			{
				subimage = tileSet.getSubimage(i*tileSize, 0, tileSize, tileSize);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
