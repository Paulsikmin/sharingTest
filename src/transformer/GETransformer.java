package transformer;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

import shapes.GEShape;

public abstract class GETransformer {
	
	protected GEShape shape;
	protected BasicStroke dashedLine;
	protected Point previousP;
	
	public GETransformer(GEShape shape) {
		this.shape = shape;
		float[] dashes = {4};
		dashedLine = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashes, 0);
	}
	
	public abstract void init(Point p);
	public abstract void transformer(Graphics2D g2D, Point p);
	

}
