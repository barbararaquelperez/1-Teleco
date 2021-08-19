//Hecho por Raul PLou y Raquel Perez
import java.util.Scanner;

public class Base2 {

	public static void main(String[] args) {
		Scanner entrada=new Scanner(System.in);
		//Sacamos por pntalla
		System.out.println("Escribe un numero en base 10");
		//Definimos variables 
		int num= entrada.nextInt();
		int digitos_num=1;
		int digitos=1;
		int pot2=1;

		/*Mientras el numero metido por pantalla sea potencia de 2 y diferente de 0*/
		/*Contamos las veces que el numero es divisible para 2 y se escribira o 1 o 0*/
		while(num/(pot2*2) !=0) {
			digitos_num=digitos_num/10;
			digitos++;
			pot2*=2; //pot=pot10*10;
		}
		/*Abrimos bucle para que la division entre el numero y 2
		 * sea de resto 0 o 1; y almacene este numero y finalmente lo saque por pantalla*/
		
		for(int i=digitos; i>=1; i--) {
			System.out.print((num/pot2)%2);
			pot2/=2; //pot10=pot10/10;
		}
	}	

}


