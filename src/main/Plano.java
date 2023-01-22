package main;
import javax.swing.JFrame;

public class Plano extends JFrame{
	public Plano(Visual Visual){
		super.setDefaultCloseOperation(super.EXIT_ON_CLOSE); //terminar a ação do terminal quando carrega no x do plano
		super.add(Visual);
		super.setResizable(false); //não alterar tamanho do plano
		super.pack();
		super.setLocationRelativeTo(null); //centralizar
		super.setVisible(true);
	}
}
