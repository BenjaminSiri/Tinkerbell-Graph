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
			
			g2.setColor(Color.BLACK);
			g2.fillRect(0,0,500,400);
		}
	}
	
}
