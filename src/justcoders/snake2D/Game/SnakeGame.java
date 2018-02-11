package justcoders.snake2D.Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import justcoders.snake2D.GUI.SnakeGamePanel;


public class SnakeGame implements KeyListener,ActionListener {
	
	   private  SnakeGamePanel sg=null;	  
	    
       public void  isEndGame() {
    	   
    	   for(int i=1;i<SnakeGameState.lengthofSnake;i++) {
    		   if(SnakeGameState.snakexlength[0]==SnakeGameState.snakexlength[i] && SnakeGameState.snakeylength[0]==SnakeGameState.snakeylength[i]) {
    			      SnakeGameState.isEnd=true;  
    			      SnakeGameState.up=false;
    			      SnakeGameState.down=false;
    			      SnakeGameState.left=false;
    			      SnakeGameState.right=false;
    		   }
    	   }
       }
	   private int RandomSetxpos() {
		   return SnakeGameState.enemyxpos[SnakeGameState.random.nextInt(34)];
		   
	   }
	   
	   private int RandomSetypos() {
		   return SnakeGameState.enemyypos[SnakeGameState.random.nextInt(23)];
		   
	   } 
	   public void generateEnemy() {
		   SnakeGameState.xpos = RandomSetxpos();
		   SnakeGameState.ypos = RandomSetypos();
	   }
	   public void generateBooster() {
		   SnakeGameState.bxpos = RandomSetxpos();
		   SnakeGameState.bypos = RandomSetypos();
	   }
	   
	   public  void checkConsumed() {
		   if(SnakeGameState.xpos == SnakeGameState.snakexlength[0] && SnakeGameState.ypos == SnakeGameState.snakeylength[0] ) {
			   SnakeGameState.isconsumed = true;
			   SnakeGameState.lengthofSnake++;
			   SnakeGameState.noOfEnemy++;
			  
		     SnakeGameState.score=SnakeGameState.score+SnakeGameState.scoreInc;
			  
			  if(SnakeGameState.noOfEnemy%SnakeGameState.stateChange == 0 || SnakeGameState.LEVEL==SnakeGameState.endLevel) {
				 
				  if(SnakeGameState.LEVEL!=SnakeGameState.endLevel) {
					  SnakeGameState.LEVEL++;
				  }
				  updateLevelSettings(SnakeGameState.LEVEL);
			  } 
			  SnakeGameState.boostercapture=false;	   
		   }
		   else {
			   SnakeGameState.isconsumed = false;
			   SnakeGameState.boostercapture=false;
		   }
		   if(SnakeGameState.bxpos == SnakeGameState.snakexlength[0] && SnakeGameState.bypos == SnakeGameState.snakeylength[0]) {
			   
			   if(!SnakeGameState.boostercapture && SnakeGameState.boostertimer<=25  ) {
				   SnakeGameState.score=SnakeGameState.score+50;
				   SnakeGameState.boostercapture=false;
			   }
			   SnakeGameState.boostertimer=0;
				SnakeGameState.noOfEnemy=0;
		   }
		   
		  
		  
	   }
	   
	   
	   public void updateLevelSettings(int level) {
		   if(level>=SnakeGameState.endLevel) {
			     SnakeGameState.isEnd=true;
			     SnakeGameState.up=false;
			      SnakeGameState.down=false;
			      SnakeGameState.left=false;
			      SnakeGameState.right=false;
		   }
		   else {
			   
			   SnakeGameState.delay=SnakeGameState.delay-25;
			   SnakeGameState.scoreInc=SnakeGameState.scoreInc+10;
			   SnakeGameState.timer.setDelay(SnakeGameState.delay);
		   }
	   }
	   
	   public void updateScore(Graphics g) {
		    g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",Font.BOLD,45));
		    g.drawString("SCORE CARD ", 885, 45);
		    
		    g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",Font.BOLD,25));
		    g.drawString("Scores: "+SnakeGameState.score,940,90);
		    
		    g.setColor(Color.WHITE);
			g.setFont(new Font("Arial",Font.BOLD,25));
		    g.drawString("LEVEL: "+SnakeGameState.LEVEL,940,135);
		   
	   }
	   
	    public SnakeGame(SnakeGamePanel sg) {
	    	this.sg = sg;
	    	sg.addKeyListener(this);
	    	sg.setFocusable(true);
	    	sg.setFocusTraversalKeysEnabled(false);
	    	
	    	SnakeGameState.timer = new Timer(SnakeGameState.delay,this);    	
	    	SnakeGameState.timer.start();
	    	
	    }
	    

	    
	    
