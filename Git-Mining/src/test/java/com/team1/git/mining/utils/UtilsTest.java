package com.team1.git.mining.utils;

import org.junit.Before;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import static com.team1.git.mining.utils.UtilsFunctions.contributions;
import static com.team1.git.mining.utils.UtilsFunctions.contributors;
import static org.junit.jupiter.api.Assertions.*;


public class UtilsTest {



    @Before
    public void init(){
    }

    @Test(expected = IllegalStateException.class)
    public void verifyConstructorExceptionCalled() throws NoSuchMethodException, IllegalAccessException, InstantiationException {
        final Constructor<UtilsFunctions> constructor = UtilsFunctions.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        try {
            constructor.newInstance();
        } catch (InvocationTargetException e) {
            throw (IllegalStateException) e.getTargetException();
        }
    }

    @Test
    public void verifyContributionsIsMap(){
        assertTrue(contributions instanceof Map);
    }

    @Test
    public void verifyContributorsIsList(){
        assertTrue(contributors instanceof List);
    }

    @Test
    public void readingContributionsCorrectly(){
        ReadCSV.readCommits("project-d16");
        assertEquals( "Saoirse" , contributors.get(1));
        assertEquals(1, contributions.get("Saoirse"));

    }

    @Test
    public void testThrows() throws IOException {
        assertThrows(IOException.class, () -> new FileWriter("/no/such/place"));
    }


    @Test
    public void verfiyWritesCorrectly(){

    }
}
