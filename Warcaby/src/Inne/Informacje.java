package Inne;

import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JEditorPane;
import javax.swing.SwingUtilities;

/**
 * Informacje.java
 * Utworzony 21/11/2014,12:59:26
 *
 * @author Kamil Jadczuk
 */

public class Informacje {

	private JEditorPane editorpane;
	
	public Informacje() {
		System.setProperty("awt.useSystemAAFontSettings","on");
		editorpane = new JEditorPane();
		editorpane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
		editorpane.setFont(new Font("Arial",Font.PLAIN, 13));
		editorpane.setBackground(null);
		
		editorpane.setPreferredSize(new Dimension(520, 180));
		editorpane.setEditable(false);
		editorpane.setContentType("text/html");
		editorpane.setText(
				"<html><body><table border= '0px' cxellpadding='10px' height='100%'><tr><td valign= 'center'><img src='file:/D:/!Szkola/eclipse/workspace/Warcaby/bin/resources/images/xcode.png'></td><td>\r\n<&#9 Aplikacja Warcaby <br />\r\n<&#9 Wykonanie: Kamil Jadczuk <br />\r\n<&#9 e-mail: kamil_jadczuk@o2.pl <br />\r\n<&#9 Tymoteusz Urbaniak <br />\r\n<&#9 e-mail: tym_urb@gmail.com <br />\r\n<&#9 Politechnika Koszalińska 2014 <br /><br /></td></tr></table></body></html>"
				);
		
		editorpane.addHierarchyListener(new HierarchyListener() {

                        @Override
			public void hierarchyChanged(HierarchyEvent e) {
			Window window = SwingUtilities.getWindowAncestor(editorpane);
			if (window instanceof Dialog) {
				Dialog dialog = (Dialog)window;
				if (!dialog.isResizable()) {
					dialog.setResizable(true);
				}
			}
		}
		});}
		
				
		public void run() {
			SwingUtilities.getWindowAncestor(editorpane).setCursor(Cursor.getDefaultCursor());
			editorpane.setToolTipText(null);
		}
		public JEditorPane getEditorPane() {
			return editorpane;
		}
		
		public void setEditorPane(JEditorPane editorPane) {
			this.editorpane = editorPane;
				}
		;}


	

