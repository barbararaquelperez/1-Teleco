//Hecho solo por Raquel Pérez

import java.util.Scanner;
public class SegGradFloatCardano {
	public static void main(String[] args) {
		float a, b, c;//Defino el tipo de caracteres
		float x1, x2;
		float raiz1=0, raiz2=0;
		System.out.println("escribe el valor de a b c ");//Saco por pantalla
		Scanner entrada= new Scanner(System.in);
		a=entrada.nextFloat(); //Leo los tres numeros de teclado
		b=entrada.nextFloat();
		c=entrada.nextFloat();
		
		//Formato float
		float discriminante= b*b -4.0F*a*c; //(raiz(b^2-4ac)
		float termino1=-b/(2.0F * a); //-b/2a
		float termino2=(float)Math.sqrt(Math.abs(discriminante))/(2.0F*a); //(raiz(b^2-4ac))/2a
		x1 =termino1+termino2;
		x2=termino1+termino2;
		float producto=c/a;
		if (b>0) { //Aplico el Tma de C-V
			 raiz1=x2;
			 raiz2=producto/x2;
		}else {//Si la raiz es negativa (nº complejo)
			raiz1=x1;
			raiz2=producto/x1;
		}
		System.out.println("Las raices de la ecuacion son: "+raiz1 + "y" + termino2);
	}

}
