package EjerColecciones;

public class Main {

	public static void main(String[] args) {
		Productos p1 = new Productos("Alitas", 400, 12);
		System.err.println(p1);
		Lista l1 = new Lista("Carne", p1);

	}

}
