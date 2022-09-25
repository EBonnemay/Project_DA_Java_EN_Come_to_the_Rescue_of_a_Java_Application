package com.hemebiotech.analytics.interfaces;

import java.io.IOException;
import java.util.TreeMap;

public interface IReadSymptomDataFromFile {

    void FromStringToBufferedReader();

    TreeMap<String, Integer> CreateMap() throws IOException;
}
