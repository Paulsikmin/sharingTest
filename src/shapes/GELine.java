package shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;

public class GELine extends GEShape {

	public GELine() {
		super(new Line2D.Double());
	}

	public void initDraw(Point startP) {
		this.startP = startP;
	}

	public void setCoordinate(Point currentP) {
		((Line2D) myShape).setLine(startP, currentP);
		
		if (anchorList != null) {
			anchorList.setPosition(myShape.getBounds());
		}

	}
	
	public boolean contains (Point p) {
		Line2D line = (Line2D)myShape;
		Rectangle rect = new Rectangle();
		rect.setFrameFromDiagonal(line.getP1(), line.getP2());
		
		return rect.contains(p);
	}
	
	@Override
	public GEShape clone() {
		return new GELine();
	}
}
