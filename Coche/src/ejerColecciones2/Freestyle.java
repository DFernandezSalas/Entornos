package ejerColecciones2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Freestyle {
	private Map<String, ArrayList<Double>> jueces = new HashMap<>();
	private Map<String, ArrayList<Double>> artistas = new HashMap<>();
	private Map<String, Double> media = new HashMap<>();
	private Map<String, Map<String, ArrayList<Double>>> mejorArtistaMetrica = new HashMap<>();
	
	private String juez;
	private String cantante;
	private String metrica;
	private double nota;
	public Freestyle(String juez, String cantante, String metrica, double nota) {
		//Map de los jueces y las notas que dan
		if (jueces.containsKey(juez)) {
			ArrayList<Double> j = jueces.get(juez);
			j.add(nota);
		} else {
			ArrayList<Double> j = jueces.get(juez);
			j.add(nota);
			jueces.put(juez, j);
		}
		//Map de las notas que reciben los cantantes
		if (artistas.containsKey(cantante)) {
			ArrayList<Double> art = artistas.get(cantante);
			art.add(nota);
		} else {
			ArrayList<Double> art = artistas.get(cantante);
			art.add(nota);
			artistas.put(juez, art);
		}
		//Map de las notas medias
		if (media.containsKey(cantante)) {
			ArrayList<Double> artist = artistas.get(cantante);
			double media;
			for (ArrayList<Double> n : artist) {
				
			}
		}
		
	}
	
	
	
}
