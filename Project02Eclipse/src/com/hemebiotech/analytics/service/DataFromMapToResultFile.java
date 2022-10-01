package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.interfaces.IDataFromMapToResultFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * Lit les données d'une Map et retourne un fichier txt listant les symptômes unitaires (pas de doublon), suivis pour chacun,
 * du nombre d'occurrences.
 */
public class DataFromMapToResultFile implements IDataFromMapToResultFile {

    private final TreeMap<String, Integer> map;

    /**
     * Constructeur de MapServices valorise la variable d'instance map.
     *
     * @param thisMap TreeMap<String, Integer>  associe chaque symptôme (clé) au
     *                nombre d'occurrences rencontrées pour ce symtôme (valeur).
     */
    public DataFromMapToResultFile(TreeMap<String, Integer> thisMap) {
        map = thisMap;
    }

    /**
     * Méthode fromTreemapToFile retourne un fichier txt contenant la liste des
     * symptômes et le nombre d'occurrences correspondant
     */
    public void fromTreemapToFile() {
        try {
            FileWriter writer = new FileWriter("result.out");
            for (String s : map.keySet()) {
                writer.write(s + "=" + map.get(s) + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("cannot open output file", e);
        }

    }

}
