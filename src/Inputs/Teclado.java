package Inputs;
import static Utilidade.Constantes.Direções.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import main.Visual;


public class Teclado implements KeyListener{

	private Visual Visual;
	public Teclado(Visual Visual){
		this.Visual = Visual;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
			Visual.Mover(Cima);
			break;
		case KeyEvent.VK_A:
			Visual.Mover(Esquerda);
			break;
		case KeyEvent.VK_S:
			Visual.Mover(Baixo);
			break;
		case KeyEvent.VK_D:
			Visual.Mover(Direita);
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_A:
		case KeyEvent.VK_S:
		case KeyEvent.VK_D:
			Visual.AlterarMover(false);
		}
	}

}
