package frames;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import constants.GEConstants;
import menus.GEMenuBar;

public class GEMainFrame extends JFrame {
	
	private GEDrawingPanel drawingPanel;
	private GEMenuBar menuBar;
	private GEToolBar toolBar;
	
	public GEMainFrame(String title) {
		super(title);
		
		drawingPanel = new GEDrawingPanel();
		this.add(drawingPanel);						// add panel in MainFrame
		
		menuBar = new GEMenuBar();
		this.setJMenuBar(menuBar);					// set MenuBar in MainFrame
		
		toolBar = new GEToolBar("TOOlBAR");
		this.add(BorderLayout.NORTH, toolBar);		// add ToolBar in MainFrame ordered by BorderLayout(North)
//		** BorderLayout
	}
	
	
	
	public void initialization() {					// 'first set MainFrame on screen' method 
		
		toolBar.initialization(drawingPanel);		// first set ToolBar on screen 
		menuBar.initialization(drawingPanel);
		
		this.setSize(GEConstants.MAINFRAME_WIDTH, GEConstants.MAINFRAME_HEIGHT); // method of 'public class Window extends Container'
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// method of JFrame // close operation --> exit program
		this.setVisible(true);	// method of 'public class Window'
		
		
//		JFrame extends Frame / Frame extends Window / Window extends Container
		
	}
	

}
