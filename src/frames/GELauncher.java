package frames;

import constants.GEConstants;

public class GELauncher {

	public static void main(String[] args) {

		GEMainFrame frame = new GEMainFrame(GEConstants.MAINFRAME_TITLE);	// MainFrame new, set title
		frame.initialization();		// method run
	}

}
