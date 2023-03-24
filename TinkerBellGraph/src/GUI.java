import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class GUI extends JFrame {
	
	GraphPanel gPanel;
	JPanel topPanel;
	JPanel bottomPanel;
	JLabel xEquationLabel;
	JLabel yEquationLabel;
	
	JLabel statusLabel;
	
	JPanel fieldsPanel;
	JLabel aLabel;
	JTextField aTextField;
	JLabel bLabel;
	JTextField bTextField;
	JLabel cLabel;
	JTextField cTextField;
	JLabel dLabel;
	JTextField dTextField;
	
	JPanel xyPanel;
	JLabel xLabel;
	JTextField xTextField;
	JLabel yLabel;
	JTextField yTextField;
	
	JButton runButton;

	public GUI() {
		this.setTitle("Tinkerbell Graph");
		this.setSize(700, 600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		
		// --- TOP PANEL ---
		topPanel = new JPanel(new GridLayout(2,0));
		add(topPanel, BorderLayout.NORTH);
		xEquationLabel = new JLabel("X(next) = (x*x) - (y*y) + (a*x) + (b*y)");
		yEquationLabel = new JLabel("Y(next) = (2*x*y) + (c*x) + (d*y)");
		topPanel.add(xEquationLabel);
		topPanel.add(yEquationLabel);
		
		// --- DRAW PANEL ---
		gPanel = new GraphPanel();
		add(gPanel,BorderLayout.CENTER);
		
		// --- BOTTOM PANEL ---
		bottomPanel = new JPanel(new GridLayout(4,0));
		add(bottomPanel, BorderLayout.SOUTH);
		fieldsPanel = new JPanel(new FlowLayout());
		xyPanel = new JPanel(new FlowLayout());
		
		statusLabel = new JLabel("Success!");
		bottomPanel.add(statusLabel);
		
		aLabel = new JLabel("a:");
		bLabel = new JLabel("b:");
		cLabel = new JLabel("c:");
		dLabel = new JLabel("d:");		
		aTextField = new JTextField(".9",3);
		bTextField = new JTextField("-.601",3);
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
		bottomPanel.add(fieldsPanel);
		
		xLabel = new JLabel("initial x:");
		yLabel = new JLabel("initial y:");
		xTextField = new JTextField("-.72",3);
		yTextField = new JTextField("-.64",3);
		xyPanel.add(xLabel);
		xyPanel.add(xTextField);
		xyPanel.add(yLabel);
		xyPanel.add(yTextField);
		bottomPanel.add(xyPanel);
		
		ButtonHandler bHandler = new ButtonHandler();		
		runButton = new JButton("Run");
		runButton.addActionListener(bHandler);
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
			
			double a = Double.parseDouble(aTextField.getText());
			double b = Double.parseDouble(bTextField.getText());
			double c = Double.parseDouble(cTextField.getText());
			double d = Double.parseDouble(dTextField.getText());
			double x = Double.parseDouble(xTextField.getText());
			double y = Double.parseDouble(yTextField.getText());

			
			TBFunction f = new TBFunction(x,y,a,b,c,d,width,height, 5000);
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
	
	private class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Run") {
				// ERROR CATCHING
				if(Double.parseDouble(xTextField.getText()) == 0 && Double.parseDouble(yTextField.getText()) == 0) {
					statusLabel.setText("WARNING: Setting x and y to 0 will result in a point at (0,0).");
				}
				gPanel.repaint();
				statusLabel.setText("Success!");
			}
		}
	}
	
}
