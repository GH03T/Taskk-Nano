package com.gh03t.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Writer;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.FileReader;

import java.util.ArrayList;

public class SaveManager {
    // INSTANCE VARIABLES
    private static final String SAVE_FILE = "data.json";
    private static final Gson gson = new Gson();
    
    // METHODS
    public static void save(ArrayList<String> data) {
        try (Writer writer = new FileWriter(SAVE_FILE)) {
            gson.toJson(data, writer);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static ArrayList<String> load() {
        try (Reader reader = new FileReader(SAVE_FILE)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<String>>(){}.getType());
        } catch(IOException e) {
            System.err.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
