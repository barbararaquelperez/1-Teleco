//Hecho SOLO por Raquel Pérez

import java.util.Scanner;
public class CuentaLasPunto {
public static void main(String[] args) {
	
	Scanner teclado= new Scanner(System.in);
	System.out.println("Introduce una secuencia de caracteres acabada en punto: ");//Sacamos por pantalla
	char letra='\0'; //Definimos las variables como retorno de carro
	char letra_anterior='\0';
	int i=0; //longitud de la linea
	int j=0;//Contador de "la"
	String linea=teclado.nextLine();//Leemos la linea
	while(letra!='.') { //Hasta que la secuencia o acbe en .
		if(i<linea.length()){//Si la longitud de la linea
			letra_anterior=letra;//Hago el tratamiento de la letra
			letra=linea.charAt(i);
			i=i+1;
			if((letra_anterior=='l'|| letra_anterior=='L') && (letra=='a'|| letra=='A')) { //Contamos l o L como anterior y como letra a o A
				j=j+1;//contador
			}	
		}else { // Si i=linea.length
			i=0;
			linea=teclado.nextLine();


		}
	}
	System.out.println("El número de las es:"+ j);
	}
}





