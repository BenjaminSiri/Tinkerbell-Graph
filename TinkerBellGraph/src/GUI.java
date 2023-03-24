import java.awt.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame {
	
	GraphPanel gPanel;
	JPanel topPanel;
	JPanel bottomPanel;
	JLabel XLabel;
	JLabel YLabel;
	
	JPanel fieldsPanel;
	JLabel aLabel;
	JTextField aTextField;
	JLabel bLabel;
	JTextField bTextField;
	JLabel cLabel;
	JTextField cTextField;
	JLabel dLabel;
	JTextField dTextField;
	
	JButton runButton;

	public GUI() {
		this.setTitle("Tinker Bell Graph");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		topPanel = new JPanel(new GridLayout(2,0));
		add(topPanel, BorderLayout.NORTH);
		XLabel = new JLabel("X(next) = (x*x) - (y*y) + (a*x) + (b*y)");
		YLabel = new JLabel("Y(next) = (2*x*y) + (c*x) + (d*y)");
		topPanel.add(XLabel);
		topPanel.add(YLabel);
		
		gPanel = new GraphPanel();
		add(gPanel,BorderLayout.CENTER);
		
		bottomPanel = new JPanel(new GridLayout(2,0));
		add(bottomPanel, BorderLayout.SOUTH);
		fieldsPanel = new JPanel(new FlowLayout());
		bottomPanel.add(fieldsPanel);
		aLabel = new JLabel("a:");
		bLabel = new JLabel("b:");
		cLabel = new JLabel("c:");
		dLabel = new JLabel("d:");
		
		aTextField = new JTextField(".9",3);
		bTextField = new JTextField("-.6013",3);
		cTextField = new JTextField("2",3);
		dTextField = new JTextField(".5",3);
		
		fieldsPanel.add(aLabel);
		fieldsPanel.add(aTextField);
		fieldsPanel.add(bLabel);
		fieldsPanel.add(bTextField);
		fieldsPanel.add(cLabel);
		fieldsPanel.add(cTextField);
		fieldsPanel.add(dLabel);
		fieldsPanel.add(dTextField);
		
		runButton = new JButton("Run");
		bottomPanel.add(runButton);
		
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
			
			TBFunction f = new TBFunction(-.72,-.64,.9,-.6013,2,.5,width,height,4000);
			boolean[][] array = f.toArray();
			
			for(int i = 0; i < width; i++) {
				for(int j = 0; j < height; j++) {
					if(array[i][j]) {
						g2.setColor(Color.WHITE);
						g2.fillRect(i,j,1,1);
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
