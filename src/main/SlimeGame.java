package main;

public class SlimeGame implements Runnable{
	
	private Plano Plano;
	private Visual Visual;
	private Thread Thread;
	private final int FPS_SET = 144;
	 
	public SlimeGame() {
		Visual = new Visual();
		Plano = new Plano(Visual);
		Visual.requestFocus();
		Loop();
	}
	
	private void Loop(){
		Thread = new Thread(this);
		Thread.start();
	}
	
	public void run(){
		
		double TempoF = 1000000000.0/FPS_SET;
		long ÚltimoF = System.nanoTime();
		long Now = System.nanoTime();
		int Frames = 0;
		long ÚltimaVerificação = System.currentTimeMillis();
		
		while(true){
			Now = System.nanoTime();
			if(Now - ÚltimoF >= TempoF){
				Visual.repaint();
				ÚltimoF = Now;
				Frames++;
			}
			if(System.currentTimeMillis() - ÚltimaVerificação >= 1000){
				ÚltimaVerificação = System.currentTimeMillis();
				System.out.println("FPS -> " +Frames);
				Frames = 0;
			}
		}
	}
}
