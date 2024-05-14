package ejerColecciones2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Freestyle {
	private Map<String, Map<String, Map<String, ArrayList<Double>>>> jueces = new HashMap<>();
	private Map<String, Map<String, Map<String, ArrayList<Double>>>> artistas = new HashMap<>();
	private Map<String, ArrayList<Double>> media = new HashMap<>();
	private Map<String, Map<String, ArrayList<Double>>> mejorArtistaMetrica = new HashMap<>();


	public void agregarNota(String juez, String cantante, String metrica, double nota) {
		// Map de los jueces, las notas que dan y en que metrica
		añadirJuez(juez, cantante, metrica, nota);
		// Map de las notas que reciben los cantantes
		añadirCantante(cantante, juez, metrica, nota);
		// Map para las medias de las notas por cantante
		mapMedias(cantante, nota);
		// Map para mejor cantante por metrica
		mapMejorArtistaMetrica(cantante, metrica, nota);
	}

	public void notasCantante(String cantante) {
		StringBuilder sb = new StringBuilder();
		Map<String, Map<String, ArrayList<Double>>> notasCantante = artistas.get(cantante);
		if (notasCantante != null) {
			sb.append("Cantante: ").append(cantante).append("\n");
			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : notasCantante.entrySet()) {
				sb.append("\tJuez: ").append(innerEntry.getKey()).append("\n");
				sb.append("\tMetrica:\n");
				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
				}
			}
		} else {
			System.out.println("El cantante " + cantante + " no existe.");
		}
		System.out.println(sb);
	}

	public void notasJuez(String juez) {
		StringBuilder sb = new StringBuilder();
		Map<String, Map<String, ArrayList<Double>>> notasJuez2 = jueces.get(juez);
		if (notasJuez2 != null) {
			sb.append("Juez: ").append(juez).append("\n");
			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : notasJuez2.entrySet()) {
				sb.append("\tCantante: ").append(innerEntry.getKey()).append("\n");
				sb.append("\tMetrica:\n");
				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
				}
			}
		} else {
			System.out.println("El juez " + juez + " no existe.");
		}
		System.out.println(sb);
	}

	public void obtenerMediaCantante(String cantante) {
		double suma = 0;
		if (media.containsKey(cantante)) {
			ArrayList<Double> notas = media.get(cantante);
			for (double nota : notas) {
				suma += nota;
			}
			suma = suma / notas.size();
		}
		System.out.println("La media de la notas de " + cantante + " es " + suma);
	}

	public void artistaMetrica(String metrica) {
		String mejorCantante = "";
		double mejorMedia = 0;

		if (mejorArtistaMetrica.containsKey(metrica)) {
			Map<String, ArrayList<Double>> metric = mejorArtistaMetrica.get(metrica);
			for (Map.Entry<String, ArrayList<Double>> entry : metric.entrySet()) {
				String cantante = entry.getKey();
				ArrayList<Double> notas = entry.getValue();

				double sum = 0;
				for (double nota : notas) {
					sum += nota;
				}
				double media = sum / notas.size();
				if (media > mejorMedia) {
					mejorMedia = media;
					mejorCantante = cantante;

				}

			}
			System.out.println("El mejor cantante en la métrica " + metrica + " es " + mejorCantante
					+ " con una media de " + mejorMedia);
		} else {
			System.out.println("No esta la metrica " + metrica);
		}

	}

	private void mapMejorArtistaMetrica(String cantante, String metrica, double nota) {
		if (!mejorArtistaMetrica.containsKey(metrica)) {
			mejorArtistaMetrica.put(metrica, new HashMap<>());
		}
		Map<String, ArrayList<Double>> metricaCantante = mejorArtistaMetrica.get(metrica);
		ArrayList<Double> notas = metricaCantante.get(cantante);
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


//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		for (Map.Entry<String, Map<String, Map<String, ArrayList<Double>>>> entry : jueces.entrySet()) {
//			sb.append("Juez: ").append(entry.getKey()).append("\n");
//			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : entry.getValue().entrySet()) {
//				sb.append("\tCantante: ").append(innerEntry.getKey()).append("\n");
//				sb.append("\tMetrica:\n");
//				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
//					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
//				}
//			}
//		}
//		for (Map.Entry<String, Map<String, Map<String, ArrayList<Double>>>> entry : artistas.entrySet()) {
//			sb.append("Cantante: ").append(entry.getKey()).append("\n");
//			for (Map.Entry<String, Map<String, ArrayList<Double>>> innerEntry : entry.getValue().entrySet()) {
//				sb.append("\tJuez: ").append(innerEntry.getKey()).append("\n");
//				sb.append("\tMetrica:\n");
//				for (Map.Entry<String, ArrayList<Double>> innerEntry2 : innerEntry.getValue().entrySet()) {
//					sb.append("\t\t").append(innerEntry2.getKey()).append(innerEntry2.getValue()).append("\n");
//				}
//			}
//		}
//		for (Map.Entry<String, ArrayList<Double>> entry : media.entrySet()) {
//			sb.append("Cantante: ").append(entry.getKey()).append(", Notas: ").append(entry.getValue()).append("\n");
//		}
//	for (Map.Entry<String, Map<String, ArrayList<Double>>> entry : mejorArtistaMetrica.entrySet()) {
//		String metrica = entry.getKey();
//		sb.append("Métrica: ").append(metrica).append("\n");
//		Map<String, ArrayList<Double>> cantanteNotas = entry.getValue();
//		for (Map.Entry<String, ArrayList<Double>> innerEntry : cantanteNotas.entrySet()) {
//			String cantante = innerEntry.getKey();
//			ArrayList<Double> notas = innerEntry.getValue();
//			sb.append("\tCantante: ").append(cantante).append(", Notas: ").append(notas).append("\n");
//		}
//	}
//		return sb.toString();
//	}

}
