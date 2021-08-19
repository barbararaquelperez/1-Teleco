//Hecho por Raul Plou y Raquel Perez

import java.util.Scanner;
public class Cuadro{

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int dimension;
		int columna;
		int fila;
		do {
			System.out.println("Dame la dimension: ");
			dimension = teclado.nextInt();
		} while (dimension >= 100 || dimension<1); /*Hacer el programa para introducir una vez la dimensión 
		siempre que no esté tu dimension entre 1 y100 , que en este caso se repetria*/
		
		/*
		 * Al realizar el cuadro de divisores, la variable n representa los numeros
		 * del 1 a 20 y que sera el numero por el que se divide n, si el resto de ese cociente resulta
		 * ser 0, se escribira un asterisco; sino, un espacio.
		 */
		for (int n = 1; n <= dimension; n++) {
			for (int k = 1; k <= dimension; k++) {
				char q;
				if (n % k == 0 || k%n==0) {
				 q= '*';
				} else {
					q = ' ';
				}
				System.out.print(q);
			}
			//Sacamos por pantalla la tabla de divisores
			System.out.println (" " +n);
			}
		

		}
	}


