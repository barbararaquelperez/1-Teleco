//Hecho solo por Raquel Perez
import java.util.Scanner;
public class SCuriosa {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);//
		int numero=0, anterior=0, i=0;//Defino variables
		int suma=0;//inicialio la suma
		System.out.println("Escribe una secuencia curiosa: ");
		numero=entrada.nextInt();//almaceno el numero
		while(numero!=0) {//MIentras el numero que hemos leido no sea cero contamos la secuecia
			suma=numero+suma;
			anterior=numero;
			i=i+1;//contador
			numero=entrada.nextInt();//leemos con cada numero hasta qeu contemos todos menos el 0
		}
		if (i<3) {//mientras la longitud sea menor que tres, la secuencia ya no puede ser SC
			System.out.println("La longitud de la secuencia menor o igual que 2");
		}
			else{//decimos que la longitud es mayor que 3 
				if(suma%anterior==0) {//si nos da un entero, es una SC
					System.out.println("Es una SC de longitud " + i);	
				}
				else {//Si la division no sale un entero, no es SC
					System.out.println("No es una SC");
				}
			}
		}
}

