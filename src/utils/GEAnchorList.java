package utils;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import constants.GEConstants;
import constants.GEConstants.AnchorTypes;

public class GEAnchorList {
	
	private List<Ellipse2D> anchors;		// anchors in this List
	
	public GEAnchorList() {
		anchors = new ArrayList<>();
		
		for (int i =0; i < AnchorTypes.values().length - 1; i++) {		// - 1 because of NONE
			anchors.add(new Ellipse2D.Double());
		}
	}
	
	public void setPosition(Rectangle r) {
		int x = r.x;
		int y = r.y;
		int w = r.width;
		int h = r.height;
		
		int dx = GEConstants.ANCHOR_W / 2;
		int dy = GEConstants.ANCHOR_H / 2;
		
//		NW, NN, NE, WW, WE, SW, SS, SE, RR

		anchors.get(AnchorTypes.NW.ordinal()).setFrame(x - dx, y - dy, GEConstants.ANCHOR_W, GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.NN.ordinal()).setFrame(x + w / 2 - dx, y - dy, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.NE.ordinal()).setFrame(x + w - dx, y - dy, GEConstants.ANCHOR_W, GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.WW.ordinal()).setFrame(x - dx, y + h / 2 - dy, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.SW.ordinal()).setFrame(x - dx, y + h - dy, GEConstants.ANCHOR_W, GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.EE.ordinal()).setFrame(x + w - dx, y + h / 2 - dy, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.SS.ordinal()).setFrame(x + w / 2 - dx, y + h - dy, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.SE.ordinal()).setFrame(x + w - dx, y + h - dy, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		anchors.get(AnchorTypes.RR.ordinal()).setFrame(x + w / 2 - dx, y - GEConstants.RR_OFFSET, GEConstants.ANCHOR_W,
				GEConstants.ANCHOR_H);
		
	}
	
	public void draw(Graphics2D g2D) {
		for (int i = 0; i < AnchorTypes.values().length - 1; i ++) {
			Ellipse2D ellipse = anchors.get(i);
			g2D.setColor(GEConstants.ANCHOR_FILLCOLOR);
			g2D.fill(ellipse);
			
			g2D.setColor(GEConstants.ANCHOR_LINECOLOR);
			g2D.draw(ellipse);
		}
	}
	
	
	public AnchorTypes onAnchors(Point p) {
		for (Ellipse2D ellipse : anchors) {
			if (ellipse.contains(p)) {			// this Shape contains p?
				return AnchorTypes.values()[anchors.indexOf(ellipse)];		// .values() method returns ArrayList
			}
		}
		
		return AnchorTypes.NONE;
		
	}

}
