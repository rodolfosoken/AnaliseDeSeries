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
package br.ufabc.numerico.serie.seno;

import java.util.Scanner;

/**
 * @author Rodolfo K. Soken
 *
 */
public class SerieSeno {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//
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
			resultado = metodoSemFatorialSeno(entrada, termos);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialSeno(entrada, termos);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

		}

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
		// resultado < Double.POSITIVE_INFINITY

		while (resultado < Double.POSITIVE_INFINITY) {
			System.out.println("Qtde de Termos:" + i);
			// calcula a serie sem utilizar a função fatorial
			resultado = metodoSemFatorialSeno(entrada, i);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialSeno(entrada, i);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

			i++;
		}
	}
	
	//Incrementa os termos até ocorrer overflow na função fatorial
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
			resultado = metodoSemFatorialSeno(entrada, i);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialSeno(entrada, i);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

			i++;
		}
	}

	public static double metodoSemFatorialSeno(double entrada, int termos) {
		// inicia a soma
		double soma = 1.0f;
		if(termos < 1)
			return 1f;

		// Utilizando a série de Taylor fatorada
		for (int i = termos - 1; i > 0; --i) {
	
			int sinal = 1;
			if (i % 2 == 0 || termos==2)
				sinal = -1;
			soma = sinal * 1 + soma
					* ((entrada * entrada) / (((i * 2) + 1) * (i * 2)));
	
		}
		if(termos==2)
			return-entrada*soma;
		return entrada*soma;
	}

	public static double metodoComFatorialSeno(double entrada, int termos) {
		double resultado = 0;
		// condição inicial
		if (termos < 1)
			return 1f;
		for (int i = 0; i < termos; i++) {
			double exp = entrada;

			// Inicializa soma
			double resultadoExp = 1;
			for (int j = 0; j < (2 * i + 1); j++) {
				resultadoExp *= exp;
			}

			int sinal = -1;
			if (i % 2 == 0)
				sinal = 1;
			// se fatorial for < 0 ha overflow,
			// retorna infinity para condição de parada
			if (fatorial((long) i) > 0) {
				resultado += (sinal)
						* (resultadoExp / fatorial((long) (2 * i + 1)));
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
