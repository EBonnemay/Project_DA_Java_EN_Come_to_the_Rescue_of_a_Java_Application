package com.hemebiotech.analytics.interfaces;

import java.util.TreeMap;

public interface IReadSymptomDataFromFile {

    void FromStringToBufferedReader();

    TreeMap<String, Integer> CreateMap() throws Exception;
}
