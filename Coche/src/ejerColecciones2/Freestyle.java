package ejerColecciones2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import EjerColecciones.Producto;

public class Freestyle {
	private Map<String, Map<String, ArrayList<Double>>> jueces = new HashMap<>();
	private Map<String, Map<String, ArrayList<Double>>> artistas = new HashMap<>();
	private Map<String, Double> media = new HashMap<>();
	private Map<String, Map<String, Map<String, ArrayList<Double>>>> mejorArtistaMetrica = new HashMap<>();

	private String juez;
	private String cantante;
	private String metrica;
	private double nota;

	public void agregarNota(String juez, String cantante, String metrica, double nota) {
		// Map de los jueces, las notas que dan y en que metrica
//		if (jueces.containsKey(juez)) {
//			Map<String, ArrayList<Double>> nombreJuez = jueces.get(juez);
//			if (nombreJuez.containsKey(metrica)) {
//				ArrayList<Double> nombreMetrica = nombreJuez.get(metrica);
//				nombreMetrica.add(nota);
//			} else {
//				jueces.put(juez, metrica)
//			}
//		}
		 if (!jueces.containsKey(juez)) {
	            jueces.put(juez, new HashMap<>());
	        }

	        Map<String, ArrayList<Double>> metricasPorJuez = jueces.get(juez);

	        ArrayList<Double> notas = metricasPorJuez.get(metrica);

	        if (notas == null) {
	            notas = new ArrayList<>();
	            metricasPorJuez.put(metrica, notas);
	        }

	        notas.add(nota);

		/*
		 * if (jueces.containsKey(juez)) { ArrayList<Double> j = jueces.get(juez);
		 * j.add(nota); } else { ArrayList<Double> j = jueces.get(juez); j.add(nota);
		 * jueces.put(juez, j); }
		 */
		// Map de las notas que reciben los cantantes

	}
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Map<String, ArrayList<Double>>> entry : jueces.entrySet()) {
            sb.append("Juez: ").append(entry.getKey()).append("\n");
            for (Map.Entry<String, ArrayList<Double>> innerEntry : entry.getValue().entrySet()) {
                sb.append("\tMetrica: ").append(innerEntry.getKey()).append(", Notas: ").append(innerEntry.getValue()).append("\n");
            }
        }
        return sb.toString();
    }

}
