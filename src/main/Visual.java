package main;
import static Utilidade.Constantes.CJogador.*;
import static Utilidade.Constantes.Direções.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Inputs.Teclado;
import Inputs.Rato;

public class Visual extends JPanel{
	
	private Rato Rato;
	private float X = 100, Y = 600;
	
	private BufferedImage Img;
	private BufferedImage[][] Animações;
	private int FrameA, IndexA, VelocidadeA = 45;
	
	private boolean Mover = false;
	private int AçãoP = Parado;
	private int DireçãoEscolhida = -1;

	public Visual(){
		
		CarregarImagem();
		CarregarAnimação();
		
		Rato = new Rato(this);
		TamanhoPanel();
		addKeyListener(new Teclado(this));
		addMouseListener(Rato);
		addMouseMotionListener(Rato);
	}
	
	private void TamanhoPanel(){
		Dimension size = new Dimension(1280, 800); //Tamanho do Plano
		setPreferredSize(size);
	}
	
	//IMAGEM------------------------------------------------------
	
	public void CarregarImagem(){
		InputStream is = getClass().getResourceAsStream("/Player_Sprites.png");
		
		try {
			Img = ImageIO.read(is);
		}catch(IOException e) {
			e.printStackTrace();
		}finally{
			try{ //disponibilizar espaço e evitar bugs
				is.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	//JPanel apenas indica onde desenhar/pintar, Graphics atua sobre essa informação
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		AlterarFrameA(); //SEQUÊNCIA DAS SPITES
		AlterarAnimação(); //IDENTIFICA SE ESTÁ IDLING OU EM MOVIMENTO
		AtualizarPosição(); //MOVER O SLIME
		g.drawImage(Animações[AçãoP][IndexA], (int)X, (int)Y, 192, 120, null);
	}
	
	
	//AÇÕES-------------------------------------------------------
	
	public void AtualizarPosição(){ //MOVER O SLIME
		if(Mover == true){
			switch(DireçãoEscolhida){
			case Cima:
				Y-=5;
				break;
			case Baixo:
				Y+=5;
				break;
			case Esquerda:
				X-=5;
				break;
			case Direita:
				X+=5;
				break;
			}
		}
	}
	
	public void AlterarAnimação(){ //IDENTIFICA SE ESTÁ IDLING OU EM MOVIMENTO
		if(Mover == true){
			AçãoP = Correr;
		}else{
			AçãoP = Parado;
		}
	}
	
	public void AlterarMover(boolean mover){ //QUANDO NENHUMA TECLA ESTÁ A SER CARREGADA O MOVER TORNA SE FALSE (método chamado na class Teclado)
		this.Mover = mover;
	}
	
	//Função de Correr e identificação de Idling
	public void Mover(int Direção){
		this.DireçãoEscolhida = Direção;
		Mover = true;
	}
	

	private void CarregarAnimação(){
		Animações = new BufferedImage[9][6]; //Primeira parte do array, nº de ações, Segunda parte do array, nº max de frames
		
		for(int i = 0; i<Animações.length; i++){
			for(int j = 0; j<Animações[i].length;j++){
				Animações[i][j] = Img.getSubimage(j*64, i*40, 64, 40);
			}
		}
	}
	
	private void AlterarFrameA(){
		FrameA++;
		if(FrameA >= VelocidadeA){ //Altera o index do array Parado conforme a Velocidade imposta nos Frames
			FrameA = 0;
			IndexA++;
			if(IndexA >= TamanhoSprites(AçãoP)){ //Reseta o Ciclo
				IndexA = 0;
			}
		}
	}
}
