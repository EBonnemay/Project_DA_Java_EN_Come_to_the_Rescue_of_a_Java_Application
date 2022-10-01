package com.hemebiotech.analytics.service;


import com.hemebiotech.analytics.interfaces.IDataFromSymptomsFileToMap;

import java.io.*;
import java.util.TreeMap;

/**
 * Crée un objet File et explore le fichier pour retourner une
 * Map associant chaque symtôme à son nombre d'occurrences.
 */
public class DataFromSymptomsFileToMap implements IDataFromSymptomsFileToMap {
    private BufferedReader reader;
    private final String fileName;
    private final TreeMap<String, Integer> mapOfSymptoms = new TreeMap<>();

    /**
     * Le constructeur valorise la variable d'instance fileName avec le contenu du paramètre
     *
     * @param fileName objet String : le nom du fichier à explorer
     */
    public DataFromSymptomsFileToMap(String fileName) {

        this.fileName = fileName;
    }

    /**
     * Crée un objet BufferedReader à partir de fileName (attribut d'instance), et valorise
     * l'attribut d'instance buffer avec cet objet.
     */
    public void fromStringToBufferedReader() throws IOException {

        File file = new File(fileName);
        reader = new BufferedReader(new FileReader(file));

    }

    /**
     * Appelle fromStringToBufferedReader puis crée et retourne un objet Map associant chaque symptôme à son nombre d'occurrences.
     */
    public TreeMap<String, Integer> createMap() {


        try {
            this.fromStringToBufferedReader();
        } catch (IOException e) {
            throw new RuntimeException("file could not be opened", e);
        }
        try {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("File is empty");
            }

            while (line != null) {
                if (!mapOfSymptoms.containsKey(line)) {
                    mapOfSymptoms.put(line, 1);
                } else {
                    mapOfSymptoms.put(line, mapOfSymptoms.get(line) + 1);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException("file could not be read", e);
        }
        System.out.println(mapOfSymptoms);
        return mapOfSymptoms;
    }

}
