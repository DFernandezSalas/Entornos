package EjerColecciones;

public class Producto {
	private String producto;
	private int cantidad;
	private int peso;

	public Producto(String producto, int cantidad, int peso) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.peso = peso;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "[" + producto + ": cantidad=" + cantidad + ", peso=" + peso + "]";
	}

}
