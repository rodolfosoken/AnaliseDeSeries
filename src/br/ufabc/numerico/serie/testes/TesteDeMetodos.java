/*******************************************************************************
 * Copyright (c) 2015 Rodolfo Kohei Soken.
 * 
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     Rodolfo Kohei Soken - initial API and implementation
 ******************************************************************************/
package br.ufabc.numerico.serie.testes;

import java.util.Scanner;

import br.ufabc.numerico.serie.cosseno.SerieCosseno;
import br.ufabc.numerico.serie.exponencial.SerieExponencial;
import br.ufabc.numerico.serie.seno.SerieSeno;

public class TesteDeMetodos {

	public static void main(String[] args) {
		
		boolean loop = true;
		while(loop){
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("--------------Escolha Alguma das Opcoes:--------------");
		System.out.println("[0] Sair");
		System.out.println("[1] Funcao Exponencial - Metodo Sintetico");
		System.out.println("[2] Funcao Exponencial - Metodo Analitico");
		System.out.println("[3] Funcao Exponencial - Metodo Analitico Manual");
		System.out.println("[4] Funcao Seno - Metodo Sintetico");
		System.out.println("[5] Funcao Seno - Metodo Analitico");
		System.out.println("[6] Funcao Seno - Metodo Analitico Manual");
		System.out.println("[7] Funcao Cosseno - Metodo Sintetico");
		System.out.println("[8] Funcao Cosseno - Metodo Analitico");
		System.out.println("[9] Funcao Cosseno - Metodo Analitico Manual");
		int escolha = sc.nextInt();
		switch (escolha) {
		case 0:
			System.out.println("Aplicativo Encerrado.");
			loop = false;
			break;
			
		case 1:
			System.out.println("Metodo Sintetico: Exponencial");
			SerieExponencial.metodoSintetico();
			break;
		case 2:
			System.out.println("Metodo Analitico: Exponencial");
			SerieExponencial.metodoAnalitico();
			break;
		case 3:
			System.out.println("Metodo Analitico Manual: Exponencial");
			Scanner sc3 = new Scanner(System.in);
			System.out.print("Digite a quantidade de termos desejada:");
			SerieExponencial.metodoAnalitico(Integer.parseInt(sc3.nextLine()));
			break;
		case 4:
			System.out.println("Metodo Sintetico: Seno");
			SerieSeno.metodoSintetico();
			break;
		case 5:
			System.out.println("Metodo Analitico: Seno");
			SerieSeno.metodoAnalitico();
			break;
		case 6:
			System.out.println("Metodo Analitico Manual: Seno");
			Scanner sc6 = new Scanner(System.in);
			System.out.print("Digite a quantidade de termos desejada:");
			SerieSeno.metodoAnalitico(Integer.parseInt(sc6.nextLine()));
			break;
		case 7:
			System.out.println("Metodo Sintetico: Cosseno");
			SerieCosseno.metodoSintetico();
			break;
		case 8:
			System.out.println("Metodo Analitico: Cosseno");
			SerieCosseno.metodoAnalitico();
			break;
		case 9:
			System.out.println("Metodo Analitico Manual: Cosseno");
			Scanner sc9 = new Scanner(System.in);
			System.out.print("Digite a quantidade de termos desejada:");
			SerieCosseno.metodoAnalitico(Integer.parseInt(sc9.nextLine()));
			break;
		default:
			break;
		}
		
		}

	}
	
	

}
