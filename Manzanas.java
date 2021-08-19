//Hecho solo por Raquel Pérez
import java.util.Scanner;

public class Manzanas {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String linea;
		char letra, jugador = 0;
		int total_manzanas, max_quito_manzanas, manzanas_quito = 0, manzanas_ahora;
		int manzanas_quita_maquina;
		System.out.println("Empiezo yo(S/N): ");//Quien comienza el juego
		linea = entrada.nextLine(); //Almacenamos el orimer caracter de la entrada 
		letra = linea.charAt(0);
		System.out.println("Total manzanas en la cesta: ");//Preguntamos cuanta manzanas va a haber en la cesta
		total_manzanas = entrada.nextInt();//Leemos el nº
		manzanas_ahora = total_manzanas; //El nº de manzanas con las que empezamos
		System.out.println("Maximo a quitar por turno: ");//Preguntamos cuanta manzanas va aquitar como máximo en cada turno
		max_quito_manzanas = entrada.nextInt();//Leemos el nº
		while (manzanas_ahora > 1) { //Siempre y cuando no quede solo una manzana (que es cuando se dará por finalizado el juego) se podrá jugar.
			if (letra == 'S') { //Empieza la maquina si escribes S
				manzanas_quita_maquina = ((manzanas_ahora - 1) / (max_quito_manzanas + 1)); //El máximo de manzanas que quitas sale en el enunciado del ej.
				if (manzanas_quita_maquina == 0) { //Cuando la division daba de cociente 0 no se podia seguir jugando
					manzanas_quita_maquina = 1; //Se obliga a que cuando salda la dicision 0,... se aproxima a 1 y el que coje la ultima manzana pierde
			}
				manzanas_ahora = manzanas_ahora - manzanas_quita_maquina; //Resto manzanas que van quedando
				System.out.println("Quito: " + manzanas_quita_maquina + " y quedan: " + manzanas_ahora);//Saco por pantalla el nº de manzanas que queda en cada turno
				jugador = 'm'; //LLamo a la maquina jugador m para saber quien gana o pierde 
			if(manzanas_ahora>1) {//Mientras sigamos teniendo mas de 1 manzana podemos seguir jugando, es decir, podemos seguir preguntando
			do{ //Repetir pregunta si las manzanas que quitas son mas que las max que quitas
				System.out.println("¿Cuantas quitas?"); 
				manzanas_quito = entrada.nextInt();
			} while (manzanas_quito>max_quito_manzanas);//Si el uuario pone un numero mayor que el maximo que quita
														//se repite la pregunta para que ponga un nº menor al max q quita en cada turno
				manzanas_ahora = manzanas_ahora - manzanas_quito;
				System.out.println("Quedan :" + (manzanas_ahora));
				jugador = 'y'; //relacionamos a la maquina como jugador y para saber una referncia al final de quien gana o pierde
		}
		}
			//Se repite los mismos procedimientos pero en diferente orden y los comentarios son los mismos
		else { //Empieza el jugador escribirndo N 
			do {
				System.out.println("¿Cuantas quitas?");
				manzanas_quito = entrada.nextInt();
			} while (manzanas_quito>max_quito_manzanas);
				manzanas_ahora = manzanas_ahora - manzanas_quito;
				System.out.println("Quedan :" + (manzanas_ahora));
				jugador = 'y'; //El usuario es jugador "y" y se va tomar de referncia a la persona cuando la maquina diga si ha ganado o perdido el usuario
				if(manzanas_ahora>1) {
					manzanas_quita_maquina = ((manzanas_ahora - 1) / (max_quito_manzanas + 1));
					if (manzanas_quita_maquina == 0) {
						manzanas_quita_maquina = 1;
		}
					manzanas_ahora = manzanas_ahora - manzanas_quita_maquina;
					System.out.println("Quito: " + manzanas_quita_maquina + " y quedan: " + manzanas_ahora);
					jugador = 'm';
				}
		}
		}
			if (jugador == 'm') {//Pierdem, y gana y
				System.out.println("Has perdido");
			} else //Si gana el jugador y, entonces el jugador m ha periddo
				System.out.println("Has ganado");
	}

}
