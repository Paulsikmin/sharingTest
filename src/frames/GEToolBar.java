package frames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import constants.GEConstants;
import constants.GEConstants.ToolbarButtons;
import shapes.GEEllipse;
import shapes.GELine;
import shapes.GEPolygon;
import shapes.GERectangle;

public class GEToolBar extends JToolBar {

	private GEDrawingPanel drawingPanel;		// has panel to keep in touch with panel

	public GEToolBar(String title) {
		super(title);

		ButtonGroup group = new ButtonGroup();	// new Vector for button into
		ButtonEvent event = new ButtonEvent();	// new ActionListener Class object for catch button event

		for (ToolbarButtons e : ToolbarButtons.values()) {		// put image names(in enum group) into RadioButton
			JRadioButton item = new JRadioButton();

			// images 폴더명은 상수로 바꿔야 함
			item.setIcon(new ImageIcon(GEConstants.IMAGE_FOLDER + e.name() + ".gif"));
			item.setSelectedIcon(new ImageIcon(GEConstants.IMAGE_FOLDER + e.name() + "SLT.gif"));

			item.addActionListener(event);		// append ActionListener to RadioButton
			item.setActionCommand(e.name());

			this.add(item);
			group.add(item);
		}
	} 

	public void initialization(GEDrawingPanel drawingPanel) {	// receive panel from MainFrame and first set in this object
		this.drawingPanel = drawingPanel;
		
		JRadioButton btn = (JRadioButton)getComponent(ToolbarButtons.Rectangle.ordinal());
		// .ordinal() --> call index of Rectangle(enum)
		
		btn.doClick(); 		// btn clicked
	}
	
	
	
	
	
	

	private class ButtonEvent implements ActionListener {		// Inner Class // redefine actionPerformed

		@Override
		public void actionPerformed(ActionEvent e) {			// receive ActionEvent from 

			if (e.getActionCommand().equals(ToolbarButtons.Select.name())) {
				
				drawingPanel.setCurrentShape(null);		// ??
				

			} else if (e.getActionCommand().equals(ToolbarButtons.Rectangle.name())) {
				drawingPanel.setCurrentShape(new GERectangle());

			} else if (e.getActionCommand().equals(ToolbarButtons.Ellipse.name())) {
				drawingPanel.setCurrentShape(new GEEllipse());

			} else if (e.getActionCommand().equals(ToolbarButtons.Line.name())) {
				drawingPanel.setCurrentShape(new GELine());

			} else if (e.getActionCommand().equals(ToolbarButtons.Polygon.name())) {
				drawingPanel.setCurrentShape(new GEPolygon());

			}

		}
	}

}
