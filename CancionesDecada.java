package TP6;
import java.io.FileReader;
import java.util.Scanner;
public class CancionesDecada {
	public static void main(String[] args) {
		int []canciones_decada=new int [10];
		String linea3;
		int año_usuario,i;
		char c;
		Scanner entrada=new Scanner(System.in); 
		System.out.println("¿Qué nombre tenia el fichero anterior?");//Preguntamos al usuario cual va a ser el nombre del fichero
		String linea; //Leemos la entrada del ususario
		linea=entrada.nextLine(); //Leemos la linea
		String input=linea+".txt";
		do {
			Scanner entrada2=new Scanner(System.in); 
			System.out.println("Escribe un año y buscaremos las canciones de su década");//Preguntamos al usuario cual va a ser el nombre del fichero
			String linea2; //Leemos la entrada del ususario
			linea2=entrada2.nextLine(); //Leemos la linea
			año_usuario=Integer.parseInt(linea2);
			canciones_decada=songsOfaDecade(input, año_usuario);
			for(i=0;i<10;i++) {
				System.out.println("Tienes : "+canciones_decada[i]+" "+ "canciones del año: "+(año_usuario+i));
			}
			Scanner entrada3=new Scanner(System.in); 
			System.out.println("¿Quieres seguir buscando(Y/N)?");
			linea3=entrada3.nextLine();
			c = linea3.charAt(0);
		}while(c!='N');
		
	}
	/**
	* Determina el número de canciones publicadas en una década
	*
	* @param input Nombre del fichero de entrada
	* @param year Año inicial de la década
	* @return int[] Número de canciones encontradas para cada año
	*/
	public static int [] songsOfaDecade (String input, int year){
		int i=0, ano=0;
		int [] canciones_contadas= new int [10];//Definimos variables
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
				if((ano<year+10)&&(ano>=year)) {
					canciones_contadas[ano-year]=canciones_contadas[ano-year]+1;
				}
			}
			entrada1.close();
			}catch(java.io.IOException ex) {
				System.out.print(ex.getMessage()); 
				}
			return canciones_contadas;
		}
}
