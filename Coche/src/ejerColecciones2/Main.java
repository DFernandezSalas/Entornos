package ejerColecciones2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Freestyle f1 = new Freestyle();
		f1.agregarNota("Paco", "DjMotroco", "rimas", 5);
		f1.agregarNota("Paco", "DjMotroco", "ritmo", 5);
		f1.agregarNota("Paco", "Trueno", "rimas", 7);
		f1.agregarNota("Paco", "Trueno", "ritmo", 7);
		f1.agregarNota("Pepe", "Trueno", "rimas", 7);
		f1.agregarNota("Pepe", "Trueno", "ritmo", 7);
//		System.out.println(f1);
		f1.notasCantante("Trueno");
		f1.notasJuez("Pepe");
		f1.obtenerMediaCantante("Trueno");
		f1.artistaMetrica("ritmo");
	}

}
