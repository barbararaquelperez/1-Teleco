//Hecho SOLO por Raquel Pérez
import java.util.Scanner;
public class FM {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numero=0, anterior=0, i=0, j=0;//Defino las variables
		int suma=0;
		boolean SC=true;//Si la secuencia es Sc es cierto
		System.out.println("Introduzca una secuencia de números finalizando en 0 (para finalizar secuencia introduzca en la última línea -1) ");
		numero=entrada.nextInt();//Leer cada numero de la cadena
		while(numero!=-1) {//Si la cadena no acaba en -1,hacer...
			while(numero!=0) {//Contamos los numeros mientras este nos ea 0
				suma=numero+suma;
				anterior=numero;
				i=i+1;
				numero=entrada.nextInt();/*continuo leyendo numeros de la cadena 
												hasta encontar un 0*/
			}
			if(suma%anterior==0) { //Si se trata de una secuencia de enteros
				j=j+1;
				suma=0;
				numero=entrada.nextInt();
			}
			else {//Si no es una secuencia curiosa
				SC=false;
				numero=entrada.nextInt();
			}
		}
		if( SC== true) {//Cuando se cumple que es una secuancia curiosa
			System.out.println("Es una FM " + j + " SC");
		}else {
			System.out.println("No es una FM ");
		}
		}

	}


