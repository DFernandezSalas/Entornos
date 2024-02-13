
public class Main {

	public static void main(String[] args) {
		Coche car1 = new Coche("Corsa", "Rojo", 1000);
		Coche car2 = new Coche("Vectra", "Dorado", 2000);
		Coche car3 = new Coche("Insignia", "Negro", 4000);
		Coche car4 = new Coche("Astra", "Azul", 4000);
		
		System.out.println("Coche " + car1.nombre + " de color " + car1.color + " que cuesta " + car1.precio);
		System.out.println("El precio del coche con descuento es: " + car1.aplicarDescuento());
		System.out.println("Coche " + car2.nombre + " de color " + car2.color + " que cuesta " + car2.precio);
		System.out.println("El precio del coche con descuento es: " + car2.aplicarDescuento());
		System.out.println("Coche " + car3.nombre + " de color " + car3.color + " que cuesta " + car3.precio);
		System.out.println("El precio del coche con descuento es: " + car3.aplicarDescuento());
		System.out.println("Coche " + car4.nombre + " de color " + car4.color + " que cuesta " + car4.precio);
		System.out.println("El precio del coche con descuento es: " + car4.aplicarDescuento());
		
		Coche.cambiarDescuento(suma(2,3));
		
		System.out.println("Coche " + car1.nombre + " de color " + car1.color + " que cuesta " + car1.precio);
		System.out.println("El precio del coche con descuento es: " + car1.aplicarDescuento());
		System.out.println("Coche " + car2.nombre + " de color " + car2.color + " que cuesta " + car2.precio);
		System.out.println("El precio del coche con descuento es: " + car2.aplicarDescuento());
		System.out.println("Coche " + car3.nombre + " de color " + car3.color + " que cuesta " + car3.precio);
		System.out.println("El precio del coche con descuento es: " + car3.aplicarDescuento());
		System.out.println("Coche " + car4.nombre + " de color " + car4.color + " que cuesta " + car4.precio);
		System.out.println("El precio del coche con descuento es: " + car4.aplicarDescuento());
		
		
	}
	
	public static int suma(int num1, int num2) {
		return num1+num2;
	}

}
