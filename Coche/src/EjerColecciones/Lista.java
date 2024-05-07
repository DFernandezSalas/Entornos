package EjerColecciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lista {
	private Map<String, ArrayList<Producto>> listaCompra = new HashMap<>();

	public void addProduct(String categoria, Producto pr) {
		// Comprobar si la lista contiene categoria
		if (listaCompra.containsKey(categoria)) {
			ArrayList<Producto> listadecat = listaCompra.get(categoria);
			// Si la contiene, añadir a esa lista el producto
			listadecat.add(pr);
		} else {
			ArrayList<Producto> listadecat = new ArrayList<Producto>();
			listadecat.add(pr);
			listaCompra.put(categoria, listadecat);
		}

		// Si no la contiene crear nueva lista, añadir a la nueva lista el producto, y
		// añadir al mapa la categoria
	}

	public void getByCategory(String categoria) {
		if (listaCompra.containsKey(categoria)) {
			ArrayList<Producto> listadecat = listaCompra.get(categoria);
			System.out.println(listadecat.toString());
		} else {
			System.out.println("La lista no contiene la categoria \"" + categoria + "\".");
		}
	}

	public void gettAll() {
		Set<Map.Entry<String, ArrayList<Producto>>> cate = listaCompra.entrySet();
		for (Map.Entry<String, ArrayList<Producto>> kv : cate) {
			System.out.println(kv.toString());
		}
	}

}
