package com.jasondavidpeters.dreadside.game;

public class Game implements Runnable {
    
    private Thread thread;
    private boolean running;
    
    private GameWindow gw;
    
    
    public Game() {
	gw = new GameWindow();
    }
    public static void main(String[] args) {
	Game game = new Game();
	game.start();
    }
    
    public void run() {
	long before = System.nanoTime();
	double ns = 1000000000.0 / 60.0;
	double delta = 0;
	int ticks= 0;
	int frames=0;
	long timer = System.currentTimeMillis();
	while (running) {
	    long now = System.nanoTime();
	    delta += (now-before) / ns;
	    before=now;
	    if (delta>=1) {
		tick();
		ticks++;
		delta--;
		
	    }
	   while ((System.currentTimeMillis() - timer) >=1000) {
		System.out.println("Ticks: " + ticks + " frames: " + frames);
		timer=System.currentTimeMillis();
		ticks=0;
		frames=0;
	    }
	   render();
	   frames++;
	}
    }
    
    public void tick() {
	
    }
    public void render() {
	gw.render();
    }
    
    public synchronized void start() {
	running = true;
	thread = new Thread(this, "Main");
	thread.start();
    }
    
    public synchronized void stop() {
	running=false;
	try {
	    thread.join();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

}
