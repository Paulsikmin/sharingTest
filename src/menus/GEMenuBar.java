package menus;

import javax.swing.JMenuBar;

import frames.GEDrawingPanel;

public class GEMenuBar extends JMenuBar{
	
	private GEFileMenu fileMenu;
	private GEEditMenu editMenu;
	private GEColorMenu colorMenu;
	
	public GEMenuBar() {
		fileMenu = new GEFileMenu("FILE");
		this.add(fileMenu);
		
		editMenu = new GEEditMenu("EDIT");
		this.add(editMenu);
		
		colorMenu = new GEColorMenu("COLOR");
		this.add(colorMenu);
	}
	
	
	public void initialization (GEDrawingPanel drawingPanel) {
		colorMenu.initialization(drawingPanel);
	}
	

}
