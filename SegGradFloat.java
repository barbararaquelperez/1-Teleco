//Hecho solo por Raquel Perez
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class SegGradFloat {

	public static void main(String[] args) {
		float a, b, c;
		System.out.println("escribe el valor de a b c ");//Saco por pantalla
		Scanner entrada= new Scanner(System.in);
		a=entrada.nextFloat(); //Leo los tres numeros de teclado
		b=entrada.nextFloat();
		c=entrada.nextFloat();
		
		//Formato float
		float discriminante= b*b -4.0F*a*c; //(raiz(b^2-4ac)
		float termino1=-b/(2.0F * a); //-b/2a
		float termino2=(float)Math.sqrt(Math.abs(discriminante))/(2.0F*a); //(raiz(b^2-4ac))/2a
		if (discriminante>0) { //LA raiz tiene que ser positiva
			float x1 =termino1+termino2;
			float x2=termino1+termino2;
		}else {//Si la raiz es negativa
			System.out.println(termino1 + "+" + termino2 + "i");
		}
		System.out.println(termino1 + "-" + termino2);
	}

}
