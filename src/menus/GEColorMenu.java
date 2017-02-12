package menus;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.ColorMenuItems;
import frames.GEDrawingPanel;

public class GEColorMenu extends JMenu {
	
	private int num;
	
	private GEDrawingPanel drawingPanel;
	
	public GEColorMenu(String title) {
		super(title);
		
		EventHandler event = new EventHandler();
		
		
		for (ColorMenuItems e : ColorMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			
			item.addActionListener(event);
			item.setActionCommand(e.name());
			this.add(item);
		}
	}
	
	public void initialization (GEDrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}
	
	
	private void setLineColor() {
		Color lineColor = JColorChooser.showDialog(null, "Select Line Color", null);
		
		if (lineColor != null) {
			drawingPanel.setLineColor(lineColor);
		}
	}
	
	private void setFillColor () {
		Color fillColor = JColorChooser.showDialog(null, "Select Fill Color", null);
		
		if (fillColor != null) {
			drawingPanel.setFillColor(fillColor);
		}
	}
	
	private void deleteLineColor () {
		drawingPanel.setLineColor(Color.black);
	}
	
	private void deleteFillColor () {
		drawingPanel.setFillColor(Color.white);
	}
	
	private class EventHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			PAINT_LINE_COLOR, ERASE_LINE_COLOR, PAINT_FILM_COLOR, ERASE_FILM_COLOR
			switch (ColorMenuItems.valueOf(e.getActionCommand())) {
			case PAINT_LINE_COLOR:
				setLineColor();
				break;
			case PAINT_FILM_COLOR:
				setFillColor();
				break;
			case ERASE_LINE_COLOR:
				deleteLineColor();
				break;
			case ERASE_FILM_COLOR:
				deleteFillColor();
				break;
				
			}
			
		}
	}

}
