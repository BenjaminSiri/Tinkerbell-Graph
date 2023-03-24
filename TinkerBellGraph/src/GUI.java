import java.awt.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame {
	
	GraphPanel gPanel;

	public GUI() {
		this.setTitle("Tinker Bell Graph");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		gPanel = new GraphPanel();
		add(gPanel,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	private class GraphPanel extends JPanel {
		public GraphPanel() {}
		
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			
			
			double ratio = 16.0/9.0;
			int height = 400;
			int width = (int)(ratio * height);
			
			TBFunction f = new TBFunction(-.72,-.64,.9,-.6013,2,.5,width,height,100);
			boolean[][] array = f.toArray();
			
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					if(array[i][j]) {
						g2.setColor(Color.WHITE);
						g2.fillRect(i-1,j-1,2,2);
					}
					else {
						g2.setColor(Color.BLACK);
						g2.fillRect(i,j,1,1);
					}
				}
			}
		}
	}
	
}
