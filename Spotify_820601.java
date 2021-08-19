package TP6;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import TP6.T7.Song;

public class Spotify_820601 {
	final static int maxCanciones=10000; //Variable general del max canciones para poder usar en todos los metodos
	static public class Song {//Defino las variables de la clase Song
	public String id_Spotify;
	public String title;
	public String artist;
	public String date;
	public int popularity;
	}
	public static void main(String[] args) { //Abro el main donde invocare todo los metodos de cada tarea
	int num=0, i=0, año_usuario; //Defino variables
	int num_fechas=0;

	//TAREA 1

	Scanner entrada=new Scanner(System.in); 
	System.out.println("¿Qué nombre das al fichero de salida para caracteres extraños?");//Preguntamos al usuario cual va a ser el nombre del fichero
	String linea; //Leemos la entrada del ususario
	linea=entrada.nextLine(); //Leemos la linea
	String output=linea+".txt";//Tenemos el fichero donde se almacenara la info relevante
	String input="Spotify-songs.txt";//Introducimos el fichero de lectura
	num=filePreprocessing(input,output); //Definimos num como el procesador de entrada y salida del fichero
	System.out.println("Numeros de espacios en blanco "+num); //Sacamos por pantalla en el copilador

	//TAREA 2
	Scanner entrada2=new Scanner(System.in); 
	System.out.println("¿Qué nombre das al fichero de salida para informacion incompletas?");//Preguntamos al usuario cual va a ser el nombre del fichero
	String linea2; //Leemos la entrada del ususario
	linea2=entrada2.nextLine(); //Leemos la linea
	String output2=linea2+".txt";//Tenemos el fichero donde se almacenara la info relevante
	num=removeLines(output,output2); //Definimos num como el procesador de entrada y salida del fichero
	System.out.println("EL numero de canciones incompletas "+num); //Sacamos por pantalla en el copilador


	//TAREA 3
	Scanner entrada3= new Scanner (System.in);
	System.out.println("¿Qué nombre das al fichero de salida para canciones completas?");//Preguntamos al usuario cual va a ser el nombre del fichero
	String linea3; //Leemos la entrada del ususario
	linea3=entrada3.nextLine(); //Leemos la linea
	String output3=linea3+".txt";//Tenemos el fichero donde se almacenara la info relevante
	num_fechas=removeDates(output2,output3); //Definimos num como el procesador de entrada y salida del fichero
	System.out.println("Las canciones eliminadas por fecha incompleta son: "+num_fechas);


	//TAREA 4
	int canciones_año;
	char c;
	do {
	Scanner entrada4=new Scanner(System.in); 
	System.out.println("¿Qué año quieres buscar?");//Preguntamos al usuario cual va a ser el nombre del fichero
	String linea5; //Leemos la entrada del ususario
	linea5=entrada4.nextLine(); //Leemos la linea
	año_usuario=Integer.parseInt(linea5);
	canciones_año=songsOfaYear(output3,año_usuario);//Invoco el metodo en el main
	System.out.println("Tienes : "+canciones_año+" canciones del mismo año");//Saco por pantalla
	Scanner entrada5=new Scanner(System.in); 
	System.out.println("¿Quieres seguir buscando(Y/N)?");//Si el usuario quiere seguri buscando canciones o no
	linea5=entrada5.nextLine();//Leo entrada
	c = linea5.charAt(0);//Convierto la linea en un caracter
	}while(c!='N');


	//TAREA 5
	int []canciones_decada=new int [10]; //Defino el vector de enteros de dimension 10
	String linea6,linea7; 
	do {
		Scanner entrada6=new Scanner(System.in); 
		System.out.println("Escribe un año y buscaremos las canciones de su década");//Preguntamos al usuario cual va a ser el nombre del fichero
		linea6=entrada6.nextLine(); //Leemos la linea
		año_usuario=Integer.parseInt(linea6);//Convierto la entrada (string) a un numero (int)
		canciones_decada=songsOfaDecade(output3, año_usuario);//Onvoco el metodo
		for(i=0;i<10;i++) { //Recorro todas las lineas
			System.out.println("Tienes : "+canciones_decada[i]+" "+ "canciones del año: "+(año_usuario+i));
		}
		Scanner entrada7=new Scanner(System.in); 
		System.out.println("¿Quieres seguir buscando(Y/N)?"); //Pregunto si quiere seguir buscando
		linea7=entrada7.nextLine();
		c = linea7.charAt(0);//Convierto una linea en un numero
	}while(c!='N');



	//Tarea 7
	System.out.println("¿Que año buscas para pasar las canciones de ese año a un vector de objetos?");
	Scanner entrada8= new Scanner(System.in);
	int year=entrada8.nextInt();//LLamo year a la entrada del usuario
	Song [] lista1 = getSongsOfYear(output3,year);//Invoco el metodo

	//Tarea 8
	Song[]lista2=orderSongsByPopularity(lista1);//Invoco el metodo


	//Tarea 9
	System.out.println("¿Que palabre clave quieres buscar del año?");
	Scanner entrada9= new Scanner(System.in);
	String palabra=entrada9.nextLine(); 
	int [] indices=searchSongsByKeywords(lista2, palabra);//Invoco el metodo
	int i2=0;
	if(indices!= null) { //Si no encontramos ninguna palabra que el ususario ha introducido  
		while(i2<indices.length) { //Mientras que el contador no supere la longitud maxima de los indices
			System.out.println(indices[i2]);//Saco por pantalla la POSICION que ocupba la cancion en el vector de lista2
			i2++; //Incremento
		}
	}else {
		System.out.println("No se ha encontrado palabra clave");
	}


	//Tarea 10
	String FileOutput; //Defino la  variable de entrada
	if (indices!=null) {
	System.out.println("¿Nombre del fichero donde quieres guardar las canciones de keyword?");
	Scanner entrada10= new Scanner(System.in);
	FileOutput=entrada10.nextLine();
	String fichero=FileOutput+".txt"; //Nombro el fichero
	try {
		Scanner entrada4=new Scanner(new FileReader(output3));//Leo el fichero de entrada
		String cabecera= entrada4.nextLine();
		PrintWriter salidaFichero=new PrintWriter(new FileWriter(fichero));//Escribo en el fichero nuevo
		salidaFichero.println(cabecera);//Pinto la cabecera
		entrada4.close();
		salidaFichero.close();
		}catch(java.io.IOException ex){
			System.out.print(ex.getMessage());
		}
		SongsByKeywordstoFile(lista2, indices, fichero); //Invoco el metodo
	}

	//TAREA 12
	System.out.println("¿Año de inicio de búsqueda de canciones?");//Pregunto al usuario las 
	Scanner entrada5= new Scanner(System.in);
	int Año_inicio=entrada5.nextInt(); //
	System.out.println("¿Año final de búsqueda de canciones?");
	Scanner entrada6= new Scanner(System.in);
	int Año_fin=entrada6.nextInt();
	songsOfYearToFile (output3, Año_inicio, Año_fin);
	
	//TAREA 13 Y 14 no invoco ningun metodo porque van todos a fichero
	}//Cierro el main

