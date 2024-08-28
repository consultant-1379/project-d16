package com.team1.git.mining.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.team1.git.mining.utils.ReadCSV.DIRECTORY_NAME;

public class UtilsFunctions {

    private UtilsFunctions() {
        throw new IllegalStateException("Utility class");
    }

    protected static Map<String, Integer> contributions = new HashMap<>();
    protected static ArrayList<String> contributors = new ArrayList<>();

    public static void contributes(List<String[]> commitList){
        for (String[] values : commitList) {
            if (contributors.contains(values[1])) {
                contributions.computeIfPresent(values[1], (key, oldValue) -> oldValue + 1);
            } else {
                contributors.add(values[1]);
                contributions.put(values[1], 1);
            }
        }
    }

    public static void writeToGitHistory(String link, String start, String end, String latestUpdate){
        String projName = link.substring(link.lastIndexOf("/")+1);
        StringBuilder line = new StringBuilder();
        line.append("\n").append(projName).append(",").append(link).append(",").append(start).append(",").append(end).append(",").append(latestUpdate);

        try(FileWriter fileWriter = new FileWriter(new File(DIRECTORY_NAME.concat("Git-history.csv")),true)) {
            fileWriter.write(line.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
