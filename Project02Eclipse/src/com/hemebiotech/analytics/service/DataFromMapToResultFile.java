package com.hemebiotech.analytics.service;

import com.hemebiotech.analytics.interfaces.IDataFromMapToResultFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeMap;

/**
 * lit les données d'une Map et retourne un fichier txt listant les symptômes unitaires suivis, pouur chacun,
 * du nombre d'occurrences.
 */
public class DataFromMapToResultFile implements IDataFromMapToResultFile {

    private final TreeMap<String, Integer> map;

    /**
     * constructeur de MapServices valorise la variable d'instance map.
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
     *
     * @throws IOException si "result.out" existe mais n'est pas un fichier, ou n'existe pas
     *                     mais ne peut âs être créé, ou enfin s'il ne peut être ouvert.
     */

    public void fromTreemapToFile() throws IOException {
        FileWriter writer = new FileWriter("result.out");
        for (String s : map.keySet()) {
            writer.write(s + "=" + map.get(s) + "\n");
        }
        writer.close();

    }

}
