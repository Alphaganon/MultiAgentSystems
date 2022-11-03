package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import gui.GraphicalElement;

/**
 * Classe représentant un triangle.
 * 
 * @author Equipe 83
 *
 */
public class Triangle implements GraphicalElement {

	private Color drawColor, fillColor;
	private int x, y;
	private Point2D[] trianglePoly;

	public Triangle(int x, int y, Color drawColor, Color fillColor, int width, int height) {
		this.drawColor = drawColor;
		this.fillColor = fillColor;
		this.x = x;
		this.y = y;
		this.trianglePoly = new Point[3];
		// Définitions des sommets du triangle à partir du point central du triangle
		// situé en (x,y).
		trianglePoly[0] = new Point(x - width / 2, y - height / 2);
		trianglePoly[1] = new Point(x - width / 2, y + height / 2);
		trianglePoly[2] = new Point(x + width / 2, y);
	}

	public Triangle(int x, int y, Color drawColor, Color fillColor, int size) {
		this(x, y, drawColor, fillColor, size, size);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Fait effectuer au triangle une rotation d'angle {@code angle}.
	 * 
	 * @param angle
	 */
	public void rotate(double angle) {
		Point2D[] newPoly = { null, null, null };
		AffineTransform.getRotateInstance(angle, x, y).transform(trianglePoly, 0, newPoly, 0, 3);
		trianglePoly = newPoly;
	}

	@Override
	public void paint(Graphics2D g) {
		int[] xVals = { (int) trianglePoly[0].getX(), (int) trianglePoly[1].getX(), (int) trianglePoly[2].getX() };
		int[] yVals = { (int) trianglePoly[0].getY(), (int) trianglePoly[1].getY(), (int) trianglePoly[2].getY() };
		Color old_color = g.getColor();
		g.setColor(fillColor);
		g.fillPolygon(xVals, yVals, 3);
		g.setColor(drawColor);
		g.drawPolygon(xVals, yVals, 3);
		g.setColor(old_color);
	}

}
