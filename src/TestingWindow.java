import java.awt.Color;
import javax.swing.JFrame;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class TestingWindow extends JFrame
{
	ImageManager im = new ImageManager();
	int x = -1;
	public TestingWindow()
	{
		im.loadImages("ImageList.txt");

		setUndecorated(true);
		setSize(400,400);
		setVisible(true);
		while(true)
		{
			try
			{
				Thread.sleep(4000);
				repaint();
			}
			catch(Exception e)
			{}
		}
	}

	public void paint(Graphics g)
	{

		g.setColor(Color.GRAY);
		g.fillRect(0,0,400,400);
		g.setColor(Color.RED);
		g.drawString(""+x,300,300);
		if(x==0)
		{
			g.drawImage(im.getImage("baby"),0,0,null);
		}
		else if(x==1)
		{
			g.drawImage(im.getImage("metroid0"),0,0,null);
			g.drawImage(im.getImage("metroid1"),80,0,null);
			g.drawImage(im.getImage("metroid2"),0,200,null);
			g.drawImage(im.getImage("metroid3"),80,200,null);
			
		}
		else if(x==2)
		{
			g.drawImage(im.getImage("metroidD"),0,0,null);
			g.drawImage(im.getImage("metroidC"),80,0,null);
			g.drawImage(im.getImage("metroidB"),160,0,null);
			g.drawImage(im.getImage("metroidA"),240,0,null);
		}
		else if(x==3)
		{
			for(int r=4; r>=0; r--)
				for(int c=0; c<3;c++)
					g.drawImage(im.getImage("shaper"+r+"c"+c),r*75,c*75,null);
			
		}
		else if(x==4)
		{
			
			g.drawImage(im.getImage("chat1"),0,0,null);
			g.drawImage(im.getImage("chat2"),100,0,null);
			g.drawImage(im.getImage("v"),200,0,null);
			
			g.drawImage(im.getImage("circle"),0,100,null);
			g.drawImage(im.getImage("square"),100,100,null);
			g.drawImage(im.getImage("triangle"),200,100,null);
			
			g.drawImage(im.getImage("left"),0,200,null);
			g.drawImage(im.getImage("up"),100,200,null);
			g.drawImage(im.getImage("diamond"),200,200,null);
			
			g.drawImage(im.getImage("pentagon"),0,300,null);
			g.drawImage(im.getImage("hexagon"),100,300,null);
			g.drawImage(im.getImage("star"),200,300,null);
			
		}
		x=(x+1)%5;
	}



}