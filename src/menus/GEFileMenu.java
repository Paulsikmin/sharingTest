package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.FileMenuItems;

public class GEFileMenu extends JMenu {
	
	public GEFileMenu(String title) {
		super(title);
		
		for (FileMenuItems e : FileMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);
			
		}
		
//		for(String str : GEConstants.FileMenuItems) {
//			JMenuItem item = new JMenuItem(str);
//			this.add(item);
//		}
		
	}

}
