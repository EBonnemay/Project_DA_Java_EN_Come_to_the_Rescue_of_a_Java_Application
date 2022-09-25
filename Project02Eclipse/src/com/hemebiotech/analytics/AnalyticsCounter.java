package com.hemebiotech.analytics;


import com.hemebiotech.analytics.interfaces.IReadSymptomDataFromFile;
import com.hemebiotech.analytics.interfaces.IRetrieveDataFromMap;
import com.hemebiotech.analytics.service.*;

import java.io.IOException;
import java.util.TreeMap;

public class AnalyticsCounter {
	static String fileName;

	/**
	 * méthode main valorise un fileName par défaut ou un fileName choisi par
	 * l'utilisateur, crée un objet AnalyticsCounter et appelle sur cet objet la
	 * fonction workFlow
	 *

	 */
	public static void main(String[] args) throws Exception {
		System.out.println("beginning");
		fileName = "Project02Eclipse/symptoms.txt";
		if (args.length != 0) {
			fileName = args[0];
		}
		AnalyticsCounter controle = new AnalyticsCounter();
		controle.workFlow();
	}


	public void workFlow() throws IOException {

		IReadSymptomDataFromFile ds = new ReadSymptomDataFromFile(fileName);
		ds.FromStringToBufferedReader();
		TreeMap<String, Integer> objetMap = ds.CreateMap();
		System.out.println(objetMap);
		IRetrieveDataFromMap ms = new RetrieveDataFromMap(objetMap);
		ms.fromTreemapToFile();

	}

	/*private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dialatedPupilCount = 0;
	
	public static void main(String args[]) throws Exception {
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("Project02Eclipse/symptoms.txt"));
		String line = reader.readLine();

		// counts headaches
		while (line != null) {
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.contains("dialated pupils")) {
				dialatedPupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		reader.close();
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + dialatedPupilCount + "\n");
		writer.close();
	}
	}
	 */
}
