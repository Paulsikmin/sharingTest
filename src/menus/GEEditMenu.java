package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EditMenuItems;

public class GEEditMenu extends JMenu {
	
//	복사, 잘라내기, 삭제, 붙이기, 그룹, 그룹해제 
	

	
	public GEEditMenu(String title) {
		super(title);
		
		for (EditMenuItems e : EditMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);
		}
	}

}
