package com.jasondavidpeters.dreadside.game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class GameWindow extends Canvas {
    
    private final int WIDTH = 240;
    private final int HEIGHT = 140;
    private final int SCALE = 3;
    
    public GameWindow() {
	JFrame frame = new JFrame();
	
	frame.add(this);
	frame.setSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
	frame.setVisible(true);
    }
    
    public void render() {
	
    }
    
    public int getWidth() {
	return WIDTH;
    }
    public int getHeight() {
	return HEIGHT;
    }
    public int getScale() {
	return SCALE;
    }

}
