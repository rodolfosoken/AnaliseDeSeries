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
package br.ufabc.numerico.serie.exponencial;

import java.util.Scanner;

/**
 * @author Rodolfo K. Soken
 *
 */
public class SerieExponencial {
//	public static void main(String[] args) {
//		metodoAnalitico();
//
//	}
	public static void metodoSintetico() {

		System.out.println("----------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira a variavel:");
		double entrada = sc.nextDouble();
		System.out.println("Insira o numero de termos:");
		int termos = sc.nextInt();
		double resultado = 0;
		
			System.out.println("Qtde de Termos:" + termos);
			// calcula a serie sem utilizar a função fatorial
			resultado = metodoSemFatorialExponencial(entrada, termos);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialExponencial(entrada, termos);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

		}

	//Incrementa os termos até ocorrer overflow na função fatorial
	public static void metodoAnalitico() {

		System.out.println("----------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira a variavel:");
		double entrada = sc.nextDouble();
		// System.out.println("Insira o numero de termos:");
		// int termos = sc.nextInt();
		double resultado = 0;
		int i = 0;
		
		while (resultado < Double.POSITIVE_INFINITY) {
			System.out.println("Qtde de Termos:" + i);
			// calcula a serie sem utilizar a função fatorial
			resultado = metodoSemFatorialExponencial(entrada, i);
			System.out.println("Metodo sem fatorial:" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialExponencial(entrada, i);
			System.out.println("Metodo com fatorial:" + resultado);
			System.out.println("---------------");

			i++;
		}
	}
	
	public static void metodoAnalitico(int termos) {

		System.out.println("----------------------");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira a variavel:");
		double entrada = sc.nextDouble();
		double resultado = 0;
		int i = 0;

		while (i <= termos) {
			System.out.println("Qtde de Termos:" + i);
			// calcula a serie sem utilizar a função fatorial
			resultado = metodoSemFatorialExponencial(entrada, i);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialExponencial(entrada, i);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

			i++;
		}
	}

	public static double metodoSemFatorialExponencial(double entrada, int termos) {
		// inicia a soma
		double soma = 1.0f;

		// Utilizando a série de Taylor fatorada
		for (int i = termos - 1; i > 0; --i) {
			soma = 1 + entrada * soma / i;
		}

		return soma;
	}

	public static double metodoComFatorialExponencial(double entrada, int termos) {
		double resultado = 0;
		//condição inicial
		if(termos == 0) return 1f;
		for (int i = 0; i < termos; i++) {
			double exp = entrada;
			// Inicializa soma
			double resultadoExp = 1;
			
			for (int j = 0; j < i; j++) {
				resultadoExp *= exp;
			}
			// se fatorial for < 0 há overflow,
			//retorna infinity para condição de parada
			if (fatorial((long)i) > 0) {
				resultado += resultadoExp / fatorial((long) i);
			} else {
				return Double.POSITIVE_INFINITY;
			}
		}

		return resultado;
	}

	public static Long fatorial(Long n) {
		if (n == 0) {
			return (long) 1;
		}
		return n * fatorial(n - 1);
	}

}
