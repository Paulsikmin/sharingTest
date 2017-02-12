package transformer;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

import shapes.GEPolygon;
import shapes.GEShape;

public class GEDrawer extends GETransformer {

	public GEDrawer(GEShape shape) {
		super(shape);
	}

	
	
	public void init(Point startP) {
		shape.initDraw(startP);
	}
	
	

	@Override
	public void transformer(Graphics2D g2D, Point p) {		// same as animateDraw() in preVersion
		g2D.setXORMode(g2D.getBackground());

		g2D.setStroke(dashedLine);

		shape.draw(g2D);
		shape.setCoordinate(p);
		shape.draw(g2D);

	}

	public void finalize(List<GEShape> shapeList) {
		shapeList.add(shape);
	}

	public void continueDrawing(Point continueP) {
		((GEPolygon) shape).continueDrawing(continueP);
	}
}
