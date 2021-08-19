//Hecho SOLO por Raquel Pérez
import java.util.Scanner;
public class Tramos {

	public static void main(String[] args) {
		System.out.println("Introduce una secuencia de enteros positivos finalizada en negativo: "); 
		Scanner entrada = new Scanner(System.in);
		int numero, anterior; // Dos últimos números leídos
		int i=0;
		boolean creciente = true; // Control de la secuencia
		
		// Lectura del primer número (al menos existe uno)
		numero = entrada.nextInt();
		if(numero<0) {
			System.out.println(" La secuencia tiene 0 tramos"); //Si el numero es negativo
		}
		if (numero != 0) //MIentras sea diferente que 0 leemos la secuencia
		{
			// Lectura del segundo número
			anterior = numero;
			numero = entrada.nextInt();
			i=1;
			// Tratamiento de la secuencia	
			while (numero >=0)
			{
				// ¿Es creciente?
				creciente = (numero >= anterior);
				if(creciente==false) {
					i=i+1; //Contador de tramos crecientes
				}//Repetimos el tratamiento para cada numero que continua en la secuencia
				anterior = numero;
				numero = entrada.nextInt();
			}
			}
				System.out.println("La secuencia tiene: " + i + " tramos");
		
}
}
