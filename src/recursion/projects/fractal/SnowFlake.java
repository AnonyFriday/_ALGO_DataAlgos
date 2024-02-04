/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package recursion.projects.fractal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author duyvu
 */
public class SnowFlake extends JFrame {

    public SnowFlake() {
	super("Fractal Tree");
	setBounds(100, 100, 1000, 1000);
	setResizable(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void drawSnowFlake(Graphics g, int x1, int y1, double angle, int height) {
	if (height == 0) {
	    return;
	}

	int x2 = x1 + (int) (30 * Math.cos(Math.toRadians(angle)));
	int y2 = y1 + (int) (30 * Math.sin(Math.toRadians(angle)));
	g.drawLine(x1, y1, x2, y2);

	if (height > 0) {
	    drawSnowFlake(g, x2, y2, angle + 10, height - 1);
	    drawSnowFlake(g, x2, y2, angle - 70, height - 1);
	}
    }

    @Override
    public void paint(Graphics g) {
	g.setColor(Color.BLACK);
	for (int i = 0; i < 10; i++) {
	    drawSnowFlake(g, 300, 400, 0 + i * 36, 7);
	}
    }

    public static void main(String[] args) {
	new SnowFlake().setVisible(true);
    }
}
