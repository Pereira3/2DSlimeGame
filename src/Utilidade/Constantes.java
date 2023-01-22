package Utilidade;

public class Constantes {
	
	public static class Direções{
		public static final int Cima = 0;
		public static final int Baixo = 1;
		public static final int Esquerda = 2;
		public static final int Direita = 3;
	}
	
	public static class CJogador{
		public static final int Parado = 0;
		public static final int Correr = 1;
		public static final int Saltar = 2;
		public static final int Cair = 3;
		public static final int Ground = 4;
		public static final int Hit = 5;
		public static final int Atacar = 6;
		
		public static int TamanhoSprites(int ação){
			switch(ação){
			case Parado:
				return 5;
			case Correr:
				return 6;
				default: //Caso seja pressionada outra tecla, não buga
					return 1;
			}
		}
	}
}
