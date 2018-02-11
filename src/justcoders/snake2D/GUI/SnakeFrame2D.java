package justcoders.snake2D.GUI;

import javax.swing.JFrame;





import java.awt.Color;

public class SnakeFrame2D extends JFrame {
	public SnakeFrame2D() {
		JFrame obj = new JFrame();
		SnakeGamePanel gamepanel = new SnakeGamePanel();
		obj.setBackground(Color.DARK_GRAY);
		obj.setBounds(10, 10, 1200, 700);
		obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamepanel);
		
		
	}

	public static void main(String[] args) {
		
		new SnakeFrame2D();
	}

}
