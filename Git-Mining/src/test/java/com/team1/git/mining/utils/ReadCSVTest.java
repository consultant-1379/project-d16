package com.team1.git.mining.utils;


import com.team1.git.mining.persistence.models.GitHistory;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReadCSVTest {

    @Before
    public void init(){
    }

    @Test(expected = IllegalStateException.class)
    public void verifyConstructorExceptionCalled() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        final Constructor<ReadCSV> constructor = ReadCSV.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (IllegalStateException) e.getTargetException();
        }
    }

    @Test
    public void testThrows() throws IOException {
        assertThrows(IOException.class, () -> new FileWriter("/no/such/place"));
    }


    @Test
    public void verifyListIsList(){
        assertTrue(ReadCSV.list instanceof List);
    }

    @Test
    public void verifyprojectNameIsList(){
        assertTrue(ReadCSV.projectName instanceof List);
    }

    @Test
    public void verifyDirectoryExists(){
        File file = new File(ReadCSV.DIRECTORY_NAME);
        assertTrue(file.exists());
    }

    @Test
    public void verifyDirectoryName(){
        assertEquals("CSV_Files/", ReadCSV.DIRECTORY_NAME);
    }


    @Test
    public void verifyGitHistoryExists(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("Git-history.csv"));
        assertTrue(file.exists());
    }

    @Test
    public void verifyGitHistoryIsReadable(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("Git-history.csv"));
        assertTrue(file.canRead());
    }

    @Test
    public void verifyProjectCommitsExists(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("project-d16").concat("-Commits.csv"));
        assertTrue(file.exists());
    }

    @Test
    public void verifyProjectCommitsIsReadable(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("project-d16").concat("-Commits.csv"));
        assertTrue(file.canRead());
    }

    @Test
    public void verifyProjectInfoExists(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("project-d16").concat("-Info.csv"));
        assertTrue(file.exists());
    }

    @Test
    public void verifyProjectInfoIsReadable(){
        File file = new File(ReadCSV.DIRECTORY_NAME.concat("project-d16").concat("-Info.csv"));
        assertTrue(file.canRead());
    }

    @Test
    public void verifyReadInfoCorrectly(){
        ReadCSV.readInfo("project-d16");
        assertEquals("project-d16", ReadCSV.gitHistory.get(0).getProjectName());
    }

    @Test
    public void readingFileCorrectly(){
        List<String[]> lines = ReadCSV.readFile(ReadCSV.DIRECTORY_NAME.concat("Git-history.csv"));
        assertEquals("project-d16", lines.get(1)[0]);
        ReadCSV.clearVariables();
    }

    @Test
    public void readingProjectNamesCorrectly(){
        ReadCSV.setNumberOfProjects(0);
        ReadCSV.readNames();
        assertEquals(2, ReadCSV.projectName.size());
        assertEquals("project-d16", ReadCSV.projectName.get(0));
    }

    @Test
    public void readingCommitsCorrectly(){
        ReadCSV.readCommits("project-d16");
        Assertions.assertEquals("Saoirse", ReadCSV.commits.get(0).get(1)[1]);
    }

    @Test
    public void readingInfoCorrectly(){
        ReadCSV.readInfo("project-d16");
        assertEquals(11, ReadCSV.gitHistory.get(0).getCommitsNum());
    }

    @Test
    public void readingAllFilesCorrectly(){
        ReadCSV.readAllFiles();
        Assertions.assertEquals("Saoirse", ReadCSV.commits.get(0).get(1)[1]);
        assertEquals(11, ReadCSV.gitHistory.get(0).getCommitsNum());
        Assertions.assertEquals("project-d16", ReadCSV.projectName.get(0));
    }

    @Test
    public void verifyingGitHistClear(){
        ReadCSV.gitHistory.add(new GitHistory());
        ReadCSV.clearVariables();
        Assertions.assertEquals(0, ReadCSV.gitHistory.size());
    }

    @Test
    public void verifyingCommitsClear(){
        ReadCSV.commits.add(new ArrayList<>());
        ReadCSV.clearVariables();
        Assertions.assertEquals(0, ReadCSV.commits.size());
    }

    @Test
    public void verifyGitHistClear(){
        ReadCSV.gitHistory.add(new GitHistory());
        ReadCSV.clearVariables();
        Assertions.assertEquals(0, ReadCSV.gitHistory.size());
    }

    @Test
    public void verifyingProjNamesClear(){
        ReadCSV.projectName.add("name");
        ReadCSV.clearVariables();
        Assertions.assertEquals(0, ReadCSV.projectName.size());
    }


}
