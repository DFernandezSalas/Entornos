package EjerColecciones;

public class Main {

	public static void main(String[] args) {
		Producto p1 = new Producto("Alitas", 400, 12);
		Producto p2 = new Producto("Pollo", 400, 12);
		Producto p3 = new Producto("Lechuga", 400, 12);
		System.err.println(p1);
		Lista l1 = new Lista();
		l1.addProduct("Carne", p1);
		l1.addProduct("Carne", p2);
		l1.addProduct("Verdura", p3);
		l1.getByCategory("Carn");
		l1.gettAll();

	}

}
