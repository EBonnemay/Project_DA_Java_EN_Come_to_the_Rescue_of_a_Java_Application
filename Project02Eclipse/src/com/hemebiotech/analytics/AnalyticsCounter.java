package com.hemebiotech.analytics;


import com.hemebiotech.analytics.interfaces.IDataFromSymptomsFileToMap;
import com.hemebiotech.analytics.interfaces.IDataFromMapToResultFile;
import com.hemebiotech.analytics.service.*;

import java.io.IOException;
import java.util.TreeMap;

/**
 * lit la liste de symptômes d'un fichier txt et renvoie une map de symtômes uniques (pas de doublon)
 * en associant à chaque symtôme son nombre d'occurences.
 *
 * @author Emmanuelle Bonnemay
 * @version 1
 */
public class AnalyticsCounter {
    public static String fileName;


    /**
     * La méthode main valorise un nom de fichier par défaut OU choisi par
     * l'utilisateur, crée un objet AnalyticsCounter et appelle sur cet objet la
     * méthode workFlow
     *
     * @param args un tableau de chaines de caractères
     */


    public static void main(String[] args) throws Exception {
        fileName = "Project02Eclipse/symptoms.txt";
        if (args.length != 0) {
            fileName = args[0];
        }
        AnalyticsCounter ac = new AnalyticsCounter();
        ac.workFlow();
    }

    /**
     * La méthode workFlow appelle les méthodes des classes DataFromSymptomsFileToMap et DataFromMapToResultFile pour produire le fichier de résultats.
     *
     * @throws IOException si "result.out" existe mais n'est pas un fichier, ou n'existe pas
     *                     mais ne peut pas être créé, ou enfin s'il ne peut être ouvert.
     */
    private void workFlow() throws IOException {

        IDataFromSymptomsFileToMap readD = new DataFromSymptomsFileToMap(fileName);
        TreeMap<String, Integer> objetMap;

        try {
            objetMap = readD.createMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        IDataFromMapToResultFile retrieveD = new DataFromMapToResultFile(objetMap);

        try {
            retrieveD.fromTreemapToFile();
        } catch (IOException e) {
            throw new IOException(e);
        }

    }
}
