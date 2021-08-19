package TP6;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Fechas {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in); 
		System.out.println("¿Qué nombre tenia el fichero anterior?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea; //Leemos la entrada del ususario
		linea=entrada.nextLine(); //Leemos la linea
		String input=linea+".txt";
		Scanner entrada1= new Scanner (System.in);
		System.out.println("¿Qué nombre das al fichero de salida?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea1; //Leemos la entrada del ususario
		linea1=entrada1.nextLine(); //Leemos la linea
		String output=linea1+".txt";//Tenemos el fichero donde se almacenara la info relevante
		int num_fechas=0;
		num_fechas=removeDates(input,output); //Definimos num como el procesador de entrada y salida del fichero
		System.out.println("Las canciones eliminadas por fecha incompleta son: "+num_fechas);

	}

	/**
	* Elimina aquellas canciones con fecha incompleta
	*
	* @param input Nombre del fichero de entrada (con fechas en ambos formatos)
	* @param output Nombre del fichero de salida (sólo en formato aaaa-mm-dd)
	* @return int Número de canciones (líneas) eliminadas
	*/
	public static int removeDates (String input, String output) {
		int i=0; //Definimos variables
		try {
			Scanner entrada1=new Scanner(new FileReader(input)); //Fichero de entrada
			String linea1= entrada1.nextLine(); //Leemos toda la linea 1
			PrintWriter salidaFichero=new PrintWriter(new FileWriter(output));//Fichero de salida
			salidaFichero.println(linea1); //Imprimimos la linea dle fichero de entrada en el de salida
			while(entrada1.hasNext()) {
				String linea2= entrada1.nextLine();
				String [] datos = linea2.split(",");//Los datos vienen separados por comas
				String fecha=datos[3];
				if(fecha.length()>4) {
					salidaFichero.println(linea2);
					System.out.println(linea2);
				}
				else {
					i=i+1;
				}
			}
			entrada1.close();
			salidaFichero.close();
			}catch(java.io.IOException ex) {
				System.out.print(ex.getMessage()); 
				}
			return i;
		}
	
}
