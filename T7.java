package TP6;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
public class T7{
	final static int maxCanciones=10000;
static public class Song {
	public String id_Spotify;
	public String title;
	public String artist;
	public String date;
	public int popularity;
}


public static void main(String[] args) {

	//Tarea 7
	System.out.println("¿Que año buscas?");
	Scanner entrada= new Scanner(System.in);
	int año=entrada.nextInt();
	int input=año;
	Song [] lista1 = getSongsOfYear("juan2.txt",input);
	
	//Tarea 8
	Song[]lista2=orderSongsByPopularity(lista1);
	
	//Tarea 9
	System.out.println("¿Que palabre clave quieres buscar?");
	Scanner entrada2= new Scanner(System.in);
	String palabra=entrada2.nextLine();
	//entrada2.close();
	int [] indices=searchSongsByKeywords(lista2, palabra);
	int i=0;
	if(indices!= null) { //Si no encontramos ninguna palabra que el ususario ha introducido  
		while(i<indices.length) { //Mientras que el contador no supere la longitud maxima de los indices
			System.out.println(indices[i]);//Saco por pantalla la POSICION que ocupba la cancion en el vector de lista2
			i++; //Incremento
		}
		entrada.close();
		entrada2.close();
	}


	//Tarea 10
	System.out.println("¿Que nombre das al fichero?");
	Scanner entrada3= new Scanner(System.in);
	String nombre=entrada3.nextLine();
	String fichero=nombre+".txt";
	try {
		Scanner entrada4= new Scanner(new FileReader("juan2.txt"));
		String cabecera=entrada4.nextLine();
		PrintWriter Fichero=new PrintWriter(new FileWriter(fichero));
		Fichero.println(cabecera);
		entrada3.close();
		Fichero.close();
	}catch(java.io.IOException ioex){
		System.out.println(ioex);
	}
	songByKeywordToFile(lista2,indices,fichero);
}
/**
* Devuelve información completa sobre las canciones publicadas en un año concreto
*
* @param intput Nombre del fichero de datos filtrados
* @param year Año a buscar
* @return Song[] Vector con información completa de las canciones de ese año
*/
public static Song[] getSongsOfYear (String intput, int year) {
	int num=0, ano=0, i=0; 
	Song lista[] = new Song[maxCanciones];//Reservar el espacio para guardar los punteros, pero sin reservar los datos
	Song listaAjustada[]= new Song[num];
	
	try{

		Scanner entrada = new Scanner (new FileReader(intput));
		String cabecera = entrada.nextLine();
		while(entrada.hasNext()){
			String [] datos = entrada.nextLine().split(",");
			String fecha=datos[3];
			String[] diaMesAño= fecha.split("-");
			String ano1=diaMesAño[0];
			ano= Integer.parseInt(ano1);
			if(ano==year) {
				lista[num] = new Song();//Reservo un espacio de memoria para uardar los datos de un registro y devuelvo un puntero
				lista[num].id_Spotify=datos[0];
				//System.out.println(lista[num].id_Spotify);
				lista[num].title=datos[1];
				lista[num].artist=datos[2];
				lista[num].date=datos[3];
				lista[num].popularity=Integer.parseInt(datos[4]);
				num++;
			}	
		}
		entrada.close();
	}catch(java.io.IOException ioex){
		System.out.println(ioex);
	}
	if (num==0) {
		return null;
	}
	for(i=0;i<num;i++) {
		listaAjustada[i]=lista[i];
	}
	/*Antes de devolver la variable lista, es muy probable que encuentre menos canciones que el maxCanciones
	 * por lo tanto hacemos un contador que genere otra lista de vectores que los almacene segun su numero;
	 * porque si dejo que la dimension de inputData sea Maxcanciones me leera vectores vacios y saldra
	 * mensaje de error
	*/
	
	return listaAjustada;

}
/**
* Ordena las canciones del vector de entrada de menor a mayor popularidad 
*
* @param inputData Vector de canciones no ordenado
* @return Song[] Vector de canciones ordenado por popularidad (popularity)
*/
public static Song[] orderSongsByPopularity (Song[] inputData) {
	Song outputData[] = new Song[inputData.length];//Reservar el espacio para guardar los punteros, pero sin reservar los datos
	Song draftData[]= new Song[inputData.length];//Hemos creado el array de puntero de borrador
	int j=0,k=0,menor=0;
	int indice_menor;
	int array=inputData.length;
	while(array>0) {
		indice_menor=0;
		menor=inputData[0].popularity;
		for(j=1;j<array;j++) {
			if(inputData[j].popularity>menor) {
				draftData[j-1]=inputData[j];
			}
			else {
				draftData[j-1]=inputData[indice_menor];
				menor=inputData[j].popularity;
				indice_menor=j;
			}
		}
		outputData[inputData.length-array]=inputData[indice_menor];
		for(k=0;k<array;k++) {
			inputData[k]=draftData[k];
		}
		array=array-1;//Reduzco el tamaño del vector en una unidad para la siguiente comparacion
		System.out.println("Nº de canción "+(inputData.length-array)+" Por tanto la popularidad final: "+menor);
	}
	return outputData;	
}
/**
* Busca canciones, contenidas en un vector de entrada, que contenga la palabra
* clave “keyword” en su campo “artist” y/o “title”
*
* @param inputData Vector de canciones
* @param keyword Palabra clave
* @return int[] Índices de las componentes de “inputData” que contienen la
* palabra clave
* **/
public static int [] searchSongsByKeywords (Song[] inputData, String Keyword) {
int j,i,k, num=0;
int resultado;
int[] indice= new int[maxCanciones]; //Defino la dimension del vector de lectura que como tope sera el maxCanciones
for(j=0;j<inputData.length;j++){ //Recorro todas las canciones hasta la longitud maxima que le doy de entrada
	resultado=1;//Inicializo la variable resultado a 1 para que empiece a contar por el numero de cancion es 1 ya que el numero de canciones a 0 no tendria sentido.
	i=0;
	k=0;
	String Titulo=inputData[j].title; //Leo la cadena y me centro en la posicion del titulo,
	//y la almaceno en un vector de punteros que llegara hasta j dimensiones
	String Artista=inputData[j].artist;
	String [] Palabras_Titulo = Titulo.split(" "); //Defino la palabra como el conjunto de letras separadas por un hueco 
	//dentro de una cadena
	String [] Palabras_Artista = Artista.split(" ");
	/* La funcion compareToIgnoreCase lee la palabra en todos sus formatos
	 * (aunque haya mayusculas o minusculas, la funcion la lee igual indiferentemente de lo que el usuario introduzca)
	 * Esta funcion diferencia tres casos:
	 * 1) Si el usuario introduce menos letras (la funcion devuelve un numero <0
	 * 2)Si encuentra la palabra (en May o min) le da el valor cero
	 * 3)Si encuentra un caracter en esceso, le dara el valor 1>
	 */
	while(i<Palabras_Titulo.length-1 && resultado!=0) { 
		resultado = Palabras_Titulo[i].compareToIgnoreCase(Keyword); //Comparo la palabra que introduce el usuario con el titulo
		i++; //Sumo
	}
	while(k<Palabras_Artista.length-1 && resultado!=0) {//Si ya en la seccion titulo ha encontrado la palabra, no entra en este while
		resultado = Palabras_Artista[k].compareToIgnoreCase(Keyword);
		k++;
	}
	if(resultado == 0){ //si coincide la palabra
		indice[num]=j;//Meto la posicion de la cancion en un vector 
		num++; //Incremento las posiciones d elos vectores 
	}
}//Cierro el bucle de leer
	if (num==0) { //Si no se encuentra ninguna palabra 
		return null; //Devuelvo un null
	}

int IndiceAjustado[]= new int[num];//Creo el vector de salida hasta el num
for(i=0;i<num;i++) {//Hago un contador para que recorra todas las posiciones que voy a rellenar
	IndiceAjustado[i]=indice[i];//Coloco la posicion antigua en la nueva del vector
	}
return IndiceAjustado;//Devuelvo el vector
}

/**
* Busca canciones, contenidas en un vector de entrada, que contenga la palabra
* clave “keyword” en su campo “artist” y/o “title”
*
* @param inputData Vector de canciones
* @param foundSongs Índices de las canciones que contienen la palabra clave
* @param output Nombre del fichero de salida
*/
public static void songByKeywordToFile (Song[] inputData, int[] foundSongs,String output) {
	try {
		int i=0,indice=0;
		FileWriter fichero2= new FileWriter(output,true);//Utilizo un metodo que escribe en un fichero que existe sin que me machaque la cabecera
		PrintWriter Fichero= new PrintWriter(fichero2);//Escribo en el fichero del usuario
		while(i<foundSongs.length){ //Recorro  cada vector de punteros hasta llegar a laa canciones max del año, sino sale mensaje de error
			indice=foundSongs[i]; //Guardo la cancion que esta en el vector de punteros
		Fichero.println(inputData[indice].id_Spotify+","+inputData[indice].title+","+inputData[indice].artist+","+inputData[indice].date+","+inputData[indice].popularity);
		//Imprimo en el fichero
		i++;
		}
	}catch(java.io.IOException ex){
		System.out.print(ex.getMessage());  
	}
}

}

