package frames;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

import constants.GEConstants.State;
import shapes.GEPolygon;
import shapes.GEShape;
import transformer.GEDrawer;
import transformer.GEMover;
import transformer.GETransformer;

public class GEDrawingPanel extends JPanel {

	private GEShape currentShape;
	private List<GEShape> shapeList; // using top-level interface, expecting
										// update
	private State currentState;
	private GEShape selectedShape;
	
	private GETransformer transformer;
	
	private Color lineColor, fillColor;

	
	
	public GEDrawingPanel() {
		this.setBackground(Color.WHITE);

		MouseEventHandler event = new MouseEventHandler(); // --> inner class in
															// DrawingPanel
															// class

		this.addMouseListener(event); // method in abstract class 'Component'
		this.addMouseMotionListener(event);
		
		shapeList = new ArrayList<>(); // ArrayList for saving drawings

		currentState = State.Idle;
		
		lineColor = Color.black;
		fillColor = Color.white;
	}

	
	private boolean selectedSetColor (boolean flag, Color color) {
		if (selectedShape != null) {
			if (flag) {
				selectedShape.setLineColor(color);
				// change lineColor of shape
			} else {
				selectedShape.setFillColor(color);
				// change fillColor of shape
			}
			
			repaint();
			return true;
		}
		
		return false;
	}
	
	
	public void setLineColor(Color lineColor) {
		if (selectedSetColor(true, lineColor)) {
			return; 
		}
		
		this.lineColor = lineColor;
	}
	
	
	public void setFillColor (Color fillColor) {
		if (selectedSetColor(false, fillColor)) {
			return;
		}
		
		this.fillColor = fillColor;
	}
	
	
	
	public void setCurrentShape(GEShape currentShape) { // receive from shape
														// objects and make
														// 'currentShape'
		this.currentShape = currentShape;
	}

	private void createShape() { 
		currentShape = currentShape.clone();
		currentShape.setLineColor(lineColor);
		currentShape.setFillColor(fillColor);
	}

	private void continueDrawing(Point continueP) {
		((GEDrawer)transformer).continueDrawing(continueP);
	}
	
	
	private GEShape onShape(Point p) {
		for (int i = shapeList.size(); i > 0; i--) {
			GEShape shape = shapeList.get(i - 1);
			
			if (shape.onShape(p)) {
				return shape;
			}
		}
		
		return null;
	}
	
	private void clearShapes() {
		for (GEShape shape : shapeList) {
			shape.setSelected(false);
			
		}
	}
	

	@Override
	protected void paintComponent(Graphics g) { // Calls the paint method in
												// abstract class 'JComponent'
		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g;
		for (GEShape shape : shapeList) {
			shape.draw(g2D);
		}
	}

	private class MouseEventHandler extends MouseInputAdapter { 
		// MouseInputListener  = MouseListener, MouseMotionListener »ó¼ÓÇÑ interface

		@Override
		public void mousePressed(MouseEvent e) {
			if (currentState == State.Idle) {

				if (currentShape != null) {
					
					clearShapes();
					selectedShape = null;
					createShape();
					
					transformer = new GEDrawer(currentShape);
					((GEDrawer)transformer).init(e.getPoint());

					
					if (currentShape instanceof GEPolygon) {
						currentState = State.NPointDrawing;
					} else {
						currentState = State.TwoPointDrawing;
					}
					
				} else {
					selectedShape = onShape(e.getPoint());
					
					if (selectedShape != null) {
						clearShapes();
						selectedShape.setSelected(true);
						
						transformer = new GEMover(selectedShape);
						currentState = State.Moving;
						((GEMover)transformer).init(e.getPoint());
						
					}
				}

			}

		}
		
		
		
		
		
		@Override
		public void mouseMoved(MouseEvent e) {
			
			if (currentState == State.NPointDrawing) {
				transformer.transformer((Graphics2D)getGraphics(), e.getPoint());
			}
			
		}


		@Override
		public void mouseDragged(MouseEvent e) {
			if (currentState != State.Idle) {
				transformer.transformer((Graphics2D)getGraphics(), e.getPoint());
			}
			
		}
		
		
		@Override
		public void mouseReleased(MouseEvent e) {
			if (currentState == State.TwoPointDrawing) {
				((GEDrawer)transformer).finalize(shapeList);
				currentState = State.Idle;
				repaint();
			} else if (currentState != State.NPointDrawing) {
				currentState = State.Idle;
				repaint();
			}
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if (e.getButton() == MouseEvent.BUTTON1) { 		// BUTTON1: left, BUTTON2: right, BUTTON3: wheel
				if (currentState == State.NPointDrawing) {
					if (e.getClickCount() == 1) {
						continueDrawing(e.getPoint());
					} else if (e.getClickCount() == 2) {{
						((GEDrawer)transformer).finalize(shapeList);
						currentState = State.Idle;
						repaint();
					}
				}
			}
			
		}
		
	}
	

}

}