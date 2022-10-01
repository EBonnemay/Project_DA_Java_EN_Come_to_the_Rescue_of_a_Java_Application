package com.hemebiotech.analytics.interfaces;

import java.io.IOException;
import java.util.TreeMap;

public interface IDataFromSymptomsFileToMap {

    void fromStringToBufferedReader() throws IOException;

    TreeMap<String, Integer> createMap();
}
