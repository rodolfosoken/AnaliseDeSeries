package br.ufabc.numerico.serie.cosseno;

import java.util.Scanner;

public class SerieCosseno {

	public static void main(String[] args) {

		metodoAnalitico();

	}

	public static void metodoAnalitico() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Insira a entrada:");
		double entrada = sc.nextDouble();
		// System.out.println("Insira o numero de termos:");
		// int termos = sc.nextInt();
		double resultado = 0;
		int i = 0;
		// resultado < Double.POSITIVE_INFINITY

		while (resultado < Double.POSITIVE_INFINITY) {
			System.out.println("Qtde de Termos:" + i);
			// calcula a serie sem utilizar a função fatorial
			resultado = metodoSemFatorialCosseno(entrada, i);
			System.out.println("Metodo sem fatorial:\t" + resultado);

			// calcula a serie utilizando a função fatorial
			resultado = metodoComFatorialCosseno(entrada, i);
			System.out.println("Metodo com fatorial:\t" + resultado);
			System.out.println("---------------");

			i++;
		}
	}

	public static double metodoSemFatorialCosseno(double entrada, int termos) {
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
					* ((entrada * entrada) / (((i * 2) - 1) * (i * 2)));
	
		}
		if(termos==2)
			return-soma;
		return soma;
	}

	public static double metodoComFatorialCosseno(double entrada, int termos) {
		double resultado = 0;
		// condição inicial
		if (termos < 1)
			return 1f;
		for (int i = 0; i < termos; i++) {
			double exp = entrada;

			// Inicializa soma
			double resultadoExp = 1;
			for (int j = 0; j < (2 * i); j++) {
				resultadoExp *= exp;
			}

			int sinal = -1;
			if (i % 2 == 0)
				sinal = 1;
			// se fatorial for < 0 ha overflow,
			// retorna infinity para condição de parada
			if (fatorial((long) i) > 0) {
				resultado += (sinal)
						* (resultadoExp / fatorial((long) (2 * i)));
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
