package com.team1.Git.Mining.persistence.models;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleScriptContext;
import java.io.*;
import java.util.List;

import static java.util.Optional.empty;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.hamcrest.core.IsIterableContaining.hasItem;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GitHistoryTest {

    @BeforeEach
    public void init(){

    }

    private String resolvePythonScriptPath(String path){
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        return file.getAbsolutePath();
    }
//
//    @Test
//    public void givenPythonScript_whenPythonProcessInvoked_thenSuccess() throws Exception {
//        ProcessBuilder processBuilder = new ProcessBuilder("python3", "hello.py");
//        processBuilder.redirectErrorStream(true);
//        Process process = processBuilder.start();
//        readProcessOutput(process.getInputStream());
//
//        int exitCode = process.waitFor();
//        assertEquals(0, exitCode);
//    }
//
//    private void readProcessOutput(InputStream inputStream) throws IOException {
//        try (BufferedReader input =
//                     new BufferedReader(new
//                             InputStreamReader(inputStream))) {
//            String line;
//            while ((line = input.readLine()) != null) {
//                System.out.println(line);
//            }
//        }
//    }


//        @Test
//    public void testEmptyConstructor(){
//        GitHistory gitHistory = new GitHistory();
//        assertNotNull(gitHistory);
//    }
//    @Test
//    public void testNameConstructor(){
//        GitHistory gitHistory = new GitHistory("Test");
//        assertEquals(gitHistory.getProjectName(), "Test");
//    }
//    @Test
//    public void testGetters(){
//        GitHistory gitHistory = new GitHistory("1");
//        assertEquals("1", gitHistory.getProjectName());
//    }

}
