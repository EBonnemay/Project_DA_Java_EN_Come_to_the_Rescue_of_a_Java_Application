package com.hemebiotech.analytics.service;


import com.hemebiotech.analytics.interfaces.IDataFromSymptomsFileToMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;

/**
 * crée un objet File et explore le fichier pour retourner une
 * Map associant chaque symtôme à son nombre d'occurrences.
 */
public class DataFromSymptomsFileToMap implements IDataFromSymptomsFileToMap {
    private BufferedReader reader;
    private final String fileName;
    TreeMap<String, Integer> mapOfSymptoms = new TreeMap<>();

    /**
     * le constructeur valorise la variable d'instance fileName avec le contenu du paramètre
     *
     * @param fileName objet String : le nom du fichier à explorer
     */
    public DataFromSymptomsFileToMap(String fileName) {

        this.fileName = fileName;
    }

    /**
     * crée un objet BufferedReader à partir du nom de fichier donné en attribut, et valorise
     * l'attribut de classe buffer avec cet objet.
     */
    public void fromStringToBufferedReader() {
        File file = new File(fileName);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * appelle FromStringToBufferedReader puis crée et retourne un objet Map associant chaque symptôme à son nombre d'occurrences, à partir de l'attribut reader.
     */
    public TreeMap<String, Integer> createMap() throws Exception {
        this.fromStringToBufferedReader();
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
            throw new Exception("Impossible de lire le fichier", e);
        }
        System.out.println(mapOfSymptoms);
        return mapOfSymptoms;
    }


}
