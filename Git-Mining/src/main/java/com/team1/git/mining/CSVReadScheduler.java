package com.team1.git.mining;

import com.team1.git.mining.utils.ReadCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Configuration
public class CSVReadScheduler {
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }


}
class RunnableTask implements Runnable{

    public RunnableTask(){

    }

    @Override
    public void run(){
        /*
        * change to run after execution of last?(Done)
        * If new is called then run only new python file
        * otherwise run monitor
        *
        * OR
        *
        * Just check if last line has something before the comma, if so do not compute and stop there(Done)
        * */

        // Run CSV Monitor here
        System.out.println("Start");
//        try {
//            ProcessBuilder processBuilder = new ProcessBuilder("python3", "CSV_Monitor.py");
//            processBuilder.redirectErrorStream(true);
//            Process process = null;
//            process = processBuilder.start();
//            int exitCode = process.waitFor();
//            System.out.println(exitCode);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        ReadCSV.readAllFiles();

        if(!ReadCSV.list.isEmpty()){
            try {
                URL url = new URL("http://localhost:8000/csv");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                int responseCode = connection.getResponseCode();
                System.out.println("Response Code : " + responseCode);
                ReadCSV.clearVariables();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
