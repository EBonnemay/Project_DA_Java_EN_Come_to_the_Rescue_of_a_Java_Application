package com.hemebiotech.analytics;


import com.hemebiotech.analytics.interfaces.IReadSymptomDataFromFile;
import com.hemebiotech.analytics.interfaces.IRetrieveDataFromMap;
import com.hemebiotech.analytics.service.*;

import java.io.IOException;
import java.util.TreeMap;

public class AnalyticsCounter {
	public static String fileName;

	/**
	 * méthode main valorise un fileName par défaut ou un fileName choisi par
	 * l'utilisateur, crée un objet AnalyticsCounter et appelle sur cet objet la
	 * fonction workFlow
	 *

	 */
	public static void main(String[] args) throws Exception {
		fileName = "Project02Eclipse/symptoms.txt";
		if (args.length != 0) {
			fileName = args[0];
		}
		AnalyticsCounter controle = new AnalyticsCounter();
		controle.workFlow();
	}


	private void workFlow() throws IOException {

		IReadSymptomDataFromFile ds = new ReadSymptomDataFromFile(fileName);
		ds.FromStringToBufferedReader();

		TreeMap<String, Integer> objetMap;
		try {
			objetMap = ds.CreateMap();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		IRetrieveDataFromMap ms = new RetrieveDataFromMap(objetMap);
		try {
			ms.fromTreemapToFile();
		}
		catch(IOException e){
			throw new IOException(e);
		}

	}
}
