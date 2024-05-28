/*
 * Código em Java criado a fim de resolver o problema de número 1208, LeetCode.
 * 
 * @AUTHOR Ian Mendes
 * 
 * @Version 1.0
 * @Date 28-05-2024
 */

package ian.java.trilha;
import java.util.Scanner;


public class Solution {
/*A classe Solution, além dos getters e setters, possui apenas um único método: equalSubstring*/
	protected int resp;
	
	
	public int equalSubstring(String s, String t, int maxCost) {
		/*Método: equalSubstring.
		 * Descobrir o tamanho da maior substring que possa ser formada a partir da transformação dos caracteres de str1 em str2, dado um custo limite (maxCost).
		 * O custo é medido pela conversão da tabela ASCII, ou seja, custo = |str1[i]-str2[i]|. Para tal, foi utilizada a técnica Dynamic Sliding Window.
		 * @param String s, String t e int maxCost*
		*@return int - tamanho da maior substring possível menor ou igual ao custo máximo fornecido.*/

		/*Conversão de strings em Arrays para fins de comparação entre elementos individuais.*/
	        char _s[] = s.toCharArray();
	        char _t[] = t.toCharArray();
	        /*declaração de variáveis*/
	        int esquerda = 0;
	        int direita = 0;
	        int custoAtual = 0;
	        int maiorStr = 0;
	        int temp = 0;

	        /*A técnica de Sliding Window permite que uma estrutura sequencial tenha elementos analizados em grupos, chamados de "janelas" de tamanho fixo.
	         * Já a Dynamic Sliding Window flexibiliza a largura dessa janela, permitindo que comparemos quantos elementos sejam necessários até atingir um requerimento mínimo.
	         * Neste loop while, o requerimento mínimo é que o custo não ultrapasse maxCost.
	         * Com a utilização de janelas para, digamos, "escanear" estruturas sequenciais, precisamos ter um ponto de partida - esquerda - e ponto de finalização da janela - direita.
	         * Da esquerda para a direita, o loop while soma os custos entre elementos vizinhos.
	         * Há algumas opções para o algoritmo:
	         * 1) A maior substring encontra-se no início do vetor. Neste caso, o loop é interrompido quando maxCost é alcançado, ou seja, a direita alcança o índice final da substring.
	         * 2) A maior substring encontra-se em algum lugar no meio do vetor. Neste caso, maxCost será alcançado, ao menos, uma vez. 
	         * É neste cenário que entra a parte Dinâmica da Sliding Window: o custo é zerado e o start (esquerda) se move uma posição à direita. A direita é igualada à esquerda e o loop volta a se repetir, com o deslizamento do ponto final à direita.
	         * */
	        while (custoAtual <= maxCost && direita != t.length())
	        {
	            custoAtual += Math.abs(_s[direita] - _t[direita]);
	            direita++;
	            temp++;

	            if (custoAtual > maxCost)
	            {
	            	/*ao deslizar a janela, zerar valores prévios.*/
	                custoAtual = 0;
	                temp = 0; 
	                esquerda++;
	                direita = esquerda;
	            }
	            /*IMPORTANTE = Armazenar tamanho da maior substring.*/
	            if (temp > maiorStr) {maiorStr = temp;}
	        }
	        return maiorStr;
	    }
	
	/*Métodos getters e setters para resp.*/
	public void setSolucao(int a)
	{
		this.resp = a;
	}
	
	public int getSolucao()
	{
		return this.resp;
	}
	
	

/*Método main.
 * Iterativo com o usuário.*/
	public static void main(String[] args){
		
		String s = "",t = "";
		int maxCost = 0;
		
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\n");
		
		System.out.println("**************************************************************************");
		System.out.println("********* AVISO: OS TEXTOS DEVEM TER MESMA QUANTIA DE CARACTERES *********");
		System.out.println("Insira o primeiro grupo de letras: ");
		

		s = scanner.next();
		System.out.println("Insira o segundo grupo de letras: ");
		t = scanner.next();
		System.out.println("Qual deve ser o custo máximo para conversão? ");
		maxCost = scanner.nextInt();
		

		Solution solucao = new Solution();
			
		solucao.setSolucao(solucao.equalSubstring(s, t, maxCost));
		System.out.println("A maior substring que podemos converter possui " + solucao.getSolucao());


	}

}

