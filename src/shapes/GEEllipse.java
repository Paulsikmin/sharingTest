package shapes;

import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class GEEllipse extends GEShape {
		
	public GEEllipse() {
		super(new Ellipse2D.Double());
		
	}
	
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
	public void setCoordinate(Point currentP) {
		((Ellipse2D)myShape).setFrameFromDiagonal(startP, currentP);
		
		if (anchorList != null) {
			anchorList.setPosition(myShape.getBounds());
		}

	}
	
	@Override
	public GEShape clone() {
		return new GEEllipse();
	}

}
