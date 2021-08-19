package TP6;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class CancionesAño {
	static int  año_usuario;
	public static void main(String[] args) {
		int canciones_año;
		String linea3;
		char c;
		Scanner entrada=new Scanner(System.in); 
		System.out.println("¿Qué nombre tenia el fichero anterior?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea; //Leemos la entrada del ususario
		linea=entrada.nextLine(); //Leemos la linea
		String input=linea+".txt";
		do {
			Scanner entrada2=new Scanner(System.in); 
			System.out.println("¿Qué año quieres buscar?");//Preguntamos al usuario cual va a ser el nombre del fichero
			String linea2; //Leemos la entrada del ususario
			linea2=entrada2.nextLine(); //Leemos la linea
			año_usuario=Integer.parseInt(linea2);
			canciones_año=songsOfaYear(input,año_usuario);
			System.out.println("Tienes : "+canciones_año+" canciones del mismo año");
			Scanner entrada3=new Scanner(System.in); 
			System.out.println("¿Quieres seguir buscando(Y/N)?");
			linea3=entrada3.nextLine();
			c = linea3.charAt(0);
		}while(c!='N');
		
	}
	/**
	* Determina el número de canciones publicadas en un año
	*
	* @param input Nombre del fichero de entrada
	 * @param year Año de publicación
	 * @return int Número de canciones encontradas
	 */
	public static int songsOfaYear (String input, int year){
		int i=0,ano=0; //Definimos variables
		try {
			Scanner entrada1=new Scanner(new FileReader(input)); //Fichero de entrada
			String linea1= entrada1.nextLine(); //Leemos toda la linea 1
			while(entrada1.hasNext()) {
				String linea2= entrada1.nextLine();
				String [] datos = linea2.split(",");//Los datos vienen separados por comas
				String fecha=datos[3];
				String[] diaMesAno= fecha.split("-");
				String ano1=diaMesAno[0];
				ano= Integer.parseInt(ano1);
				if(año_usuario==ano) {
					i=i+1;
				}
			}
			entrada1.close();
			}catch(java.io.IOException ex) {
				System.out.print(ex.getMessage()); 
				}
			return i;
		}
	}


