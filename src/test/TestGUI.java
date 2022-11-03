package test;

import gui.*;

import java.awt.Color;

public class TestGUI {
	public static void main(String[] args) {
		GUISimulator ig = new GUISimulator(200, 200, Color.BLACK);

		ig.addGraphicalElement(new Rectangle(90, 40, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 40, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 40, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(80, 50, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 50, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 50, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 50, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 50, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(70, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(80, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 60, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 60, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(60, 70, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(70, 70, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 70, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 70, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(140, 70, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(60, 80, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(70, 80, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 80, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 80, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(140, 80, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(60, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(70, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(80, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 90, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(140, 90, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(80, 100, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 100, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 100, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 100, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 100, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(70, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(80, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 110, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 110, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(70, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(80, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(90, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(100, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(110, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 120, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(130, 120, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Rectangle(60, 130, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(80, 130, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(120, 130, Color.WHITE, Color.WHITE, 10));
		ig.addGraphicalElement(new Rectangle(140, 130, Color.WHITE, Color.WHITE, 10));

		ig.addGraphicalElement(new Text(100, 160, Color.WHITE, "INVADER"));
	}
}
