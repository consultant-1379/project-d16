package com.team1.git.mining.utils;

import com.team1.git.mining.persistence.models.GitHistory;
import com.team1.git.mining.persistence.models.GitRepoList;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.team1.git.mining.utils.UtilsFunctions.contributes;

public class ReadCSV {

    private ReadCSV() {
        throw new IllegalStateException("Utility class");
    }

    protected static List<String> projectName = new ArrayList<>();
    public static final String DIRECTORY_NAME = "CSV_Files/";
    public static List<GitRepoList> list = new ArrayList<>();

    public static List<String[]> readFile(String fileName) {
        String line;
        List<String[]> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line.split(","));
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static int numberOfProjects=0;

    public static void setNumberOfProjects(int numberOfProjects) {
        ReadCSV.numberOfProjects = numberOfProjects;
    }

    public static void readNames(){
        List<String[]> lines = readFile(DIRECTORY_NAME.concat("Git-history.csv"));
        int tempLineNum = 0;

        for (int i = numberOfProjects+1; i < lines.size(); i++) {
            if (!lines.get(i)[0].equals("")) {
                projectName.add(lines.get(i)[0]);
                list.add(new GitRepoList(lines.get(i)[0], lines.get(i)[1], lines.get(i)[2], lines.get(i)[3], lines.get(i)[4]));
                tempLineNum ++;
            }

        }
        numberOfProjects += tempLineNum;
    }

    public static List<List<String[]>> commits = new ArrayList<>();
    public static List<GitHistory> gitHistory = new ArrayList<GitHistory>();


    public static void readCommits(String name){
        String fileName = name.concat("-Commits.csv");
        fileName = DIRECTORY_NAME.concat(fileName);
        List<String[]> lines = readFile(fileName);
        lines.remove(0);
        contributes(lines);
        commits.add(lines);
    }

    public static void readInfo(String name){
        String fileName = name.concat("-Info.csv");
        fileName = DIRECTORY_NAME.concat(fileName);
        List<String []> lines = readFile(fileName);
        gitHistory.add(new GitHistory(lines.get(1)[0],lines.get(1)[1],lines.get(1)[2],
                Integer.valueOf(lines.get(1)[3]),Long.valueOf(lines.get(1)[4]),Long.valueOf(lines.get(1)[5]),
                Float.valueOf(lines.get(1)[6]), Integer.valueOf(lines.get(1)[7]),Long.valueOf(lines.get(1)[8]),
                Long.valueOf(lines.get(1)[9]), Float.valueOf(lines.get(1)[10]),Integer.valueOf(lines.get(1)[11]),
                Integer.valueOf(lines.get(1)[12]), Float.valueOf(lines.get(1)[13])));
    }

    public static void readAllFiles() {
        readNames();
        for(String name: projectName) {
            readCommits(name);
            readInfo(name);
        }
    }

    public static void clearVariables(){
        gitHistory.clear();
        commits.clear();
        projectName.clear();
    }
}