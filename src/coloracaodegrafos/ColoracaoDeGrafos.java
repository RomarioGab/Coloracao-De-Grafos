/*
 * Nome: Antonio Fernandes
 * Nº estudante: 108085
 * 3º Ano-Engenharia Informatica e de Computadores
 */
package coloracaodegrafos;

import java.io.IOException;
import java.util.*;

public class ColoracaoDeGrafos {
    
        public static int m;   //numero de grafos
	public static int inicio, fim, no_branco;
	public static boolean[][] Matriz;
	public static int [] cor;
	public static int[] sel;
	public static int n, k;  //n->numero de nos  k->numeru das arestas

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args)throws NumberFormatException, IOException {
        // TODO code application logic here
        
       Scanner entrada = new Scanner(System.in);
		
		m = entrada.nextInt();
		while(m-- > 0){ // enquanto existir grafos
			n = entrada.nextInt();
			k = entrada.nextInt();
			Matriz  = new boolean[n + 1][n + 1];
			
			for(int i = 0; i < k; i++){  // ciclo para ler todas as arestas
				inicio  = entrada.nextInt();
				fim = entrada.nextInt();
				Matriz[inicio][fim] = Matriz[fim][inicio] = true;
			}
			cor = new int[n + 1];
			no_branco = n;
			
			colorir(1, 0);
			System.out.println(n - no_branco);
			int n_espaco = 0;
			
			for(int i = 1; i < sel.length; i++){
				if(sel[i] == 2){
					if(n_espaco != 0)
						System.out.print(" " + i);
					else
						System.out.print(i);
					n_espaco++;
				}		
			}
			System.out.println();			
		}		
	}
	
    // Funcao recursiva que determinar cor no
	public static void colorir(int pos, int branco){
		if(pos > n){
			if(branco < no_branco){
				no_branco = branco;
				sel = cor.clone();
			}
		}else{
			boolean preto = true;
			for(int i = 0; i < Matriz.length; i++){
				if(Matriz[pos][i])
                                    preto = preto && cor[i] != 2;
			}if(preto){
				cor[pos] = 2;
				colorir(pos + 1, branco);// chamada recursivamente
				cor[pos] = 0;
			}
			cor[pos] = 1;
			colorir(pos + 1, branco + 1); //
			cor[pos] = 0;
		} 
        
    }
    
}
