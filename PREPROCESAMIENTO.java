
package TP6;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class PREPROCESAMIENTO {
	public static void main(String[]args) {

		Scanner entrada=new Scanner(System.in); 
		System.out.println("¿Qué nombre das al fichero?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea; //Leemos la entrada del ususario
		linea=entrada.nextLine(); //Leemos la linea
		String output=linea+".txt";//Tenemos el fichero donde se almacenara la info relevante
		String input="Spotify-songs.txt";//Introducimos el fichero de lectura
		int num=0;
		num=filePreprocessing(input,output); //Definimos num como el procesador de entrada y salida del fichero
		System.out.println("Numeros de espacios en blanco "+num); //Sacamos por pantalla en el copilador
	}
	/**
	* Sustituye los caracteres extraños de un fichero de canciones
	*
	* @param input Nombre del fichero de datos crudos
	* @param output Nombre del fichero de salida filtrado
	* @return int Número de caracteres extraños que han sido sustituidos
	*/
		public static int filePreprocessing (String input, String output) {
		int j=0; //Inicializamos el contador 
			try {
			int i=0; //Definimos variables
			Scanner entrada1=new Scanner(new FileReader(input)); //Fichero de entrada
			String linea1= entrada1.nextLine(); //Leemos toda la linea 1
			PrintWriter salidaFichero=new PrintWriter(new FileWriter(output));//Fichero de salida
			salidaFichero.println(linea1); //Imprimimos la linea dle fichero de entrada en el de salida
			while(entrada1.hasNext()) { //Mientras lee cada linea
				String linea2= entrada1.nextLine();//Leo la linea del fichero de entrada
				String linea3=" ";//Creo un string vacio
			for(i=0;i<linea2.length();i++) { //Contamos los caracteres extraños que sustituimos por espacios en blanco 
				char c=linea2.charAt(i);
				if((c>='a' && c<='z')||(c>='A' && c<='Z')||(c>='0' && c<='9')||(c=='-')||(c==' ')||(c==',')){ 
					linea3=linea3+c;//Los caracteres correctos se rellenan en el string vacio 
				}else {
					linea3=linea3+" "; //Introduzco un espacio 
					j=j+1;//Cuento el espacio
				}
				}
			salidaFichero.println(linea3);//Escribe en un fichero nuevo con los caracteres correctos
			}
			entrada1.close();
			salidaFichero.close();
	}catch(java.io.IOException ex) {
		 System.out.print(ex.getMessage()); 
		}
			return j;//Devuelve el numero de espacios introducidos	
		}
}


