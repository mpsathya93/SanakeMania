package justcoders.snake2D.Game;

import java.util.Random;
import javax.swing.ImageIcon;


public final class  SnakeGameState {
	
	   public static ImageIcon downmouth;
	   public static ImageIcon rightmouth;
	   public static ImageIcon upmouth;
	   public static ImageIcon leftmouth;
	   public static ImageIcon enemy;

	    public static javax.swing.Timer timer;
	    public static int boostertimer=0;
	    
	    public static boolean spaceKeyToggle=false;

	    public static int moves=0;
	    
	    public static int stateChange=7;
	    
	    public static short endLevel=5;

	    public static ImageIcon snakeimage;
	    
	    public static ImageIcon boosterimage;
	    public static boolean boostercapture=false;
	    
	    public static int scoreInc=10; 
	    
	    public static Random random =  new Random();
	    public static  int xpos;
	    public static int ypos;
	   
	    
	    public static  int bxpos;
	    public static int bypos;
	    public static short noOfEnemy=0;

      public static int [] enemyxpos={25,50,75,100,125,150,175,200,225,250,275,300,325,
    	                     350,375,400,425,450,475,500,525,550,575,600,625,650
    	                    ,675,700,725,750,775,800,825,850};
    public static int [] enemyypos={75,100,125,150,175,200,225,250,275,300,325,350,
    	                           375,400,425,450,475,500,525,550,575,600,625};
	public static int score = 0;
	public static int lengthofSnake=3;
	public static int[] snakexlength = new int[750];
	public static int[] snakeylength = new int[750];
	public static boolean left  = false;
	public static boolean right = false;
	public static boolean up    = false;
	public static boolean down  = false;
	public static int delay=150;
	public static short LEVEL=1;
	public static boolean isconsumed = false;
    public static boolean isEnd = false;

	
}
