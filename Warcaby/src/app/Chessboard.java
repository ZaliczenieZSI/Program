package app;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

/**
 * Chessboard.java
 * Utworzony 21/11/2014,11:59:26
 *
 * @author Kamil Jadczuk
 */

public class Chessboard {
    
    @SuppressWarnings("deprecation")
	public static void main(String[] args)	{
    	
    	DrawFrame frame = new DrawFrame();
    	frame.setTitle("Warcaby");
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	JMenuBar menuBar = new JMenuBar();
    	frame.setJMenuBar(menuBar);
    	JMenu mnPlik = new JMenu("Plik");
    	menuBar.add(mnPlik);
    	JMenuItem mntmZamknij = new JMenuItem("Zamknij");
    	mntmZamknij.setIcon(new ImageIcon(Chessboard.class.getResource("/resources/images/Log Out.png")));
    	
    	mntmZamknij.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
});
    	mnPlik.add(mntmZamknij);
    	JMenu mnInfo = new JMenu("Pomoc");
    	menuBar.add(mnInfo);
    	JMenuItem mntmInformacje = new JMenuItem("Informacje");
    	
    	mntmInformacje.addActionListener(new ActionListener() {    		
    	public void actionPerformed(ActionEvent e) {
    	Inne.Informacje about = new Inne.Informacje();
    		
    	JOptionPane.showMessageDialog(null, about.getEditorPane(), "Informacje o autorze", JOptionPane.PLAIN_MESSAGE);
    }
});
    	mntmInformacje.setIcon(new ImageIcon(Chessboard.class.getResource("/resources/images/information2.png")));
    	mnInfo.add(mntmInformacje);
    	frame.show();
    	}
}
    
	class DrawFrame extends JFrame {
		/**
		 * 
		 */
		private static final long serialVersionUID = 5874454503377747879L;
		static int one_for_all=700; //wysokość i szerokość ramki
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		public int screenHeight = screenSize.height;
		public int screenWidth = screenSize.width;

		public DrawFrame() {
			setSize(FRAME_WIDTH, FRAME_HEIGHT);
			
// centruj ramke na ekranie
			setLocation(screenWidth / 4, screenHeight / 4);
			setResizable(true);
			setTitle("Warcaby");
			setUndecorated(false); 	//oprawa okienka

// dodanie panelu do ramki
			

			DrawPanel panel = new DrawPanel();
			Container contentPane = getContentPane();
			contentPane.add(panel);
			}
		
		public static final int FRAME_WIDTH = one_for_all;
		public static final int FRAME_HEIGHT = one_for_all;
		}

    class DrawPanel extends JPanel    {
    	/**
		 * 
		 */
		private static final long serialVersionUID = -7375113517727125447L;

		public void paintComponent(Graphics g)    	{
			
    	DrawFrame frame = new DrawFrame();
    	int XXX=25;				//x miejsce gdzie ma zacząć rysowanie
    	int YYY=25;				//y miejsce gdzie ma zacząć rysowanie
    	System.out.println(XXX);
    	int co_x=XXX;
    	int co_y=YYY;
    	int no=8; 		
    	int size=80; 	
    	boolean flag=false;
    	setBackground(new Color(80,40,40));
    	super.paintComponent(g);
    	Graphics2D g2 = (Graphics2D)g;
    	for(int j=0;j<no;j++)
    	{
    		if(j%2==0)
    		{flag=false;
    		}
    		
    		else if(j%2==1)
    		{flag=true;
    		}
    		
    		co_x=XXX;
    		for(int i=0;i<no;i++)
    		{
    			if(flag==true)
    			{
    				g2.setPaint(Color.WHITE);
    				g2.fill(new Rectangle2D.Double(co_x,co_y,size,size));
    				flag=false;
    				}
    			else
    			{
    				g2.setPaint(Color.BLACK);
    				g2.fill(new Rectangle2D.Double(co_x,co_y,size,size));
    				flag=true;
    				}
    			co_x+=size;
    			}
    		co_y+=size;
    		}
    	}
}