package com.hemebiotech.analytics.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile  {
	BufferedReader reader;
	String fileName;
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

	public TreeMap<String, Integer> CreateMap() throws IOException {
		String line = reader.readLine();
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
		System.out.println(mapOfSymptoms);
		return mapOfSymptoms;
	}

/*
	private String filepath;
	

	public ReadSymptomDataFromFile (String filepath) {
		this.filepath = filepath;
	}
	
	@Override
	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader (new FileReader(filepath));
				String line = reader.readLine();
				
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	*/

}
