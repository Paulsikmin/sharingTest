package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

import constants.GEConstants.AnchorTypes;
import utils.GEAnchorList;

public abstract class GEShape {
	
	protected Shape myShape;
	protected Point startP;
	
	protected boolean selected;
	protected GEAnchorList anchorList;
	protected AnchorTypes selectedAnchor;
	
	protected Color lineColor, fillColor;
	protected AffineTransform affine;
	
	public GEShape(Shape myShpae) {
		this.myShape = myShpae;
		this.anchorList = null;
		this.selected = false;
		
		affine = new AffineTransform();
	}
	
	public void setLineColor (Color lineColor) {
		this.lineColor = lineColor;
	}
	
	public void setFillColor (Color fillColor) {
		this.fillColor = fillColor;
	}
	
	
	
	public void draw(Graphics2D g2D) {
		
		if (fillColor != null) {
			g2D.setColor(fillColor);
			g2D.fill(myShape);
			
		}
		
		if (lineColor != null) {
			g2D.setColor(lineColor);
			g2D.draw(myShape);
			
		} 
		
		if (selected) {
			anchorList.setPosition(myShape.getBounds());
			anchorList.draw(g2D);
		}
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
		if (selected) {
			anchorList = new GEAnchorList();
			anchorList.setPosition(myShape.getBounds());
		} else {
			anchorList = null;
		}
	}
	
	public boolean onShape (Point p) {
		if (anchorList != null) {
			selectedAnchor = anchorList.onAnchors(p);
			if (selectedAnchor != AnchorTypes.NONE) {
				return true;
			}
		} 
		return myShape.intersects(new Rectangle(p.x, p.y, 2, 2));
		// does this Shape intersects 'parameter(new Rectangle)'?
		
	}
	
	public void moveCoordinate(Point moveP) {
		affine.setToTranslation(moveP.getX(), moveP.getY());
		myShape = affine.createTransformedShape(myShape);
	}
	
	
	public abstract GEShape clone();
	
	public abstract void initDraw(Point startP);
	public abstract void setCoordinate(Point currentP); 

}