	//TAREA 1
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

	//TAREA 2

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

	//TAREA 3

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
				if(fecha.length()>4) { //La longitud de la fecha no puede superar los 4 numeros enteros 
					salidaFichero.println(linea2);//Imprimo en el fichero la info de la cancion completa
				}
				else {
					i=i+1;//Incremento el contador
				}
			}
			entrada1.close();
			salidaFichero.close();
		}catch(java.io.IOException ex) {
			System.out.print(ex.getMessage());//Error
		}
		return i;//Devuelvo el parametro que me crea le metodo
	}

	//TAREA 4	

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
				String fecha=datos[3];//Fecha tiene la posicion 3 del vector
				String[] diaMesAno= fecha.split("-"); //Digo que dentro de la fecha se separan los dias meses y año por un guion
				String ano1=diaMesAno[0]; //Digo la posicion q ocupa el año dentro de la fecha
				ano= Integer.parseInt(ano1); //Convierto el string en entero
				if(year==ano) { //Si encuentro la cancion con el mismo año 
					//que introdcue el ususario la acumulo en el contador
					i=i+1;//Contador
				}
			}
			entrada1.close();
		}catch(java.io.IOException ex) {
			System.out.print(ex.getMessage()); 
		}
		return i; //Devuelvo la variable que creo en el metodo
	}

	//TAREA 5
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
				String linea2= entrada1.nextLine(); //
				String [] datos = linea2.split(",");//Los datos vienen separados por comas
				String fecha=datos[3]; //Digo la posicion en la que se encuentra la fecha
				String[] diaMesAno= fecha.split("-"); //Se separa por guion 
				String ano1=diaMesAno[0]; //La psoicion en la que se encuentra el año
				ano= Integer.parseInt(ano1); //Convierto el string en un entero
					if((ano<year+10)&&(ano>=year)) { //Si cumple la condision de ser decada
						canciones_contadas[ano-year]=canciones_contadas[ano-year]+1; //Sumo una posisicon al contador
					}
			}
			entrada1.close();
	}catch(java.io.IOException ex) {
		System.out.print(ex.getMessage()); 
		}
		return canciones_contadas; //Devuelvo el parametro que me crea el metodo
	}
	
	//SEGUNDA PARTE
	
	//TAREA 7
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
		try{
			Scanner entrada = new Scanner (new FileReader(intput)); //Leo la entrada del fichero
			String cabecera = entrada.nextLine(); //Leo la cabecera y la descarto
			while(entrada.hasNext()){ //Leo todas las lineas del fichero
				String [] datos = entrada.nextLine().split(","); //Cada campo esta separado por ,
				String fecha=datos[3]; //Localizo la posicion en la que se encuentra la fecha
				String[] diaMesAño= fecha.split("-"); //La variable fecha esta separada por guiones en sus 
				String ano1=diaMesAño[0]; //Almaceno la posicion del año dentro de la fecha
				ano= Integer.parseInt(ano1);//Convierto un String en un entero
				if(ano==year) {
					lista[num] = new Song();//Reservo un espacio de memoria para uardar los datos de un registro y devuelvo un puntero
					lista[num].id_Spotify=datos[0];
					lista[num].title=datos[1];
					lista[num].artist=datos[2];
					lista[num].date=datos[3];
					lista[num].popularity=Integer.parseInt(datos[4]);//COnvierto el string de popularidad en un entero (numero)
					num++;//Recorro todos los indices
				}	
			}
			entrada.close();
		}catch(java.io.IOException ioex){
			System.out.println(ioex);
		}
		if (num==0) {//No hay ninguina cancion de ese año, devuelvo null
			return null;
		}
		Song listaAjustada[]= new Song[num];//En vez de inicializar este vecor a null (me daba problemas), lo inicializo al nuevo vector de canciones
		for(i=0;i<num;i++) {//Relleno todo el vector
			listaAjustada[i]=lista[i]; //Las dimensiones de ambos tienen que ser iguales
		}

	/*Antes de devolver la variable lista, es muy probable que encuentre menos canciones que el maxCanciones
	* por lo tanto hacemos un contador que genere otra lista de vectores que los almacene segun su numero;
	* porque si dejo que la dimension de inputData sea Maxcanciones me leera vectores vacios y saldra
	* mensaje de error
	*/
		return listaAjustada;//Devuelvo el metodo un vector con la las posiciones y numero de canciones exactas
	}

	//TAREA 8
	/**
	* Ordena las canciones del vector de entrada de menor a mayor popularidad 
	*
	* @param inputData Vector de canciones no ordenado
	* @return Song[] Vector de canciones ordenado por popularidad (popularity)
	*/

	public static Song[] orderSongsByPopularity (Song[] inputData) {
		Song outputData[] = new Song[inputData.length];//Reservar el espacio para guardar los punteros, pero sin reservar los datos
		Song draftData[]= new Song[inputData.length];//Hemos creado el array de puntero en borrador donde haremos la ordenacion
		int j=0,k=0,menor=0;
		int indice_menor;//Posicion del valor de menor popularidad
		int array=inputData.length;//Defino la dimension del vector (auxiliar) de punteros que lo llamo array
		while(array>0) {//Mientras que la longitud del puntero de entrada sea mayor que 0
			indice_menor=0;
			menor=inputData[0].popularity; //Definimos el numero menor que se encontarra en la posicion 0 del vector
			for(j=1;j<array;j++) { //Recorro todo el puntero 
				if(inputData[j].popularity>menor) { //Recorro todos los elementos del puntero que sean mayores que el numero menor
					draftData[j-1]=inputData[j];//La posicion del puntero en el vector auxiliar(draft) sera una menos 
					//que el del vector como parametro de entrada(input), al comparar dos valores y escoger dos posiciones
				}
				else { //Si se encuentra un numero menor que el ya asignado menor
					draftData[j-1]=inputData[indice_menor]; //Almaceno el nuevo menor en la posicion 0 del vector
					//y lo coloco delante del antiguo menor 
					menor=inputData[j].popularity;//Asigno a la variable menor otro valor menor al que ya tenia
					indice_menor=j;//Y conservo el indice donde se encuentra el mas pequeño en el vector de entrada
				}
			}
		outputData[inputData.length-array]=inputData[indice_menor];//Asignar el menor valor al vector Output (nº de cancion)
		for(k=0;k<array;k++) {//Traslado los punteros del vector auxiliar al de entrada (input)
			inputData[k]=draftData[k];//Volcamos todos los datos del vector borrador en el input para hacer la nueva comparacion
		}
		array=array-1;//Reduzco el tamaño del vector en una unidad para la siguiente comparacion
		System.out.println("Nº de canción "+(inputData.length-array)+" Por tanto la popularidad final: "+menor);
		}
		return outputData;	//Devuelvo variable del metodo getSongsofYear
	}

	//TAREA 9
	
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

			while(i<Palabras_Titulo.length-1 && resultado!=0) { //Longitud menos uno poruqe sino se desborda al compilar
				resultado = Palabras_Titulo[i].compareToIgnoreCase(Keyword); //Comparo la palabra que introduce el usuario con el titulo
				i++; //Recorro posiciones
			}
			while(k<Palabras_Artista.length-1 && resultado!=0) {//Si ya en la seccion titulo ha encontrado la palabra, no hace falta buscarlo en el artista
				resultado = Palabras_Artista[k].compareToIgnoreCase(Keyword);//Metodo de comparar con la palabra que introduce el ususario
				k++;//Sigo recorriendo posiciones
			}
			if(resultado == 0){ //si coincide la palabra
				indice[num]=j;//Meto la posicion de la cancion en un vector 
				num++; //Incremento las posiciones d elos vectores 
			}
		}//Cierro el bucle de leer
		if (num==0) { //Si no se encuentra ninguna palabra 
			return null; //Devuelvo un null
		}
		
		//Estas son las variables que voy a devolver al metodo general
		int IndiceAjustado[]= new int[num];//Creo el vector de salida hasta el num
		for(i=0;i<num;i++) {//Hago un contador para que recorra todas las posiciones que voy a rellenar
			IndiceAjustado[i]=indice[i];//Coloco la posicion antigua en la nueva del vector
			}
		return IndiceAjustado;//Devuelvo el vector
	}//FIN TAREA 9

	//TAREA 10
	/**
	* Busca canciones, contenidas en un vector de entrada, que contenga la palabra
	* clave “keyword” en su campo “artist” y/o “title”
	*
	* @param inputData Vector de canciones
	* @param foundSongs Índices de las canciones que contienen la palabra clave
	* @param output Nombre del fichero de salida
	*/

	public static void SongsByKeywordstoFile (Song[] inputData, int[] foundSongs,String output) {
		try {
			int i=0,indice=0;//Indice es la posicion que ocupa cada dato del vector
			FileWriter fichero2= new FileWriter(output,true);//Utilizo un metodo de una clase que escribe en un fichero que existe sin que me machaque la cabecera
			PrintWriter Fichero= new PrintWriter(fichero2);//Asigno las propiedades de la clase a la variable Fichero para poder escribir en el fichero del usuario
			while(i<foundSongs.length){ //Recorro  cada vector de punteros hasta llegar a laa canciones max del año, sino sale mensaje de error
				indice=foundSongs[i]; //Transfiero el numero de orden de la canción a una variable que voy a utilizar como idice del vector de canciones
				Fichero.println(inputData[indice].id_Spotify+","+inputData[indice].title+","+inputData[indice].artist+","+inputData[indice].date+","+inputData[indice].popularity);
				//Imprimo los datos en el fichero
				i++;//Recorro todas las canciones encontradas
			}
			Fichero.close();//Cierro fichero
		}catch(java.io.IOException ex){
			System.out.print(ex.getMessage());  
		}
	}//FIN DE LA TAREA 10
	
