package ejerColecciones2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import EjerColecciones.Producto;

public class Freestyle {
	private Map<String, Map<String, Map<String, ArrayList<Double>>>> jueces = new HashMap<>();
	private Map<String, Map<String, Map<String, ArrayList<Double>>>> artistas = new HashMap<>();
	private Map<String, ArrayList<Double>> media = new HashMap<>();
	private Map<String, Map<String, ArrayList<Double>>> mejorArtistaMetrica = new HashMap<>();

	private String juez;
	private String cantante;
	private String metrica;
	private double nota;

	public void agregarNota(String juez, String cantante, String metrica, double nota) {
		// Map de los jueces, las notas que dan y en que metrica
		añadirJuez(juez, cantante, metrica, nota);
		// Map de las notas que reciben los cantantes
		añadirCantante(cantante, juez, metrica, nota);
		// Map para las medias de las notas por cantante
		mapMedias(cantante, nota);
		//Map para mejor cantante por metrica
		mapMejorArtistaMetrica(cantante, metrica, nota);
	}

	private void mapMejorArtistaMetrica(String cantante, String metrica, double nota) {
		if (!mejorArtistaMetrica.containsKey(cantante)) {
			mejorArtistaMetrica.put(metrica, new HashMap<>());
		}
		Map<String, ArrayList<Double>> metricaCantante = mejorArtistaMetrica.get(cantante);
		ArrayList<Double> notas = media.get(cantante);
		if (notas == null) {
			notas = new ArrayList<>();
			metricaCantante.put(cantante, notas);
		}
		notas.add(nota);
	}

	private void mapMedias(String cantante, double nota) {
		if (!media.containsKey(cantante)) {
			ArrayList<Double> notas = media.get(cantante);
			if (notas == null) {
				notas = new ArrayList<>();
				notas.add(nota);
				media.put(cantante, notas);
			}
		} else {
			ArrayList<Double> notas = media.get(cantante);
			notas.add(nota);
		}
	}

	private void añadirJuez(String juez, String cantante, String metrica, double nota) {
		if (!jueces.containsKey(juez)) {
			jueces.put(juez, new HashMap<>());
		}

		Map<String, Map<String, ArrayList<Double>>> cantantePorJuez = jueces.get(juez);
		if (!cantantePorJuez.containsKey(cantante)) {
			cantantePorJuez.put(cantante, new HashMap<>());
		}

		Map<String, ArrayList<Double>> metricasPorJuez = cantantePorJuez.get(cantante);

		ArrayList<Double> notas = metricasPorJuez.get(metrica);

		if (notas == null) {
			notas = new ArrayList<>();
			metricasPorJuez.put(metrica, notas);
		}

		notas.add(nota);
	}

	private void añadirCantante(String cantante, String juez, String metrica, double nota) {
		if (!artistas.containsKey(cantante)) {
			artistas.put(cantante, new HashMap<>());
		}

		Map<String, Map<String, ArrayList<Double>>> juecesPorCantante = artistas.get(cantante);
		if (!juecesPorCantante.containsKey(juez)) {
			juecesPorCantante.put(juez, new HashMap<>());
		}
		Map<String, ArrayList<Double>> metricasPorCantante = juecesPorCantante.get(juez);

		ArrayList<Double> notas = metricasPorCantante.get(metrica);

		if (notas == null) {
			notas = new ArrayList<>();
			metricasPorCantante.put(metrica, notas);
		}

		notas.add(nota);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Map<String, Map<String, ArrayList<Double>>>> entry : jueces.entrySet()) {
			sb.append("Juez: ").append(entry.getKey()).append("\n");
			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : entry.getValue().entrySet()) {
				sb.append("\tCantante: ").append(innerEntry.getKey()).append("\n");
				sb.append("\tMetrica:\n");
				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
				}
			}
		}
		for (Map.Entry<String, Map<String, Map<String, ArrayList<Double>>>> entry : artistas.entrySet()) {
			sb.append("Cantante: ").append(entry.getKey()).append("\n");
			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : entry.getValue().entrySet()) {
				sb.append("\tJuez: ").append(innerEntry.getKey()).append("\n");
				sb.append("\tMetrica:\n");
				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
				}
			}
		}
	    for (Map.Entry<String, ArrayList<Double>> entry : media.entrySet()) {
	        sb.append("Cantante: ").append(entry.getKey()).append(", Notas: ").append(entry.getValue()).append("\n");
	    }
		return sb.toString();
	}

}
