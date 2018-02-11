package justcoders.snake2D.GUI;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import justcoders.snake2D.Game.SnakeGame;
import justcoders.snake2D.Game.SnakeGameState;



public class SnakeGamePanel extends JPanel  {
    private ImageIcon titleImage;
    private ImageIcon grassImage;
    
   SnakeGame sg= new SnakeGame(this);
  
   
	public SnakeGamePanel() {
		
	}
	

	public void paint(Graphics g) {
			
		//draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(24,10,851,55);
		
		
		titleImage = new ImageIcon("Assests//snaketitle.jpg");
		titleImage.paintIcon(this, g, 25, 11);
	    
	    
		g.setColor(Color.WHITE);
		g.drawRect(24,74, 851, 577);
	
		g.setColor(Color.WHITE);
		g.drawRect(879,9, 311, 644);
		
		//fill color scorecard
		g.setColor(Color.GRAY);
		g.fillRect(880,10, 310, 643);
			
	    sg.updateScore(g);	
		
		g.setColor(Color.BLACK);	    
		g.fillRect(25,75, 850, 575);
		    
        sg.init(g);
		
		g.dispose();
	}
	
}
