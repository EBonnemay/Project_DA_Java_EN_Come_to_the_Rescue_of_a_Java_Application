package com.hemebiotech.analytics.service;

import java.io.FileWriter;
import java.io.IOException;
//import java.util.HashMap;
import java.util.TreeMap;


public class RetrieveDataFromMap {

    TreeMap<String, Integer> map;
// pourquoi = new TreeMap<>(); est-il redondant?
    /**
     * constructeur de MapServices valorise la variable de classe map.
     *
     * @param thisMap TreeMap<String, Integer> qui associe chaque symptôme (clé) au
     *                nombre d'occurrences rencontrées pour ce symtôme (valeur).
     */
    public RetrieveDataFromMap(TreeMap<String, Integer> thisMap) {
        map = thisMap;
    }

    /**
     * Méthode fromTreemapToFile retourne un fichier txt contenant la liste des
     * symptômes et le nombre d'occurrences correspondant
     */
    public void fromTreemapToFile() throws IOException {
        FileWriter writer = new FileWriter("result.out");
        for (String s : map.keySet()) {
            writer.write(s + "=" + map.get(s) + "\n");
        }
        writer.close();

    }

}
