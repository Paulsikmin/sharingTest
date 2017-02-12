package constants;

import java.awt.Color;

public class GEConstants {
	
//	Main Frame 
	
	public static final String MAINFRAME_TITLE = "Graphic Editor ver 1.0";
	public static final int MAINFRAME_WIDTH = 500;
	public static final int MAINFRAME_HEIGHT = 800;
	public static final String IMAGE_FOLDER = "images/";
	
//	Menu
	
	public enum FileMenuItems {
		NEW_FILE, OPEN, SAVE, EXIT
	}
	
	public enum EditMenuItems {
		COPY, PASTE, DELETE, APPEND, GROUP, UNGROUP
	}
	
	public enum ColorMenuItems {
		PAINT_LINE_COLOR, ERASE_LINE_COLOR, PAINT_FILM_COLOR, ERASE_FILM_COLOR
	}
	
	public enum ToolbarButtons {
		Select, Rectangle, Ellipse, Line, Polygon
	}
	
	public enum State {
		Idle, TwoPointDrawing, NPointDrawing, Moving
	}
	
//	about Select Anchor
	public static final int ANCHOR_W = 6;
	public static final int ANCHOR_H = 6;
	public static final int RR_OFFSET = 40; 	// rotation mark
	
	public static final Color ANCHOR_LINECOLOR = Color.blue;
	public static final Color ANCHOR_FILLCOLOR = Color.pink;
	
	
	public enum AnchorTypes {
		NW, NN, NE, WW, EE, SW, SS, SE, RR, NONE
	}
}
