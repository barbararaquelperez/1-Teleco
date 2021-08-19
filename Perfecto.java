//Hecho por Raul PLou y Raquel Pérez
public class Perfecto {

	public static void main(String[] args) {
		int num=0;
		int divisor=1;
		int suma_divisores=0;
		System.out.print("Los cuatro numeros perfectos de menor valor son: ");

		for(num=1;num<=10000;num++) {
			suma_divisores=0;
			for(divisor=1;divisor<num;divisor++) {
				if(num%divisor==0) {
					suma_divisores=suma_divisores + divisor;
					//Si el resto es 0, sumamos el divisor a la suma de divisores acumulada
				}
				
			}
			if(num==suma_divisores) {
				System.out.println(num);
				//Si el umero es igual a la suma de sus divisores, será perfecto
				//Si la suma de sus divisores no es igual al numero, no es perfecto
		}
		}
	}

}
