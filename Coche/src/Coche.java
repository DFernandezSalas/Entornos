
public class Coche {
	String nombre;
	String color;
	int precio;
	static int discount = 10;

	Coche(String nombre, String color, int precio) {
		this.nombre = nombre;
		this.color = color;
		this.precio = precio;
		
	}
	
	public int aplicarDescuento() {
		return precio * (100 - discount) / 100;
	}
	
	public static void cambiarDescuento(int nuevoDescuento) {
		Coche.discount = nuevoDescuento;
	}

}
