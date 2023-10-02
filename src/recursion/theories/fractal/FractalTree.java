/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.theories.fractal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author duyvu
 */
public class FractalTree extends JFrame {

    public FractalTree() {
	super("Fractal Tree");
	setBounds(100, 100, 1000, 1000);
	setResizable(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void drawTreeRecursively(Graphics g, int x1, int y1, double angle, int depth) {
	if (depth == 0) {
	    return;
	}
	int x2 = x1 + (int) (Math.cos(Math.toRadians(angle)) * depth * 10.0);
	int y2 = y1 + (int) (Math.sin(Math.toRadians(angle)) * depth * 10.0);

	g.drawLine(x1, y1, x2, y2);
	drawTreeRecursively(g, x2, y2, angle - 20, depth - 1);
	drawTreeRecursively(g, x2, y2, angle + 20, depth - 1);
    }

    @Override
    public void paint(Graphics g) {
	g.setColor(Color.BLACK);

	drawTreeRecursively(g, 440, 600, -90, 10);
    }

    public static void main(String[] args) {
	FractalTree tree = new FractalTree();
	tree.setVisible(true);
    }
}
