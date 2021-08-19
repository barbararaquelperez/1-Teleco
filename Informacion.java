package TP6;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class Informacion {
	public static void main(String[]args) {

		Scanner entrada=new Scanner(System.in); 
		System.out.println("¿Qué nombre tenia el fichero anterior?");
		String linea;
		linea=entrada.nextLine();
		String input=linea+".txt";
		Scanner entrada2=new Scanner(System.in); 
		System.out.println("¿Qué nombre das al fichero?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea2; //Leemos la entrada del ususario
		linea2=entrada2.nextLine(); //Leemos la linea
		String output=linea2+".txt";//Tenemos el fichero donde se almacenara la info relevante
		int num=0;
		num=removeLines(input,output); //Definimos num como el procesador de entrada y salida del fichero
		System.out.println("EL numero de canciones incompletas "+num); //Sacamos por pantalla en el copilador
		entrada.close();
	}
	/**
	* Elimina aquellas canciones con información incompleta
	*
	* @param input Nombre del fichero de entrada (sin caracteres extraños)
	* @param output Nombre del fichero de salida (sin canciones incompletas)
	* @return int Número de canciones (líneas) eliminadas
	*/
	public static int removeLines (String input, String output) {
		int j=0, n_comas, k; //Inicializamos el contador 
		try {
			Scanner entrada1=new Scanner(new FileReader(input)); //Fichero de entrada
			String linea1= entrada1.nextLine(); //Leemos toda la linea 1
			PrintWriter salidaFichero=new PrintWriter(new FileWriter(output));//Fichero de salida
			salidaFichero.println(linea1); //Imprimimos la linea dle fichero de entrada en el de salida
			while(entrada1.hasNext()) { //Mientras lee cada linea
				String linea2= entrada1.nextLine();//Leo la linea del fichero de entrada
				n_comas=0;
				for(k=0; k<linea2.length();k++){ // algoritmo para verificar que tenemos 5 campos en este string contando las comas
					char c = linea2.charAt(k);//Leo todos los caracteres de la linea para reconocerlos
					if(c==','){ //El caracter a buscar en la linea, es la coma 
						n_comas=n_comas+1;//Cuento las comas para que apartir de la 4 selecciones la cancion como completa, sino sera incompleta
					}
				}
				if (n_comas==4){ // Si tenemos 4 comas significa que tenemos 5 campos correctamente estructurados
					String [] datos = linea2.split(",");//Pasamos de un string a un array de campos separados por una coma
					String ID=datos[0]; //Asigno el valor del campo a cada variable 
					String titulo=datos[1];
					String autor=datos[2];
					String fecha=datos[3];
					String popularidad=datos[4];
					if((ID!=" ")&&(titulo!=" ")&&(autor!=" ")&&(fecha!=" ")&&(popularidad!=" ")){ 
						salidaFichero.println(linea2);//Imprimo en el fichero de salida la info de la cancion
					}
				}else {
					j=j+1;//Cuento cuantas canciones elimino
				}
			}
			entrada1.close();//Cierro variables abiertas
			salidaFichero.close();
		}catch(java.io.IOException ex) {
			System.out.print(ex.getMessage()); 
			}
		return j;//Devuelve el numero de canciones eliminadas
		}
	}


