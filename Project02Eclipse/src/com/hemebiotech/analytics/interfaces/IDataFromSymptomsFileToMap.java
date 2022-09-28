package com.hemebiotech.analytics.interfaces;

import java.util.TreeMap;

public interface IDataFromSymptomsFileToMap {

    void fromStringToBufferedReader();

    TreeMap<String, Integer> createMap() throws Exception;
}
