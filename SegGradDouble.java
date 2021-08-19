//Hecho SOLO por Raquel Pérez

import java.util.Scanner;
public class SegGradDouble{
	public static void main(String[] args) {
		double a, b, c;
		System.out.println("escribe el valor de a b c ");
		Scanner entrada= new Scanner(System.in);
		a=entrada.nextDouble(); 
		b=entrada.nextDouble();
		c=entrada.nextDouble();
		double x1, x2;
		
		double discriminante= b*b -4.0F*a*c; //(raiz(b^2-4ac)
		double termino1=-b/(2.0F * a); //-b/2a
		double termino2=(double)Math.sqrt(Math.abs(discriminante))/(2.0F*a); //(raiz(b^2-4ac))/2a
		
		if(b>0) {// La raiz sera real
			x1=termino1-termino2;
		}else {//Si es un nº complejo
			x1=termino1+termino2;
		 }
		x2=(c/a)/x1;
		
		System.out.println(termino1 + "+" + termino2 + "i");
		System.out.println(termino1 + "-" + termino2 + "i");
	}

}