	public void init(Graphics g) {
		
		    
	if(!SnakeGameState.isEnd) {	
		if (SnakeGameState.moves == 0) {
			SnakeGameState.snakexlength[2]=50;
			SnakeGameState.snakexlength[1]=75;
			SnakeGameState.snakexlength[0]=100;
			
			SnakeGameState.snakeylength[2]=100;
			SnakeGameState.snakeylength[1]=100;
			SnakeGameState.snakeylength[0]=100;
			generateEnemy();
			
		}
		if(SnakeGameState.isconsumed && SnakeGameState.moves!=0) {
			generateEnemy();
		}
		SnakeGameState.rightmouth=new ImageIcon("Assests//rightmouth.png");
		SnakeGameState.rightmouth.paintIcon(sg, g, SnakeGameState.snakexlength[0], SnakeGameState.snakeylength[0]);
		
		for(int i=0;i<SnakeGameState.lengthofSnake;i++) {
			if(i==0 && SnakeGameState.left ) {
				SnakeGameState.leftmouth=new ImageIcon("Assests//leftmouth.png");
				SnakeGameState.leftmouth.paintIcon(sg, g, SnakeGameState.snakexlength[0], SnakeGameState.snakeylength[0]);
			}
			if(i==0 && SnakeGameState.right ) {
				SnakeGameState.rightmouth=new ImageIcon("Assests//rightmouth.png");
				SnakeGameState.rightmouth.paintIcon(sg, g, SnakeGameState.snakexlength[0], SnakeGameState.snakeylength[0]);
			}
			if(i==0 && SnakeGameState.up ) {
				SnakeGameState.upmouth=new ImageIcon("Assests//upmouth.png");
				SnakeGameState.upmouth.paintIcon(sg, g, SnakeGameState.snakexlength[0], SnakeGameState.snakeylength[0]);
			}
			if(i==0 && SnakeGameState.down ) {
				SnakeGameState.downmouth=new ImageIcon("Assests//downmouth.png");
				SnakeGameState.downmouth.paintIcon(sg, g, SnakeGameState.snakexlength[0], SnakeGameState.snakeylength[0]);
			}
			if(i!=0) {
				SnakeGameState.snakeimage=new ImageIcon("Assests//snakeimage.png");
				SnakeGameState.snakeimage.paintIcon(sg, g, SnakeGameState.snakexlength[i], SnakeGameState.snakeylength[i]);

			}
		}
		
		if(!SnakeGameState.isconsumed) {
		
			SnakeGameState.enemy = new ImageIcon("Assests//enemy.png");
			SnakeGameState.enemy.paintIcon(sg, g,SnakeGameState.xpos, SnakeGameState.ypos);			
			
			}
		 else if(SnakeGameState.isconsumed && SnakeGameState.moves!=0  ) {
			
		      SnakeGameState.enemy = new ImageIcon("Assests//enemy.png");
		      SnakeGameState.enemy.paintIcon(sg, g, SnakeGameState.xpos, SnakeGameState.ypos);
		    }
		
			
		} 
		if(!SnakeGameState.boostercapture && SnakeGameState.noOfEnemy%SnakeGameState.stateChange == 0 && SnakeGameState.boostertimer<=25 && SnakeGameState.noOfEnemy>1) {
			if(SnakeGameState.boostertimer==0) {
				generateBooster();
			}
			SnakeGameState.boosterimage = new ImageIcon("Assests//booster.png");
			SnakeGameState.boosterimage.paintIcon(sg, g, SnakeGameState.bxpos, SnakeGameState.bypos);
			SnakeGameState.boostertimer=SnakeGameState.boostertimer+1;
	   
			
	    	}
		if(SnakeGameState.boostertimer>=25) {
			SnakeGameState.boostercapture=true;
			SnakeGameState.boostertimer=0;
			SnakeGameState.noOfEnemy=0;
		}
		
		  	    
		checkConsumed();
		isEndGame();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
	   
		if(!SnakeGameState.isEnd) {
			SnakeGameState.timer.start();
		if(SnakeGameState.right) {
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				SnakeGameState.snakeylength[i+1]=SnakeGameState.snakeylength[i];
			}
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				if(i==0) {
					SnakeGameState.snakexlength[i]=SnakeGameState.snakexlength[i]+25;
					
				}
				else {
					SnakeGameState.snakexlength[i]=SnakeGameState.snakexlength[i-1];
				}
				if(SnakeGameState.snakexlength[i] > 850) {
					SnakeGameState.snakexlength[i]=25;
				}
			}
			sg.repaint();
		}
		