//TERCERA PARTE
	//TAREA 12
	
	/**
	* Genera un conjunto de ficheros de canciones organizadas por año de publicación
	*
	* @param inputData Fichero original de canciones
	* @param agno_min El año mínimo que define el rango de trabajo
	* @param agno_max El año máximo que define el rango de trabajo
	*/
	public static void songsOfYearToFile (String inputData, int agno_min, int agno_max) {
		int i,j=0;
		int agnos=agno_max-agno_min+1;//Conocer el numero de años que voy a leer
		Song[] lista;
		try {	
			Scanner entradaOrigen=new Scanner(new FileReader(inputData));//Leo el fichero
			String cabecera= entradaOrigen.nextLine();//Leo la cabecera y leo los datos a partir de ella
			PrintWriter salidaFicheroMeta=new PrintWriter(new FileWriter("metadatos_songs.txt"));//Escribo en fichero
			try {
				for(i=0;i<agnos;i++) {//Para cada año que lea en el fichero de metafatos
					String FicheroAgno="songs_"+(agno_min+i)+".txt";//Nombre de cada fichero de años 
					PrintWriter salidaFichero=new PrintWriter(new FileWriter(FicheroAgno));//Escribire en un fichero cuyo nombre lo de el ususario
					salidaFichero.println(cabecera);//Imprimo la cabecera con la info de los campos
					lista=getSongsOfYear (inputData, agno_min+i);//Conseguir las canciones de un año y las escribo en el fichero nuevo que abro
					while(j<lista.length) { 
						salidaFichero.println(lista[j].id_Spotify+","+lista[j].title +","+lista[j].artist+","+lista[j].date+","+lista[j].popularity);
						//Lo que imprimire en el fichero de cada año 
						j++;//
					}
					salidaFichero.close();
					FileWriter fw = new FileWriter("metadatos_songs.txt", true); //para escribir en un fichero ya existente sin eliminar lo anterior
					PrintWriter salidaFicheroMeta2 = new PrintWriter(fw);//Imprimo en fichero los datos de
					salidaFicheroMeta2.println((agno_min+i)+" "+lista.length+" "+FicheroAgno);//Imprimimos en el fichero
					salidaFicheroMeta2.close();
				}
			}catch(java.io.IOException ex){
				System.out.print(ex.getMessage());  
			}
			salidaFicheroMeta.close();
		}catch(java.io.IOException ex){
			System.out.print(ex.getMessage());  
		}
	}//CIERRO TAREA 12

	//TAREA 13 y 14
	/**
	* Analizar los máximos/mínimos de una matriz de popularidad por años
	*
	* @param m Matriz de popularidad por años
	*/
	//Uso el mismo metodo para la tarea 13 y 14
	public static void analysisOfPopMatrix (int[][] matriz) {
		//TAREA 13
		int num=0, i;	
		int MaxAños=40;
		String [] ficheros=new String [MaxAños];
		int [] años=new int [MaxAños];
		try {
			Scanner entrada=new Scanner(new FileReader("metadatos_songs.txt")); //Leer los campos del fichero 
			//y usarlos para formar la matriz
			while(entrada.hasNext()) {//Leo todas las lineas del fichero
				String linea= entrada.nextLine();//Leo la linea
				String [] datos = linea.split(" ");//Los datos vienen separados por espacios
				años[num]=Integer.parseInt(datos[0]);//COnvierto el string en un entero
				ficheros[num]= datos[2];//Los fichero estan en el campo 2
				num++; //Repito para todo el num de años que haya en el fichero
			}
			entrada.close();
			}catch(java.io.IOException ex) {
				System.out.print(ex.getMessage()); 
				}

			int [][] Matrix = new int[num][11];//Le pongo 11 columnas para poner en la 1º columna el año de las canciones
			try {
			 for(i=0; i<num;i++) {
				 Scanner entrada2=new Scanner(new FileReader(ficheros[i])); //Fichero de entrada
				 String cabecera = entrada2.nextLine();//Leo 
				 Matrix[i][0]=años[i];//Asignar el año a las filas de la matriz
				 while(entrada2.hasNext()) {
					 String linea= entrada2.nextLine();//Salto la primera linea (cabecera)
					 String [] datos = linea.split(",");//Los datos vienen separados por comas
					 int popularidad=Integer.parseInt(datos[4]);//Convierto el string de popularidad en un entero
					 if(0<=popularidad && popularidad<=9) { //Para cada rango de popu. 
						 Matrix[i][1]=Matrix[i][1]+1;//Su posicion en la matriz
						 //Añado uno a cada cancion que esta en ese rango de popu.
					 }
					 if(10<=popularidad && popularidad<=19) {
						 Matrix[i][2]=Matrix[i][2]+1;
					 }
					 if(20<=popularidad && popularidad<=29) {
						 Matrix[i][3]=Matrix[i][3]+1;
					 }
					 if(30<=popularidad && popularidad<=39) {
						 Matrix[i][4]=Matrix[i][4]+1;
					 }
					 if(40<=popularidad && popularidad<=49) {
						 Matrix[i][5]=Matrix[i][5]+1;
					 }
					 if(50<=popularidad && popularidad<=59) {
						 Matrix[i][6]=Matrix[i][6]+1;
					 }
					 if(60<=popularidad && popularidad<=69) {
						 Matrix[i][7]=Matrix[i][7]+1;
					 }
					 if(70<=popularidad && popularidad<=79) {
						 Matrix[i][8]=Matrix[i][8]+1;
					 }
					 if(80<=popularidad && popularidad<=89) {
						 Matrix[i][9]=Matrix[i][9]+1;
					 }
					 if(90<=popularidad && popularidad<=100) {
						 Matrix[i][10]=Matrix[i][10]+1;
					 }
				 }
				 entrada2.close();
			 }
			}catch(java.io.IOException ex) {
				System.out.print(ex.getMessage());
			}
			
	//TAREA 14
	int l,j, k;
	int indice_mayor=0, indice_menor=0, indice_menor_año=0, indice_mayor_año=0;
	int menores[][]=new int [2][matriz.length];//Defino la dimension de la matriz y en una fila meto los años 
	//y en la segunda meto el rango donde menos popularidad hay
	int mayores[][]=new int [2][matriz.length];//y en la segunda meto el rango donde mayor popularidad hay

	String popularidad[]=new String[10];//La dimension del vector popularidad
	popularidad[0]="0-9";//Defino las posiciones que abarca cada rango de popularidad
	popularidad[1]="10-19";
	popularidad[2]="20-29";
	popularidad[3]="30-39";
	popularidad[4]="40-49";
	popularidad[5]="50-59";
	popularidad[6]="60-69";
	popularidad[7]="70-79";
	popularidad[8]="80-89";
	popularidad[9]="90-100";

	for(l=0;l<matriz.length;l++) { //Recorro los años (filas)
		int menor=matriz[l][1]; //Tomamos el primer valor como el menor
		int mayor=matriz[l][1]; //Tomamos el primer valor como el mayor
		indice_menor=0;//Tienen que inicializarse a 0 cada vez que entran en el bucle
		indice_mayor=0;
		for(j=0;j<10;j++) { //Recorro rangos de popu. (columnas)
			if(menor>matriz[l][j+1]) { //Sacar de la matriz el valor menor y su indice
				menor=matriz[l][j+1]; //Si matriz es menor que menor, asigno su valor al nuevo menor
				indice_menor=j; //Guardo la posicion del menor
			}
			if(mayor<matriz[l][j+1]) { //Sacar de la matriz el valor menor y su indice
				mayor=matriz[l][j+1]; //Si matriz es mayor que mayor, asigno su valor al nuevo mayor
				indice_mayor=j;//Guardo la posicion del mayor
			}
	   }
		//Ya tengo todos los valores comparados y guardo los mayores y menores de popularidad de cada año
	   menores[0][l]=menor; 
	   menores[1][l]=indice_menor;
	   mayores[0][l]=mayor;
	   mayores[1][l]=indice_mayor;
	   
	   System.out.println("Año"+matriz[l][0]+": máximo (popularidad "+popularidad[indice_mayor]+") y mínimo (popularidad "+popularidad[indice_menor]+")");
	} 
	//Comparamos todos los rangos de todos los años
	int Menor=100, Mayor=0; //Menor tiene valor 100 para asegurarme que no se quedan con el valor inicial que le doy
	for(k=0;k<matriz.length;k++) { //Recorro los años y me quedo con el rango menor y su año
		if(Menor> menores[0][k]) { //Si encuentro un menor mas pequeño que el valor que yo he asignado a menor
	   		Menor=menores[0][k]; //Cambio sus valores de las variables por el nuevo menor
	   		indice_menor_año=k;
	   		indice_menor=menores[1][k];
	   	}
	}

	for(k=0;k<matriz.length;k++) { //Recorro los años y me quedo con el rango mayor y su año
	   	if(Mayor<mayores[0][k]) {//Si encuentro un menor mas pequeño que el valor que yo he asignado a mayor
	   		Mayor=mayores[0][k];//Cambio sus valores de las variables por el nuevo mayor
	   		indice_mayor_año=k;
	   		indice_mayor=mayores[1][k];
	   	}
	}
	   	
	System.out.println("Finalmente: Años "+matriz[0][0]+"-"+matriz[matriz.length-1][0]+": máximo ("+matriz[indice_mayor_año][0]+", popularidad "+popularidad[indice_mayor]+")"+" "+"y mínimo ("+matriz[indice_menor_año][0]+", popularidad "+popularidad[indice_menor]+")");
	}
	 
}//FIN DE LA CLASE
