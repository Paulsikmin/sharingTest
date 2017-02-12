package transformer;

import java.awt.Graphics2D;
import java.awt.Point;

import shapes.GEShape;

public class GEMover extends GETransformer{

	public GEMover(GEShape shape) {
		super(shape);
	}

	@Override
	public void init(Point p) {
		this.previousP = p;
		
	}

	@Override
	public void transformer(Graphics2D g2D, Point p) {
		Point tp = new Point(p.x - previousP.x, p.y - previousP.y);
		g2D.setXORMode(g2D.getBackground());
		g2D.setStroke(dashedLine);
		
		shape.draw(g2D);
		shape.moveCoordinate(tp);
		shape.draw(g2D);
		
		previousP = p;
	}
	
	

}
