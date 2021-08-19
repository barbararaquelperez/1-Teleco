//Hecho solo por Raquel Perez

public class Gemelos {

	public static void main(String[] args) {
		int num;//Definimos las variables
		int i=2; //empezamos contando a partir del 2
		System.out.println("Los primos Gemelos menores de 1000 son:"); //Automaticamente saca todos los primos por pantalla
		for(num=3;num<=1000;num++){ //Sacar todos los primos desde el 3 hasta el 1000       
			for(i=2;i<num;i++){//Repetimos el bucle i++ veces
				if(num%i==0){//Si sale un numero entero 
					i=num+1;//Avanzamos un puesto
				}
			}
			if((int)i==num) {//Si i es el num
					for(i=2;i<num+2;i++){ //Repetimos el bucle i ++ veces
					if((num+2)%i==0){ //Cmprobamos que el segundo numero tambien es primo, y si lo es lo sacamos por pantalla
						i=num+3;//contador
					}
					}
					if((int)i==num+2) { //Si estudiamos si es primo para num+2 
					System.out.println("("+(num)+","+(num+2)+")");
					//num=num+2;
					}
					}		
					}


	}

}
