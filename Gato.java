//Hecho solo por Raquel Pérez

import java.util.Scanner;
public class Gato {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//Almacenamos los numeros que el usuario introduce
		int numero=0, anterior=0, anterior_del_anterior=0;//definimos las variables
		System.out.println("Escribe una secuencia de enteros: ");//Sacamos por pantalla
		numero=entrada.nextInt();//Leemos el numero
		while(numero!=0) {/*Hasta que no llegamos a leer un cero que pone fin a la secuencia, 
		acumulamos en cada numero su letra correspondiente, la cual tiene una posicion respecto a un nº*/
		
		if(anterior + anterior_del_anterior!=numero){//Hasta que no recorre dos posiciones no guardamos una letra siempre y cuando sea diferente al nº
			//Hacemos una lectura para cada vez que repita el bucle
		anterior_del_anterior=anterior;
		anterior=numero;
		numero=entrada.nextInt();
		}
		else{ //Si los dos nº anteriores son igual que el numero que guardamos entonces le damos un valor al caracter para que descuente posiciones
		char value_char  = (char) (numero+64);//El valor del calacter tiene que ocupar la posicion numerica que le corresponda
		System.out.print(value_char);//Sacamos por pantalla el caracter almacenado en la posicion del nº
		anterior_del_anterior=0;//Repetimos la lectura de cada numero que guarda un caracter en su posicion
		anterior=0;
		numero=entrada.nextInt();
		}
		}

	}

}
