package com.hemebiotech.analytics;


import com.hemebiotech.analytics.interfaces.IDataFromSymptomsFileToMap;
import com.hemebiotech.analytics.interfaces.IDataFromMapToResultFile;
import com.hemebiotech.analytics.service.*;

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


    public static void main(String[] args) {
        fileName = "Project02Eclipse/symptoms.txt";
        if (args.length != 0) {
            fileName = args[0];
        }
        AnalyticsCounter ac = new AnalyticsCounter();

        ac.workFlow();
    }


    /**
     * La méthode workFlow appelle les méthodes des classes DataFromSymptomsFileToMap et DataFromMapToResultFile pour produire le fichier de résultats.
     */

    private void workFlow() {

        IDataFromSymptomsFileToMap readD = new DataFromSymptomsFileToMap(fileName);
        TreeMap<String, Integer> objetMap;
        objetMap = readD.createMap();
        IDataFromMapToResultFile retrieveD = new DataFromMapToResultFile(objetMap);
        retrieveD.fromTreemapToFile();
    }
}