		if(SnakeGameState.left) {
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				SnakeGameState.snakeylength[i+1]=SnakeGameState.snakeylength[i];
			}
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				if(i==0) {
					SnakeGameState.snakexlength[i]=SnakeGameState.snakexlength[i]-25;
					
				}
				else {
					SnakeGameState.snakexlength[i]=SnakeGameState.snakexlength[i-1];
				}
				if(SnakeGameState.snakexlength[i]  < 25) {
					SnakeGameState.snakexlength[i]=850;
				}
			}
			sg.repaint();
		}
		if(SnakeGameState.down) {
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				SnakeGameState.snakexlength[i+1]=SnakeGameState.snakexlength[i];
			}
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				if(i==0) {
					SnakeGameState.snakeylength[i]=SnakeGameState.snakeylength[i]+25;
					
				}
				else {
					SnakeGameState.snakeylength[i]=SnakeGameState.snakeylength[i-1];
				}
				if(SnakeGameState.snakeylength[i]  > 625) {
					SnakeGameState.snakeylength[i]=75;
				}
			}
			sg.repaint();
		}
		if(SnakeGameState.up) {
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				SnakeGameState.snakexlength[i+1]=SnakeGameState.snakexlength[i];
			}
			for(int i=SnakeGameState.lengthofSnake-1;i>=0;i--) {
				if(i==0) {
					SnakeGameState.snakeylength[i]=SnakeGameState.snakeylength[i]-25;
					
				}
				else {
					SnakeGameState.snakeylength[i]=SnakeGameState.snakeylength[i-1];
				}
				if(SnakeGameState.snakeylength[i]  < 75) {
					SnakeGameState.snakeylength[i]=625;
				}
			}
			sg.repaint();
		 }
		}
		
		else if(SnakeGameState.LEVEL>= SnakeGameState.endLevel) {
			
			SnakeGameState.timer.stop();
			sg.repaint();
			JOptionPane.showMessageDialog(sg, "Game OVER ,YOUR SCORE :"+SnakeGameState.score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			
			SnakeGameState.timer.stop();
			JOptionPane.showMessageDialog(sg, "Uh-oh! TRY AGAIN!!! YOUR SCORE :"+SnakeGameState.score, "Game Over", JOptionPane.ERROR_MESSAGE);
			
		}
		
	
	

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			SnakeGameState.moves++;
			
			if(!SnakeGameState.left) {
				SnakeGameState.right =true;
				SnakeGameState.left=false;
			}
			else {
				SnakeGameState.left = true;
				SnakeGameState.right=false;
			}
			SnakeGameState.up = false;
			SnakeGameState.down = false;
		     
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			SnakeGameState.moves++;
			if(!SnakeGameState.right) {
				SnakeGameState.left =true;
				SnakeGameState.right =false;
			}
			else {
				SnakeGameState.right = true;
				SnakeGameState.left=false;
			}
			SnakeGameState.up = false;
			SnakeGameState.down = false;
		     
		}
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			SnakeGameState.moves++;
			if(!SnakeGameState.down) {
				SnakeGameState.up =true;
				SnakeGameState.down=false;
			}
			else {
				SnakeGameState.down = true;
				SnakeGameState.up=false;
			}
			SnakeGameState.left = false;
			SnakeGameState.right = false;
		     
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			SnakeGameState.moves++;
			if(!SnakeGameState.up) {
				SnakeGameState.down =true;
				SnakeGameState.up = false;
			}
			else {
				SnakeGameState.up = true;
				SnakeGameState.down=false;
			}
			SnakeGameState.left = false;
			SnakeGameState.right = false;
		     
		}
	    if(e.getKeyCode() == KeyEvent.VK_SPACE) {
	    	
	    	if(!SnakeGameState.spaceKeyToggle) {
	    		SnakeGameState.timer.stop();
	    		SnakeGameState.spaceKeyToggle=true;
	    	 }
	    	else {
	    		SnakeGameState.timer.start();
	    		SnakeGameState.spaceKeyToggle=false;
	    	}
	    }	
  
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
