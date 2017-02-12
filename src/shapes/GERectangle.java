package shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class GERectangle extends GEShape {
	
	
	public GERectangle(){
		super(new Rectangle());
//		Shape myShape = new Rectangle();

	}
	
//	Mouse press => save startP 
	public void initDraw(Point startP) {
		this.startP = startP;
	}
	
//	Mouse drag => set rectangle size and point
	public void setCoordinate(Point currentP) {
		((Rectangle)myShape).setFrameFromDiagonal(startP, currentP);
		
		if (anchorList != null) {
			anchorList.setPosition(myShape.getBounds());
		}
	
	}
	
	@Override
	public GEShape clone() {
		return new GERectangle();
	}
}



