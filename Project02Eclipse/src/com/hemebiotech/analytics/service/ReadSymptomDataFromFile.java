package com.hemebiotech.analytics.service;


import com.hemebiotech.analytics.interfaces.IReadSymptomDataFromFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements IReadSymptomDataFromFile {
	private BufferedReader reader;
	private final String fileName;
	TreeMap<String, Integer> mapOfSymptoms = new TreeMap<>();

	public ReadSymptomDataFromFile(String fileName) {
		this.fileName = fileName;
	}

	public void FromStringToBufferedReader()  {
		File file = new File(fileName);
		try {
			reader = new BufferedReader(new FileReader(file));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TreeMap<String, Integer> CreateMap() throws Exception {
		try {
			String line = reader.readLine();
			if (line == null) {
				System.out.println("File is empty");
			}

			while (line != null) {

				if (!mapOfSymptoms.containsKey(line)) {
					mapOfSymptoms.put(line, 1);
				}
				else {
					mapOfSymptoms.put(line, mapOfSymptoms.get(line) + 1);
				}

				line = reader.readLine();
			}
			reader.close();
		}
		catch(IOException e){
			throw new Exception("Impossible de lire le fichier", e);
		}
			System.out.println(mapOfSymptoms);
			return mapOfSymptoms;
		}


}
