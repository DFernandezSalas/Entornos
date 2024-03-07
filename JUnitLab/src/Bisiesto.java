
public class Bisiesto {
	//Imaginemos una función que determine si un año es bisiesto o no. Un año es bisiesto si es divisible por 4,
	//pero no es divisible por 100, a menos que también sea divisible por 400.
	public static void main(String[] args) {
		
		esBisiesto(377);
		esBisiesto(2024);
		esBisiesto(400);
		esBisiesto(100);
		esBisiesto(2100);
	}
	
	public static void esBisiesto(int a) {
		if ((a%100!=0 || a%400==0)&& a%4==0) {
			System.out.println("Es bisiesto " + a);
			
		} else {
			System.out.println("No es bisiesto " + a);
		}
		
	}

}
